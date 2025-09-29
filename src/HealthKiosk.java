import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);


        // Welcome Message
        System.out.println("Welcome To Health Kiosk!");


        //Service Router
        System.out.println("Enter service code (P/L/T/C):");

        char serviceCode = userInput.next().strip().toLowerCase().charAt(0);

        switch (serviceCode) {

            case 'p' -> System.out.println("Go to: Pharmacy Desk");
            case 'l' -> System.out.println("Go to: Lab Desk");
            case 't' -> System.out.println("Go to: Triage Desk");
            case 'c' -> System.out.println("Go to: Counselling Desk");
            default -> System.out.println("Invalid service code");

        }


        // Mini Health Metric
        System.out.println("Enter Health Metric \n 1 - BMI, \n 2 - Dosage Round-Up, \n 3 - Trig Helper");
        int healthMetric = userInput.nextInt();
        int metricChosen = 0;
        String bmiString = "";
        double bmi = 0;
        int numberTabletsInt = 0;
        double sinDegrees = 0;

        switch (healthMetric) {
            case 1 -> {
                System.out.println("Enter your weight in kg:");
                double userWeight = userInput.nextDouble();

                System.out.println("Enter your height in meters:");
                double userHeight = userInput.nextDouble();

                bmi = Math.round(userWeight / Math.pow(userHeight, 2) * 10 / 10.0);
                bmiString = Double.toString(bmi);

                System.out.println("Bmi: " + bmiString);
                metricChosen = 1;


                if (bmi < 18.5)
                    System.out.println("BMI status: Underweight");
                else if (bmi < 24.9)
                    System.out.println("BMI status: Normal");
                else if (bmi < 29.9)
                    System.out.println("BMI status: Overweight");
                else
                    System.out.println("Bmi status: Obese");

            }

            case 2 -> {
                System.out.println("Enter required dosage in mg:");
                double dosage = userInput.nextDouble();

                double numberTablets = dosage / 250;
                numberTabletsInt = (int) Math.ceil(numberTablets);

                System.out.println("Number of tablets: " + numberTabletsInt);

                metricChosen = 2;


            }

            case 3 ->{
                System.out.println("Enter an angle in degrees: ");
                double degrees = userInput.nextDouble();

                sinDegrees = (Math.round(Math.sin(degrees) * 1000) / 1000.0);
                double cosDegrees = (Math.round(Math.cos(degrees) * 1000) / 1000.0);

                System.out.println("Sin(" + degrees + ") = " + sinDegrees);
                System.out.println("Cos(" + degrees + ") = " + cosDegrees);

                metricChosen = 3;

            }
        }


        // ID Sanity Checker
        double randDouble = ((65 + Math.random() * 25));
        int randInt = (int) randDouble;
        char randChar = (char) randInt;

        double randDouble1 = (3 + Math.random() * 7);
        int randInt1 = (int) randDouble1;

        double randDouble2 = (3 + Math.random() * 7);
        int randInt2 = (int) randDouble2;

        double randDouble3 = (3 + Math.random() * 7);
        int randInt3 = (int) randDouble3;

        double randDouble4 = (3 + Math.random() * 7);
        int randInt4 = (int) randDouble4;

        String randID = randChar + String.valueOf(randInt1) + String.valueOf(randInt2) + String.valueOf(randInt3) + String.valueOf(randInt4);


        if (randID.length() > 5)
            System.out.println("Invalid length");
        else if (!Character.isAlphabetic(randID.charAt(0)))
            System.out.println("Invalid First Character");
        else if (!Character.isDigit(randID.charAt(1)) || !Character.isDigit(randID.charAt(2)) || !Character.isDigit(randID.charAt(3)) || !Character.isDigit(randID.charAt(4)))
            System.out.println("Last 4 characters must be digits");
        else
            System.out.println("ID verified");


        // Secure Display Code
        System.out.println("Enter your first name: ");
        String userName = userInput.next();
        char firstChar = userName.charAt(0);

        int bmiToInt = (int) bmi;
        String bmiToString = String.valueOf(bmiToInt);
        char baseCode = (char) ('A' + (firstChar - 'A' + 2) % 26);
        String finalCodeFormat =   baseCode + randID.substring(randID.length() -2 ) + "-";

        String numberTablesString = String.valueOf(numberTabletsInt);
        String sinDegreesString = String.valueOf(Math.round(sinDegrees));

        switch (metricChosen) {

            case 1 -> finalCodeFormat += bmiToString;
            case 2 -> finalCodeFormat += numberTablesString;
            case 3 -> finalCodeFormat += sinDegreesString;

        }

        System.out.println("Display Code: " + finalCodeFormat);


        // Service Summary
        switch (serviceCode) {

            case 'p' -> System.out.println("Summary: PHARMACY | ID =" + randID+ " | Code=" + finalCodeFormat);
            case 'l' -> System.out.println("Summary: LAB | ID =" + randID + " | Code=" + finalCodeFormat);
            case 't' -> System.out.println("Summary: TRIAGE | ID =" + randID + " | Code=" + finalCodeFormat);
            case 'c' -> System.out.println("Summary: COUNSELLING | ID =" + randID + " | Code=" + finalCodeFormat);
            default -> System.out.println("Invalid service code");

        }
    }
}
