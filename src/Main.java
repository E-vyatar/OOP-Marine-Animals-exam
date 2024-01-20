import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        File shelters = new File(args[0]);
        File animals = new File(args[1]);

        MarineZoo marineZoo = MarineZoo.read(shelters, animals);

        while (true) {
            System.out.println("""
                    Please make your choice:\s
                    1 – Show all shelters
                    2 – Show all animals
                    3 – Show all shelters suitable for a specific animal
                    4 – Show the optimal shelters for a specific animal
                    5 – Show the constant properties per shelter type
                    6 – Stop the program
                    """);

            int choice = inputScanner.nextInt();

            switch (choice) {
                case 1:
                    marineZoo.showAllShelters();
                    break;
                case 2:
                    marineZoo.showAllAnimals();
                    break;
                case 3:
                    marineZoo.sheltersSuitableForAnimal(inputScanner,false);
                    break;
                case 4:
                    marineZoo.sheltersSuitableForAnimal(inputScanner,true);
                    break;
                case 5:
                    marineZoo.shelterProperties(inputScanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
