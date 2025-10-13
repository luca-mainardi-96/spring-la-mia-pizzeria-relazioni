package pizzeria.spring_la_mia_pizzeria_relazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzeria.spring_la_mia_pizzeria_relazioni.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

   List<Pizza> findByNameContainingIgnoreCase(String name);

}