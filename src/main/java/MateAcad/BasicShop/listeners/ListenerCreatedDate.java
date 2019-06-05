package MateAcad.BasicShop.listeners;

import MateAcad.BasicShop.Entities.parententities.CreatebleEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class ListenerCreatedDate {
    @PrePersist
    public void prePersist(CreatebleEntity entity) {
        entity.setCreatedDate(new Date().getTime());
    }


}
