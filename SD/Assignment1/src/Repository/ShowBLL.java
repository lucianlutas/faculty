package Repository;

import DataAccess.ShowDAO;
import DataAccess.UserDAO;
import Model.Show;
import Model.User;

import javax.swing.table.TableModel;

public class ShowBLL {

    public TableModel populateShows(){
        ShowDAO showDAO = new ShowDAO();
        TableModel model = null;
        model = showDAO.populate();

        return model;
    }

    public static boolean addShow(String title, String genre, String distribution, int ticketNo, String date){
        ShowDAO showDAO = new ShowDAO();
        Show show = new Show();
        TicketBLL ticketBLL = new TicketBLL();

        if(title != null && title.length() > 0 && genre != null && genre.length() > 0 && distribution != null && distribution.length() > 0 && ticketNo > 0 && date != null && date.length() > 0){
            show.setTitle(title);
            show.setGenre(genre);
            show.setDistribution(distribution);
            show.setTicketNo(ticketNo);
            show.setDate(date);
            if(showDAO.exists(title, date)) {
                return false;
            }
            showDAO.create(show);
            ticketBLL.createTickets(show.getTitle(), 10, 10);
            return true;
        }

        return false;
    }

    public static boolean updateShow(String title, String newTitle, String newGenre, String newDistribution, int newTicketNo, String newDate){
        ShowDAO showDao = new ShowDAO();
        Show show = null;

        if(newTitle != null && newTitle.length() > 0 && newGenre != null && newGenre.length() > 0 && newDistribution != null && newDistribution.length() > 0 && newTicketNo > 0 && newDate != null && newDate.length() > 0){
            show = showDao.read(title);
            show.setTitle(title);
            show.setGenre(newGenre);
            show.setDistribution(newDistribution);
            show.setTicketNo(newTicketNo);
            show.setDate(newDate);
            showDao.update(show);
            return true;
        }

        return false;
    }
    public static boolean removeShow(String title){
        ShowDAO showDAO = new ShowDAO();
        Show show = null;

        if(title != null && title.length() > 0){
            show = showDAO.read(title);
            showDAO.delete(show.getId());
            return true;
        }

        return false;
    }


}
