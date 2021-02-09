/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin;

import hr.darwin.builder.impl.BuildQuery;
import hr.darwin.controller.TravelWarrantController;
import hr.darwin.model.impl.TravelWarrant;
import hr.darwin.view.TravelWarrantView;
import java.util.List;

/**
 *
 * @author darwin
 */
public class Main {   
    public static void main(String[] args) {
        try {
            //Pripremi osnovno
            TravelWarrantView view = new TravelWarrantView();
            List<TravelWarrant> model = new BuildQuery.Builder("ReportGeneratorPU").withNamedQuery("TravelWarrant", "findAll").build(); //Zadužen za izgradnju modela

            //Pripremi controller
            TravelWarrantController controller = new TravelWarrantController(model, view);

            //Prikaži view
            controller.printView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
