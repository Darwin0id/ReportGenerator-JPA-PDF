/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.pdf;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author darwin
 */
public class PdfNativeManager {
    private static String FILE_PATH;
    private static PDDocument doc = null;
    private static PDPage page = null;
    private static PDPageContentStream contentStream = null;
    
    private void generateFilePathName() {
        String pattern = "MM_dd_yyyy-HH_mm";
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();
        String todayAsString = df.format(today);
        FILE_PATH = "izvjestaj_"+todayAsString+".pdf";
    }

    public PdfNativeManager() throws IOException {
        generateFilePathName();               
        PdfNativeManager.doc = new PDDocument();
        PdfNativeManager.page = new PDPage();
        doc.addPage(page);
        PdfNativeManager.contentStream = new PDPageContentStream(doc, page);
    }

    public PDPageContentStream getContentStream() {
        return contentStream;
    }
    
    public void save() throws IOException {
        doc.save(FILE_PATH);
    }
    
    public void drawTable(float y, float margin, List<String[]> content) throws IOException {
        final int rows = content.size();
        final int cols = content.get(0).length;
        final float rowHeight = 20f;
        final float tableWidth = PdfNativeManager.page.getCropBox().getWidth() - margin - margin;
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth/(float)cols;
        final float cellMargin=3f;

        float nexty = y ;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin+tableWidth, nexty);
            nexty-= rowHeight;
        }

        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y-tableHeight);
            nextx += colWidth;
        }

        contentStream.setFont(PDType1Font.HELVETICA, 6);
        
       
        float textx = margin+cellMargin;
        float texty = y-15;
        for(int i = 0; i < content.size(); i++){
            for (String text : content.get(i)) {
                contentStream.beginText();
                contentStream.moveTextPositionByAmount(textx,texty);
                contentStream.drawString(text);
                contentStream.endText();
                textx += colWidth;
            }
            texty-=rowHeight;
            textx = margin+cellMargin;
        }
    }

    
}
