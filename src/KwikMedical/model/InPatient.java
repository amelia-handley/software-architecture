package KwikMedical.model;

public class InPatient {
    // Attributes of the Patient object
    private String inPatientName;
    private String inNHSRegistrationNumber;
    private String inContactNumber;
    private String inPatientAddress;
    private String inExistingMedicalCondition;
    private String inIncidentCondition;
    private String inActionTaken;
    private String inHospitalName;

    // Default constructor

    public InPatient(String inPatientName, String inNHSRegistrationNumber, String inContactNumber, String inPatientAddress, String inExistingMedicalCondition, String inIncidentCondition, String inActionTaken, String inHospitalName)
    {
        this.inPatientName = inPatientName;
        this.inNHSRegistrationNumber = inNHSRegistrationNumber;
        this.inContactNumber = inContactNumber;
        this.inPatientAddress = inPatientAddress;
        this.inExistingMedicalCondition = inExistingMedicalCondition;
        this.inIncidentCondition = inIncidentCondition;
        this.inHospitalName = inHospitalName;
        this.inActionTaken = inActionTaken;

    }

    /**
     * Getters and Setters for the in-patient details
     */

    // Gets the Patient name
    public String getInPatientName() { return inPatientName; }
    // Changes the Patients name
    public void setInPatientName(String inPatientName) { this.inPatientName = inPatientName; }

    // Gets the Patients NHSRegistrationNumber
    public String getInNHSRegistrationNumber() { return inNHSRegistrationNumber; }
    // Changes the Patients name
    public void setInNHSRegistrationNumber(String inNHSRegistrationNumber) { this.inNHSRegistrationNumber = inNHSRegistrationNumber; }

    // Gets the Patients contact number
    public String getInContactNumber() { return inContactNumber; }
    // Changes the Patients contact number
    public void setInContactNumber(String inContactNumber) { this.inContactNumber = inContactNumber; }

    // Gets the Patients address
    public String getInPatientAddress() { return inPatientAddress; }
    // Changes the Patients address
    public void setInPatientAddress(String inPatientAddress) { this.inPatientAddress = inPatientAddress; }

    // Gets the Patients MedicalCondition
    public String getInExistingMedicalCondition() { return inExistingMedicalCondition; }
    // Changes the Patients Medical Condition
    public void setInExistingMedicalCondition(String inExistingMedicalCondition) { this.inExistingMedicalCondition = inExistingMedicalCondition; }

    // Gets the Patients Incident Condition
    public String getInIncidentCondition() { return inIncidentCondition; }
    // Changes the Patients Medical Condition
    public void setInIncidentCondition(String inIncidentCondition) { this.inIncidentCondition = inIncidentCondition; }

    // Gets the action taken
    public String getInActionTaken() { return inActionTaken; }
    public void setInActionTaken(String inActionTaken) {this.inActionTaken = inActionTaken; }

    // Gets the Patients Hospital
    public String getInHospitalName() {return inHospitalName; }
    public void setInHospitalName(String inHospitalName) {this.inHospitalName = inHospitalName; }




}
