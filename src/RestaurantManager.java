import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;


public class RestaurantManager {
	private static ArrayList<String> names = new ArrayList<>();
	private static ArrayList<Double> prices = new ArrayList<>();
/**
 *  This method will record menu vale from ArrayList to Array.
 * @return
 */
	public static String[] getMenuItem() {
		String[] namemenu = names.toArray(new String[names.size()]);
		return namemenu;
	}
/**
 * This method will record price vale from ArrayList to Array.	
 * @return
 */
	public static double[] getPrices() {
		double[] pricemenu = new double[prices.size()];
		for (int x = 0; x < pricemenu.length; x++) {
			pricemenu[x] = prices.get(x);
		}
		return pricemenu;
	}
/**
 * This method will load menu file from folder data.
 * @param filename
 */
	static void setMenu(String filename) {
		ClassLoader loader = RestaurantManager.class.getClassLoader();
		InputStream in = loader.getResourceAsStream(filename);
		if (in == null) {
			System.out.println("Error reading file: " + filename);
			return;
		}
		Scanner input = new Scanner(in);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.startsWith("#")) {
				continue;
			}
			String[] array = line.split(";");
			names.add(array[0]);
			prices.add(Double.parseDouble(array[1]));
		}
	}
/**
 *  This method will call load menu method.
 */
	static void init() {
		setMenu("data/menu.txt");
	}
/**
 * This method will record order.
 * @param price
 * @param total
 * @param sum
 * @param menu
 * @param order
 */
	static void recordOrder(double[] price, double total, double sum, String[] menu, ArrayList<Integer> order) {
		FileWriter fileWriter;
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		try {
			fileWriter = new FileWriter("order.txt");
			PrintWriter r = new PrintWriter(fileWriter);
			r.println("\t\tSKE Restaurant");
			r.println("Date: " + date + "  Time: " + time);
			r.println("o------ Menu --------------o-- Qty --o-- Price --o");
			for (int i = 0; i < price.length; i++) {
				if (price[i] * order.get(i) != 0) {
					r.printf("|%-8s\t\t   |\t%d    |\t%7.2f  |", menu[i], order.get(i), price[i] * order.get(i));
					r.println();
				}
			}
			r.println("o--------------------------o---------o-----------o");
			r.printf("|Total\t\t\t   |\t%.0f    |\t%7.2f  |\n", total, sum);
			r.println();
			r.print("o--------------------------o---------o-----------o");
			r.close();
		} catch (IOException a) {
			a.printStackTrace();
		}

	}
}
