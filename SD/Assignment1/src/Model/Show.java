package Model;

public class Show {
    private int id;
    private String title;
    private String genre;
    private String distribution;
    private int ticketNo;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getDistribution() {
        return distribution;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }
}
