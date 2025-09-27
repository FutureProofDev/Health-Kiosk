import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        // Welcome Message
        System.out.println("Welcome To Health Kiosk!");
        System.out.println("Enter service code (P/L/T/C):");

        char serviceCode = userInput.next().strip().toLowerCase().charAt(0);

        switch (serviceCode) {

            case 'p' -> System.out.println("Go to Pharmacy Desk");
            case 'l' -> System.out.println("Go to Lab Desk");
            case 't' -> System.out.println("Triage Desk");
            case 'c' -> System.out.println("Counselling Desk");
            default -> System.out.println("Invalid service code");



        }


    }
}
