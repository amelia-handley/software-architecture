package KwikMedical.controller;

public interface ControllerApplicationLayerInterface {
    // Adds a new patient to the underlying data layer
    public String addPatient(String patientName, String NHSRegistrationNumber, String contactNumber, String patientAddress, String existingMedicalConditions);
    // Updates a new patient
    public String updatePatient(String patientName, String NHSRegistrationNumber, String contactNumber, String patientAddress, String existingMedicalConditions);
    // Gets a patient record
    public String getPatient(String NHSRegistrationNumber);
    // Incident Reports
    public String addIncidentReport(String incidentID, String incidentPatientName, String incidentNHSRegNumber, String incidentCondition, String incidentActionTaken, String incidentLocation);

    public String getIncident(String incidentID);

    public String getAmbulance(String ambulanceID);

    public String getHospital(String hospitalID);

    public String addInPatient(String NHSRegistrationNumber);

    public String getInPatientDetails(String NHSRegistrationNumber);

}
