package OOPActivities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n\t\tFile Handling Menu:");
	            System.out.println("1. Create a file");
	            System.out.println("2. Read from a file");
	            System.out.println("3. Write to a file");
	            System.out.println("4. Search for a file");
	            System.out.println("5. Delete a file");
	            System.out.println("6. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                    createFile(scanner);
	                    break;
	                case 2:
	                    readFile(scanner);
	                    break;
	                case 3:
	                    writeFile(scanner);
	                    break;
	                case 4:
	                    searchFile(scanner);
	                    break;
	                case 5:
	                    deleteFile(scanner);
	                    break;
	                case 6:
	                    System.out.println("Exiting the program.");
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        }
	    }

	    private static void createFile(Scanner scanner) {
	    	System.out.println("----------------------------------------");
	        System.out.print("Enter the file name to create: ");
	        String fileName = scanner.nextLine();

	        try {
	            File file = new File(fileName);

	            if (file.createNewFile()) {
	                System.out.println("File created successfully: " + file.getAbsolutePath());
	            } else {
	                System.out.println("File already exists.");
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }

	    private static void readFile(Scanner scanner) {
	    	System.out.println("----------------------------------------");
	        System.out.print("Enter the file name to read: ");
	        String fileName = scanner.nextLine();

	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(fileName));
	            String line;

	            System.out.println("File contents:");
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }

	            reader.close();
	        } catch (IOException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }

	    private static void writeFile(Scanner scanner) {
	    	System.out.println("----------------------------------------");
	        System.out.print("Enter the file name to write: ");
	        String fileName = scanner.nextLine();

	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)); 

	            System.out.println("Enter text to write to the file (Type '.' to finish):");
	            String line;
	            while (!(line = scanner.nextLine()).equals(".")) {
	                writer.write(line);
	                writer.newLine();
	            }

	            writer.close();
	            System.out.println("Data written to the file.");
	        } catch (IOException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }

	    private static void searchFile(Scanner scanner) {
	    	System.out.println("----------------------------------------");
	        System.out.print("Enter the file name to search: ");
	        String fileName = scanner.nextLine();

	        File file = new File(fileName);

	        if (file.exists()) {
	            System.out.println("File found: " + file.getAbsolutePath());
	        } else {
	            System.out.println("File not found.");
	        }
	    }

	    private static void deleteFile(Scanner scanner) {
	    	System.out.println("----------------------------------------");
	        System.out.print("Enter the file name to delete: ");
	        String fileName = scanner.nextLine();

	        File file = new File(fileName);

	        if (file.delete()) {
	            System.out.println("File deleted successfully.");
	        } else {
	            System.out.println("Unable to delete the file. It may not exist.");
	        }
	        
	        
	}

}
