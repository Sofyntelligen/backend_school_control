package com.sofyntelligen.school.control.api.services;

import com.sofyntelligen.school.control.api.model.entity.Matter;
import com.sofyntelligen.school.control.api.repositories.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MatterService {

    @Autowired
    private MatterRepository matterRepository;

    public Matter matterSaveAndUpdate(Matter matter) {
        return matterRepository.save(matter);
    }

    public Page<Matter> matterFindAll(Integer page, Integer size, Integer descendingAndAscending, String sort) {

        Sort sortType = Sort.unsorted();

        if (!sort.isEmpty()) {
            if (descendingAndAscending.equals(1)) {
                sortType = Sort.by(sort).descending();
            } else if (descendingAndAscending.equals(2)) {
                sortType = Sort.by(sort).ascending();
            } else {
                sortType = Sort.by(sort);
            }
        }

        Pageable pageable =
                PageRequest.of(page, size, sortType);

        return matterRepository.findAll(pageable);
    }

}
