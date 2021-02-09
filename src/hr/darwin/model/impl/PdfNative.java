/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.model.impl;

import hr.darwin.model.Pdf;
import hr.darwin.pdf.PdfNativeManager;
import java.util.List;

/**
 *
 * @author darwin
 */
public class PdfNative implements Pdf {
    private final String[] tableColumns;

    public PdfNative(String[] _tableColumns) {
       tableColumns = _tableColumns;
    }
    
    @Override
    public void generatePDF(List<String[]> list) throws Exception {
       list.add(0, tableColumns);
       PdfNativeManager pdfManager = new PdfNativeManager();
       pdfManager.drawTable(700, 10, list);
       pdfManager.getContentStream().close();
       pdfManager.save();
    }
    
}
