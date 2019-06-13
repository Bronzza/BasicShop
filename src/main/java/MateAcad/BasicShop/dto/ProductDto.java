package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.Producer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode (callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseEntityDto {

    private String name;

    private BigDecimal price;

    private String description;

    private Producer producer;
}
