
import java.util.List;

public class Cafe {
    private final Menu menu;
    private final Storage store;
    private final TaxCalc taxCalc;
    private final DiscCalc discCalc;
    private final Printer printer;
    private int seq = 1000;

    public Cafe(Menu menu, Storage store, TaxCalc taxCalc, DiscCalc discCalc, Printer printer) {
        this.menu = menu;
        this.store = store;
        this.taxCalc = taxCalc;
        this.discCalc = discCalc;
        this.printer = printer;
    }

    public void checkout(String type, List<OrderLine> lines) {
        String id = "INV-" + (++seq);

        double sub = 0.0;
        for (OrderLine l : lines) {
            sub += menu.get(l.itemId).price * l.qty;
        }

        double taxPct = taxCalc.calc(type);
        double tax = sub * (taxPct / 100.0);
        double disc = discCalc.calc(type, sub, lines.size());
        double tot = sub + tax - disc;

        String invText = printer.buildInv(id, lines, menu, sub, taxPct, tax, disc, tot);
        printer.printOut(invText);

        store.save(id, invText);
        printer.printSaved(id, store.countLines(id));
    }
}