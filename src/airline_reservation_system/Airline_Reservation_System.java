package airline_reservation_system;
import static airline_reservation_system.ReservationSystem.args;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ashik
 */
public class Airline_Reservation_System {
   
    static boolean exit = false;
    public static  int CLASS;
    static int type;
    static String Pnr;
    static int menu;
    static int c = 0;
    static int TYPE;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws ParseException {
        System.out.println("\n1.Book the ticket\n2.Cancel/Edit ticket\n3.list all passengers"
                + "\n4.get bagage limit\n5.exit");
        System.out.print("\nSELECT MENU (1-5) : ");
        menu = checkInteger(1,5);
        System.out.println();
        switch(menu){
            case 1:
                Class();
                break;
            case 2:
                Cancel.main(args);
                askuser();
                break;
            case 3:
                for (int i = 0; i < Passenger.PNR.size(); i++) {
                    Passenger.showDetails(i); 
                }
                askuser();
                break;
                        
            case 4:
                System.out.print("Enter pnr number : ");
                Pnr = input.next();
                Passenger.getbagagelimit(Pnr);
                askuser();
                break;
            case 5:
                System.out.println("EXIT COMPLETED!");
                System.exit(0);
                break;
        }
   }
    public static void Reservation(int CLASS) throws ParseException{
        Scanner input = new Scanner(System.in);
        switch(CLASS){
            case 1:
                switch(type){
                    case 1:
                        System.out.println("\navailable flights are");
                        System.out.println("\n2.type 2\n3.type 3");
                        System.out.print("\nEnter your choice : ");
                        break;
                    case 2:
                        System.out.println("\navailable flights are");
                        System.out.println("1.type 1\n3.type 3");
                        System.out.print("\nEnter your choice : ");
                        break;
                    case 3:
                        System.out.println("\navailable flights are");
                        System.out.println("1.type 1\n2.type 2");
                        System.out.print("\nEnter your choice : ");
                        break;
                    default:
                        System.out.println("\navailable flights are");
                        System.out.println("1.type 1\n2.type 2\n3.type 3");
                        System.out.print("\nEnter your choice : ");
                }
                type = checkInteger(1,3);
                TYPE = type;
                FlightwithEconomy.main(args);
                break;
            case 2:
                switch(type){
                    case 2:
                        System.out.println("\navailable flight is");
                        System.out.println("\n3.type 3");
                        type = 3;
                        TYPE = type;
                        FlightWithEconomyAndBusiness.main(args);
                        break;
                    case 3:
                        System.out.println("\navailable flight is");
                        System.out.println("1.type 2");
                        type = 2;
                        TYPE = type;
                        FlightWithEconomyAndBusiness.main(args);
                        break;
                    default:
                        System.out.println("\navailable flights are");
                        System.out.println("\n2.type 2\n3.type 3");
                        System.out.print("\nEnter your choice : ");
                        type = checkInteger(2,3);
                        TYPE = type;
                        FlightWithEconomyAndBusiness.main(args);
                }
                break;
            case 3:
                System.out.println("\navailable flight is type 3");
                type = 3;
                TYPE = type;
                Flight_Economy_Business_Firstclass.main(args);
                break;
        }
    }
    public static void Class() throws ParseException{
        Scanner input = new Scanner(System.in);
        System.out.println("Availible classes are : ");
        System.out.println("1.Economy\n2.Buisness\n3.First class");
        System.out.print("\nEnter your choice : ");
        CLASS = checkInteger(1,3);
        Reservation(CLASS);
    }
     public static int checkInteger(int min,int max){
        exit = true;
        Scanner input = new Scanner(System.in);
        int check = 0;
        while(exit){
            try{
                check = input.nextInt();
                if (check> max || check < min)
                    throw new RuntimeException();
                exit = false;
            }catch(InputMismatchException exception){
                input.next();
                System.out.println(" ! ERROR : input must be integer !");
                System.out.print("*PLEASE ENTER NUMBER! ");
                System.out.print("SELECT MENU AGAIN : ");
            }catch(RuntimeException exception){
                System.out.printf(" ! ERROR : choice must be between %d and %d !",min,max);
                System.out.print("\nEnter menu : ");
            }
        }
        return check;
    }
    @SuppressWarnings("ConvertToStringSwitch")
    public static void askuser() throws ParseException{
        exit = false;
        do{
            System.out.print("\n\nDo you want to continue (Y/N): ");
            String check = input.next();
            if("Y".equals(check) ||"y".equals(check)){
                Airline_Reservation_System.main(args);
                break;
            }
            else if("N".equals(check) ||"n".equals(check)){
                System.out.println("EXIT COMPLETED!");
                System.exit(0);
            }
            else
                exit = true;
        }while(exit);
     }
}