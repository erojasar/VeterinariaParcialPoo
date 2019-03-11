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
public class Person {
    private String name;
    private String id;
    private ArrayList<Pet> pet;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
        this.pet = new ArrayList<>();
    }
    
    public void ShowPets(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Pet> getPet() {
        return pet;
    }

    public void addPet(Pet pet) {
        this.pet.add(pet);
    }
    
}
