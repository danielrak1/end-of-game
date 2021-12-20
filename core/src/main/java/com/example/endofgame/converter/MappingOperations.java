package com.example.endofgame.converter;


public interface MappingOperations<E, D> {

    D fromEntityToDto (E entity);
    E fromDtoToEntity(D dto);

}
