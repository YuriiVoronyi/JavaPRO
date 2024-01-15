package de.aittr.g_31_2_rest.controllers;

import de.aittr.g_31_2_rest.domain.Dog;
import de.aittr.g_31_2_rest.services.DogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/dogs")
public class DogController {
    private DogService service;

    public DogController(DogService service) {
        this.service = service;
    }

    @GetMapping
    // - метод принимает GET запросы на эндпоинт http://12.34.56.78:8080/dogs
    public List<Dog> getAll() {
        return service.getAll();
    }

    // 1 способ получения собаки по ИД - передача ИД как подстроки запроса
    // http//12.34.56.78:8080/dogs/5
    @GetMapping("/{id}")
    public Dog getByIg(@PathVariable int id) {
        return service.getById(id);
    }
}
