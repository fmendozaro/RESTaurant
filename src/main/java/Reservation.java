public class Reservation {

    private long id;
    private long userId;
    private int num_people;
    private String date;
    private String time;

    public Reservation(long id, long userId, int num_people, String date, String time) {
        this.id = id;
        this.userId = userId;
        this.num_people = num_people;
        this.date = date;
        this.time = time;
    }

    public Reservation(long userId, int num_people, String date, String time) {
        this.userId = userId;
        this.num_people = num_people;
        this.date = date;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getNum_people() {
        return num_people;
    }

    public void setNum_people(int num_people) {
        this.num_people = num_people;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
