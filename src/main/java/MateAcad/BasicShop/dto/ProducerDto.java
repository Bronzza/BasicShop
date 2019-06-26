package MateAcad.BasicShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Accessors (chain = true)
public class ProducerDto extends BaseEntityDto {

    private Long id;

    private String uuid;

    private String name;

    private Set<String> products;
}
