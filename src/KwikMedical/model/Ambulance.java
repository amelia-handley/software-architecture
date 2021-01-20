package KwikMedical.model;

public class Ambulance {

    // Attributes of the Ambulance class
    private String ambulanceID;
    private String ambulanceDriver;
    private String ambulanceLocation;
    private String ambulanceHospital;

    //Default Constructor

    public Ambulance(String ambulanceID, String ambulanceDriver, String ambulanceLocation, String ambulanceHospital){
        this.ambulanceID = ambulanceID;
        this.ambulanceDriver = ambulanceDriver;
        this.ambulanceLocation = ambulanceLocation;
        this.ambulanceHospital = ambulanceHospital;
    }

    /**
     * Getters and Setters of Ambulance Class
     */

    public String getAmbulanceID(){return ambulanceID;}
    public void setAmbulanceID(String ambulanceID){this.ambulanceID = ambulanceID;}
    public String getAmbulanceDriver(){return ambulanceDriver;}
    public void setAmbulanceDriver(String ambulanceDriver){this.ambulanceDriver = ambulanceDriver;}
    public String getAmbulanceLocation(){return ambulanceLocation;}
    public void setAmbulanceLocation(String ambulanceLocation){this.ambulanceLocation = ambulanceLocation;}
    public String getAmbulanceHospital(){return ambulanceHospital;}
    public void setAmbulanceHospital(String ambulanceHospital){this.ambulanceHospital = ambulanceHospital;}
}
