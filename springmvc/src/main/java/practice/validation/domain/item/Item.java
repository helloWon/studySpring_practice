package practice.validation.domain.item;

// import javax.validation.constraints.Max;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;

// import org.hibernate.validator.constraints.Range;
// import org.hibernate.validator.constraints.ScriptAssert;

import lombok.Data;

@Data
public class Item {

    // @NotNull(groups = UpdateCheck.class)
    private Long id;

    // @NotBlank(groups = { SaveCheck.class, UpdateCheck.class }, message = "공백X")
    private String itemName;

    // @NotNull(groups = { SaveCheck.class, UpdateCheck.class })
    // @Range(min = 1000, max = 1000000, groups = { SaveCheck.class,
    // UpdateCheck.class })
    private Integer price;

    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
