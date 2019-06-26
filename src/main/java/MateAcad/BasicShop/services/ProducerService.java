package MateAcad.BasicShop.services;


import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.dto.ProducerDto;
import MateAcad.BasicShop.dto.ProducerMapper;
import MateAcad.BasicShop.repositories.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerService {

    private final ProducerRepository repository;

    private final ProducerMapper producerMapper;

    public Set<Producer> findAllUniqueProducers() {
        return new HashSet<>(repository.findAll());
    }

    public Set<ProducerDto> findAllUniqueProducersDto(){
      return  new HashSet<>(producerMapper.mapProducersToDtos(repository.findAll())) ;
    }

    public void saveProducer(ProducerDto producerDto) {
        repository.save(producerMapper.toProducer(producerDto));
    }
}
