package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.Product;
import MateAcad.BasicShop.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component

public class ProductMapper {
    @Autowired
    private ProducerMapper producerMapper;

    private ProductService productService;

    public void setProductService(@Autowired ProductService productService) {
        this.productService = productService;
    }

    public Product toProduct(ProductDto productDto) {
        Product product = new Product();
         product.setName(productDto.getName())
                .setPrice(productDto.getPrice())
                .setDescription(productDto.getDescription())
                .setProducer(producerMapper.toProducer(productDto.getProducer()))
                .setUuid(productDto.getUuid())
                .setId(productDto.getId());
         int i =0;
        return  product;

    }

    public ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        return productDto.setId(product.getId())
                .setUuid(product.getUuid())
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setDescription(product.getDescription())
                .setProducer(producerMapper.toProducerDto(product.getProducer()));
    }

    public Set<ProductDto> toSetOfProductsDto(Set<Product> products) {
        return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toSet());

    }

    public Set<String> toUuidProducts(Set<Product> products) {
        return products.stream()
                .map(Product::getUuid)
                .collect(Collectors.toSet());
    }

    public Set<Product> toProductsFromUuid(Set<String> uuidProducts) {
        return uuidProducts.stream().map(uuid -> productService.getProductByUUID(uuid).get())
                .collect(Collectors.toSet());
    }

    public List<ProductDto> toListOfProductDto (List <Product> products){
        return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toList());
    }
}
