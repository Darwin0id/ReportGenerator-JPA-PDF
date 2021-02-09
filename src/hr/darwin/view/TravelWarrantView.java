/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.view;

import hr.darwin.model.impl.TravelWarrant;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author darwin
 */
public class TravelWarrantView {
    
    private void clearScreen() throws IOException {
        Runtime.getRuntime().exec("clear");
    }

    public int showMenu() throws IOException {
        clearScreen();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("MENU:");
        System.out.println("1. Zelim ispis svih izvjestaja");
        System.out.println("2. Zelim ispis odabranih izvjestaja");
        System.out.println("");
        System.out.print("Odaberite: ");
        
        return scanner.nextInt();
    }

    public String[] selectTravelWarrants(List<TravelWarrant> model) throws IOException {
        clearScreen();
         
        Scanner scanner = new Scanner(System.in);
        String slicer;
        
        System.out.println("POPIS:");     
         model.forEach(travel -> {
            System.out.println("ID: "+travel.getIDTravelWarrant()+", Pocetak: "+travel.getStartAddress()+", Kraj: "+travel.getEndAddress());
        }); 
                
        System.out.print("Odaberite: ");
        slicer = scanner.nextLine();
        return slicer.split(",");
    }
    
}
