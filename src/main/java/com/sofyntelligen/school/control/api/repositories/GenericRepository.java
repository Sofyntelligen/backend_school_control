package com.sofyntelligen.school.control.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface GenericRepository<T> extends PagingAndSortingRepository<T, String> {

    @Override
    Page<T> findAll(Pageable pageable);

}
