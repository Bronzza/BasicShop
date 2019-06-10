package MateAcad.BasicShop.listeners;

import MateAcad.BasicShop.Entities.parententities.CreatebleEntity;
import org.springframework.beans.propertyeditors.UUIDEditor;

import javax.persistence.PrePersist;
import java.util.UUID;

public class ListenerUuid {
    @PrePersist
    public void prePersist(CreatebleEntity entity) {
        if (entity.getUuid() == null) {
            String s = UUID.randomUUID().toString();
            System.out.println(s);
            entity.setUuid(s);
        }
    }
}
