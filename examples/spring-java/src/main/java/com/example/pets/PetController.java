package com.example.pets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {

    @GetMapping("/{petId}")
    public Pet getPet(@PathVariable long petId) {
        return new Pet(petId, "Example pet");
    }

    public record Pet(long id, String name) {}
}

