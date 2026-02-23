public class LimitWrap extends Exporter {
    private final Exporter base;
    
    public LimitWrap(Exporter base) { this.base = base; }

    @Override
    public ExportResult export(ExportRequest req) {
        if (req.body != null && req.body.length() > 20) {
            throw new IllegalArgumentException("PDF cannot handle content > 20 chars");
        }
        return base.export(req);
    }
}