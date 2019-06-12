package MateAcad.BasicShop.Entities;

import MateAcad.BasicShop.Entities.parententities.CreatebleEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "products")
@Entity
@Getter
@Setter
@EqualsAndHashCode (callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product extends CreatebleEntity {

    @Column(name = "name")
    private String name;

    @Digits(fraction = 2, integer = 10)
    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "producers_id")
    private Producer producer;
}
