public class Customer {
    private  String firstName;
    private  String lastName;
    private  String email;
    private  long creditCard;
    private  int discountCode;

    //create constructor/////////////////////////////////
    public  Customer (String firstName,String lastName,String email,long card,int code){
        this.firstName =firstName;
        this.lastName =lastName;
        this.email =email;
        creditCard=card;
        discountCode=code;
    }

    //set & get of f name///////////////////////////////
    public void  setFirstName(String f){
        this.firstName = f;
    }
    public String getFirstName(){
        return  firstName;
    }

    //set & get of l name///////////////////////////////
    public void  setLastName(String l){
        this.lastName = l;
    }
    public String getLastName(){
        return  lastName;
    }

    //set & get of email///////////////////////////////
    public  void setEmail(String e){
        this.email =e;
    }
    public  String getEmail(){
        return  email;
    }

    //set & get of card///////////////////////////////
    public  void setCreditCard(long c){
        this.creditCard = c;
    }
    public  long getCreditCard(){
        return  creditCard;
    }

    //get of code///////////////////////////////////
    public  int getDiscountCode(){
        return discountCode;
    }
    public  String toString(){
        String r = firstName+" ,"+lastName+" ,"+email+" ,"+creditCard+" ,"+discountCode;
        return r;
    }


}
