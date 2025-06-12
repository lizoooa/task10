import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Ship ship = null;

        while (true) {
            System.out.println("\n1. Create ship  2. Add container  3. Exit");
            int option = input.nextInt();

            if (option == 1) {
                System.out.print("Max speed: ");
                int speed = input.nextInt();
                System.out.print("Max containers: ");
                int maxC = input.nextInt();
                System.out.print("Max total weight (kg): ");
                int maxW = input.nextInt();
                ship = new Ship(speed, maxC, maxW);
            }

            else if (option == 2) {
                if (ship == null) {
                    System.out.println("Add ship first.");
                    continue;
                }

                System.out.print("Type (1=Liquid, 2=Gas, 3=Refrigerated): ");
                int type = input.nextInt();

                System.out.print("Load mass: ");
                int mass = input.nextInt();
                System.out.print("Tare weight: ");
                int tare = input.nextInt();
                System.out.print("Height: ");
                int height = input.nextInt();
                System.out.print("Depth: ");
                int depth = input.nextInt();
                System.out.print("Max capacity: ");
                int cap = input.nextInt();

                Container c = null;

                if (type == 1) {
                    System.out.print("Hazardous? (true/false): ");
                    boolean haz = input.nextBoolean();
                    c = new LiquidContainer(mass, height, tare, depth, cap, haz);
                } else if (type == 2) {
                    System.out.print("Pressure: ");
                    double press = input.nextDouble();
                    c = new GasContainer(mass, height, tare, depth, cap, press);
                } else if (type == 3) {
                    input.nextLine(); // consume leftover newline
                    System.out.print("Product type: ");
                    String prod = input.nextLine();
                    System.out.print("Temperature: ");
                    double temp = input.nextDouble();
                    c = new RefrigeratedContainer(mass, height, tare, depth, cap, prod, temp);
                }

                try {
                    ship.addContainer(c);
                    System.out.println("Container added: " + c.getSerialNumber());
                } catch (Exception e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }

            else if (option == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}