package airline_reservation_system;
import static airline_reservation_system.ReservationSystem.args;
import java.text.ParseException;
import java.util.Scanner;
/**
 *
 * @author ashik
 */
public class Cancel {
    public static String D_date;
    static Scanner input = new Scanner(System.in);
    static String booked_pnr;
    static int option,i = 0,age,s = 0;
    static String name;
    static boolean exit = false;
    static Scanner output = new Scanner(System.in);
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws ParseException {
        System.out.println("\n1.EDIT TICKET\n2.CANCEL TICKET");
        System.out.print("\nEnter your choice : ");
        int choice = Airline_Reservation_System.checkInteger(1,2);
        switch(choice){
            case 1:
                System.out.println("\n1.edit departure time\n2.edit user name\n3.edit age\n4.back to main menu");
                System.out.print("\nEnter your option  : ");
                option = Airline_Reservation_System.checkInteger(1,4);
                exit = false;
                if(option<4){
                    do{
                        booked_pnr = input_pnr();
                        for(i = 0;i<Passenger.PNR.size();i++){
                            if(Passenger.PNR.get(i).equals(booked_pnr.trim())){
                                s = i;
                                exit = true;
                            }
                        }
                    }while(!exit);
                }
                edit(option,s);
                break;
            case 2:
                booked_pnr = input_pnr();
                CANCEL(booked_pnr.trim());
                break;
            }
        
    }
     public static String input_pnr() throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.print("ENTER PASSENGER pnr number : ");
        String pnr = input.nextLine(); // Read the pnr
        return pnr;
    }
     public static void edit(int option,int i) throws ParseException{
         switch(option){
            case 1:
                System.out.println("your old departure date is "+Passenger.DEPDATE.get(i));
                do{
                    System.out.print("Enter new departure date : ");
                    D_date = input.nextLine();
                }while(!ReservationSystem.isValidDate(D_date));
                Passenger.DEPDATE.remove(i);
                Passenger.DEPDATE.add(i,D_date);
                break;
            case 2:
                System.out.println("entered name is "+Passenger.NAME.get(i));
                System.out.print("ENTER NEW NAME : ");
                name = output.nextLine();
                while (!name.matches("[a-zA-Z\\s]+")) { // A-Z and Space
                    System.out.println("ENTER IN LETTERS ONLY!");
                    System.out.print("\nName : ");
                    name = output.nextLine();
                }
                Passenger.NAME.remove(i);
                Passenger.NAME.add(i,name);
                break;
            case 3:
                Scanner sc = new Scanner(System.in);
                System.out.println("entered age is "+Passenger.AGE.get(i));
                System.out.print("ENTER NEW AGE : ");
                while(!sc.hasNextInt()){
                    System.out.print("\nAGE : ");
                    sc.next();
                }
                age = sc.nextInt();
                Passenger.AGE.remove(i);
                Passenger.AGE.add(i,age);
                break;
            case 4:
                Airline_Reservation_System.main(args);
                break;
        }
    }
    public static void CANCEL(String pnr) throws ParseException{
        exit = false;
        for(i = 0;i<Passenger.PNR.size();i++){
            if(Passenger.PNR.get(i).equals(booked_pnr)){
                Passenger.PNR.remove(i);
                Passenger.NAME.remove(i);
                Passenger.AGE.remove(i);
                Passenger.Class.remove(i);
                Passenger.Type.remove(i);
                Passenger.bagage.remove(i);
                Passenger.ROUTE.remove(i);
                System.out.println("\n!! DELETED !!");
                exit = true;
                break;
            }
        }
        if(exit = false){
            System.out.println("!! No person found !!");
            System.out.println("ENTER VALID PNR NUMBER ");
            booked_pnr = input_pnr();
            CANCEL(booked_pnr);
        }
    }
}