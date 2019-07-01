package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerMapper extends AbstractMapper<Producer, ProducerDto> {

    @Autowired
    public ProducerMapper() {
        super(Producer.class, ProducerDto.class);
    }
}
