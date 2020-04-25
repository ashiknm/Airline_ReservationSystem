package airline_reservation_system;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ashik
 */
class Passenger {
    public  static  String name;
    public  static  String pnr_Number;
    public  static  int age;
    static boolean exit = false;
    static int passangerNo;
    public static String text;
    static SecureRandom randomNumbers = new SecureRandom();
    public static ArrayList<String> PNR = new ArrayList<String>();
    public static ArrayList<String> NAME = new ArrayList<String>();
    public static ArrayList<Integer> AGE = new ArrayList<Integer>();
    public static ArrayList<String> usedPNR = new ArrayList<String>();
    public static ArrayList<String> ROUTE = new ArrayList<String>();
    public static ArrayList<Float> bagage = new ArrayList<Float>();
    public static ArrayList<String> DEPDATE = new ArrayList<String>();
    public static ArrayList<String> Class = new ArrayList<String>();
    public static ArrayList<Integer> Type = new ArrayList<Integer>();
    static Scanner input = new Scanner(System.in);
    static int c = 0,d = 0;
    static float k1;
    static int k2;
    public static int e1,e2,e3,b2,b3,f3;
 
    public Passenger(String name, String pnr_Number, int age) {
        Passenger.name = name;
        Passenger.pnr_Number = pnr_Number;
        Passenger.age = age;
    }
    
    @SuppressWarnings("ConvertToStringSwitch")
    public static  void setPassangerDetails() throws ParseException{
        exit = false;
        do{
            System.out.print("\n**ENTER NUMBER OF PASSENGER(S) (LIMITED 5 PEOPLE) : ");
            passangerNo= Airline_Reservation_System.checkInteger(1,5);
            checkAvailibility(passangerNo);
        }while(exit);
        for (int i = 0; i < passangerNo; i++) {
            Scanner output = new Scanner(System.in);
            System.out.printf("\n\nEnter Passanger %d details : ",i+1);
            System.out.print("\nName : ");
            name = output.nextLine();
            while (!name.matches("[a-zA-Z\\s]+")) { // A-Z and Space
                System.out.println("ENTER IN LETTERS ONLY!");
                System.out.print("\nName : ");
                name = output.nextLine();
            }
            NAME.add(i,name);
            Scanner sc = new Scanner(System.in);
            System.out.print("AGE : ");
            while(!sc.hasNextInt()){
                System.out.print("AGE : ");
                sc.next();
            }
            age = sc.nextInt();
            AGE.add(i,age);
            exit = false;
            do{
                try{
                    pnr_Number = randInt(100,999)+"-"+randInt(100,999)+"-"+randInt(1000,9999);
                    if(usedPNR.contains(pnr_Number))
                        throw new RuntimeException();
                }catch(RuntimeException exception){
                    exit = true;
                }
            }while(exit);
            PNR.add(i,pnr_Number);
            DEPDATE.add(i, ReservationSystem.depDate);
            switch(Airline_Reservation_System.CLASS){
                case 1:
                    text = "Economy class";
                    bagage.add(i, (float)FlightwithEconomy.e_bagage);
                    break;
                case 2:
                    text = "Business class";
                    bagage.add(i, (float)FlightWithEconomyAndBusiness.e_bagage);
                    break;
                case 3:
                    text = "first class";
                    bagage.add(i, (float)Flight_Economy_Business_Firstclass.e_bagage);
                    break;
            }
            Class.add(i, text);
            Type.add(i, Airline_Reservation_System.TYPE);
            ROUTE.add(i, ReservationSystem.fullform(ReservationSystem .flight[ReservationSystem.from-1][0])+"-"+
                        ReservationSystem.fullform(ReservationSystem .flight[ReservationSystem.destination-1][1]));
            Passenger one = new Passenger(name,pnr_Number,age);
            exit = false;
            do{
                System.out.print("\ndo you want to buy excess bagage (Y/N) : ");
                String check = input.next();
                if("Y".equals(check) ||"y".equals(check)){
                    switch(Airline_Reservation_System.CLASS){
                        case 1:
                            do{
                                System.out.print("\nEnter number of additional Kgs to be purchased (limited 5 kg): ");
                                if(input.hasNextInt()){
                                    k2 = input.nextInt();
                                    if(k2<=5 && k2>=1){
                                        FlightwithEconomy.buyExcessBaggage(k2);
                                        bagage.add(i, (float)FlightwithEconomy.e_bagage+k2);
                                    }else{
                                        exit = true;
                                        System.out.println("enter value between 1 and 5");
                                    }
                                }
                                else if(input.hasNextFloat()){
                                    k1 = input.nextFloat();
                                    if((int)k1 <=5 && (int)k1 >=1){
                                        FlightwithEconomy.buyExcessBaggage(k1);
                                        bagage.add(i, (float)FlightwithEconomy.e_bagage+k1);
                                    }else{
                                        exit = true;
                                        System.out.print("enter value between 1 and 5 : ");
                                    }
                                }    
                            }while(exit);
                            break;
                        case 2:
                            do{
                                System.out.print("\nEnter number of additional Kgs to be purchased (limited 10 kg): ");
                                if(input.hasNextInt()){
                                    k2 = input.nextInt();
                                    if(k2<=10 && k2>=1){
                                        FlightWithEconomyAndBusiness.buyExcessBaggage(k2);
                                        bagage.add(i, (float)FlightWithEconomyAndBusiness.e_bagage+k2);
                                    }else{
                                        exit = true;
                                        System.out.println("enter value between 1 and 10");
                                    }
                                }
                                else if(input.hasNextFloat()){
                                    k1 = input.nextFloat();
                                    if((int)k1<=10 && (int)k1>=1){
                                        FlightWithEconomyAndBusiness.buyExcessBaggage(k1);
                                        bagage.add(i, (float)FlightWithEconomyAndBusiness.e_bagage+k1);
                                    }else{
                                        exit = true;
                                        System.out.println("enter value between 1 and 10");
                                    }
                                }    
                            }while(exit);
                            break;
                        case 3:
                          do{
                                System.out.print("\nEnter number of additional Kgs to be purchased (limited 10 kg): ");
                                if(input.hasNextInt()){
                                    k2 = input.nextInt();
                                    if(k2<=10 && k2>=1){
                                        Flight_Economy_Business_Firstclass.buyExcessBaggage(k2);
                                        bagage.add(i, (float)Flight_Economy_Business_Firstclass.e_bagage+k2);
                                    }else{
                                        exit = true;
                                        System.out.println("enter value between 1 and 10");
                                    }
                                }
                                else if(input.hasNextFloat()){
                                    k1 = input.nextFloat();
                                    if((int)k1<=10 && (int)k1>=1){
                                        Flight_Economy_Business_Firstclass.buyExcessBaggage(k1);
                                        bagage.add(i, (float)Flight_Economy_Business_Firstclass.e_bagage+k1);
                                    }else{
                                        exit = true;
                                        System.out.println("enter value between 1 and 10");
                                    }
                                }    
                            }while(exit);
                            break;
                    }
                }
                else if("N".equals(check) ||"n".equals(check))
                    break;
                else
                    exit = true;
            }while(exit);
        }
            
    }
    public static int randInt(int min, int max){
        Random rand = new Random();
        int randnumber = rand.nextInt((max-min)+1)+min;
        return randnumber;
        
        
    }
    public static void showDetails(int i){
            System.out.printf("\n\n* PNR number : %s \n* NAME : %s\n* AGE : %d\n* bagage checked : %.2f Kgs\n* "
            + "route : %s\n* Type of flight : TYPE %d\n* Class of flight : %s\n* Departure date : %s",
            PNR.get(i),NAME.get(i),AGE.get(i),bagage.get(i),ROUTE.get(i),
            Type.get(i),Class.get(i),DEPDATE.get(i));
            System.out.println("\n\n**************************");
    }
        
