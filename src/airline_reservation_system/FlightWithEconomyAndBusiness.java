package airline_reservation_system;

import java.text.ParseException;

/**
 *
 * @author ashik
 */
public class FlightWithEconomyAndBusiness extends FlightwithEconomy {
    public static void main(String[] args) throws ParseException{
        FlightWithEconomyAndBusiness one = new FlightWithEconomyAndBusiness(25,4);
        System.out.println("\n!! 4 seats per row\n Passanger "
                + "can check maximum of 25 kgs!!");
        book(Airline_Reservation_System.type);
    }
    public FlightWithEconomyAndBusiness(int e_bagage, int e_seats_row) {
        super(e_bagage, e_seats_row);
    }
    public static void book(int TYPE) throws ParseException{
        switch(TYPE){
            case 2:
                try{
                    if(Passenger.b2>=0 && Passenger.b2<10){
                        System.out.println("\nAvailable seats (1-10) :  "+(10-Passenger.b2));
                        Airline_Reservation_System.type= 0;
                        ReservationSystem.booking();
                        Passenger.setPassangerDetails();
                        ReservationSystem.output();
                    }else
                        throw new IndexOutOfBoundsException();
                }catch(IndexOutOfBoundsException exception){
                    System.out.println("\n!! no seats avaialable");
                    System.out.println("book another flight !! ");
                    Airline_Reservation_System.Reservation(2);
                }
                break;
            case 3:
                try{
                    if(Passenger.b3>=0 && Passenger.b3<10){
                        System.out.println("\nAvailable seats (11-20): "+(10-Passenger.b3));
                        Airline_Reservation_System.type= 0;
                        ReservationSystem.booking();
                        Passenger.setPassangerDetails();
                        ReservationSystem.output();
                    }else
                        throw new IndexOutOfBoundsException();
                }catch(IndexOutOfBoundsException exception){
                    System.out.println("\n!! no seats avaialable");
                    System.out.println("book another flight !! ");
                    Airline_Reservation_System.Reservation(2);
                }
                break;
        }
    }
    public static void buyExcessBaggage(int k){
       System.out.printf("\npay %d to book the flight : ",k*3000);
       makePayment(k*3000);
    }
    public static void buyExcessBaggage(float k){
       System.out.printf("\npay %.2f to book the flight : ",k*3000);
       makePayment(k*3000);
    }
}
