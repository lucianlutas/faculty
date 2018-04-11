package DataAccess;

import Model.Show;
import Model.Ticket;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import net.proteanit.sql.DbUtils;

import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO {

    private static final String CREATE_QUERY = "INSERT INTO ticket (`id`, `showID`, `rows`, `cols`, `sold`) VALUES (?,?,?,?,?)";
    /** The query for read. */
    private static final String READ_QUERY = "SELECT * FROM ticket where rows = ? AND cols = ? AND showID=?";
    /** The query for update. */
    private static final String UPDATE_QUERY = "UPDATE ticket SET showID=?, rows=? ,cols=?, sold=? WHERE id=?";
    /** The query for delete. */
    private static final String DELETE_QUERY = "DELETE FROM ticket WHERE rows = ? AND cols = ? AND showID = ?";

    public static TableModel populate(int showID, int sold){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("select rows, cols from ticket where showID=? AND sold=?");
            preparedStatement.setInt(1, showID);
            preparedStatement.setInt(2, sold);
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

    public int create(Ticket ticket) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(CREATE_QUERY,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, ticket.getId());
            preparedStatement.setInt(2, ticket.getShowID());
            preparedStatement.setInt(3, ticket.getRow());
            preparedStatement.setInt(4, ticket.getCol());
            preparedStatement.setInt(5, ticket.getSold());
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

    public Ticket read(int row, int col, int showID) {
        Ticket ticket = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(READ_QUERY);
            preparedStatement.setInt(1, row);
            preparedStatement.setInt(2, col);
            preparedStatement.setInt(3, showID);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();

            if (result.next() && result != null) {
                ticket = new Ticket();
                ticket.setId(result.getInt(1));
                ticket.setShowID(result.getInt(2));
                ticket.setRow(result.getInt(3));
                ticket.setCol(result.getInt(4));
                ticket.setSold(result.getInt(5));
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

        return ticket;
    }

    public boolean update(Ticket ticket) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(5, ticket.getId());
            preparedStatement.setInt(1, ticket.getShowID());
            preparedStatement.setInt(2, ticket.getRow());
            preparedStatement.setInt(3, ticket.getCol());
            preparedStatement.setInt(4, ticket.getSold());
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

    public boolean delete(int row, int col, int showID) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, row);
            preparedStatement.setInt(2, col);
            preparedStatement.setInt(3, showID);
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

    public boolean cancel(Ticket ticket) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("UPDATE ticket SET sold=? WHERE showID=? AND rows = ? AND cols = ?");
            preparedStatement.setInt(2, ticket.getShowID());
            preparedStatement.setInt(3, ticket.getRow());
            preparedStatement.setInt(4, ticket.getCol());
            preparedStatement.setInt(1, 0);
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

    public boolean add(Ticket ticket) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("UPDATE ticket SET sold=? WHERE showID=? AND rows = ? AND cols = ?");
            preparedStatement.setInt(2, ticket.getShowID());
            preparedStatement.setInt(3, ticket.getRow());
            preparedStatement.setInt(4, ticket.getCol());
            preparedStatement.setInt(1, 1);
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

    public boolean truncate(int showID){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("DELETE FROM ticket WHERE showID = ?");
            preparedStatement.setInt(1, showID);
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

    public boolean export(int showID){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = (PreparedStatement) conn.prepareStatement("SELECT rows, cols INTO OUTFILE \'E:/export.csv\'\n" +
                    "  FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"'\n" +
                    "  LINES TERMINATED BY '\\n'\n" +
                    "  FROM ticket WHERE showID=? AND sold = 1;");
            preparedStatement.setInt(1, showID);
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
