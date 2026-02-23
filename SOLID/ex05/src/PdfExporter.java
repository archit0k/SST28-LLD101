import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        String pdf = "PDF(" + req.title + "):" + req.body;
        return new ExportResult("application/pdf", pdf.getBytes(StandardCharsets.UTF_8));
    }
}