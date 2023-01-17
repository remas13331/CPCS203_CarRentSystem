import org.omg.CORBA.PUBLIC_MEMBER;
/*
Name : remas anwar alghamdi
ID : 2205889
Section : B2A

 */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // FILES///////////////////////////////////////////////////////////
        File inputCar_txt = new File("inputCar.txt");
        if (!(inputCar_txt.exists())) {
            System.out.println("- FILE 1 DOES NOT EXIST -");
            System.exit(0);
        }

        File CarsInfo_txt = new File("carsInfo.txt");
        if (!(CarsInfo_txt.exists())) {
            System.out.println("- FILE 2 DOES NOT EXIST -");
            System.exit(0);
        }

        File inputReservation = new File("Reservationinput.txt");
        if (!(inputReservation.exists())) {
            System.out.println("- FILE 3 DOES NOT EXIST -");
            System.exit(0);
        }

        File reservationStatus = new File("reservationStatus.txt");
        File analyze = new File("analyze.txt");

        //SCANNERS////////////////////////////////////////////////////////
        Scanner readCar = new Scanner(inputCar_txt);
        Scanner readReservation = new Scanner(inputReservation);

        //PRINTS//////////////////////////////////////////////////////////
        PrintWriter infoWriter = new PrintWriter(CarsInfo_txt);
        PrintWriter infoReservation = new PrintWriter(reservationStatus);
        PrintWriter infoAnalyze = new PrintWriter(analyze);

        //FILE ONE //////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////


        // TYPES AND TYPES NUMBER //////////////////////////////////////
        int typeNum = readCar.nextInt();
        String t1 = readCar.next();
        String t2 = readCar.next();
        String t3 = readCar.next();
        String[] typeArr = CarTypes(typeNum, t1, t2, t3);


        // GET 6 & 3 AND CREATE THEIR ARRAYS////////////////////////////
        int carNum = readCar.nextInt();
        int servNum = readCar.nextInt();
        Car[] addCarArr = new Car[carNum];
        Service[] addServArr = new Service[servNum];


        // READ THE LINES ////////////////////////////////////////////
        int r = 0;
        int m = 0;
        while (readCar.hasNext()) {
            String myStick = readCar.next();
            switch (myStick) {
                case "AddCar":
                    Car car = new Car(readCar.next(), readCar.nextInt(), readCar.nextInt(), readCar.nextBoolean(), readCar.next(), readCar.nextBoolean());
                    addCarArr[r] = car;
                    r++;
                    break;

                case "AddService":
                    Service service = new Service(readCar.next(), readCar.nextInt());
                    addServArr[m] = service;
                    m++;
                    break;

                case "Quit":
                    break;
            }

        }
        // OUTPUT FILE 1 //////////////////////////////////////////

        infoWriter.println("-------------------- Welcome To Car Renting Data Base --------------------");
        infoWriter.println();
        FillOutput1(addCarArr, infoWriter);
        infoWriter.close();
        infoWriter.flush();
        readCar.close();

        // RESERVATION FILE READ FROM//////////////////////////////
        int reserveNum = readReservation.nextInt();
        Reservation[] reserveArr = new Reservation[reserveNum];

        // READ LINES//////////////////////////////////////////////
        int e = 0;
        int counter = 1;
        while (readReservation.hasNext()) {
            String myStick2 = readReservation.next();
            switch (myStick2) {
                case "Reserve":
                    String type = readReservation.next();
                    String trans = readReservation.next();
                    String conv = readReservation.next();
                    String city1 = readReservation.next();
                    String city2 = readReservation.next();
                    int year1 = readReservation.nextInt();
                    int month1 = readReservation.nextInt();
                    int day1 = readReservation.nextInt();
                    int year2 = readReservation.nextInt();
                    int month2 = readReservation.nextInt();
                    int day2 = readReservation.nextInt();
                    String fname = readReservation.next();
                    String lname = readReservation.next();
                    String email = readReservation.next();
                    long card = readReservation.nextInt();
                    int code = readReservation.nextInt();
                    String servi = readReservation.next();
                    if (counter == 2) {
                        servi = "submit";
                    } else {
                        String submitReader = readReservation.next();
                    }
                    reserveArr[e] = FillReservation(type, trans, conv, city1, city2, year1, month1, day1, year2, month2, day2, fname, lname, email, card, code, servi, counter);
                    e++;
                    break;

                case "Quit":
                    break;
            }
            counter++;
        }
        for (int g = 0; g < reserveArr.length; g++) {
            System.out.println(reserveArr[g]);
            System.out.println("-------------------------------------------------------");
        }


        //PRINT THE RESERVATION STATUS FILE//////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////

        infoReservation.println("----------------------- Welcome To Car Renting Management System -----------------------");
        infoReservation.println();
        infoReservation.println("--------------------------- Display All System Procedures -----------------------------");
        infoReservation.println();

        // PRINT THE PROCEDURES ////////////////////////////////////////////////

        for (int x = 0; x < reserveArr.length; x++) {

            // CREATE OBJECTS TO USE THEM INSIDE THE LOOP /////////////////////
            Service checkService = OrderedService(addServArr, reserveArr[x].getServices().getServiceType());
            Car checkCar = OrderedCar(addCarArr, reserveArr[x].getCar().getCarType(), reserveArr[x].getCar().getTransmission(), reserveArr[x].getCar().isConvertible());

            // CHECKING ///////////////////////////////////////////////////////

            if (checkCar == null || checkService == null) {
                infoReservation.println();
                infoReservation.println();
                infoReservation.println("SORRY: The reservation is NOT completed");
                infoReservation.println("There is no available Car");
                infoReservation.println();
                infoReservation.println();


            } else {

                //PRINTING ///////////////////////////////////////////////////

                infoReservation.println("DONE: The reservation is completed");
                infoReservation.print("******Reservation Reference number : ");
                infoReservation.println(GenerateRandomCode(reserveArr[x].getCustomer().getFirstName(), reserveArr[x].getCustomer().getLastName(), checkCar.getYearOfConstruction()));
                infoReservation.println();
                infoReservation.print("******Customer information : Customer Name: " + reserveArr[x].getCustomer().getFirstName() + " " + reserveArr[x].getCustomer().getLastName() + ", ");
                infoReservation.println("Email: " + reserveArr[x].getCustomer().getEmail() + ", Code: " + reserveArr[x].getCustomer().getDiscountCode());
                infoReservation.println();
                infoReservation.println("******Pick Up Location : " + reserveArr[x].getPickUpLocation() + " ******Drop Of Location : " + reserveArr[x].getDropOfLocation());
                infoReservation.println();
                infoReservation.print("******Pick Up Date : " + reserveArr[x].getPickUpDate().getYear() + "-" + reserveArr[x].getPickUpDate().getMonth() + "-" + reserveArr[x].getPickUpDate().getDay());
                infoReservation.println("  ******Drop Of Date : " + reserveArr[x].getDropOfDate().getYear() + "-" + reserveArr[x].getDropOfDate().getMonth() + "-" + reserveArr[x].getDropOfDate().getDay());
                infoReservation.println();
                infoReservation.println("******The Car Information : " + checkCar.toString());
                infoReservation.println();
                infoReservation.println("******Additional Service : Service " + checkService.getServiceType());
                infoReservation.println();
                infoReservation.println("----------------------------------- Invoice Details -----------------------------------");
                infoReservation.println();


                //CALCULATING //////////////////////////////////////////////////

                double numOfDays = (reserveArr[x].getDropOfDate().getDay() - reserveArr[x].getPickUpDate().getDay());
                //System.out.println(numOfDays);
                infoReservation.println("Number of reserved days: " + numOfDays);
                infoReservation.println();
                double intiTotal = (checkCar.calculateFinalPrice()) * (numOfDays);
                infoReservation.println("Initial Total : " + intiTotal);
                infoReservation.println("------------------------------ Additional Services Price ------------------------------");
                infoReservation.println();
                double priceTotal = (intiTotal + checkService.getServicePrice());
                infoReservation.println("Total After Additional Services : " + priceTotal);
                infoReservation.println();
                infoReservation.println("----------------------------- Final Payment after Discount-----------------------------");
                infoReservation.println();
                String codeChar = String.valueOf(reserveArr[x].getCustomer().getDiscountCode());
                double discount = 0;
                if (codeChar.charAt(0) == '9' || codeChar.charAt(0) == '8' || codeChar.charAt(0) == '7') {
                    discount = 0.20;
                } else if (codeChar.charAt(0) == '6' || codeChar.charAt(0) == '5' || codeChar.charAt(0) == '4') {
                    discount = 0.15;
                } else if (codeChar.charAt(0) == '3' || codeChar.charAt(0) == '2' || codeChar.charAt(0) == '1') {
                    discount = 0.10;
                }
                double finalTotal = priceTotal - (priceTotal * discount);
                infoReservation.println("Final Total  : " + finalTotal);

            }

        }
        //CLOSING FILES ////////////////////////////////////////////////////////

        readReservation.close();
        infoReservation.close();
        infoReservation.flush();

        //THE ANALYSIS FILE ///////////////////////////////////////////////////
        // ////////////////////////////////////////////////////////////////////

        infoAnalyze.println("-------------- Analysis Report ---------------");
        infoAnalyze.println();
        infoAnalyze.print("Car Type        ");
        for (int z = 0; z < typeArr.length; z++) {
            infoAnalyze.print(typeArr[z] + "      ");
        }
        infoAnalyze.println();
        infoAnalyze.println("Services");
        infoAnalyze.println("-----------------------------------------------------");
        infoAnalyze.println();

        // CREATE 2D ARRAY //////////////////////////////////////////////////////

        int[][] analyzeArr = new int[addServArr.length][typeArr.length];


        for (int d = 0; d < analyzeArr.length; d++) {
            String doArr = addServArr[d].getServiceType();
            if(reserveArr[d] !=null && reserveArr[d].getServices() != null) {
                if (doArr.equals("Luxury") &&
                        reserveArr[d].getServices().equals("Navigation")) {
                    analyzeArr[0][0]++;
                }
                if (reserveArr[d].getCar().getCarType().equals("Luxury") &&
                        doArr.equals("Full_Insurance")) {
                    analyzeArr[1][0]++;
                }
                if (reserveArr[d].getCar().getCarType().equals("Luxury") &&
                        doArr.equals("Car_Seat")) {
                    analyzeArr[2][0]++;
                }
                if (reserveArr[d].getCar().getCarType().equals("Sport") &&
                        doArr.equals("Navigation")) {
                    analyzeArr[0][1]++;
                }
                if (reserveArr[d].getCar().getCarType().equals("Sport") &&
                        doArr.equals("Full_Insurance")) {
                    analyzeArr[1][1]++;
                }
                if (reserveArr[d].getCar().getCarType().equals("Sport") &&
                        doArr.equals("Car_Seat")) {
                    analyzeArr[2][1]++;
                }
                if (reserveArr[d].getCar().getCarType().equals("Economy") &&
                        doArr.equals("Navigation")) {
                    analyzeArr[0][2]++;
                }
                if (reserveArr[d].getCar().getCarType().equals("Economy") &&
                        doArr.equals("Full_Insurance")) {
                    analyzeArr[1][2]++;
                }
                if (reserveArr[d].getCar().getCarType().equals("Economy") &&
                        doArr.equals("Car_Seat")) {
                    analyzeArr[2][2]++;
                }
            }

        }
        // PRINTING THE INFORMATION ///////////////////////////////////////////////
       for (int h=0 ; h < addServArr.length; h++) {
           if (h == 0) {
               infoAnalyze.println(addServArr[h].getServiceType() + "\t\t\t" + analyzeArr[0][0] + "\t\t" + analyzeArr[0][1] + "\t\t" + analyzeArr[0][2]);
           }
           if (h == 1) {
               infoAnalyze.println(addServArr[h].getServiceType() + "\t\t" + analyzeArr[1][0] + "\t\t" + analyzeArr[1][1] + "\t\t" + analyzeArr[1][2]);
           }
           if (h == 2) {
               infoAnalyze.println(addServArr[h].getServiceType() + "\t\t\t" + analyzeArr[2][0] + "\t\t" + analyzeArr[2][1] + "\t\t" + analyzeArr[2][2]);
           }
       }
       //CLOSING FILES //////////////////////////////////////////////////////////

       infoAnalyze.close();
       infoAnalyze.flush();

    }


    // METHOD TO FILL THE CAR TYPE 1D ARRAY ////////////////////////////////////
    public static String[] CarTypes(int size, String t1, String t2, String t3) {
        String[] array = new String[size];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array[i] = t1;
            }
            if (i == 1) {
                array[i] = t2;
            }
            if (i == 2) {
                array[i] = t3;
            }
        }
        return array;
    }

    // METHOD TO FILL THE CARS INFO FILE ////////////////////////////////////
    public static void FillOutput1(Car[] arr, PrintWriter infoWriter) {
        for (int r = 0; r < arr.length; r++) {
            infoWriter.println(arr[r].toString());
            infoWriter.println("------------------------------------------------------------------------------");
            infoWriter.println();
        }

    }

    // FILL THE RESERVATION ARRAY///////////////////////////////////////////
    public static Reservation FillReservation(String type, String trans, String conv, String city1, String city2, int year1,
                                              int month1, int day1, int year2, int month2, int day2, String name, String name2, String email, long card, int code, String service, int c) {
        if (service.equals("submit")) {
            service = null;
        }
        Date d1 = new Date(year1, month1 - 1, day1);
        Date d2 = new Date(year2, month2 - 1, day2);
        Boolean conv2 = Boolean.valueOf(conv);
        Boolean trans2 = Boolean.valueOf(trans);
        if (trans.equalsIgnoreCase("Manual")) {
            trans2 = true;
        }
        conv2 = true;
        /*if (trans.equalsIgnoreCase("Non_Convertible")){
            conv2 = false;
        }*/
        if (c == 3) {
            conv2 = false;
        }
        Customer client = new Customer(name, name2, email, card, code);
        Car car = new Car(null, 0, 0, trans2, type, conv2);
        Service serviceClass = new Service(service, 0);
        Reservation res = new Reservation(city1, city2, d1, d2, client, car, serviceClass);
        return res;
    }

    //METHOD TO CHECK IF CAR EXIST OR NOT////////////////////////////////
    public static Car OrderedCar(Car[] arr, String type, boolean trans, boolean convert) {
        // TRY //
        /*boolean trans1 = trans.equalsIgnoreCase("Manual");
        boolean convert1 = convert.equalsIgnoreCase("Convertible");*/

        for (int i = 0; i < arr.length; i++) {
            Car orderedCar = arr[i];
            if (orderedCar.getCarType().equalsIgnoreCase(type) && orderedCar.getTransmission() == trans && orderedCar.isConvertible() == convert) {
                return orderedCar;
            }
        }
        return null;
    }

    //METHOD TO CHECK THE SERVICE AND TAKE PRICE////////////////////////
    public static Service OrderedService(Service[] arr, String serviceName) {
        for (int i = 0; i != arr.length; i++) {
            Service orderedService = arr[i];
            if (arr[i].getServiceType().equalsIgnoreCase(serviceName)) {
                return arr[i];
            }
        }
        return null;
    }

    //METHOD TO GENERATE RANDOM CODE /////////////////////////////////
    public static String GenerateRandomCode(String f, String l, int year) {
        char first = f.charAt(0);
        char second = l.charAt(0);
        int randomNum = ((int) (Math.random() * 1000));
        String code = first + "" + second + "_" + randomNum + "_" + year;
        return code;
    }


}

