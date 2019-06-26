package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.Product;
import MateAcad.BasicShop.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@Mapper (unmappedSourcePolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        uses = ProducerMapper.class,
        injectionStrategy = InjectionStrategy.FIELD)
public abstract class ProductMapper {

    @Autowired
    private ProductService productService;

    @Mapping(target = "createdDate", expression = "java(new Date(createdDate))")
    @Mapping(target = "producer.createdDate", expression = "java(new Date(createdDate))")
    @Mapping(target = "producer.products", expression = "java(products.stream().map(product ->product.getUuid())" +
            ".get()).collect(Collectors.toSet()))")
    abstract ProductDto toProductDto (Product product);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "producer.createdDate", ignore = true)
    @Mapping(target = "producer.products", expression = "java(producerDto.products.stream().map(uuid ->productService.getProductByUUID(uuid)" +
            ".get()).collect(Collectors.toSet()))")
    abstract Product toProduct (ProductDto productDto);

   abstract List<ProductDto> toListOfProductDto (List<Product> products);
}
