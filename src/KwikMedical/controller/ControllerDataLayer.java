package KwikMedical.controller;

import KwikMedical.model.Hospital;
import KwikMedical.model.Incident;
import KwikMedical.model.Patient;
import KwikMedical.model.Ambulance;
import KwikMedical.model.InPatient;

import java.sql.*;

public class ControllerDataLayer implements ControllerDataLayerInterface {
    // Default constructor
    public ControllerDataLayer() {
    }

    // Add a new patient to the database
    public boolean addPatient(Patient patient) {
        boolean success = false;
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM PatientRecord WHERE NHSRegistrationNumber = '" + patient.getNHSRegistrationNumber() + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if a patient already exists with the same nhs number
            if (result.next()) {
                success = false;
                System.out.println("Patient already exists.");
            } else {
                // No patient exists. Add it to the database
                // Build the INSERT statement
                String update = "INSERT INTO PatientRecord (PatientName, NHSRegistrationNumber, ContactNumber, PatientAddress, ExistingMedicalCondition) " +
                        "VALUES ('" + patient.getPatientName() + "','" + patient.getNHSRegistrationNumber() + "','" + patient.getContactNumber() + "','" + patient.getPatientAddress() + "','" + patient.getExistingMedicalCondition() + "')";
                // Execute Statement
                statement.executeUpdate(update);
                // Return true
                success = true;
                System.out.println("Update successful.");
            }
            // Release resources held by the statement
            statement.close();
            // Release resources held by the connection. This also ensures that the INSERT completes,
            conn.close();

        } catch (ClassNotFoundException cnf) {
            System.err.print("Could not load driver.");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.print("Error performing SQL update.");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return success;
    }

    // Get a patient from the database
    public Patient getPatient(String NHSRegistrationNumber) {
        Patient patient = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM PatientRecord WHERE NHSRegistrationNumber = '" + NHSRegistrationNumber + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if a patient already exists with the same nhs number
            if (result.next()) {
                // Return the first instance of the NHSReg Number
                result.first();
                // Get patient details
                String patientName = result.getString("PatientName");
                String pNHSRegistrationNumber = result.getString("NHSRegistrationNumber");
                String contactNumber = result.getString("ContactNumber");
                String patientAddress = result.getString("PatientAddress");
                String existingMedicalCondition = result.getString("ExistingMedicalCondition");

                patient = new Patient(patientName, pNHSRegistrationNumber, contactNumber, patientAddress, existingMedicalCondition);
            }
        } catch (ClassNotFoundException cnf) {
            System.err.println("Could not load driver");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.println("Error in SQL Update");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return patient;
    }


    //Update a Patient
    public boolean updatePatient(String NHSRegistrationNumber, Patient patient) {
        // Check if the Patient record exists
        boolean success = false;
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM PatientRecord WHERE NHSRegistrationNumber = '" + patient.getNHSRegistrationNumber() + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if a patient already exists with the same NHS Registration Number
            if (result.next()) {
                // Return the first instance of the NHSReg Number
                result.first();
                // Update patient details
                result.updateString("PatientName", patient.getPatientName());
                result.updateString("ContactNumber", patient.getContactNumber());
                result.updateString("PatientAddress", patient.getPatientAddress());
                result.updateString("ExistingMedicalCondition", patient.getExistingMedicalCondition());
                result.updateRow();
                success = true;
            } else {
                // No patient exists.
                success = false;
                System.out.println("Patient does not exist");
            }
            // Release resources held by the statement
            statement.close();
            // Release resources held by the connection. This also ensures that the INSERT completes,
            conn.close();
        } catch (ClassNotFoundException cnf) {
            System.err.print("Could not load driver.");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.print("Error performing SQL update.");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return success;
    }

    // Add Incident Report
    public boolean addIncidentReport(Incident incident) {
        boolean success = false;
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM IncidentReport,PatientRecord WHERE PatientRecord.NHSRegistrationNumber = '" + incident.getincidentNHSRegNumber() + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if incident ID already exists
            if (result.next()) {
                success = false;
                System.out.println("There is no patient on the Kwik Medical system with that exists.");
            } else {
                System.out.println("Patient found in the Kwik Medical Database. Reporting Incident.");
                // Patient is on the system, add to the database
                // Build the INSERT statement
                String update = "INSERT INTO IncidentReport (IncidentID, IncidentPatientName, IncidentNHSRegNumber, IncidentCondition, IncidentActionTaken, IncidentLocation) " +
                        "VALUES ('" + incident.getIncidentID() + "','" + incident.getincidentPatientName() + "','" + incident.getincidentNHSRegNumber() + "','" + incident.getIncidentCondition() + "','" + incident.getIncidentActionTaken() + "','" + incident.getIncidentLocation() + "')";
                // Execute Statement
                statement.executeUpdate(update);
                // Return true
                success = true;
            }
            // Release resources held by the statement
            statement.close();
            // Release resources held by the connection. This also ensures that the INSERT completes,
            conn.close();
        } catch (ClassNotFoundException cnf) {
            System.err.print("Could not load driver.");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.print("Error performing SQL update.");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return success;
    }

