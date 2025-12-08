import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;

public class currency_converter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");
        System.out.println("1. USD to Rupee");
        System.out.println("2. Rupee to USD");
        System.out.println("3. Euro to Rupee");
        System.out.println("4. Rupee to Euro");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        double amount;
        String from = "", to = "";

        if (choice == 1) {
            from = "USD";
            to = "INR";
            System.out.print("Enter amount in USD: ");
            amount = scanner.nextDouble();
            double result = convertUsingAPI(amount, from, to);
            System.out.println("Converted amount in Rupee: " + result);

        } else if (choice == 2) {
            from = "INR";
            to = "USD";
            System.out.print("Enter amount in Rupee: ");
            amount = scanner.nextDouble();
            double result = convertUsingAPI(amount, from, to);
            System.out.println("Converted amount in USD: " + result);

        } else if (choice == 3) {
            from = "EUR";
            to = "INR";
            System.out.print("Enter amount in Euro: ");
            amount = scanner.nextDouble();
            double result = convertUsingAPI(amount, from, to);
            System.out.println("Converted amount in Rupee: " + result);

        } else if (choice == 4) {
            from = "INR";
            to = "EUR";
            System.out.print("Enter amount in Rupee: ");
            amount = scanner.nextDouble();
            double result = convertUsingAPI(amount, from, to);
            System.out.println("Converted amount in Euro: " + result);

        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // ===== REAL API METHOD (Very Simple) =====
    public static double convertUsingAPI(double amount, String from, String to) {
        try {
            String link = "https://api.frankfurter.app/latest?amount=" 
                            + amount + "&from=" + from + "&to=" + to;

            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner reader = new Scanner(url.openStream());
            String response = "";
            while (reader.hasNext()) {
                response += reader.nextLine();
            }
            reader.close();

            // Extract the number from: {"rates":{"INR":830.25}}
            int index = response.indexOf(to) + to.length() + 2; 
            String value = response.substring(index, response.indexOf("}", index));

            return Double.parseDouble(value);

        } catch (Exception e) {
            System.out.println("API Error! Check Internet or Currency Codes.");
            return 0;
        }
    }
}
