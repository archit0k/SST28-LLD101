
import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<Rule> rules;

    public EligibilityEngine(FakeEligibilityStore store, List<Rule> rules) { 
        this.store = store; 
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); 
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        
        for (Rule rule : rules) {
            String failMsg = rule.check(s);
            if (failMsg != null) {
                reasons.add(failMsg);
                break;
            }
        }
        
        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, reasons);
    }
}