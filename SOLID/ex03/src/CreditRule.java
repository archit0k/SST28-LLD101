
public class CreditRule implements Rule {
    @Override 
    public String check(StudentProfile s) {
        if (s.earnedCredits < 20) return "credits below 20";
        return null;
    }
}