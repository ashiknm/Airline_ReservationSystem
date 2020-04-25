package airline_reservation_system;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author ashik
 */

public class Flight_Economy_Business_Firstclass extends FlightwithEconomy{
    static int c = 0;
    public static void main(String[] args) throws ParseException{
        Flight_Economy_Business_Firstclass one = new Flight_Economy_Business_Firstclass(30,2);
        System.out.println("\n!! 2 seats per row\n Passanger "
                + "can check maximum of 30 kgs!!");
       book();
    }
    public Flight_Economy_Business_Firstclass(int e_bagage, int e_seats_row) {
        super(e_bagage, e_seats_row);
    }
    public static void book() throws ParseException{
        Scanner input = new Scanner(System.in);
        try{
            if(Passenger.f3>=0 && Passenger.f3<10){
                System.out.println("\nAvailable seats (1-10) : "+(10-Passenger.f3));
                Airline_Reservation_System.type= 0;
                ReservationSystem.booking();
                Passenger.setPassangerDetails();
                ReservationSystem.output();
            }else
                throw new IndexOutOfBoundsException();
        }catch(IndexOutOfBoundsException exception){
            System.out.println("no seats availible ");
            Airline_Reservation_System.askuser();
        }
       
    }
    public static void buyExcessBaggage(int k){
       System.out.printf("\npay %d to book the flight : ",k*4000);
       makePayment(k*4000);
    }
    public static void buyExcessBaggage(float k){
       System.out.printf("\npay %.2f to book the flight : ",k*4000);
       makePayment(k*4000);
    }
}