package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.Producer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductDto extends BaseEntityDto {

    private Long id;

    private String Uuid;

    private String name;

    private BigDecimal price;

    private String description;

    private Long producerId;
}
