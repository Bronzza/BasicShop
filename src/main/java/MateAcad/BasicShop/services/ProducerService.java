package MateAcad.BasicShop.services;


import MateAcad.BasicShop.repositories.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerService {

    private ProducerRepository repository;


}
