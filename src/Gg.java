/*
 /**
 * User interface for a menu and ordering system,
 * using console interface.
 *
 * @author Supanut Petchnapaphan
 */
import java.util.Scanner;

public class Gg {

    static double pizza, chicken, coke, cake, milkshake = 0;
    static int pizzapiece, chickenpiece, cokepiece, menu,quantity, pizzaquantity, chickenquantity, cokequantity, cakepiece, cakequantity, milkshakequantity, milkshakepiece, collector1, collector2, collector3, collector4, collector5;
    static String surname, lastname;
    static Scanner k = new Scanner(System.in);

    public static void printGreeter(String surname, String lastname) {
        Scanner n = new Scanner(System.in);
        System.out.print("Enter your surname: ");
        surname = n.next();
        System.out.print("Enter your lastname: ");
        lastname = n.next();
        System.out.print("Hello Khun " + surname + " " + lastname);
        System.out.println();

    }

    public static void printOrder() {
        System.out.println("--------- Welcome to SKE Restaurant ---------");
        System.out.println("1.) Pizza 250 Baht.");
        System.out.println("2.) Chickens 120 Baht.");
        System.out.println("3.) Coke 45 Baht.");
        System.out.println("4.) Cake 80 Baht.");
        System.out.println("5.) Milkshake 60 Baht.");
        System.out.println("6.) Total ");
        System.out.println("7.) Exit");
    }

    public static double addOrder(int menu, int quantity) {
        switch ( menu ) {
            case 1:
                pizza++;
                pizzaquantity = quantity;
                pizzapiece = pizzaquantity * 250;
                collector1 = 1;
                break;
            case 2:
                chicken++;
                chickenpiece = quantity;
                chickenpiece = chickenquantity * 120;
                collector2 = 1;
                break;
            case 3:
                coke++;
                cokequantity = quantity;
                cokepiece = cokequantity * 45;
                collector3 = 1;
                break;
            case 4:
                cake++;
                cakequantity = quantity;
                cakepiece = cakequantity * 80;
                collector4 = 1;
                break;
            case 5:
                milkshake++;
                milkshakequantity = quantity;
                milkshakepiece = milkshakequantity * 60;
                collector5 = 1;
                break;
            default:
                break;
        }
        return collector1 | collector2 | collector3 | collector4 | collector5;
    }

    public static void printBill(int menu, double pizza, double chicken, double coke, double cake, double milkshake) {
        double total = 0;
        total = pizzapiece + chickenpiece + cokepiece + cakepiece + milkshakepiece;
        if ( menu == 6 ) {
            System.out.println("o------ Menu ------+-- Qty --+-- Price --o");
            if ( pizza > 0 ) {
                System.out.printf("| Pizza            |  %5d  |    %5d  |\n", pizzaquantity, pizzapiece);
            }
            if ( chicken > 0 ) {
                System.out.printf("| Chikens          |  %5d  |    %5d  |\n", chickenquantity, chickenpiece);
            }
            if ( coke > 0 ) {
                System.out.printf("| Coke             |  %5d  |    %5d  |\n", cokequantity, cokepiece);
            }
            if ( cake > 0 ) {
                System.out.printf("| Cake             |  %5d  |    %5d  |\n", cakequantity, cakepiece);
            }
            if ( milkshake > 0 ) {
                System.out.printf("| Milkshake        |  %5d  |    %5d  |\n", milkshakequantity, milkshakepiece);
            }
            System.out.println("o------------------o---------o-----------o");
            System.out.printf("| Total                      |    %.0f    |\n", (total));
            System.out.printf("| Vat 7 percent              |    %.2f |\n", (total * 1.07));
            System.out.println("o------------------o---------o-----------o");
            System.out.println("");
        }
    }

    public static void repeatOrder() {
        do {
            System.out.print("Enter your Choice: ");
            menu = k.nextInt();
            printBill(menu, pizza, chicken, coke, cake, milkshake);
            if ( menu == 7 ) {
                break;
            }
            if ( menu != 6 ) {
                System.out.print("Enter Quantity: ");
                quantity = k.nextInt();
                System.out.println("");
                addOrder(menu, quantity);
            }
        } while ( menu != 7 );
        System.out.println("===== Thank you =====");
        System.out.print("Have a nice day :D");
        System.out.println();
    }

    public static void main(String[] args) {

        printGreeter(surname, lastname);
        printOrder();
        repeatOrder();

    }
}
