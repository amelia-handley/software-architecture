package KwikMedical.view;

import KwikMedical.controller.ControllerApplicationLayer;
import KwikMedical.controller.ControllerDataLayer;

import java.io.*;

public class ControllerLayers {
    // As other methods will be accessing these, make them globally accessible
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static ControllerApplicationLayer appLayer;

    public static void main(String[] args) {
        // Create the data layer
        ControllerDataLayer dataLayer = new ControllerDataLayer();
        // Create the application layer, passing in the data layer
        appLayer = new ControllerApplicationLayer(dataLayer);
        try {
            // Loop until programme is exited (or an exception occurs)
            while (true) {
                // Display the user menu
                displayMenu();
                // Get the user input
                int choice = Integer.parseInt(input.readLine());
                // Behave based on the user input
                switch (choice) {
                    case 1:
                        // 1 selected, add a new student
                        addPatient();
                        break;
                    case 2:
                        // 2 selected, get an existing student
                        getPatient();
                        break;
                    case 3:
                        // 3 selected, update an existing student
                        updatePatient();
                        break;
                    case 4:
                        //4 selected, report incident
                        addIncidentReport();
                        break;
                    case 5:
                        //5 selected, view incident reports
                        getIncident();
                        break;
                    case 6:
                        getAmbulance();
                        break;
                    case 7:
                        getInPatientDetails();
                        break;
                    default:
                        // Another value was entered.  Display error message
                        System.out.println("\nInvalid choice");
                        break;
                }
                System.out.println();
            }
        } catch (IOException ioe) {
            System.err.println("Error in I/O");
            System.err.println(ioe.getMessage());
            System.exit(-1);
        }
    }

    /**
     * Displays the user menu
     */
    private static void displayMenu() {
        System.out.println("--------------------------------------");
        System.out.println("|      KWIK MEDICAL APPLICATION      |");
        System.out.println("--------------------------------------");
        System.out.println("(1) Add Patient to System");
        System.out.println("(2) Find Patient from System");
        System.out.println("(3) Update Patient Details");
        System.out.println("--------------------------------------");
        System.out.println("|          INCIDENT REPORTING        |");
        System.out.println("--------------------------------------");
        System.out.println("(4) Add Emergency Incident");
        System.out.println("(5) View On-Going Emergency Reports");
        System.out.println("(6) Send Ambulance and Patient Details");
        System.out.println("--------------------------------------");
        System.out.println("|    REGIONAL HOSPITAL APPLICATION   |");
        System.out.println("--------------------------------------");
        System.out.println("(7) View In-Patient Details");
        System.out.println("--------------------------------------");
        System.out.print("\nEnter choice: ");
    }

    /**
     * Adds a new Patient record
     *
     * @throws IOException Thrown if a problem occurs during keyboard I/O
     */
    private static void addPatient() throws IOException {
        // Prompt and get all the student details
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //Prompt for Patient details
        System.out.println("\n*** Adding new patient ***");
        System.out.print("\nNew Patient Name: ");
        String patientName = input.readLine();
        System.out.print("New Patient NHS Registration number: ");
        String NHSRegistrationNumber = input.readLine();
        System.out.print("New Patient contact number: ");
        String contactNumber = input.readLine();
        System.out.print("New Patient Address: ");
        String patientAddress = input.readLine();
        System.out.println("Patients Medical records: ");
        String existingMedicalCondition = input.readLine();
        // Get the result from trying to add the Student record to the app layer
        String result = appLayer.addPatient(patientName, NHSRegistrationNumber, contactNumber, patientAddress, existingMedicalCondition);
        // Display result
        System.out.println("\n" + result);
    }

    /**
     * Gets an existing Student record
     *
     * @throws IOException Thrown if a problem occurs during keyboard I/O
     */
    private static void getPatient() throws IOException {
        // Prompt and get the Patients NHSReg number
        System.out.print("\n*** Viewing Patient Details ***");
        System.out.print("\nEnter patient NHS Registration Number: ");
        String NHSRegistrationNumber = input.readLine();
        // Get result from trying to retrieve the Student record
        String result = appLayer.getPatient(NHSRegistrationNumber);
        // Display result
        System.out.println("Patient details:" + result);
    }

