package KwikMedical.model;

public class Hospital {

    // Attributes of the Hospital Class
    private String hospitalID;
    private String hospitalLocation;
    private String hospitalName;

    // Default Constructor
    public Hospital (String hospitalID, String hospitalLocation, String hospitalName){
        this.hospitalID = hospitalID;
        this.hospitalLocation = hospitalLocation;
        this.hospitalName = hospitalName;
    }

    /**
     * Getters and Setters for the hospital class
     */
    public String getHospitalID(){return hospitalID;}
    public void setHospitalID(String hospitalID){this.hospitalID = hospitalID;}
    public String getHospitalLocation(){return hospitalLocation;}
    public void setHospitalLocation(String hospitalLocation){this.hospitalLocation = hospitalLocation;}
    public String getHospitalName(){return hospitalName;}
    public void setHospitalName(String hospitalName){this.hospitalName = hospitalName;}

}
