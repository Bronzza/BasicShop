package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.repositories.ProductRepository;
import MateAcad.BasicShop.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@Mapper (componentModel = "cdi", uses = ProductService.class, injectionStrategy = InjectionStrategy.FIELD)
public abstract class ProducerMapper {

    @Autowired
    private ProductService productService;

    @Mapping(target = "products",
            expression = "java(producer.getProducts().stream().map(Product::getUuid).collect(Collectors.toSet())")
    @Mapping(target = "createdDate", expression = "java(new java.util.Date(producer.getCreatedDate()))")
   abstract public ProducerDto toProducerDto(Producer producer);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "products", expression = "java(producerDto.getProducts().stream().map(uuid ->productService.getProductbyUuid(uuid).get)" +
            ".collect(Collectors.toSet()))")
  abstract   public Producer toProducer(ProducerDto producerDto);

   abstract public Set<ProducerDto> mapProducersToDtos(List<Producer> producers);
}
