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
import pizzeria.spring_la_mia_pizzeria_relazioni.model.Pizza;
import pizzeria.spring_la_mia_pizzeria_relazioni.model.SpecialOffer;
import pizzeria.spring_la_mia_pizzeria_relazioni.repository.PizzaRepository;
import pizzeria.spring_la_mia_pizzeria_relazioni.repository.SpecialOfferRepository;

@Controller
@RequestMapping("/offer")
public class SpecialOfferController {

    @Autowired
    private SpecialOfferRepository repository;

    @Autowired
    private PizzaRepository pizzaRepository;


    @GetMapping("/edit")
    public String details(Model model){
        model.addAttribute("offer", new SpecialOffer());
        model.addAttribute("editMode", false);
        return "special_offer/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("offer") SpecialOffer formOffer,
                        BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            return "special_offer/edit";
        }

        Pizza pizza = pizzaRepository.findById(formOffer.getPizza().getId()).get();
        formOffer.setPizza(pizza);

        repository.save(formOffer);
        return "redirect:/details/" + formOffer.getPizza().getId();
    }
    
    @GetMapping("/edit/{id}")
    public String modify(@PathVariable("id") Integer id, Model model){
        SpecialOffer offer = repository.findById(id).get();
        model.addAttribute("editMode", true);
        model.addAttribute("offer", offer);
        return "special_offer/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("offer") SpecialOffer offer,
                            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("editMode", true);
            return "special_offer/edit";
        }

        repository.save(offer);
        return "redirect:/pizza/details/" + offer.getPizza().getId();
    }

    @GetMapping("/view")
    public String view(Model model){
        List<SpecialOffer> list;
        list = repository.findAll();
        model.addAttribute("list", list);
        return "special_offer/view";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return "redirect:/offer/view";
    }

}
