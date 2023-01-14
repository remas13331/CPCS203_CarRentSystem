import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // FILES
        File inputCar_txt = new File("inputCar.txt");
        if (!(inputCar_txt.exists())) {
            System.out.println("- FILE 1 DOES NOT EXIST -");
            System.exit(0);
        }

        File CarsInfo_txt = new File("carsInfo");
        if (!(CarsInfo_txt.exists())) {
            System.out.println("- FILE 2 DOES NOT EXIST -");
            System.exit(0);
        }

        File inputReservation = new File ("Reservationinput.txt");
        if (!(inputReservation.exists())) {
            System.out.println("- FILE 3 DOES NOT EXIST -");
            System.exit(0);
        }

        File reservationStatus = new File("reservationStatus.txt");
        File analyze = new File("analyze");

        //SCANNERS
        Scanner readCar = new Scanner(inputCar_txt);
        Scanner readReservation = new Scanner(inputReservation);

        //PRINTS
        PrintWriter infoWriter = new PrintWriter(CarsInfo_txt);
        PrintWriter infoReservation = new PrintWriter(reservationStatus);
        PrintWriter infoAnalyze = new PrintWriter(analyze);

        // TYPES AND TYPES NUMBER //////////////////////////////////////
        int typeNum = readCar.nextInt();
        String t1 = readCar.next();
        String t2 = readCar.next();
        String t3 = readCar.next();
        String[] typeArr = CarTypes(typeNum, t1, t2, t3);


        // GET 6 & 3 AND CRETE THEIR ARRAYS////////////////////////////
        int carNum = readCar.nextInt();
        int servNum = readCar.nextInt();
        Car[] addCarArr = new Car[carNum];
        Service[] addServArr = new Service[servNum];


        // READ THE LINES ////////////////////////////////////////////
        int r =0;
        int m =0;
        while (readCar.hasNext()) {
            String myStick = readCar.next();
            switch (myStick){
                case "AddCar" : Car car = new Car(readCar.next(),readCar.nextInt(),readCar.nextInt(),readCar.nextBoolean(),readCar.next(),readCar.nextBoolean());
                                addCarArr[r]=car;
                                r++;break;

                case "AddService" : Service service = new Service(readCar.next(),readCar.nextInt()) ;
                                    addServArr[m] = service;
                                    m++;break;

                case "Quit" : break;
            }

        }
        //////////////////////////////////////////////////////////////

        infoWriter.println("-------------------- Welcome To Car Renting Data Base --------------------");
        FillOutput1(addCarArr, infoWriter);
        infoWriter.close();
        infoWriter.flush();
        readCar.close();

        /////////////////////////////////////////////////////////////




    }

    // METHOD TO FILL THE CAR TYPE 1D ARRAY //
    public static String[] CarTypes (int size, String t1, String t2,String t3){
        String[] array = new String [size];
        for (int i = 0; i < array.length ; i++){
            array[i] = "t"+(i+1);
        }
        return array;
    }

    // METHOD TO FILL THE CARS INFO FILE //
    public static void FillOutput1 (Car [] arr , PrintWriter infoWriter){
        for (int r = 0 ; r < arr.length ; r++){
           infoWriter.println(arr[r].toString());
           infoWriter.println("------------------------------------------------------------------------------");
        }


    }


}
