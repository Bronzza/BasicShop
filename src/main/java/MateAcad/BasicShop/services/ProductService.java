package MateAcad.BasicShop.services;

import MateAcad.BasicShop.Entities.Producer;
import MateAcad.BasicShop.Entities.Product;
import MateAcad.BasicShop.dto.ProductDto;
import MateAcad.BasicShop.dto.ProductMapper;
import MateAcad.BasicShop.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Qualifier ("productService")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository repository;

    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductByUUID(String uuid) {
        return Optional.of(repository.findByUuid(uuid));
    }

    public Optional<ProductDto> getDtoByUUID(String uuid) {
        return Optional.of(productMapper.toDto(repository.findByUuid(uuid)));
    }

    public void saveProduct(ProductDto productDto) {
        repository.save(productMapper.toEntity(productDto));
    }

    public void deleteByUUID(String uuid) {
        repository.deleteByUuid(uuid);
        List <String> products = new ArrayList<>();
        products.stream().map(uu ->getProductByUUID(uu).get()).collect(Collectors.toList());
    }

}
