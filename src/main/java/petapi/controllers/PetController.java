package petapi.controllers;

import org.springframework.web.bind.annotation.*;
import petapi.models.Pet;

import java.util.ArrayList;

@RestController
public class PetController {
    private final ArrayList<Pet> pets = new ArrayList<>();

    @GetMapping("/api/pets")
    public ArrayList<Pet> getPets(){
        return pets;
    }

    @PostMapping("/api/pets")
    public Pet createPet(@RequestBody() Pet petsRequest){
        Pet pet = new Pet(
                petsRequest.getPetName(),
                petsRequest.getAge(),
                petsRequest.getType(),
                petsRequest.getOwnerName()
        );

        this.pets.add(pet);
        return pet;
    }

    @PutMapping("/api/pets/{petName}")
    public ArrayList<Pet> updatePet(@PathVariable String petName, @RequestBody Pet petUpdated) {
        for (Pet pet : pets) {
            if (pet.getPetName().equals(petName)) {
                pet.setPetName(petUpdated.getPetName());
                pet.setAge(petUpdated.getAge());
                pet.setType(petUpdated.getType());
                pet.setOwnerName(petUpdated.getOwnerName());
            }
        }
        return pets;
    }

    @DeleteMapping("/api/pets/{petName}")
    public ArrayList<Pet> removePet(@PathVariable String petName){
        for(Pet pet: pets){
            if(pet.getPetName().equals(petName)){
                pets.remove(pet);
            }
        }
        return pets;
    }
}
