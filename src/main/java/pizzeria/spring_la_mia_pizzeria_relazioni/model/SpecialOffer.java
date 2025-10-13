package pizzeria.spring_la_mia_pizzeria_relazioni.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;


@Entity
public class SpecialOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String title;

    @NotNull(message="This field cannot be empty")
    private LocalDate offerStart;

    private LocalDate offerEnd;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    
    
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getOfferStart() {
        return offerStart;
    }

    public void setOfferStart(LocalDate offerStart) {
        this.offerStart = offerStart;
    }

    public LocalDate getOfferEnd() {
        return offerEnd;
    }

    public void setOfferEnd(LocalDate offerEnd) {
        this.offerEnd = offerEnd;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    

}
