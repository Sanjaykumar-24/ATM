package date;
import java.time.*;
import java.text.*;
public class date {
    private String date;
    private String time;
    public date()throws Exception
    {
    LocalDate d = LocalDate.now();
    String s = d.toString();
    SimpleDateFormat form  = new SimpleDateFormat("yyyy-MM-dd");
    date = (form.parse(s)).toString();
    LocalTime t = LocalTime.now(ZoneId.of("Asia/Kolkata"));
    time = t.toString();
    }
    public String getdate()
    {
        return date;
    }
    public String gettime()
    {
        return time;
    }
}
