package com.example.pets

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pets")
class PetController {

    @GetMapping("/{petId}")
    fun getPet(@PathVariable petId: Long): Pet = Pet(petId, "Example pet")
}

data class Pet(val id: Long, val name: String)
