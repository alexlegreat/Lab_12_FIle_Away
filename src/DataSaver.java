import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        while (true) {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter ID Number (e.g., 000001): ");
            String idNumber = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter Year of Birth: ");
            String yearOfBirth = scanner.nextLine();

            records.add(firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + yearOfBirth);

            System.out.print("Do you want to add another record? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) break;
        }

        System.out.print("Enter the output CSV file name (e.g., data.csv): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

