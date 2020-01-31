package gillian;

import java.io.Serializable;

public class AttendenceForm implements Serializable {
    private static final long serialVersionUID = 1L;
    String studentName;
    String date;
    String time;

    public AttendenceForm(String studentName, String date, String time) {
        this.studentName = studentName;
        this.date = date;
        this.time = time;
    }

}
