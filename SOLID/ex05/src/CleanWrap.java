public class CleanWrap extends Exporter {
    private final Exporter base;

    public CleanWrap(Exporter base) { this.base = base; }

    @Override
    public ExportResult export(ExportRequest req) {
        String b = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
        return base.export(new ExportRequest(req.title, b));
    }
}