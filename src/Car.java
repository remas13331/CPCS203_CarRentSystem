
public class Car {
    private String brand;
    private String carType ;
    private int year_of_construction;
    private double car_rate ;
    private boolean transmission_Manual;
    private boolean convertible ;

    //constructor/////////////////////////////////////
    public Car (String brand, int year, double rate, boolean transmission, String type, boolean convertible ){
        this.brand = brand;
        year_of_construction = year;
        car_rate = rate = 0;
        transmission_Manual = transmission;
        carType = type;
        this.convertible = convertible;
    }


    //set & get for brand name//////////////////////
    public void setBrand (String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }

    //set & get brand type//////////////////////////
    public void setCarType (String type){
        carType = type;
    }
    public String getCarType(){
        return carType;
    }

    //set & get of year of construction////////////
    public void setYearOfConstruction(int year){
        year_of_construction = year;
    }
    public int getYearOfConstruction(){
        return year_of_construction;
    }

    //set & get of car rate////////////////////////
    public void setCarRate(double rate){
        car_rate = rate;
    }
    public double getCarRate(){
        return car_rate;
    }

    //set & get of transmission///////////////////
    public void  setTransmission(boolean Transmission){
        transmission_Manual = Transmission;
    }
    public boolean getTransmission(){
        return  transmission_Manual;
    }
     //convertible methods///////////////////////
    public void setConvertible(boolean convertible){
        this.convertible = convertible;
    }
    public boolean isConvertible(){
        if (convertible == true)
        return true;
        else
        return false;
    }
    //calc/////////////////////////////////////////
    public double calculateFinalPrice(){
        String r = carType.toLowerCase();
        if (r.equals("luxury")){
            car_rate = car_rate+(0.10*car_rate);
            return car_rate;
        }else
           return car_rate;
    }

    //toString///////////////////////////////////////
    public  String toString (){
        String trans ="";
        if (transmission_Manual == true){
            trans = "Manual";
        }else
            trans = "Automatic";

        if(isConvertible()){
            trans+= " and Convertible";
        }else
            trans += " and not Convertible";

        String r = "The car type: "+brand+" ,"+ carType+" ,Year: "+year_of_construction+"  ,Transmission: "+trans;
        return r;
    }


}
