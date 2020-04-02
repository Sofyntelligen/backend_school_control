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
    public List<Matter> listMatter(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam(value="descendingAndAscending", required = false) Integer descendingAndAscending, @RequestParam(value="sort", required = false) String sort) {

        Page<Matter> pageMatter = matterService.matterFindAll(Util.validIntegerNullAndIsEmpty(page), Util.validIntegerNullAndIsEmpty(size), Util.validIntegerNullAndIsEmpty(descendingAndAscending), Util.validStringNull(sort));

        if (page >= pageMatter.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }

        return pageMatter.getContent();
    }

    @PostMapping("/")
    public ResponseEntity<?> createMatter(@Valid @RequestBody Matter matter, BindingResult bindingResult) {

        ResponseEntity<?> responseEntity = mapValidationErrorService.validationService(bindingResult);

        if (responseEntity == null) {

            Matter resultMatter = matterService.matterSaveAndUpdate(matter);
            responseEntity = new ResponseEntity<>(resultMatter, HttpStatus.CREATED);

        }

        return responseEntity;
    }

    @PatchMapping("/")
    public ResponseEntity<?>  updateMatter(@Valid @RequestBody Matter matter, BindingResult bindingResult) {

        ResponseEntity<?> responseEntity = mapValidationErrorService.validationService(bindingResult);

        if (responseEntity == null) {

            Matter resultMatter = matterService.matterSaveAndUpdate(matter);
            responseEntity = new ResponseEntity<>(resultMatter, HttpStatus.CREATED);

        }

        return responseEntity;
    }

    @DeleteMapping("/matter_id")
    public String deleteMatter() {
        return "Test API Status";
    }
}
