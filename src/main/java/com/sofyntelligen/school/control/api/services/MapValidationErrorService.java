package com.sofyntelligen.school.control.api.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> validationService(BindingResult bindingResult) {

        ResponseEntity<?> result = null;

        if (bindingResult.hasErrors()) {

            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            result = new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);

        }

        return result;

    }

}
