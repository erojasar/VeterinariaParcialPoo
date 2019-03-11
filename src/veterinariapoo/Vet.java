/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinariapoo;

import java.util.ArrayList;

/**
 *
 * @author erojasar
 */
public class Vet {
    private ArrayList<Pet> pets;

    public Vet() {
        this.pets = new ArrayList<>();
    }
    
    public void removePet(Pet p){
        this.pets.remove(p);
    }
    
    public void ShowPetsByType(String type){
        for(Pet mascota : pets){
            if(mascota.getClass().getCanonicalName().equals("veterinariapoo."+type)){
                System.out.println(mascota.getId() + " " 
                        + mascota.getName() + " " + mascota.getHairColor());             
            }
        }
    }
    
    public void ShowPets(){
        for(Pet mascota : pets){
            System.out.println(mascota.getId() + " " 
                    + mascota.getName() + " " + mascota.getHairColor());             
            
        }
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
    
}

