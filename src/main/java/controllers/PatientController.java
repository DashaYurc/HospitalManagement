package controllers;

import Objects.Drug;
import Objects.Patient;
import dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addNewPatient() {

        System.out.println("Enter the name of the patient:");
        String name = scanner.next();

        System.out.println("Enter the age of the patient: ");
        int age = scanner.nextInt();

        System.out.println("Enter the doctor's ID who will be responsible for the patient: ");
        int doctorId = scanner.nextInt();

        try {

            ps = DbConnection.getConnection().prepareStatement("INSERT INTO patients(name, age, doctor_id) " +
                    " VALUES('" + name + "', " + age + "," + doctorId + ")");
            ps.execute();
            System.out.println("Successfully added patient.");


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public static void removePatient() {
        System.out.println("Enter the id of the patient you want to remove: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("DELETE FROM patients WHERE patient_id = " + id);
            ps.execute();
            System.out.println("The patient has been removed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void editPatient() {

        System.out.print("Enter the patients's id: ");
        int patientId = scanner.nextInt();

        System.out.println("Available fields: name, age, date_in, date_out. The correct way to edit date is: YYYY-MM-DD.");
        System.out.print("Enter the field you want to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConnection.getConnection().prepareStatement("UPDATE patients SET " + field + " = '" + update +
                    "' WHERE patient_id = " + patientId);
            ps.execute();
            System.out.println("Successfully updated patient.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void countPatients() {

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM patients");
            rs = ps.executeQuery();

            int count = 0;
            if(rs.next()) {
                count = rs.getInt(1);
            }

            System.out.println("The amount of patients is: "+ count + " people.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void averageAgePatients() {

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT ROUND(AVG(age),0) FROM patients");
            rs = ps.executeQuery();

            int avgAge = 0;
            if(rs.next()) {
                avgAge = rs.getInt(1);
            }

            System.out.println("The average age of patients is: "+ avgAge + " years.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Patient getPatientById() {

        //prompt the user to enter the id of the student they want to retrieve
        System.out.println("Enter the id of the patient: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT * FROM patients WHERE patient_id =" + id);
            rs = ps.executeQuery();

            Patient patient = new Patient();
            int patientId, age;
            String name;

            while (rs.next()) {
                patientId = rs.getInt("patient_id");
                name = rs.getString("name");
                age = rs.getInt("age");
                patient.setPatientId(patientId);
                patient.setName(name);
                patient.setAge(age);
                System.out.println(patientId + "\t" + name + "\t" + age + "\t" + "years old.");
            }
            return patient;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }



}
