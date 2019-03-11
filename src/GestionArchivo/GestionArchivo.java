/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionArchivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import veterinariapoo.Cat;
import veterinariapoo.Dog;
import veterinariapoo.Hamster;
import veterinariapoo.Person;
import veterinariapoo.Pet;

/**
 *
 * @author erojasar
 */
public class GestionArchivo {
    private String ruta;
    public GestionArchivo() {
        this.ruta = "pets.txt";
    }
    
    public boolean guardar (ArrayList<Person> p) throws FileNotFoundException, IOException{
        File archivo = new File(this.ruta);
        if(!archivo.exists())
            archivo.createNewFile();
         
        PrintStream salida = 
               new PrintStream(archivo);
        for (Person persona : p){
            for(Pet pet : persona.getPet()){
                if(pet.getClass().getCanonicalName().equals("veterinariapoo.Dog")){
                    salida.print("Dog " + pet.getId() + " " + pet.getName() + " " 
                            + pet.getHairColor() + " " + ((Dog)pet).getBreed());
                    salida.print(persona.getName() + " " + persona.getId());
                }else if(pet.getClass().getCanonicalName().equals("veterinariapoo.Cat")){
                    salida.print("Cat " + pet.getId() + " " + pet.getName() + " " 
                            + pet.getHairColor() + " " + ((Cat)pet).isIsHunter());
                    salida.print(persona.getName() + " " + persona.getId());
                }else if(pet.getClass().getCanonicalName().equals("veterinariapoo.Hamster")){
                    salida.print("Hamster " + pet.getId() + " " + pet.getName() + " " 
                            + pet.getHairColor() + " " + ((Hamster)pet).getWeight());
                    salida.print(persona.getName() + " " + persona.getId());
                }
                
            }
        }
            
        
        salida.flush();
        salida.close();
        return true;
    }
    
    public ArrayList<Person> cargar() throws FileNotFoundException{
       ArrayList<Person> personas = 
               new ArrayList<>();
       Scanner lectura = 
               new Scanner(new File(this.ruta));
       while(lectura.hasNext()){
         String tipo = lectura.next();
         if(tipo.equals("Dog")){
            String id = lectura.next();
            String name = lectura.next();
            String hairColor = lectura.next();
            String breed = lectura.next();

            String namePersona = lectura.next();
            String idPersona = lectura.next();
            
            Dog dog = new Dog(breed, id, name, hairColor);
            Person person = new Person(namePersona, idPersona);
            person.addPet(dog);
            personas.add(person);
         }else if(tipo.equals("Cat")){
            String id = lectura.next();
            String name = lectura.next();
            String hairColor = lectura.next();
            boolean isHunter = lectura.nextBoolean();

            String namePersona = lectura.next();
            String idPersona = lectura.next(); 
            
            Cat cat = new Cat(isHunter, id, name, hairColor);
            Person person = new Person(namePersona, idPersona);
            person.addPet(cat);
            personas.add(person);
         }else if(tipo.equals("Hamster")){
            String id = lectura.next();
            String name = lectura.next();
            String hairColor = lectura.next();
            double weight = lectura.nextDouble();

            String namePersona = lectura.next();
            String idPersona = lectura.next();
            
            Hamster hamster = new Hamster(weight, id, name, hairColor);
            Person person = new Person(namePersona, idPersona);
            person.addPet(hamster);
            personas.add(person);
         }
       }
       lectura.close();
       return personas;
    }
}
