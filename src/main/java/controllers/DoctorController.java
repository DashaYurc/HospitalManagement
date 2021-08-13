package controllers;

import Objects.Doctor;
import Objects.Patient;
import dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static void addNewDoctor() {

        System.out.println("Enter the name of the doctor:");
        String name = scanner.next();

        System.out.println("Enter the age of the doctor: ");
        int age = scanner.nextInt();

        System.out.println("Enter the specialisation of the doctor:");
        String specialisation = scanner.next();

        try {

            ps = DbConnection.getConnection().prepareStatement("INSERT INTO doctors(name, age, specialisation) " +
                    " VALUES('" + name + "', " + age + ",'" + specialisation + "')");
            ps.execute();
            System.out.println("Successfully added doctor.");


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static void removeDoctor() {
        System.out.println("Enter the id of the doctor you want to remove: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("DELETE FROM doctors WHERE doctor_id = " + id);
            ps.execute();
            System.out.println("The doctor has been removed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void editDoctor() {

        System.out.print("Enter the doctor's id: ");
        int doctorId = scanner.nextInt();

        System.out.println("Available fields: name, age, specialisation.");
        System.out.print("Enter the field you want to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConnection.getConnection().prepareStatement("UPDATE doctors SET " + field + " = '" + update +
                    "' WHERE doctor_id = " + doctorId);
            ps.execute();
            System.out.println("Successfully updated doctor.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void countDoctors() {

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM doctors");
            rs = ps.executeQuery();

            int count = 0;
            if(rs.next()) {
                count = rs.getInt(1);
            }

            System.out.println("The amount of doctors is: "+ count + " people.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void averageAgeDoctors() {

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT ROUND(AVG(age),0) FROM doctors");
            rs = ps.executeQuery();

            int avgAge = 0;
            if(rs.next()) {
                avgAge = rs.getInt(1);
            }

            System.out.println("The average age of doctors is: "+ avgAge + " years.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void countDoctorsPatients() {

        System.out.println("Enter the doctor's ID to see how many patients this doctor has.");
        int doctorId = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM patients where doctor_id = " +
                    doctorId);
            rs = ps.executeQuery();

            int patientsAmount = 0;
            if(rs.next()) {
                patientsAmount = rs.getInt(1);
            }

            System.out.println("The amount of patients is: "+ patientsAmount + " people.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Doctor getDoctorById() {

        //prompt the user to enter the id of the student they want to retrieve
        System.out.println("Enter the id of the doctor: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT * FROM doctors WHERE doctor_id =" + id);
            rs = ps.executeQuery();

            Doctor doctor = new Doctor();
            int doctorId, age;
            String name, specialisation;

            while (rs.next()) {
                doctorId = rs.getInt("doctor_id");
                name = rs.getString("name");
                age = rs.getInt("age");
                specialisation = rs.getString("specialisation");
                doctor.setId(doctorId);
                doctor.setName(name);
                doctor.setAge(age);
                System.out.println(doctorId + "\t " + name + "\t" + age + "\t " + specialisation + "\t");
            }
            return doctor;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
