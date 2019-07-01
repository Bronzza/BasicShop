package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.Product;
import MateAcad.BasicShop.repositories.ProducerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class ProductMapper  extends AbstractMapper <Product, ProductDto>{

    private final ModelMapper modelMapper;

    private final ProducerRepository producerRepository;

    @Autowired
    public ProductMapper(ModelMapper mapper, ProducerRepository repository) {
        super(Product.class, ProductDto.class);
        modelMapper = mapper;
        producerRepository = repository;
    }

    @PostConstruct
    public void setMapper(){
        modelMapper.createTypeMap(Product.class, ProductDto.class)
                .addMappings(m -> m.skip(ProductDto::setProducerId)).setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(ProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product:: setProducer)).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(ProductDto source, Product destination) {
        destination.setProducer(producerRepository.findById(source.getProducerId()).orElse(null));
    }

    @Override
    protected void mapSpecificFields(Product source, ProductDto destination) {
        destination.setProducerId(getId(source));
    }

    private Long getId(Product source) {
        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getProducer().getId();
    }
}
