package com.sofyntelligen.school.control.api.repositories;

import com.sofyntelligen.school.control.api.model.entity.Matter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatterRepository extends CrudRepository<Matter, String>, GenericRepository<Matter> {

    @Override
    Matter save(Matter matter);

    @Override
    Optional<Matter> findById(String id);

}
