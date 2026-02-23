
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        Menu menu = new Menu();
        menu.add(new MenuItem("M1", "Veg Thali", 80.00));
        menu.add(new MenuItem("C1", "Coffee", 30.00));
        menu.add(new MenuItem("S1", "Sandwich", 60.00));

        Storage store = new FileStore();
        TaxCalc tax = new BasicTax();
        DiscCalc disc = new BasicDisc();
        Printer printer = new Printer();

        Cafe cafe = new Cafe(menu, store, tax, disc, printer);

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        cafe.checkout("student", order);
    }
}