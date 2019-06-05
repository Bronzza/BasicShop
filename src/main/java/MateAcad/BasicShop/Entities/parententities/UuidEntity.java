package MateAcad.BasicShop.Entities.parententities;

import MateAcad.BasicShop.listeners.ListenerUuid;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(value = ListenerUuid.class)
public class UuidEntity  extends BaseEntity {


    @Column(name = "uuid", length = 32, unique = true, nullable = false)
    private String uuid;
}
