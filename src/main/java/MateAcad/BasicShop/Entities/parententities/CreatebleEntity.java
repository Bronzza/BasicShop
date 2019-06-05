package MateAcad.BasicShop.Entities.parententities;

import MateAcad.BasicShop.listeners.ListenerCreatedDate;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Setter
@MappedSuperclass
@EntityListeners(value = ListenerCreatedDate.class)
public class CreatebleEntity extends UuidEntity {

    @Column(name = "created_date")
    private Long createdDate;
}
