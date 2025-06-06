package org.example;

import java.util.*;

// Patient class to store patient information
class Patient {
    private String pid;
    private String firstName;
    private String lastName;
    private String email;
    private long mobileNumber;
    private String gender;
    private String city;
    private String doctorId;
    private String doctorName;
    private String address;
    private long contactNo;

    // Constructor
    public Patient(String pid, String firstName, String lastName, String email,
                   long mobileNumber, String gender, String city, String doctorId,
                   String doctorName, String address, long contactNo) {
        this.pid = pid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.city = city;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.address = address;
        this.contactNo = contactNo;
    }

    // Getters
    public String getPid() { return pid; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public long getMobileNumber() { return mobileNumber; }
    public String getGender() { return gender; }
    public String getCity() { return city; }
    public String getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public String getAddress() { return address; }
    public long getContactNo() { return contactNo; }

    // Setters
    public void setEmail(String email) { this.email = email; }
    public void setMobileNumber(long mobileNumber) { this.mobileNumber = mobileNumber; }
    public void setContactNo(long contactNo) { this.contactNo = contactNo; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }

    // toString method for displaying patient details
    @Override
    public String toString() {
        return "Patient Details:\n" +
                "PID: " + pid + "\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Mobile: " + mobileNumber + "\n" +
                "Gender: " + gender + "\n" +
                "City: " + city + "\n" +
                "Doctor ID: " + doctorId + "\n" +
                "Doctor Name: " + doctorName + "\n" +
                "Address: " + address + "\n" +
                "Contact No: " + contactNo + "\n";
    }
}

public class Main {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int pidCounter = 1000; // Starting PID counter

    public static void main(String[] args) {
        System.out.println("=== HOSPITAL ADMINISTRATION SYSTEM ===");
        System.out.println("Welcome Administrator!");

        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    System.out.println("You have selected the Patient Registration Feature.");
                    registerPatient();
                    break;
                case 2:
                    System.out.println("You have selected the View Patient Details Feature.");
                    viewPatientDetails();
                    break;
                case 3:
                    System.out.println("You have selected the Search Patient Feature.");
                    searchPatientByPID();
                    break;
                case 4:
                    System.out.println("You have selected the Update Patients by Email Domain Feature.");
                    updatePatientsByEmailDomain();
                    break;
                case 5:
                    System.out.println("You have selected the Delete Patients by Mobile number Feature.");
                    deletePatientsByMobileNumber();
                    break;
                case 6:
                    System.out.println("Good Bye Administrator!! Terminating the Program!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option (1-6).");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void displayMenu() {
        System.out.println("\n==========================================");
        System.out.println("          HOSPITAL ADMIN MENU");
        System.out.println("==========================================");
        System.out.println("1. Patient Registration");
        System.out.println("2. View Patient Details");
        System.out.println("3. Search Patient by PID");
        System.out.println("4. Update Patients by Email Domain");
        System.out.println("5. Delete Patients by Mobile Number");
        System.out.println("6. Exit");
        System.out.println("==========================================");
        System.out.print("Enter your choice (1-6): ");
    }

    private static int getChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }

    private static void registerPatient() {
        System.out.println("\n--- PATIENT REGISTRATION ---");

        try {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Enter Email ID: ");
            String email = scanner.nextLine().trim();

            System.out.print("Enter Mobile Number: ");
            long mobileNumber = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Gender: ");
            String gender = scanner.nextLine().trim();

            System.out.print("Enter City: ");
            String city = scanner.nextLine().trim();

            System.out.print("Enter Doctor ID: ");
            String doctorId = scanner.nextLine().trim();

            System.out.print("Enter Doctor Name: ");
            String doctorName = scanner.nextLine().trim();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine().trim();

            System.out.print("Enter Contact Number: ");
            long contactNo = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            // Generate unique PID
            String pid = "PID" + (pidCounter++);

            // Create and add patient
            Patient patient = new Patient(pid, firstName, lastName, email, mobileNumber,
                    gender, city, doctorId, doctorName, address, contactNo);
            patients.add(patient);

            System.out.println("\n✓ Patient registered successfully!");
            System.out.println("Generated Patient ID: " + pid);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input format. Please enter correct data types.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("Error occurred during registration: " + e.getMessage());
        }
    }

    private static void viewPatientDetails() {
        System.out.println("\n--- ALL PATIENT DETAILS ---");

        if (patients.isEmpty()) {
            System.out.println("No patients registered in the system.");
            return;
        }

        System.out.println("Total Patients: " + patients.size());
        System.out.println("==========================================");

        for (int i = 0; i < patients.size(); i++) {
            System.out.println("Patient " + (i + 1) + ":");
            System.out.println(patients.get(i));
            System.out.println("==========================================");
        }
    }

