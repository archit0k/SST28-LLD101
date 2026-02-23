
public class BasicTax implements TaxCalc {
    @Override
    public double calc(String type) {
        if ("student".equalsIgnoreCase(type)) return 5.0;
        if ("staff".equalsIgnoreCase(type)) return 2.0;
        return 8.0;
    }
}