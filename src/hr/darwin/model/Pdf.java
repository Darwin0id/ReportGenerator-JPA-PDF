/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.model;

import java.util.List;

/**
 *
 * @author darwin
 */
public interface Pdf {
    void generatePDF(List<String[]> list) throws Exception;
}
