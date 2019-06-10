package MateAcad.BasicShop.services;


import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.repositories.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerService {

    private ProducerRepository repository;

    public Set<Producer> findAllUniqueProducers() {
        return new HashSet<>(repository.findAll());
    }

    public void saveProducer(Producer producer) {
        repository.save(producer);
    }
}
