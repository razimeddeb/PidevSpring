package tn.esprit.pidev.PDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
public class PdfGenerator {

    public static byte[] generatePdf(String content) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, baos);

        document.open();
        document.add(new Paragraph(content));
        document.close();

        return baos.toByteArray();
    }
}
