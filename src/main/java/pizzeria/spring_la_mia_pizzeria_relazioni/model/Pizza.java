package pizzeria.spring_la_mia_pizzeria_relazioni.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="pizzas")
public class Pizza {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "This field cannot be blank")
    private String name;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 200, message = "This field cannot exceed 200 characters")
    private String description;

    private String photo;

    @NotNull(message = "This field cannot be null")
    @Positive(message= "This field cannot be negative.")
    private Double price;

    private String doughType;

    @Positive(message= "This field cannot be negative")
    private Integer prepTime;

    @OneToMany(mappedBy="pizza")
    private List<SpecialOffer> specialOffers = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "pizzas_ingredients", joinColumns = @JoinColumn(name="pizza_id"), inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    private List<Ingredient> ingredients;
    
    public List<SpecialOffer> getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(List<SpecialOffer> specialoffers) {
        this.specialOffers = specialoffers;
    }

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getPhoto() {
        return photo;
    }
    public Double getPrice() {
        return price;
    }

    public String getDoughType() {
        return doughType;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
                
}
