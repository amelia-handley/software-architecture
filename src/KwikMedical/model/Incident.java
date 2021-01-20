package KwikMedical.model;

public class Incident {
    private String incidentID;
    private String incidentPatientName;
    private String incidentNHSRegNumber;
    private String incidentCondition;
    private String incidentLocation;
    private String incidentActionTaken;
    //private Date dateOfIncident;

    public Incident(String incidentID, String incidentPatientName,
                    String incidentNHSRegNumber, String incidentCondition, String incidentActionTaken, String incidentLocation){
        this.incidentID = incidentID;
        this.incidentPatientName = incidentPatientName;
        this.incidentNHSRegNumber = incidentNHSRegNumber;
        this.incidentCondition = incidentCondition;
        this.incidentActionTaken = incidentActionTaken;
        this.incidentLocation = incidentLocation;

    }
    /**
     * Getters and Setters for Incident Class
     */
    public String getIncidentID(){return incidentID;}
    public void setIncidentID(String incidentID){this.incidentID=incidentID;}
    public String getincidentPatientName() { return incidentPatientName; }
    public void setIncidentPatientName(String incidentPatientName) { this.incidentPatientName = incidentPatientName; }
    public String getincidentNHSRegNumber(){return incidentNHSRegNumber;}
    public void setIncidentNHSRegNumber(String incidentNHSRegNumber){this.incidentNHSRegNumber=incidentNHSRegNumber;}
    public String getIncidentCondition(){return incidentCondition;}
    public void setIncidentCondition(String incidentCondition){this.incidentCondition=incidentCondition;}
    public String getIncidentActionTaken(){return incidentActionTaken;}
    public void setIncidentActionTaken(String incidentActionTaken){this.incidentActionTaken=incidentActionTaken;}
    public String getIncidentLocation(){return incidentLocation;}
    public void setIncidentLocation(String incidentLocation){this.incidentLocation=incidentLocation;}

}
