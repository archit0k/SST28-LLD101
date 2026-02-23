
import java.util.List;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        
        
        List<Rule> rules = List.of(
            new FlagRule(),
            new CgrRule(),
            new AttRule(),
            new CreditRule()
        );

        FakeEligibilityStore store = new FakeEligibilityStore();
        EligibilityEngine engine = new EligibilityEngine(store, rules);
        
        engine.runAndPrint(s);
    }
}