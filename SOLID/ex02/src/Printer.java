
import java.util.List;

public class Printer {
    public String buildInv(String id, List<OrderLine> lines, Menu menu, double sub, double taxPct, double tax, double disc, double tot) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(id).append("\n");

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTot = item.price * l.qty;
            sb.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTot));
        }

        sb.append(String.format("Subtotal: %.2f\n", sub));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        sb.append(String.format("Discount: -%.2f\n", disc));
        sb.append(String.format("TOTAL: %.2f\n", tot));

        return sb.toString();
    }

    public void printOut(String text) {
        System.out.print(text);
    }

    public void printSaved(String id, int lines) {
        System.out.println("Saved invoice: " + id + " (lines=" + lines + ")");
    }
}