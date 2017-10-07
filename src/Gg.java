
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
	static String surname, lastname;
	static Scanner k = new Scanner(System.in);
	static String[] Menu = { "Pizza", "Chicken", "Coke", "Cake", "Milkshake" };
	static int[] Price = { 250, 120, 45, 80, 60 };
	static int[] Quantity = new int[5];
	static int menu, quantity, totalpizza, totalchicken, totalcake, totalcoke, totalmilkshake;

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
		for (int l = 0; l < Quantity.length; l++) {
			System.out.printf("\n%d.) %-23s %4d Baht.\n", l + 1, Menu[l], Price[l]);
		}
		System.out.printf("\n6.) Total\n7.) Exit\n");
	}

	public static int calculateOrder(int menu, int quantity) {
		switch (menu) {
		case 1:
			pizza++;
			totalpizza = quantity * Price[0];
			break;
		case 2:
			chicken++;
			totalchicken = quantity * Price[1];

			break;
		case 3:
			coke++;
			totalcoke = quantity * Price[2];
			break;
		case 4:
			cake++;
			totalcake = quantity * Price[3];

			break;
		case 5:
			milkshake++;
			totalmilkshake = quantity * Price[4];

			break;
		default:
			break;
		}
		return totalpizza | totalchicken | totalcake | totalcoke | totalmilkshake;

	}

	public static void printBill(int menu, double pizza, double chicken, double coke, double cake, double milkshake) {
		double total;
		total = totalpizza + totalchicken + totalcake + totalcoke + totalmilkshake;
		if (menu == 6) {
			System.out.println("o------ Menu ------+-- Qty --+-- Price --o");
			if (pizza > 0) {
				System.out.printf("| Pizza            |  %5d  |    %5d  |\n", quantity, Price[0]);
			}
			if (chicken > 0) {
				System.out.printf("| Chikens          |  %5d  |    %5d  |\n", quantity, Price[1]);
			}
			if (coke > 0) {
				System.out.printf("| Coke             |  %5d  |    %5d  |\n", quantity, Price[2]);
			}
			if (cake > 0) {
				System.out.printf("| Cake             |  %5d  |    %5d  |\n", quantity, Price[3]);
			}
			if (milkshake > 0) {
				System.out.printf("| Milkshake        |  %5d  |    %5d  |\n", quantity, Price[4]);
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
			if (menu == 7) {
				break;
			}
			if (menu != 6) {
				System.out.print("Enter Quantity: ");
				quantity = k.nextInt();
				System.out.println("");
				calculateOrder(menu, quantity);
			}
		} while (menu != 7);
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