    /**
     * Updates an existing Student record
     *
     * @throws IOException Thrown if a problem occurs during keyboard I/O
     */
    private static void updatePatient() throws IOException {
        // Prompt and get the Patient's reg number
        System.out.println("\n*** Updating Patient Details ***");
        System.out.print("Patient NHS Registration Number: ");
        String NHSRegistrationNumber = input.readLine();
        // Prompt and get the new Patient's details
        System.out.print("Patient Name: ");
        String patientName = input.readLine();
        System.out.print("Patient Address: ");
        String patientAddress = input.readLine();
        System.out.println("Patient Contact Number: ");
        String contactNumber = input.readLine();
        System.out.println("Patient Existing Medical Conditions");
        String existingMedicalConditions = input.readLine();
        // Get result from trying to update the Student record
        String result = appLayer.updatePatient(patientName, NHSRegistrationNumber, contactNumber, patientAddress, existingMedicalConditions);
        // Display result
        System.out.println("\n" + result);
    }

    /**
     * Adds Incident Report
     *
     * @throws IOException Thrown if a problem occurs during keyboard I/O
     */
    private static void addIncidentReport() throws IOException {
        // Prompt and get all the patient details
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //Prompt for Patient details
        System.out.print("*** Enter Emergency Incident Details ***\n");
        System.out.print("Incident ID: ");
        String incidentID = input.readLine();
        System.out.print("Patient Name: ");
        String incidentPatientName = input.readLine();
        System.out.print("Patient NHS Registration Number: ");
        String incidentNHSRegNumber = input.readLine();
        System.out.print("Incident Condition: ");
        String incidentCondition = input.readLine();
        System.out.println("Any Action Taken:");
        String incidentActionTaken = input.readLine();
        System.out.print("Incident Location: ");
        String incidentLocation = input.readLine();

        // Get the result from trying to add the incident patient record to the app layer
        String result = appLayer.addIncidentReport(incidentID, incidentPatientName, incidentNHSRegNumber, incidentCondition, incidentActionTaken, incidentLocation);
        // Display result
        System.out.println("\n" + result);
    }

    /**
     * Gets Incident Reports
     *
     * @throws IOException Thrown if a problem occurs during keyboard I/O
     */
    private static void getIncident() throws IOException {
        // Prompt and get the Incident ID
        System.out.print("\n*** Find on-going Incident Reports ***");
        System.out.print("\nEnter the Incident ID: ");
        String incidentID = input.readLine();
        // Get result from trying to retrieve the Patient record
        String result = appLayer.getIncident(incidentID);
        // Display result
        System.out.println("Incident details:" + result);
    }

    /**
     * Gets Ambulances in the area, looks at hospitals in area, adds the patients details to hospital
     *
     * @throws IOException Thrown if a problem occurs during keyboard I/O
     */
    private static void getAmbulance() throws IOException {
        // get the incident report
        System.out.println("*** Send Ambulance ***");
        ControllerLayers.getIncident();
        // Prompt to get patients NHSRegistration number
        System.out.print ("\nEnter patient NHS Registration Number: ");
        String NHSRegistrationNumber = input.readLine();
        // Get result from trying to retrieve the Patient record
        String result1 = appLayer.getPatient(NHSRegistrationNumber);
        // Display result
        System.out.println("Patient details:" + result1);

        System.out.print("\nCheck for ambulances in area: ");
        String incidentLocation = input.readLine();
        // Get result from trying to retrieve the Student record
        String result2 = appLayer.getAmbulance(incidentLocation);
        // Display result
        System.out.println("\n" + "Ambulance: " + result2);
        String result3 = appLayer.getHospital(incidentLocation);
        System.out.println("\nThe Patient will be taken to this regional Hospital: " + result3);

        String result4 = appLayer.addInPatient(NHSRegistrationNumber);
        System.out.println("\nIn-Patient Details: " + result4);
    }

    /**
     * Gets Patients in Hospital
     *
     * @throws IOException Thrown if a problem occurs during keyboard I/O
     */
    private static void getInPatientDetails() throws IOException {
        // Prompt and get the Incident ID
        System.out.print("\nEnter the Patient NHS Registration Number: ");
        String patientregid = input.readLine();
        // Get result from trying to retrieve the Patient record
        String result = appLayer.getInPatientDetails(patientregid);
        // Display result
        System.out.println("\nIn-Patient Details:" + result);
    }

}

/**
 * Removes an existing Patient record
 *
 * @throws IOException Thrown if a problem occurs during keyboard I/O
 */
  /*  private static void removePatient() throws IOException
    {
        // Prompt and get Patient's matric number
        System.out.print("\nPatient NHS Registration Number: ");
        String NHSRegistrationNumber = input.readLine();
        // Get result from trying to remove the Student record
        String result = appLayer.removePatient(NHSRegistrationNumber);
        // Display the result
        System.out.println("\n" + result);
    }
}*/

