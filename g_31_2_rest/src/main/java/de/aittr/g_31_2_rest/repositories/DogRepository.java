package de.aittr.g_31_2_rest.repositories;

import de.aittr.g_31_2_rest.domain.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class DogRepository implements CrudRepository<Dog>{
    private Map<Integer, Dog> dogs = new HashMap<>();
    private int currentId;

    public DogRepository() {
        save(new Dog("Найда", 3, "Немецкая Овчарка", "черный", 5.5));
        save(new Dog("Акбар", 5, "Афганская Борзая", "серый", 7));
        save(new Dog("Флинт", 7, "Аффенпинчер", "Белый", 6.5));
        save(new Dog("Арчи", 4, "Австралийский Терьер", "Коричневый", 7.3));
        save(new Dog("Балу", 9, "Басенджи", "Пятнистый", 8));
    }

    @Override
    public Dog save(Dog dog) {
        dog.setId(++currentId);
        dogs.put(currentId, dog);
        return dog;

    }

    @Override
    public List<Dog> getAll() {
        return new ArrayList<>(dogs.values());
    }

    @Override
    public Dog getById(int id) {
        return dogs.get(id);
    }

    @Override
    public void update(Dog obj) {

    }

    @Override
    public void deleteById() {

    }
}
