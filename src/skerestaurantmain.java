
/*
 /**
 * User interface for a menu and ordering system,
 * using console interface.
 *
 * @author Supanut Petchnapaphan
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class skerestaurantmain {
	public static Scanner input = new Scanner(System.in);
	private static ArrayList<Integer> order = new ArrayList<Integer>();
	static double sum = 0;

	public static void printMenu() {
		String[] menu = RestaurantManager.getMenuItem();
		double[] price = RestaurantManager.getPrices();
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d.) %s", i + 1, menu[i]);
			System.out.printf("\t\t\t   %7.2f Baht.\n", price[i]);
		}
		System.out.println("[T]otal");
		System.out.println("[M]enu");
		System.out.println("[P]ayment");
		System.out.println("[E]xit");
	}

	public static double printOrder(double sum, String choice) {
		Double total = 0.0;
		String[] menu = RestaurantManager.getMenuItem();
		double[] price = RestaurantManager.getPrices();
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		if (choice.equalsIgnoreCase("T")) {
			System.out.println("\t\tSKE Restaurant");
			System.out.println("Date: " + date + "  Time: " + time);
			System.out.println("o------ Menu --------------o-- Qty --o-- Price --o");
			for (int i = 0; i < price.length; i++) {
				if (price[i] * order.get(i) != 0) {
					System.out.printf("|%-8s\t\t   |\t%d    |\t%7.2f  |\n", menu[i], order.get(i),
							price[i] * order.get(i));
				}
			}
			for (int j = 0; j < menu.length; j++) {
				total = total + order.get(j);
			}
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("|Total\t\t\t   |\t%.0f    |\t%7.2f  |\n", total, sum);
			System.out.println("+--------------------------+---------+-----------+");
		}
		return sum;
	}

	public static void payMent(double finalpay) {
		double money;
		do {

			System.out.print("Pay(Baht): ");
			money = input.nextDouble();
			if (money < finalpay) {
				System.out.println("Sorry not enough money.Please try again.");
			}
		} while (money < finalpay);
		System.out.printf("Change(Baht): %.2f\n", money - finalpay);
	}
	public static void setOrder() {
		for (int k = 0; k < RestaurantManager.getMenuItem().length; k++) {
			order.add(0);
		}
	}

	public static double calculatePrice(String choice, int quantity) {
		int orders, all;
		double prices = 0;
		double[] calculateprice = RestaurantManager.getPrices();
		ArrayList<Integer> realQty = new ArrayList<Integer>();
		for (int i = 0; i < calculateprice.length; i++) {
			realQty.add(0);
		}
		int choice1 = Integer.parseInt(choice);
		for (int j = 0; j < calculateprice.length; j++) {
			if (choice1 == j + 1) {
				orders = order.get(j) + quantity;
				order.add(j, orders);
				order.remove(j + 1);
				
				
				
				all = quantity - realQty.get(j);
				realQty.add(j, all);
				realQty.remove(j + 1);
				prices = all * calculateprice[j];
				break;
			}
		}
		return prices;
	}
	public static String CheckInt(String choice){
		String stri;
		for (int cha = 1; cha <= RestaurantManager.getPrices().length; cha++){
			stri = Integer.toString(cha);
			if (choice.equals(stri)){
				return stri;
			}
		}return " ";
	}

	public static void entertheOrder() {
		String choice;
		int qty = 0;
		double price = 0;
		do {
			System.out.print("Enter your Choice: ");
			choice = input.next();
			price = printOrder(sum, choice);
			if ((!choice.equalsIgnoreCase("T") && !choice.equalsIgnoreCase("P") && !choice.equalsIgnoreCase("E")
					&& !choice.equalsIgnoreCase("M")) && !choice.equals(CheckInt(choice))) {
				System.out.println("Incorrect menu!!\nTry again.");
				continue;
			}
			if (choice.equalsIgnoreCase("M")) {
				System.out.println();
				printMenu();
				entertheOrder();
			} else if (choice.equalsIgnoreCase("E")) {
				System.out.print("==== Thank you ====");
				System.out.print("Have a nice day :D");
				System.exit(0);
			} else if (choice.equalsIgnoreCase("P")) {
				payMent(price);
				System.out.print("==== Thank you ====");
				System.out.print("Have a nice day :D");
				System.exit(0);
			} else if (!choice.equalsIgnoreCase("T") && !choice.equalsIgnoreCase("M") && !choice.equalsIgnoreCase("P")
					&& !choice.equalsIgnoreCase("E")) {
				System.out.print("Enter Quantity: ");
				qty = input.nextInt();
			} else {
				continue;
			}
			sum = sum + calculatePrice(choice, qty);
		} while (!choice.equalsIgnoreCase("E"));
	}
	public static void main(String[] args) {
		RestaurantManager.init();
		printMenu();
		setOrder();
		entertheOrder();
		
	}
}