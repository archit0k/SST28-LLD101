public class Demo01 {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        
        
        Store db = new FakeDb();
        Parser parser = new Parser();
        Checker validator = new Checker();
        Printer printer = new Printer();
        

        OnboardingService svc = new OnboardingService(db, parser, validator, printer);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}