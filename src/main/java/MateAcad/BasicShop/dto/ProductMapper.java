//package MateAcad.BasicShop.dto;
//
//import MateAcad.BasicShop.Entities.Product;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Objects;
//
//@Component
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class ProductMapper {
//
//    private ModelMapper modelMapper;
//
//    public Product toProduct(ProductDto productDto) {
//        return Objects.nonNull(productDto) ? modelMapper.map(productDto, Product.class) : null;
//    }
//
//    public ProductDto toProductDto(Product product) {
//        return Objects.nonNull(product) ? modelMapper.map(product, ProductDto.class) : null;
//    }
//}
