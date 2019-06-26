package MateAcad.BasicShop.repositories;

import MateAcad.BasicShop.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository <Product, Long> {
    Product findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