    public static void getbagagelimit(String Pnr){
        exit = false;
        for(int i = 0;i<PNR.size();i++){
            if(PNR.get(i).equals(Pnr)){
                System.out.println("bagage limit is "+bagage.get(i));
                exit = true;
                break;
            }
        }
        if(exit = false){
            System.out.print("please enter valid pnr number: ");
            Pnr = input.next();
            Passenger.getbagagelimit(Pnr);
        }
    }
    public static void checkAvailibility(int n){
    exit = false;
    switch(Airline_Reservation_System.CLASS){
        case 1:
            switch(Airline_Reservation_System.TYPE){
            case 1:
                e1 += n;
                if(e1>50){
                    e1 -= n;
                    System.out.printf("there are only %d passengers  allowed ",(50-e1));
                    exit = true;
                }
                break;
            case 2:
                e2 += n;
                if(e2>50){
                    e2 -= n;
                    System.out.printf("there are only %d passengers allowed ",(50-e2));
                    exit= true;  
                }
                break;
            case 3:
                e3 += n;
                if(e3>50){
                    e3 -= n;
                    System.out.printf("there are only %d passengers  allowed ",(50-e3));
                    exit = true;
                }
                break;
        }
        break;
        case 2:
            switch(Airline_Reservation_System.TYPE){
                case 2:
                    b2 += n;
                    if(b2>10){
                        b2 -= n;
                        System.out.printf("there are only %d passengers  allowed ",(10-b2));
                       exit = true;
                    }
                    break;
                case 3:
                    b3 += n;
                    if(b3>10){
                        b3 -= n;
                        System.out.printf("there are only %d passengers  allowed ",(10-b3));
                        exit = true;
                    }
                    break;
            }
            break;
        case 3:
            f3 += n;
            if(f3>10){
                f3 -= n;
                System.out.printf("there are only %d passengers are allowed ",(10-f3));
                exit = true;
            }
            break;
        }
    }
}