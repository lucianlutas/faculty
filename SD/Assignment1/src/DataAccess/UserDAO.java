package DataAccess;

import Model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import net.proteanit.sql.DbUtils;

import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {

    private static final String CREATE_QUERY = "INSERT INTO users (`id`, `type`, `username`, `password`) VALUES (?,?,?,?)";
    /** The query for read. */
    private static final String READ_QUERY = "SELECT * FROM users where username = ?";
    /** The query for update. */
    private static final String UPDATE_QUERY = "UPDATE users SET type=?, username=? ,password=? WHERE id=?";
    /** The query for delete. */
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";

    public static TableModel populate(int type){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("select username, password from users where type=?");
            preparedStatement.setInt(1, type);
            rs = preparedStatement.executeQuery();
            return DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return DbUtils.resultSetToTableModel(rs);
    }

    public int create(User user){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(CREATE_QUERY,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, user.getType());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();

            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }

        return -1;
    }

    public User read(String username) {
        User user = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(READ_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();

            if (result.next() && result != null) {
                user = new User();
                user.setId(result.getInt(1));
                user.setType(result.getInt(2));
                user.setUsername(result.getString(3));
                user.setPass(result.getString(4));
            } else {
                // TODO
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }

        return user;
    }

    public boolean exists(String username) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(READ_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();

            if (result.next() && result != null) {
                return true;
            } else {
                // TODO
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }

        return false;
    }

    public boolean update(User user) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(4, user.getId());
            preparedStatement.setInt(1, user.getType());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPass());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
    }

    public int getSize() {
        int numberRow = 0;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            String query = "select count(*) from users";
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                numberRow = rs.getInt("count(*)");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return numberRow;
    }

    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
    }

}
