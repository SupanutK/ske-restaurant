import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManager {
	private static ArrayList<String> names = new ArrayList<>();
	private static ArrayList<Double> prices = new ArrayList<>();

	public static String[] getMenuItem() {
		String[] namemenu = names.toArray(new String[names.size()]);
		return namemenu;
	}

	public static double[] getPrices() {
		double[] pricemenu = new double[prices.size()];
		for (int x = 0; x < pricemenu.length; x++) {
			pricemenu[x] = prices.get(x);
		}
		return pricemenu;
	}

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

	static void init() {
		setMenu("data/menu.txt");
	}
}
