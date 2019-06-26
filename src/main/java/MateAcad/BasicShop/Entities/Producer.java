package MateAcad.BasicShop.Entities;

import MateAcad.BasicShop.Entities.parententities.CreatebleEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "producers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Producer extends CreatebleEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "producer")
    private Set<Product> products;

    @Override
    public String toString() {
        return name;
    }
}
