/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import GestionArchivo.GestionArchivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import veterinariapoo.*;

/**
 *
 * @author erojasar
 */
public class Starter {
    
    
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        GestionArchivo gestionArchivo = new GestionArchivo();
        try {
            persons = gestionArchivo.cargar();
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo...");
        }
        ArrayList<Pet> pets = new ArrayList<>();
        for(Person p : persons){
            for(Pet masc : p.getPet()){
                pets.add(masc);
            } 
        }
        Vet veterinaria = new Vet();
        veterinaria.setPets(pets);
        Scanner lectura = new Scanner(System.in);
        
        
        System.out.println("1. Remover una mascota dando su id. "
                + "\n2. Listar las mascotas segun el tipo (Dog, Cat o Hamster)"
                + "\n3. listar todas las mascotas y cerrar");
        
        int opc = lectura.nextInt();
        switch(opc){
            case 1:
                System.out.println("Ingrese el id de la mascota a remover: ");
                String id = lectura.next();
                Pet mascota = null;
                for (Person persona : persons){
                    for(Pet pet : persona.getPet()){
                        if(pet.getId().equals(id)){
                            mascota = pet;
                            persona.getPet().remove(mascota);
                        }
                    }
                }
                veterinaria.removePet(mascota);
                System.out.println("Ha sido removido Correctamente.");
                break;
            case 2:
                System.out.println("Ingrese que tipo de mascotas quiere listar: "
                        + "\n1. Dog"
                        + "\n2. Cat"
                        + "\n3. Hamster");
                int tipo = lectura.nextInt();
                if(tipo == 1){
                   veterinaria.ShowPetsByType("Dog");
                }else if(tipo == 2){
                    veterinaria.ShowPetsByType("Cat");
                }else if(tipo == 3){
                    veterinaria.ShowPetsByType("Hamster");
                }
                break;
            case 3:
                veterinaria.ShowPets();
        {
            try {
                gestionArchivo.guardar(persons);
            } catch (IOException ex) {
                Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                System.exit(0);
                break;
        }
    }
    
}
