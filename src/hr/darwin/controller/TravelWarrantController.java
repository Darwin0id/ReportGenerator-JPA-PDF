/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.controller;

import hr.darwin.factory.PdfFactory;
import hr.darwin.model.Pdf;
import hr.darwin.model.impl.EnumPdf;
import hr.darwin.model.impl.Person;
import hr.darwin.model.impl.TravelWarrant;
import hr.darwin.model.impl.Vehicle;
import hr.darwin.model.impl.VehicleBrand;
import hr.darwin.view.TravelWarrantView;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author darwin
 */
public class TravelWarrantController {
    //PRIVATE
    private final String[] tableColumns = {"Pocetak", "Kraj", "Km", "Cijena", "Trajanje", "Osoba", "Vozilo"};
    private static PdfFactory pdfFactory = new PdfFactory();
    private TravelWarrantView view;
    
    //PUBLIC
    private List<TravelWarrant> model;
    
    //CONTROLLER
    public TravelWarrantController(List<TravelWarrant> _model, TravelWarrantView _view) {
        this.view = _view;
        this.model = _model;
    }
        
    //PREPARE DATA FOR PDF
    private static List<String[]> prepareTravelWarrantData(List<TravelWarrant> objList) {
        List<String[]> listTravelWarrantData = new ArrayList<>();
        
        objList.forEach(data -> {
            TravelWarrant tw = data;
            Person person = tw.getPersonID();
            Vehicle vehicle = tw.getVehicleID();
            VehicleBrand brand = vehicle.getBrandID();

            String[] n = {
              tw.getStartAddress(), 
              tw.getEndAddress(), 
              tw.getRoadDistance(),
              tw.getFuelPrice(),
              tw.getTripDuration(),
              person.getFName()+ " "+person.getLname(),
              brand.getTitle()
            };

            listTravelWarrantData.add(n);
        });
    
       return listTravelWarrantData;
    }
    
    private void prepareSelectedData(String[] slice) throws Exception {
        List<TravelWarrant> tempTravelList = new ArrayList<>();
        for (String s : slice) {           
            tempTravelList.add(this.model.get(parseInt(s)-1));
        }
        this.model = tempTravelList;      
    }
    
    //PRINT VIEW
    public void printView() throws Exception {
        int menuSelection = this.view.showMenu();
        switch(menuSelection) {
            case 1:
                Pdf pdfManagerAll = pdfFactory.getPdf(EnumPdf.NATIVE, tableColumns);
                pdfManagerAll.generatePDF(prepareTravelWarrantData(this.model));
                break;
            case 2:
                String[] slice = this.view.selectTravelWarrants(this.model);
                prepareSelectedData(slice);               
                Pdf pdfManagerSelected = pdfFactory.getPdf(EnumPdf.NATIVE, tableColumns);
                pdfManagerSelected.generatePDF(prepareTravelWarrantData(this.model));
                break;
            default:
                throw new Exception("Morate odabrati dostupne opcije.");
        }
    }
}
