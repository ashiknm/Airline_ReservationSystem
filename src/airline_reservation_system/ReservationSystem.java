package airline_reservation_system;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationSystem {
    static int from;
    static int destination;
    public  static String[] args;
    public static String depDate;
    static String text;
    static boolean exit = false;
    static int c = 0;
    static Scanner input = new Scanner(System.in);
    
    public static void booking() throws ParseException{
        String FROM =  "";
        System.out.println("\n# AIRPORT TABLE : TYPE : LOCAL"); 
        System.out.println("ID   FROM AIRPORT\n");
        FromTable();
        System.out.print("\nSELECT FROM AIRPORT (1-8) : ");
        from = Airline_Reservation_System.checkInteger(1,8);
        System.out.println("\nRoute table : ");
        System.out.println("ID   FROM  AIRPORT    TO    DESTINATION AIRPORT\n");
        
        switch(from){
            case 1: FROM = "HYD";break;
            case 2: FROM = "VGA";break;
            case 3: FROM = "CCU";break;
            case 4: FROM = "PNY";break;
            case 5: FROM = "IXB";break;
            case 6: FROM = "VTZ";break;
            case 7: FROM = "GOI";break;
            case 8: FROM = "SIN";break;
        }
        DestinationTable(FROM);
        System.out.print("\nSELECT rute (1-7) : ");
        destination = Airline_Reservation_System.checkInteger(1,7);
        System.out.println("\n** ENTER DEPARTING DATE ( EX. dd/MM/yyyy , DATE [01-31] / MONTH [01-12] / YEAR [20xx]");
        checkdate();
    }
    
    public static void FromTable(){
        System.out.println("1.   [HYD] - HYDERABD");
        System.out.println("2.   [VGA] - VIJAYAVADA");
        System.out.println("3.   [CCU] - KOLKATTA");
        System.out.println("4.   [PNY] - PUDUCHERRY ]");
        System.out.println("5.   [IXB] - SILGURI");
        System.out.println("6.   [VTZ] - VISHAKAPATNAM");
        System.out.println("7.   [GOI] - GOA");
        System.out.println("8.   [SIN] - SINGAPORE");
    }
    public static void DestinationTable(String FAirport){
        int s = 0;
        for (String[] flight1 : flight) {
            if (flight1[0].equals(FAirport)) {
                System.out.println((s+1)+". "+" [" + flight1[0] + "] - " + fullform(flight1[0]) + " " + " TO " + "  [" + flight1[1] + "] - " + fullform(flight1[1]));
                s++;
            }
        }
    }
    static String[][]flight = {
        {"HYD","VGA"},{"HYD","CCU"},{"HYD","PNY"},{"HYD","IXB"},
        {"HYD","VTZ"},{"HYD","GOI"},{"HYD","SIN"},
        {"VGA","HYD"},{"VGA","CCU"},{"VGA","PNY"},{"VGA","IXB"},
        {"VGA","VTZ"},{"VGA","GOI"},{"VGA","SIN"},
        {"CCU","HYD"},{"CCU","VGA"},{"CCU","PNY"},{"CCU","IXB"},
        {"CCU","VTZ"},{"CCU","GOI"},{"CCU","SIN"},
        {"PNY","HYD"},{"PNY","VGA"},{"PNY","CCU"},{"PNY","IXB"},
        {"PNY","VTZ"},{"PNY","GOI"},{"PNY","SIN"},
        {"IXB","HYD"},{"IXB","VGA"},{"IXB","CCU"},{"IXB","PNY"},
        {"IXB","VTZ"},{"IXB","GOI"},{"IXB","SIN"},
        {"VTZ","HYD"},{"VTZ","VGA"},{"VTZ","CCU"},{"VTZ","PNY"},
        {"VTZ","IXB"},{"VTZ","GOI"},{"VTZ","SIN"},
        {"GOI","HYD"},{"GOI","VGA"},{"GOI","CCU"},{"GOI","PNY"},
        {"GOI","IXB"},{"GOI","VTZ"},{"GOI","SIN"},
        {"SIN","HYD"},{"SIN","VGA"},{"SIN","CCU"},{"SIN","PNY"},
        {"SIN","IXB"},{"SIN","VTZ"},{"SIN","GOI"},
        
    };
    public static String fullform(String airport){
        switch(airport){
            case "HYD":text = "HYDERABD";break;
            case "VGA":text = "VIJAYAVADA";break;
            case "CCU":text = "KOLKATTA";break;
            case "PNY":text = "PUDUCHERRY";break;
            case "IXB":text = "SILGURI";break;
            case "VTZ":text = "VISHAKAPATNAM";break;
            case "GOI":text = "GOA";break;
            case "SIN":text = "SINGAPORE";break;
        }
        return text;
    }
    public static boolean isValidDate(String D) { 
        if (D == null) {
            return false;
        }
        // SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (D.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(D.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
    public static void checkdate() throws ParseException{
        exit = false;
         do {
            depDate = input.next();
            if (isValidDate(depDate)) {
                exit = true;
            } else{
               if (isValidDate(depDate) == false) {
                    System.out.println("*PLEASE ENTER DATE IN CORRECT FORMAT!");
                    System.out.print("ENTER DATE : ");
                }
            }
        } while (!exit);
    }
    public static void output() throws ParseException{
        System.out.println("\n\n --***** ----TICKET BOOKED --***** ---- !!!");
        System.out.println("***************************************************");
        
        for (int i = 0; i < Passenger.passangerNo; i++) {
            Passenger.showDetails(i); 
        }
        Airline_Reservation_System.askuser();
    }
}
