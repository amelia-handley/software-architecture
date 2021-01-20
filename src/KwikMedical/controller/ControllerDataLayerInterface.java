package KwikMedical.controller;

import KwikMedical.model.Hospital;
import KwikMedical.model.Incident;
import KwikMedical.model.Patient;
import KwikMedical.model.Ambulance;
import KwikMedical.model.InPatient;

public interface ControllerDataLayerInterface {
    // Adds a new student to the data store
    public boolean addPatient(Patient patient);

    // Returns a Patient record from the data source
    public Patient getPatient(String NHSRegistrationNumber);

    // Removes a Patient from the data store
    // public boolean removePatient(String NHSRegistrationNumber);

    //Updates a Patient record in the data store
    public boolean updatePatient(String NHSRegistrationNumber, Patient patient);

    // Adds Incident Case
    public boolean addIncidentReport(Incident incident);

    // Gets Incident Reports
    public Incident getIncident(String incidentID);

    // Gets AmbulanceS
    public Ambulance getAmbulance(String ambulanceID);

    // Get local hospital
    public Hospital getHospital(String hospitalID);

    // Add inpatient
    public Patient addInPatient(Patient patient, Incident incident);

    public InPatient getInPatientDetails(String inNHSRegistrationNumber);

}
