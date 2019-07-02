package MateAcad.BasicShop.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Accessors (chain = true)
public class ProducerDto extends BaseEntityDto {

    private String uuid;

    private String name;

    private Set<ProductDto> products;
}
