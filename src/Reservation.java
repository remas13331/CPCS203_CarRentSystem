import java.util.*;
public class Reservation {
    private  String reservationCode;
    private  String pickUpLocation;
    private  String dropOfLocation;
    private  Date pickUpDate;
    private  Date dropOfDate;
    private  Date dateOfReservation;
    private  Customer customer;
    private  Car car;
    private  Service additionalServices;

    //constructor///////////////////////////////////////////////////////////
    public  Reservation(String pickUpLocation, String dropOfLocation, Date pickUpDate, Date dropOfDate,Customer customer, Car car){
        this.pickUpLocation = pickUpLocation;
        this.dropOfLocation = dropOfLocation;
        this.pickUpDate = pickUpDate;
        this.dropOfDate = dropOfDate;
        this.customer = customer;
        this.car = car;
    }

    //set & get code/////////////////////////////////////////////////////////
    public  void setReservationCode(String c){
        reservationCode =c;
    }
    public  String getReservationCode(){
        return reservationCode;
    }

    //set & get p location//////////////////////////////////////////////////////
    public  void setPickUpLocation(String l){
        pickUpLocation =l ;
    }
    public  String getPickUpLocation(){
        return pickUpLocation;
    }

    //set & get d location//////////////////////////////////////////////////////
    public  void setDropOfLocation(String d){
        dropOfLocation = d;
    }
    public  String getDropOfLocation(){
        return dropOfLocation;
    }

    //set & get services/////////////////////////////////////////////////////
    public  void addService(Service currenService){
        additionalServices = currenService;
    }
    public  Service getServices(){
        return additionalServices;
    }

    //set & get p date/////////////////////////////////////////////////////
    public  void setPickUpDate(Date p){
        pickUpDate = p;
    }
    public  Date getPickUpDate (){
        return  pickUpDate;
    }

    //set & get d date///////////////////////////////////////////////////
    public  void setDropOfDate(Date d){
        dropOfDate = d;
    }
    public  Date getDropOfDate(){
        return dropOfDate;
    }

    //get /////////////////////////////////////////////////////////////
    public  Date getDateOfReservation(){
        return dateOfReservation;
    }
    public  Customer getCustomer(){
        return customer;
    }
    //set & get of car///////////////////////////////////////////////
    public  void setCar (Car c){
        car =c;
    }
    public  Car getCar (){
        return car;
    }

    public  String toString(){
        String r = reservationCode+" ,"+pickUpLocation+" ,"+dropOfLocation+" ,"+pickUpDate+" ,"+dropOfDate+" ,"+dateOfReservation+" ,"+customer+" ,"+car+" ,"+additionalServices;
        return r;
    }
}
/*
- reservation_code : String
- pick_up_location : String
- drop_of_location : String
- pick_up : Date
- drop_of : Date
- date_of_reservation : Date
- customer : Customer
- car : Car
- additional_services : Service
 */