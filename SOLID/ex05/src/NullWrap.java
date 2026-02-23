public class NullWrap extends Exporter {
    private final Exporter base;

    public NullWrap(Exporter base) { this.base = base; }

    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null) return new ExportResult("application/json", new byte[0]);
        return base.export(req);
    }
}