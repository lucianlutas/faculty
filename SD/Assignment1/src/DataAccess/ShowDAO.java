package DataAccess;

import Model.Show;
import Model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import net.proteanit.sql.DbUtils;

import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowDAO {

    private static final String CREATE_QUERY = "INSERT INTO showtable (`id`, `title`, `genre`, `distribution`, `ticketNo`, `date`) VALUES (?,?,?,?,?,?)";
    /** The query for read. */
    private static final String READ_QUERY = "SELECT * FROM showtable where title = ?";
    /** The query for update. */
    private static final String UPDATE_QUERY = "UPDATE showtable SET title=?, genre=? ,distribution=?, ticketNo=?, date=? WHERE id=?";
    /** The query for delete. */
    private static final String DELETE_QUERY = "DELETE FROM showtable WHERE id = ?";

    public static TableModel populate(){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("select title, genre, distribution, ticketNo, date from showtable");
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

    public int create(Show show) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(CREATE_QUERY,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, show.getId());
            preparedStatement.setString(2, show.getTitle());
            preparedStatement.setString(3, show.getGenre());
            preparedStatement.setString(4, show.getDistribution());
            preparedStatement.setInt(5, show.getTicketNo());
            preparedStatement.setString(6, show.getDate());
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

    public Show read(String title) {
        Show show = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(READ_QUERY);
            preparedStatement.setString(1, title);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();

            if (result.next() && result != null) {
                show = new Show();
                show.setId(result.getInt(1));
                show.setTitle(result.getString(2));
                show.setGenre(result.getString(3));
                show.setDistribution(result.getString(4));
                show.setTicketNo(result.getInt(5));
                show.setDate(result.getString(6));
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

        return show;
    }

    public String readFirst() {
        Show show = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT title FROM showtable");
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
            String title = result.getString(1);
            return title;

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

        return "";
    }

    public boolean update(Show show) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(6, show.getId());
            preparedStatement.setString(1, show.getTitle());
            preparedStatement.setString(2, show.getGenre());
            preparedStatement.setString(3, show.getDistribution());
            preparedStatement.setInt(4, show.getTicketNo());
            preparedStatement.setString(5, show.getDate());
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

    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            TicketDAO ticketDAO = new TicketDAO();
            ticketDAO.truncate(id);
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
            String query = "select count(*) from showtable";
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

    public boolean exists(String username, String date) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT * FROM showtable where title = ? AND date = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, date);
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
}
