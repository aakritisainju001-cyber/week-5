import java.util.Scanner;

/**
 * Write a description of class senario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class senario{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice = 'y';

        double feeRate = 0.005; 

        while (choice == 'y' || choice == 'Y') {

        
            System.out.print("\nEnter deposit amount (minimum Rs.1000): ");
            double P = sc.nextDouble();

            if (P < 1000) {
                System.out.println("Deposit must be at least Rs.1000!");
                continue;
            }

            System.out.print("Enter annual interest rate (8% - 12%): ");
            double annualRate = sc.nextDouble();

            if (annualRate < 8 || annualRate > 12) {
                System.out.println("Interest rate must be between 8% to 12% only!");
                continue;
            }

            System.out.print("Enter duration in years (maximum 5 years): ");
            int years = sc.nextInt();

            if (years > 5 || years <= 0) {
                System.out.println("Duration must be between 1 and 5 years only!");
                continue;
            }

            int months = years * 12;
            double monthlyRate = (annualRate / 100) / 12;

            double A = P * Math.pow((1 + monthlyRate), months);
            double fee = A * feeRate;
            double finalAmount = A - fee;

            System.out.println("\n----- Fixed Deposit Summary -----");
            System.out.println("Principal (P): Rs. " + P);
            System.out.println("Annual Interest Rate: " + annualRate + "%");
            System.out.println("Monthly Rate: " + monthlyRate);
            System.out.println("Duration: " + months + " months");
            System.out.println("Maturity Amount (Before Fee): Rs. " + A);
            System.out.println("Processing Fee (0.5%): Rs. " + fee);
            System.out.println("Final Amount (After Fee): Rs. " + finalAmount);

            System.out.print("\nDo you want to calculate another FD? (y/n): ");
            choice = sc.next().charAt(0);
        }

        System.out.println("\nThank you for using Nepal Investment Bank FD Calculator.");
        sc.close();
    }
}
