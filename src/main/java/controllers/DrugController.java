package controllers;

import Objects.Doctor;
import Objects.Drug;
import dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DrugController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;


    public static void addNewDrug() {

        System.out.println("Enter the name of the drug:");
        String drugName = scanner.next();

        try {

            ps = DbConnection.getConnection().prepareStatement("INSERT INTO drugs(drug_name) " +
                    " VALUES('" + drugName + "')");
            ps.execute();
            System.out.println("Successfully added drug.");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    public static void removeDrug() {
        System.out.println("Enter the id of the drug you want to remove: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("DELETE FROM drugs WHERE drug_id = " + id);
            ps.execute();
            System.out.println("The drug has been removed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addDrugToPatient() {

        System.out.println("Enter the id of the patient: ");
        int patientId = scanner.nextInt();

        System.out.println("Enter the drug's ID for the patient: ");
        int drugId = scanner.nextInt();

        try {

            ps = DbConnection.getConnection().prepareStatement("UPDATE patients SET drug_id = " + drugId + " WHERE " +
                    "patient_id = " + patientId);
            ps.execute();
            System.out.println("Successfully added drug for the patient.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void countDrugs() {

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT COUNT(*) FROM drugs");
            rs = ps.executeQuery();

            int count = 0;
            if(rs.next()) {
                count = rs.getInt(1);
            }

            System.out.println("The amount of drugs is: "+ count + " types.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Drug getDrugById() {

        //prompt the user to enter the id of the student they want to retrieve
        System.out.println("Enter the id of the drug: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT * FROM drugs WHERE drug_id =" + id);
            rs = ps.executeQuery();

            Drug drug = new Drug();
            int drugId;
            String name;

            while (rs.next()) {
                drugId = rs.getInt("drug_id");
                name = rs.getString("drug_name");
                drug.setId(drugId);
                drug.setName(name);
                System.out.println(drugId + "\t " + name + "\t");
            }
            return drug;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
