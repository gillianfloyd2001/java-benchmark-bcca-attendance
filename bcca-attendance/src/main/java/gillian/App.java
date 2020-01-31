package gillian;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, Welcome to BCCA");
        ArrayList<AttendenceForm> attendences = loadAttendence();

        AttendenceForm attendence = takeAttendence();

        saveAttendence(attendences);
    }

    public static void saveAttendence(ArrayList<AttendenceForm> attendences) {
        try {
            FileOutputStream fileStream = new FileOutputStream("attendence.ser");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileStream);
            objOutput.writeObject(attendences);
            objOutput.close();
        } catch (IOException ex) {
            System.out.print("Sorry, can not save attenedence");
        }
    }

    public static AttendenceForm takeAttendence() {
        System.out.print("Name: ");
        String studentName = in.nextLine();
        System.out.print("date (day of week /mm/dd): ");
        String date = in.nextLine();
        System.out.print("Time: ");
        String time = in.nextLine();
        return new AttendenceForm(studentName, date, time);
    }

    public static ArrayList<AttendenceForm> loadAttendence() {
        try {
            FileInputStream fileStream = new FileInputStream("attendence.ser");
            ObjectInputStream objInput = new ObjectInputStream(fileStream);
            ArrayList<AttendenceForm> attedences = (ArrayList<AttendenceForm>) objInput.readObject();
            objInput.close();
            return attedences;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<AttendenceForm>();
        }
    }
}
