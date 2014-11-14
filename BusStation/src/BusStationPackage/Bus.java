package BusStationPackage;

public class Bus {

    private int routeNo;
    private String destination;
    private String departureTime;
    
    public Bus() {
        super();
    }
    
    public Bus(int routeNo, String destination, String departureTime) {
        super();
        this.routeNo = routeNo;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public int getRouteNo() {
        return routeNo;
    }
    
    public void setRouteNo(int routeNo) {
        this.routeNo = routeNo;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getDepartureTime() {
        return departureTime;
    }
    
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    
    public String toString() {
        return "Bus route " + routeNo + " going to " + destination + " leaving at " + departureTime;
    }

    //non parameterized constructor


    // parameterized constructor


    //getters and setters for each of the 3 variables. 



}
