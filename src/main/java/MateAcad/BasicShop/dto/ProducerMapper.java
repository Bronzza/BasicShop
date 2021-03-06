package MateAcad.BasicShop.dto;


import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProducerMapper {

    @Autowired
    private ProductMapper productMapper;

    public Producer toProducer(ProducerDto producerDto) {
        Producer producer = new Producer();
        producer.setName(producerDto.getName());
        if (Objects.nonNull(producerDto.getId())) {
            producer.setId(producerDto.getId());
        }
        if (Objects.nonNull(producerDto.getUuid())) {
            producer.setUuid(producerDto.getUuid());
        }
        return Objects.nonNull(producerDto.getProducts()) ?
                producer.setProducts(productMapper.toProductsFromUuid(producerDto.getProducts())) : producer;
//        if (producerDto.getProducts() != null){
//            ;
//
//        }
//        return producer;
    }


    public ProducerDto toProducerDto(Producer producer) {
        ProducerDto producerDto = new ProducerDto();
        return producerDto.setId(producer.getId())
                .setUuid(producer.getUuid())
                .setName(producer.getName())
                .setProducts(productMapper.toUuidProducts(producer.getProducts()));

    }

    public List<ProducerDto> mapProducersToDtos(List<Producer> producers) {
        return producers.stream()
                .map(this::toProducerDto)
                .collect(Collectors.toList());
    }
}
