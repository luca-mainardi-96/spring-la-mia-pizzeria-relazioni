package pizzeria.spring_la_mia_pizzeria_relazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzeria.spring_la_mia_pizzeria_relazioni.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

}
