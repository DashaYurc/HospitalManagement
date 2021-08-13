package Menu;

import Objects.Patient;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import controllers.DoctorController;
import controllers.DrugController;
import controllers.PatientController;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What menu would you like to choose?");
        System.out.println("1. Doctor's menu.");
        System.out.println("2. Patient's menu.");
        System.out.println("3. Drug's menu.");

        int menu = scanner.nextInt();

        if (menu == 1) {
            System.out.println("What would you like to do now?");
            System.out.println("1. Add new doctor.");
            System.out.println("2. Remove doctor.");
            System.out.println("3. Edit a doctor's details.");
            System.out.println("4. Count the amount of doctors.");
            System.out.println("5. Count the average age of doctors.");
            System.out.println("6. To see the amount of doctor's patients.");
            System.out.println("7. Find doctor by id.");

            System.out.println("Select an option: ");
            int option = scanner.nextInt();


            switch (option) {
                case 1:
                    DoctorController.addNewDoctor();
                    break;
                case 2:
                    DoctorController.removeDoctor();
                    break;
                case 3:
                    DoctorController.editDoctor();
                    break;
                case 4:
                    DoctorController.countDoctors();
                    break;
                case 5:
                    DoctorController.averageAgeDoctors();
                    break;
                case 6:
                    DoctorController.countDoctorsPatients();
                    break;
                case 7:
                    DoctorController.getDoctorById();
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } else if(menu == 2){
            System.out.println("What would you like to do now?");
            System.out.println("1. Add new patient.");
            System.out.println("2. Remove patient.");
            System.out.println("3. Edit a patient's details.");
            System.out.println("4. Count the amount of patients.");
            System.out.println("5. Count the average age of patients.");
            System.out.println("6. Find patient by id.");

            System.out.println("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    PatientController.addNewPatient();
                    break;
                case 2:
                    PatientController.removePatient();
                    break;
                case 3:
                    PatientController.editPatient();
                    break;
                case 4:
                    PatientController.countPatients();
                    break;
                case 5:
                    PatientController.averageAgePatients();
                    break;
                case 6:
                    PatientController.getPatientById();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } else {
            System.out.println("What would you like to do now?");
            System.out.println("1. Add new drug.");
            System.out.println("2. Remove drug.");
            System.out.println("3. Add a new drug to the patient.");
            System.out.println("4. Count the amount of drugs.");
            System.out.println("5. Find drug by id.");

            System.out.println("Select an option: ");
            int option = scanner.nextInt();


            switch (option) {
                case 1:
                    DrugController.addNewDrug();
                    break;
                case 2:
                    DrugController.removeDrug();
                    break;
                case 3:
                    DrugController.addDrugToPatient();
                    break;
                case 4:
                    DrugController.countDrugs();
                    break;
                case 5:
                    DrugController.getDrugById();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

}
