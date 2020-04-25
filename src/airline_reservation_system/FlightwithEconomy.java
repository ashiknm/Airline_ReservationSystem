package airline_reservation_system;

import java.text.ParseException;
import java.util.Scanner;
/**
 * @author ashik
 */
public class FlightwithEconomy{
    public static int e_bagage;
    public static int e_seats_row;
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws ParseException{
        FlightwithEconomy one = new FlightwithEconomy( 15,6);
        System.out.println("\n!! 6 seats per row\n Passanger "
                + "can check maximum of 15 kgs!!");
       book(Airline_Reservation_System.type);
    }
    public FlightwithEconomy(int e_bagage,int e_seats_row) {
        FlightwithEconomy.e_bagage = e_bagage;
        FlightwithEconomy.e_seats_row = e_seats_row;
    }
    
    public static void book(int TYPE) throws ParseException{
        switch(TYPE){
            case 1:
                try{
                    if(Passenger.e1>=0 && Passenger.e1<50){
                        System.out.println("\nAvailable seats (1-50(): "+(50-Passenger.e1));
                        Airline_Reservation_System.type= 0;
                        ReservationSystem.booking();
                        Passenger.setPassangerDetails();
                        ReservationSystem.output();
                    }else
                        throw new IndexOutOfBoundsException();
                }catch(IndexOutOfBoundsException exception){
                    System.out.println("no seats avaialable");
                    System.out.println("book another flight ");
                    Airline_Reservation_System.Reservation(1);
                }
                break;
            case 2:
                try{
                    if(Passenger.e2>=0 && Passenger.e2<40){
                        System.out.println("\nAvailable seats (11-50): "+(40-Passenger.e2));
                        Airline_Reservation_System.type= 0;
                        ReservationSystem.booking();
                        Passenger.setPassangerDetails();
                        ReservationSystem.output();
                    
                    }else
                        throw new IndexOutOfBoundsException();
                }catch(IndexOutOfBoundsException exception){
                    System.out.println("no seats avaialable");
                    System.out.println("book another flight ");
                    Airline_Reservation_System.Reservation(1);
                }
                
                break;
            case 3:
               try{
                    if(Passenger.e3>=0 && Passenger.e3<30){
                        System.out.println("\nAvailable seats (21-50): "+(30-Passenger.e3));
                        Airline_Reservation_System.type= 0;
                        ReservationSystem.booking();
                        Passenger.setPassangerDetails();
                        ReservationSystem.output();
                    
                    }else
                        throw new IndexOutOfBoundsException();
                }catch(IndexOutOfBoundsException exception){
                    System.out.println("no seats avaialable");
                    System.out.println("book another flight ");
                    Airline_Reservation_System.Reservation(1);
                }
                break;   
        }
       
    }
    public static void buyExcessBaggage(int k){
       System.out.printf("\npay %d to book the flight : ",k*2000);
       makePayment(k*2000);
    }
    public static void buyExcessBaggage(float k){
       System.out.printf("\npay %.2f to book the flight : ",k*2000);
       makePayment(k*2000);
    }
    public static void  makePayment(int R){
        int pay;
        int change;
        System.out.print("\nEnter the amount to be paid : ");
        pay = Airline_Reservation_System.checkInteger(R,50000);
        change=pay-R;
        System.out.println("CHANGE: "+change);
    }
    public static void  makePayment(float R){
        boolean exit = false;
        float pay;
        float change;
        System.out.print("\nEnter the amount to be paid : ");
        do{
            if(input.hasNextFloat()){
                pay = input.nextFloat();
                if(pay<R || pay>50000){
                    System.out.printf("\nEnter amount within %.2f and %d",R,50000);
                    exit = true;
                }
                change=pay-R;
                System.out.printf("CHANGE: %.2f",change);
            }else{
                System.out.println("Please enter correct value ");
                exit = true;
            }
        }while(exit);
        
    }
   
}