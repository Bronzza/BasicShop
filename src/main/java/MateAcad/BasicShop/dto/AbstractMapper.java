package MateAcad.BasicShop.dto;

import MateAcad.BasicShop.Entities.parententities.CreatebleEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class AbstractMapper<E extends CreatebleEntity, D extends BaseEntityDto> {

    @Autowired
    private ModelMapper mapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;


    public AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, entityClass);
    }

    public D toDto (E entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, dtoClass);
    }

    Converter <E, D> toDtoConverter(){
        return mappingContext -> {
            E source = mappingContext.getSource();
            D destination = mappingContext.getDestination();
            mapSpecificFields(source, destination);
          return mappingContext.getDestination();
        };
    }

    Converter <D, E> toEntityConverter (){
        return mappingContext -> {
            D source = mappingContext.getSource();
            E destination = mappingContext.getDestination();
            mapSpecificFields(source, destination);
            return mappingContext.getDestination();
        };
    }

    protected void mapSpecificFields(D source, E destination) {
    }

    protected void mapSpecificFields(E source, D destination) {
    }
}
