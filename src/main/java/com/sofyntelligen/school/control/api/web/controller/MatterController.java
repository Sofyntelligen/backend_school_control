package com.sofyntelligen.school.control.api.web.controller;

import com.sofyntelligen.school.control.api.model.entity.Matter;
import com.sofyntelligen.school.control.api.services.MapValidationErrorService;
import com.sofyntelligen.school.control.api.services.MatterService;
import com.sofyntelligen.school.control.api.util.Util;
import com.sofyntelligen.school.control.api.web.exception.MyResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matter")
@CrossOrigin
public class MatterController {

    @Autowired
    private MatterService matterService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @GetMapping("/matter_id/")
    public String getMatter() {
        return "Test API Status";
    }

    @GetMapping("/all/")
    public List<Matter> listMatter(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("descendingAndAscending") Integer descendingAndAscending, @RequestParam("sort") String sort) {
        Page<Matter> resultPage = matterService.findAllMatter(Util.validIntegerNullAndIsEmpty(page), Util.validIntegerNullAndIsEmpty(size), Util.validIntegerNullAndIsEmpty(descendingAndAscending), Util.validStringNull(sort));

        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }

        return resultPage.getContent();
    }

    @PostMapping("/")
    public ResponseEntity<?> createMatter(@Valid @RequestBody Matter matter, BindingResult bindingResult) {

        ResponseEntity<?> result = mapValidationErrorService.validationService(bindingResult);

        if (result == null) {

            Matter resultMatter = matterService.saveMatter(matter);
            result = new ResponseEntity<>(resultMatter, HttpStatus.CREATED);

        }

        return result;
    }

    @PutMapping("/")
    public String updateMatter() {
        return "Test API Status";
    }

    @DeleteMapping("/matter_id")
    public String deleteMatter() {
        return "Test API Status";
    }
}
