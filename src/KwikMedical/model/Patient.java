package KwikMedical.model;

public class Patient {

    // Attributes of the Patient object
    private String patientName;
    private String NHSRegistrationNumber;
    private String contactNumber;
    private String patientAddress;
    private String existingMedicalCondition;

    // Default constructor

    public Patient(String patientName, String NHSRegistrationNumber, String contactNumber, String patientAddress, String existingMedicalCondition )
    {
        this.patientName = patientName;
        this.NHSRegistrationNumber = NHSRegistrationNumber;
        this.contactNumber = contactNumber;
        this.patientAddress = patientAddress;
        this.existingMedicalCondition = existingMedicalCondition;
    }

    /**Ú
     * Getters and Setters for the patient details
     */

    // Gets the Patient name
    public String getPatientName() { return patientName; }

    // Changes the Patients name
    public void setPatientName(String patientName) { this.patientName = patientName; }

    // Gets the Patients NHSRegistrationNumber
    public String getNHSRegistrationNumber() { return NHSRegistrationNumber; }

    // Changes the Patients name
    public void setNHSRegistrationNumber(String NHSRegistrationNumber) { this.NHSRegistrationNumber = NHSRegistrationNumber; }

    // Gets the Patients contact number
    public String getContactNumber() { return contactNumber; }

    // Changes the Patients contact number
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    // Gets the Patients address
    public String getPatientAddress() { return patientAddress; }

    // Changes the Patients address
    public void setPatientAddress(String patientAddress) { this.patientAddress = patientAddress; }

    // Gets the Patients MedicalCondition
    public String getExistingMedicalCondition() { return existingMedicalCondition; }

    // Changes the Patients Medical Condition
    public void setExistingMedicalCondition(String existingMedicalConditions) { this.existingMedicalCondition = existingMedicalConditions; }
}