    private static void searchPatientByPID() {
        System.out.println("\n--- SEARCH PATIENT BY PID ---");

        if (patients.isEmpty()) {
            System.out.println("No patients registered in the system.");
            return;
        }

        System.out.print("Enter Patient ID (PID): ");
        String searchPID = scanner.nextLine().trim();

        boolean found = false;
        for (Patient patient : patients) {
            if (patient.getPid().equalsIgnoreCase(searchPID)) {
                System.out.println("\n✓ Patient Found!");
                System.out.println("==========================================");
                System.out.println(patient);
                System.out.println("==========================================");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("✗ No patient found with PID: " + searchPID);
        }
    }

    private static void updatePatientsByEmailDomain() {
        System.out.println("\n--- UPDATE PATIENTS BY EMAIL DOMAIN ---");

        if (patients.isEmpty()) {
            System.out.println("No patients registered in the system.");
            return;
        }

        System.out.print("Enter email domain to search (e.g., gmail.com): ");
        String domain = scanner.nextLine().trim();

        System.out.println("Patients with email domain '" + domain + "':");

        boolean found = false;
        for (Patient patient : patients) {
            if (patient.getEmail().toLowerCase().endsWith("@" + domain.toLowerCase())) {
                System.out.println("PID: " + patient.getPid() + " | Name: " +
                        patient.getFirstName() + " " + patient.getLastName() +
                        " | Email: " + patient.getEmail());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found with email domain: " + domain);
            return;
        }

        System.out.print("\nEnter PID of patient to update: ");
        String pidToUpdate = scanner.nextLine().trim();

        for (Patient patient : patients) {
            if (patient.getPid().equalsIgnoreCase(pidToUpdate) &&
                    patient.getEmail().toLowerCase().endsWith("@" + domain.toLowerCase())) {

                System.out.println("\nCurrent details:");
                System.out.println(patient);

                System.out.println("What would you like to update?");
                System.out.println("1. Email");
                System.out.println("2. Address");
                System.out.println("3. City");
                System.out.println("4. Contact Number");
                System.out.print("Enter choice: ");

                int updateChoice = getChoice();

                switch (updateChoice) {
                    case 1:
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine().trim();
                        patient.setEmail(newEmail);
                        System.out.println("✓ Email updated successfully!");
                        break;
                    case 2:
                        System.out.print("Enter new address: ");
                        String newAddress = scanner.nextLine().trim();
                        patient.setAddress(newAddress);
                        System.out.println("✓ Address updated successfully!");
                        break;
                    case 3:
                        System.out.print("Enter new city: ");
                        String newCity = scanner.nextLine().trim();
                        patient.setCity(newCity);
                        System.out.println("✓ City updated successfully!");
                        break;
                    case 4:
                        System.out.print("Enter new contact number: ");
                        try {
                            long newContact = scanner.nextLong();
                            scanner.nextLine();
                            patient.setContactNo(newContact);
                            System.out.println("✓ Contact number updated successfully!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid contact number format.");
                            scanner.nextLine();
                        }
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                return;
            }
        }

        System.out.println("Patient with PID " + pidToUpdate + " not found or doesn't have the specified email domain.");
    }

    private static void deletePatientsByMobileNumber() {
        System.out.println("\n--- DELETE PATIENTS BY MOBILE NUMBER ---");

        if (patients.isEmpty()) {
            System.out.println("No patients registered in the system.");
            return;
        }

        System.out.print("Enter mobile number: ");
        try {
            long mobileNumber = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            boolean found = false;
            Iterator<Patient> iterator = patients.iterator();

            while (iterator.hasNext()) {
                Patient patient = iterator.next();
                if (patient.getMobileNumber() == mobileNumber) {
                    System.out.println("\nPatient found:");
                    System.out.println("PID: " + patient.getPid());
                    System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
                    System.out.println("Mobile: " + patient.getMobileNumber());

                    System.out.print("Are you sure you want to delete this patient? (yes/no): ");
                    String confirmation = scanner.nextLine().trim().toLowerCase();

                    if (confirmation.equals("yes") || confirmation.equals("y")) {
                        iterator.remove();
                        System.out.println("✓ Patient deleted successfully!");
                        found = true;
                    } else {
                        System.out.println("Delete operation cancelled.");
                        found = true;
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("✗ No patient found with mobile number: " + mobileNumber);
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid mobile number format. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
}