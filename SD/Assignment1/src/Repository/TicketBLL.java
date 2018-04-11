package Repository;

import DataAccess.ShowDAO;
import DataAccess.TicketDAO;
import Model.Show;
import Model.Ticket;

import javax.swing.table.TableModel;

public class TicketBLL {

    public TableModel populateTickets(String showTitle, int sold){
        TicketDAO ticketDAO = new TicketDAO();
        ShowDAO showDAO = new ShowDAO();
        Show show = new Show();
        TableModel model = null;
        if(showTitle != null && showTitle.length() > 0) {
            show = showDAO.read(showTitle);
            System.out.println(show.getId());
            if (show != null) {
                model = ticketDAO.populate(show.getId(), sold);
            }
        }

        return model;
    }

    public static boolean createTickets(String showTitle, int rows, int cols){

        TicketDAO ticketDAO = new TicketDAO();
        Ticket ticket = new Ticket();
        ShowDAO showDAO = new ShowDAO();
        Show show = new Show();
        show = showDAO.read(showTitle);
        if(showTitle != null && showTitle.length() > 0) {
            ticket.setShowID(show.getId());
            ticket.setSold(0);
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    ticket.setCol(j);
                    ticket.setRow(i);
                    ticketDAO.create(ticket);
                }
            }
            return true;
        }
        return false;
    }

    public static boolean cancelReservation(int col, int row, String showTitle){
        TicketDAO ticketDAO = new TicketDAO();
        Ticket ticket = new Ticket();
        ShowDAO showDAO = new ShowDAO();
        Show show = new Show();
        show = showDAO.read(showTitle);

        if(col > 0 && row > 0 && col < 11 && row < 11 ){
            ticket.setRow(row);
            ticket.setCol(col);
            ticket.setShowID(show.getId());

            ticketDAO.cancel(ticket);
            return true;
        }

        return false;
    }

    public static boolean addReservation(int col, int row, String showTitle){
        TicketDAO ticketDAO = new TicketDAO();
        Ticket ticket = new Ticket();
        ShowDAO showDAO = new ShowDAO();
        Show show = new Show();
        show = showDAO.read(showTitle);

        if(col > 0 && row > 0 && col < 11 && row < 11 ){
            ticket.setRow(row);
            ticket.setCol(col);
            ticket.setShowID(show.getId());

            ticketDAO.add(ticket);
            return true;
        }

        return false;
    }

    public static int updateReservation(int col, int row, int oldCol, int oldRow, String showTitle){
        TicketDAO ticketDAO = new TicketDAO();
        Ticket ticket = new Ticket();
        Ticket ticketOld = new Ticket();
        ShowDAO showDAO = new ShowDAO();
        Show show = new Show();
        show = showDAO.read(showTitle);

        if(col > 0 && row > 0 && col < 11 && row < 11 ){

            ticketOld.setRow(row);
            ticketOld.setCol(col);
            ticketOld.setShowID(show.getId());

            ticket = ticketDAO.read(row, col, show.getId());
            System.out.println(col + " " + row);
            if(ticket.getSold() == 1){
                return 0;
            }

            ticketOld = ticketDAO.read(oldRow, oldCol, show.getId());

            ticketDAO.add(ticket);
            ticketDAO.cancel(ticketOld);
            return 1;
        }

        return -1;
    }

    public static boolean exportCsv(String showTitle){
        TicketDAO ticketDAO = new TicketDAO();
        ShowDAO showDAO = new ShowDAO();
        Show show = new Show();
        show = showDAO.read(showTitle);
        if(showTitle != null && showTitle.length() > 0 && show != null){
            ticketDAO.export(show.getId());
        }

        return false;
    }
}