    // Get Incident ID
    public Incident getIncident(String incidentID) {
        Incident incident = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM IncidentReport WHERE IncidentID = '" + incidentID + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if record exists
            if (result.next()) {
                // Return the first instance of the incident record
                result.first();
                // Get patient details
                String iincidentID = result.getString("IncidentID");
                String incidentPatientName = result.getString("IncidentPatientName");
                String incidentNHSRegNumber = result.getString("IncidentNHSRegNumber");
                String incidentCondition = result.getString("IncidentCondition");
                String incidentActionTaken = result.getString("IncidentActionTaken");
                String incidentLocation = result.getString("IncidentLocation");

                incident = new Incident(iincidentID, incidentPatientName, incidentNHSRegNumber, incidentCondition, incidentActionTaken, incidentLocation);
            }
        } catch (ClassNotFoundException cnf) {
            System.err.println("Could not load driver");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.println("Error in SQL Update");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return incident;
    }

    // Get ambulance ID
    public Ambulance getAmbulance(String ambulanceLocation)
    {
        Ambulance ambulance = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM AmbulanceRecord WHERE AmbulanceLocation= '" + ambulanceLocation + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if record exists
            if (result.next()) {
                // Return the first instance of the incident record
                result.first();
                // Get patient details
                String nambulanceID = result.getString("AmbulanceID");
                String ambulanceDriver = result.getString("AmbulanceDriver");
                String nambulanceLocation = result.getString("AmbulanceLocation");
                String ambulanceHospital = result.getString("AmbulanceHospital");
                ambulance = new Ambulance(nambulanceID, ambulanceDriver, nambulanceLocation, ambulanceHospital);
            }
        } catch (ClassNotFoundException cnf) {
            System.err.println("Could not load driver");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.println("Error in SQL Update");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return ambulance;
    }

    // Get Hospital ID
    public Hospital getHospital(String hospitalLocation)
    {
        Hospital hospital = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM HospitalRecords WHERE HospitalLocation= '" + hospitalLocation + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if record exists
            if (result.next()) {
                // Return the first instance of the incident record
                result.first();
                // Get patient details
                String hospitalID = result.getString("HospitalID");
                String nhospitalLocation = result.getString("HospitalLocation");
                String hospitalName = result.getString("HospitalName");
                hospital = new Hospital(hospitalID, nhospitalLocation, hospitalName);
            }
        } catch (ClassNotFoundException cnf) {
            System.err.println("Could not load driver");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.println("Error in SQL Update");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return hospital;
    }

    //add in patient report
    public Patient addInPatient(Patient patient, Incident incident) {

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM PatientRecord WHERE NHSRegistrationNumber = '" + patient.getNHSRegistrationNumber() + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if a patient already exists with the same reg number
                result.first();
                // Will insert the patient name, nhs number, contact number, medical conditions, incident condition, action taken and the hospital the patient is sent to
                String update = "INSERT INTO InPatientRecord (InPatientName, InNHSRegistrationNumber, InContactNumber, InPatientAddress, InExistingMedicalCondition, InIncidentCondition, InActionTaken, hospitalName) " +
                        "SELECT PatientName, p.NHSRegistrationNumber, ContactNumber, PatientAddress, ExistingMedicalCondition, i.IncidentCondition, i.IncidentActionTaken, h.HospitalName " +
                        "FROM PatientRecord p " +
                        "INNER JOIN IncidentReport i ON p.NHSRegistrationNumber = i.IncidentNHSRegNumber " +
                        "INNER JOIN HospitalRecords h ON i.IncidentLocation = h.HospitalLocation";
                // Execute Statement
                statement.executeUpdate(update);
                //System.out.println("Update successful.");
            // Release resources held by the statement
            statement.close();
            // Release resources held by the connection. This also ensures that the INSERT completes,
            conn.close();

        } catch (ClassNotFoundException cnf) {
            System.err.print("Could not load driver.");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.print("Error performing SQL update.");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return patient;
    }

    // Get in-patient details from the database
    public InPatient getInPatientDetails(String inNHSRegistrationNumber) {
        InPatient inPatient = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/KwikMedical?user=Java1&password=Java1");
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM inPatientRecord WHERE inNHSRegistrationNumber = '" + inNHSRegistrationNumber + "'";
            ResultSet result = statement.executeQuery(query);

            // Check to see if a patient already exists with the same matric number
            if (result.next()) {
                // Return the first instance of the NHSReg Number
                result.first();
                // Get patient details
                String inPatientName = result.getString("InPatientName");
                String pNHSRegistrationNumber = result.getString("InNHSRegistrationNumber");
                String inContactNumber = result.getString("InContactNumber");
                String inPatientAddress = result.getString("InPatientAddress");
                String inExistingMedicalCondition = result.getString("InExistingMedicalCondition");
                String inIncidentCondition = result.getString("InIncidentCondition");
                String inActionTaken = result.getString("InActionTaken");
                String inHospitalName = result.getString("hospitalName");
                inPatient = new InPatient(inPatientName, pNHSRegistrationNumber, inContactNumber, inPatientAddress, inExistingMedicalCondition, inIncidentCondition, inActionTaken, inHospitalName);
            }
        } catch (ClassNotFoundException cnf) {
            System.err.println("Could not load driver");
            System.err.println(cnf.getMessage());
            System.exit(-1);
        } catch (SQLException sqe) {
            System.err.println("Error in SQL Update");
            System.err.println(sqe.getMessage());
            System.exit(-1);
        }
        return inPatient;
    }
}








