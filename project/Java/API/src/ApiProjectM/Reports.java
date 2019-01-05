package ApiProjectM;

public class Reports {

    private int id;
    private  String reporter;
    private String subject;
    private String date;

    public void setId(int id) {this.id = id;}

    public void setReporter(String reporter) {this.reporter = reporter;}

    public void setSubject(String subject) {this.subject = subject;}

    public void setDate(String date) {this.date = date;}

    public int getId() {return id;}

    public String getReporter() {return reporter;}

    public String getSubject() {return subject;}

    public String getDate() {return date;}
}
