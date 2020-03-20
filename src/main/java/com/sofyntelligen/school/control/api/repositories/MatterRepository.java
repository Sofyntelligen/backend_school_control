package com.sofyntelligen.school.control.api.repositories;

import com.sofyntelligen.school.control.api.model.entity.Matter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatterRepository extends CrudRepository<Matter, Integer>, GenericRepository<Matter> {

    @Override
    Matter save(Matter matter);

}
