package project.mapper;

import java.util.List;

public interface IMapper<T,E>{
    E toDTO(T t);
    T toEntity(E e);
    List<E> toDTOS(List<T> list);
    List<T> toEntitys(List<E> eList);
}
