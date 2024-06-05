import java.util.Scanner;

public class TokoElektronik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int total = 0;
        scanner.nextLine();

        for(int  i = 0; i < amount; i++){
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                String brand = scanner.nextLine();
                String model = scanner.nextLine();
                int storageCapacity = scanner.nextInt();
                int batteryLife = scanner.nextInt();
                Smartphone smartphone = new Smartphone(brand, model, storageCapacity, batteryLife);
                smartphone.displayDetails();
                System.out.printf("Price: %d\n", smartphone.calculatePrice());
                total += smartphone.calculatePrice();
            }
            else if(choice == 2){
                String brand = scanner.nextLine();
                String model = scanner.nextLine();
                String processorType = scanner.nextLine();
                int ram = scanner.nextInt();
                scanner.nextLine();
                int ts = scanner.nextInt();
                boolean ists = false;
                if(ts != 0){
                    ists = true;
                }
                Laptop laptop = new Laptop(brand, model, processorType, ram, ists);
                laptop.displayDetails();
                System.out.printf("Price: %d\n", laptop.calculatePrice());
                total += laptop.calculatePrice();
            }
            else{
                String brand = scanner.nextLine();
                String model = scanner.nextLine();
                int screenSize = scanner.nextInt();
                int hasCellular = scanner.nextInt();
                boolean ishs = false;
                if(hasCellular != 0){
                    ishs = true;
                }
                Tablet tablet = new Tablet(brand, model, screenSize, ishs);
                tablet.displayDetails();
                System.out.printf("Price: %d\n", tablet.calculatePrice());
                total += tablet.calculatePrice();
            }
        }
        System.out.printf("Total price: %d\n", total);
        scanner.close();
    }
}
