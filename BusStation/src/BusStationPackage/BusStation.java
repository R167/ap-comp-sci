package BusStationPackage;

public class BusStation {

    private String address;
    private Bus bus1;
    private Bus bus2;
    
    public BusStation() {
        super();
        this.bus1 = new Bus();
        this.bus2 = new Bus();
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public Bus getBus(int num) {
        return num == 1 ? this.bus1 : this.bus2;
    }

    public void setBus(int num, int routeNum, String destination, String departureTime) {
        if (num == 1) {
            this.bus1.setRouteNo(routeNum);
            this.bus1.setDestination(destination);
            this.bus1.setDepartureTime(departureTime);
        } else {
            this.bus2.setRouteNo(routeNum);
            this.bus2.setDestination(destination);
            this.bus2.setDepartureTime(departureTime);
        }
    }

    //non-parameterized constructor


    //getter and setter for Adress


}
