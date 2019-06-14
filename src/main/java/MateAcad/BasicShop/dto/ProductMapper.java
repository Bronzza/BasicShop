package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.Entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProductMapper {
    Producer mapProductDtoToProduct (ProductDto productDto);

    @Mapping(target = "id", source = "id")
    ProducerDto mapProductToProductDto(Product product);

    List<ProductDto> mapProductsToProductsDto (List<Product> products);
}
