package MateAcad.BasicShop.Entities.parententities;

import MateAcad.BasicShop.listeners.ListenerUuid;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
@Accessors(chain = true)
@EntityListeners(value = ListenerUuid.class)
public class UuidEntity extends BaseEntity {

    @Column(name = "uuid", length = 45, unique = true, nullable = false)
    private String uuid;
}
