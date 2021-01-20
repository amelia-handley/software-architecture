package KwikMedical.controller;

import KwikMedical.model.Hospital;
import KwikMedical.model.Incident;
import KwikMedical.model.Patient;
import KwikMedical.model.Ambulance;
import KwikMedical.model.InPatient;

public class ControllerApplicationLayer implements ControllerApplicationLayerInterface {

    // the underlying data layer this application layer sits upon
    private ControllerDataLayerInterface dataLayer;

    /**
     * default constructor
     */
    public ControllerApplicationLayer(ControllerDataLayerInterface dataLayer) { this.dataLayer = dataLayer; }

    public String addPatient(String patientName, String NHSRegistrationNumber, String contactNumber, String patientAddress, String existingMedicalConditions)
    {
        // Create a Patient Record
        Patient patient = new Patient(patientName, NHSRegistrationNumber, contactNumber, patientAddress, existingMedicalConditions);

        // Try and add the record to the data layer
        boolean success = dataLayer.addPatient(patient);
        // Either the record was added or not
        if(success) {
            return "Patient " + NHSRegistrationNumber + " added.";
        }
        else
        {
            return "Failed to add Patient: " + NHSRegistrationNumber;
        }
    }

    public String getPatient(String NHSRegistrationNumber)
    {
        Patient patient = dataLayer.getPatient(NHSRegistrationNumber);
        // If the patient record does not exist, return null.
        if(patient != null)
        {
            return "\nPatient NHS Registration Number: " + patient.getNHSRegistrationNumber() + "\nPatient Name: " + patient.getPatientName() + "\nPatient Contact Number: " + patient.getContactNumber() + "\nPatient Address: " + patient.getPatientAddress() + "\nPatient Existing Medical Conditions: " + patient.getExistingMedicalCondition();
        }
        else {
            // Return fail message
            return "Patient " + NHSRegistrationNumber + "does not exist.";
        }
    }

    public String updatePatient(String patientName, String NHSRegistrationNumber, String contactNumber, String patientAddress, String existingMedicalConditions) {
        // Create a new Patient record object
        Patient patient = new Patient(patientName, NHSRegistrationNumber, contactNumber, patientAddress, existingMedicalConditions);
        // Return message if update was successful
        boolean success = dataLayer.updatePatient(NHSRegistrationNumber, patient);
        if(success) {
            return "Patient " + NHSRegistrationNumber + " was successfully updated.";
        } else {
            return "Patient " + NHSRegistrationNumber + " not updated.";
        }
    }

    // Incident Reports (add an incident report when an emergency call is received)

    public String addIncidentReport(String incidentID, String incidentPatientName, String incidentNHSRegNumber, String incidentCondition, String incidentActionTaken, String incidentLocation) {
        Incident incident = new Incident(incidentID, incidentPatientName, incidentNHSRegNumber, incidentCondition, incidentActionTaken, incidentLocation);

        //Try to add incident to a database
        boolean success = dataLayer.addIncidentReport(incident);
        // Either the record was added or not
        if(success) {
            return "Incident Report ID: " + incidentID + " added.";
        }
        else
        {
            return "Failed to add Incident Report ID: " + incidentID;
        }
    }

    // send ambulance (get method)

    public String getIncident(String incidentID)
    {
        Incident incident = dataLayer.getIncident(incidentID);
        // If the patient record does not exist, return null.
        if(incident != null)
        {
            return "\nIncident ID: " + incident.getIncidentID() + "\nIncident Patient Name:" + incident.getincidentPatientName() + "\nIncident Patient NHS Registration Number: " + incident.getincidentNHSRegNumber() + "\nIncident Patient Condition: " + incident.getIncidentCondition() + "\nAction Taken: " + incident.getIncidentActionTaken() + "\nIncident Location: " + incident.getIncidentLocation();
        }
        else {
            // Return fail message
            return "Incident " + incidentID + "does not exist.";
        }
    }

    public String getAmbulance(String ambulanceID) {
        Ambulance ambulance = dataLayer.getAmbulance(ambulanceID);
        if(ambulance!= null){
            return "\nAmbulance ID: " + ambulance.getAmbulanceID() + "\nAmbulance Driver: " + ambulance.getAmbulanceDriver() + "\nAmbulance Location: " + ambulance.getAmbulanceLocation() + "\nAmbulance Hospital: " + ambulance.getAmbulanceHospital() + "\n***Ambulance Being sent***";
        }
        else{
            return "Ambulance not available.";
        }
    }

    public String getHospital(String hospitalID){
        Hospital hospital = dataLayer.getHospital(hospitalID);
        if(hospital!=null){
            return "\nHospital ID: " + hospital.getHospitalID() + "\nHospital Location: " + hospital.getHospitalLocation() + "\nHospital Name: " + hospital.getHospitalName();
        }else{
            return "No hospitals in area.";
        }
    }

    public String addInPatient(String NHSRegistrationNumber) {
        Patient patient = dataLayer.getPatient(NHSRegistrationNumber);
        Incident incident = dataLayer.getIncident(NHSRegistrationNumber);

        dataLayer.addInPatient(patient, incident);

        if(patient!=null){
            return "\nIn Patient: " + NHSRegistrationNumber + " added to regional hospital system";
        }else {
            return "Patient: " + NHSRegistrationNumber + " does not exist";
        }
    }

    public String getInPatientDetails(String inNHSRegistrationNumber)
    {
        InPatient inPatient = dataLayer.getInPatientDetails(inNHSRegistrationNumber);
        // If the patient record does not exist, return null.
        if(inPatient != null)
        {
            return "\nPatient NHS Registration Number: " + inPatient.getInNHSRegistrationNumber() + "\nPatient Name: " + inPatient.getInPatientName() + "\nPatient Contact Number:" + inPatient.getInContactNumber() + "\nPatient Address: " + inPatient.getInPatientAddress() + "\nPatient Existing Medical Conditions: " + inPatient.getInExistingMedicalCondition() + "\nPatient Incident Condition: " + inPatient.getInIncidentCondition() + "\nAny Action Taken: " + inPatient.getInActionTaken() + "\nPatient Hospital Location: " + inPatient.getInHospitalName();
        }
        else {
            // Return fail message
            return "Patient " + inNHSRegistrationNumber + "does not exist.";
        }
    }

}
