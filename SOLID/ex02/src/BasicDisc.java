
public class BasicDisc implements DiscCalc {
    @Override
    public double calc(String type, double sub, int lines) {
        if ("student".equalsIgnoreCase(type)) {
            if (sub >= 180.0) return 10.0;
            return 0.0;
        }
        if ("staff".equalsIgnoreCase(type)) {
            if (lines >= 3) return 15.0;
            return 5.0;
        }
        return 0.0;
    }
}
