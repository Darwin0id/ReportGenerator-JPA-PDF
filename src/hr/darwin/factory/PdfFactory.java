/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.factory;

import hr.darwin.model.Pdf;
import hr.darwin.model.impl.EnumPdf;
import hr.darwin.model.impl.PdfNative;

/**
 *
 * @author darwin
 */
public class PdfFactory {
    public Pdf getPdf(EnumPdf pdfType, String[] _tableColumns) {
        if(pdfType == null){
            return null;
        }
        if(pdfType.equals(EnumPdf.NATIVE)){
            return new PdfNative(_tableColumns);
        } else {
            return null;
        }
    }
}
