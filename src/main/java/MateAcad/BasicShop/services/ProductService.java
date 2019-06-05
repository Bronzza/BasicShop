package MateAcad.BasicShop.services;

import MateAcad.BasicShop.Entities.Product;
import MateAcad.BasicShop.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductByUUID(String uuid) {
        return Optional.of(repository.findByUuid(uuid));
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public void deleteByUUID(String uuid) {
        repository.deleteByUuid(uuid);
    }


}
