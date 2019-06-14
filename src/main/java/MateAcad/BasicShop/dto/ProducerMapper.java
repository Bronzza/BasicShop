package MateAcad.BasicShop.dto;


import MateAcad.BasicShop.Entities.Producer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProducerMapper {

    Producer mapProducerDtoToProducer(ProducerDto producerDto);

    @Mapping(target = "id", source = "id")
    ProducerDto mapProducerToProducerDto(Producer producer);

    List<ProducerDto> mapProducersToDtos(List<Producer> producers);
}
