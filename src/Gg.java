import java.util.Scanner;

public class Gg {

    static double p, c, ck, ca, ms = 0;
    static int pp, cp, ckp, m, t, q, pq, cq, ckq, cap, caq, msq, msp, k1, k2, k3, k4, k5;
    static String surname, lastname;
    static Scanner k = new Scanner(System.in);

    public static void greeter(String surname, String lastname) {
        Scanner n = new Scanner(System.in);
        System.out.print("Enter your surname: ");
        surname = n.next();
        System.out.print("Enter your lastname: ");
        lastname = n.next();
        System.out.print("Hello Khun " + surname + " " + lastname);
        System.out.println();

    }

    public static void first() {
        System.out.println("--------- Welcome to SKE Restaurant ---------");
        System.out.println("1.) Pizza 250 Baht.");
        System.out.println("2.) Chickens 120 Baht.");
        System.out.println("3.) Coke 45 Baht.");
        System.out.println("4.) Cake 80 Baht.");
        System.out.println("5.) Milkshake 60 Baht.");
        System.out.println("6.) Total ");
        System.out.println("7.) Exit");
    }

    public static double food(int m, int q) {
        if (m == 1) {
            p++;
            pq = q;
            pp = pq * 250;
            k1 = 1;
        } else if (m == 2) {
            c++;
            cq = q;
            cp = cq * 120;
            k2 = 1;
        } else if (m == 3) {
            ck++;
            ckq = q;
            ckp = ckq * 45;
            k3 = 1;
        } else if (m == 4) {
            ca++;
            caq = q;
            cap = caq * 80;
            k4 = 1;
        } else if (m == 5) {
            ms++;
            msq = q;
            msp = msq * 60;
            k5 = 1;
        }
        return k1 | k2 | k3 | k4 | k5;
    }

    public static void bill(int m, double p, double c, double ck, double ca, double ms) {
        double sum = 0;
        sum = pp + cp + ckp + cap + msp;
        if (m == 6) {
            System.out.println("o------ Menu ------+-- Qty --+-- Price --o");
            if (p > 0) {
                System.out.printf("| Pizza            |  %5d  |    %5d  |\n", pq, pp);
            }
            if (c > 0) {
                System.out.printf("| Chikens          |  %5d  |    %5d  |\n", cq, cp);
            }
            if (ck > 0) {
                System.out.printf("| Coke             |  %5d  |    %5d  |\n", ckq, ckp);
            }
            if (ca > 0) {
                System.out.printf("| Cake             |  %5d  |    %5d  |\n", caq, cap);
            }
            if (ms > 0) {
                System.out.printf("| Milkshake        |  %5d  |    %5d  |\n", msq, msp);
            }
            System.out.println("o------------------o---------o-----------o");
            System.out.printf("| Total                      |    %5f  |\n", (sum));
            System.out.printf("| Vat 7 percent              |    %5f  |\n", (sum * 1.07));
            System.out.println("o------------------o---------o-----------o");
            System.out.println("");
        }
    }
    public static void re () {
        do {
            System.out.print("Enter your Choice: ");
            m = k.nextInt();
            bill(m, p, c, ckp, ca, ms);
            if (m == 7) {
                break;
            }
            if (m != 6) {
                System.out.print("Enter Quantity: ");
                q = k.nextInt();
                System.out.println("");
                food(m, q);
            }
        } while (m != 7);
        System.out.println("===== Thank you =====");
        System.out.print("Have a nice day :D");
        System.out.println();
    }

    public static void main(String[] args) {
        
        greeter(surname, lastname);
        first();
        re();

    }
}

