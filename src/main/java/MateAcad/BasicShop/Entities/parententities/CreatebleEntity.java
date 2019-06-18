package MateAcad.BasicShop.Entities.parententities;

import MateAcad.BasicShop.listeners.ListenerCreatedDate;
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
@EntityListeners(value = ListenerCreatedDate.class)
public class CreatebleEntity extends UuidEntity {

    @Column(name = "created_date")
    private Long createdDate;
}
