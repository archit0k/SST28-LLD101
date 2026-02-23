
public class CgrRule implements Rule {
    @Override 
    public String check(StudentProfile s) {
        if (s.cgr < 8.0) return "CGR below 8.0";
        return null;
    }
}