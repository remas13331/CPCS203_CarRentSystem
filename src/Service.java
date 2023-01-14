public class Service {
    private  String serviceType;
    private  double servicePrice;

    //constructor///////////////////////////////////
    public  Service(String type, double price){
        serviceType = type;
        servicePrice = price;
    }

    //set & get of type////////////////////////////
    public  void setServiceType(String type){
        serviceType = type;
    }
    public  String getServiceType(){
        return serviceType;
    }

    //set & get of price////////////////////////////
    public  void setServicePrice(double price){
        servicePrice = price;
    }
    public  double getServicePrice(){
        return servicePrice;
    }

    //to string////////////////////////////////////
    public  String toString(){
        String r = serviceType+" ,"+servicePrice;
        return r;
    }
}
