package pizzeria.spring_la_mia_pizzeria_relazioni.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import pizzeria.spring_la_mia_pizzeria_relazioni.model.Ingredient;
import pizzeria.spring_la_mia_pizzeria_relazioni.repository.IngredientRepository;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {


    @Autowired
    private IngredientRepository repository;

    @GetMapping("/")
    public String show(Model model){
        List<Ingredient> list = repository.findAll();
        model.addAttribute("ingredients", list);
        return "ingredients/ingredients";
    }

    @GetMapping("/edit")
    public String edit(Model model){
        model.addAttribute("ingredient", new Ingredient());
        model.addAttribute("editMode", false);
        return "ingredients/edit";
    }

    @PostMapping("/edit")
    public String create(@Valid @ModelAttribute("ingredient") Ingredient formIngredient, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "ingredients/edit";
        }

        repository.save(formIngredient);
        return "redirect:/ingredients/";
    }

    @GetMapping("/edit/{id}")
    public String modify(@PathVariable("id") Integer id, Model model){
        Ingredient ing = repository.findById(id).get();
        model.addAttribute("editMode", true);
        model.addAttribute("ingredient", ing);
        return "ingredients/edit"; 
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("ingredient") Ingredient formIng, BindingResult bindingResult, Model model){
        
        if(bindingResult.hasErrors()){
            model.addAttribute("editMode", true);
            return "ingredients/edit";
        }

        repository.save(formIng);
        return "redirect:/ingredients/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return "redirect:/ingredients/";
    }
}
