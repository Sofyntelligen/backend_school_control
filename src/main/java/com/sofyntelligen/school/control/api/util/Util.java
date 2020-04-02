package com.sofyntelligen.school.control.api.util;

import java.math.BigDecimal;
import java.util.Optional;

public class Util {

    private Util() {
        super();
    }

    public static String validStringNull(Object validString) {
        String result = "";

        Optional<Object> optionalObject = Optional.ofNullable(validString);

        if (optionalObject.isPresent()) {
            result = optionalObject.get().toString();
        }

        return result;
    }

    public static Integer validIntegerNullAndIsEmpty(Object validInteger) {
        Integer result = 0;

        Optional<Object> optionalObject = Optional.ofNullable(validInteger);

        if (optionalObject.isPresent() && !optionalObject.toString().isEmpty()) {
            result = Integer.valueOf(optionalObject.get().toString());
        }

        return result;
    }

    public static BigDecimal validBigDecimalNullAndIsEmpty(Object validBigDecimal) {
        String result = "0.0";

        Optional<Object> optionalObject = Optional.ofNullable(validBigDecimal);

        if (optionalObject.isPresent() && !optionalObject.toString().isEmpty()) {
            result = optionalObject.get().toString();
        }

        return new BigDecimal(result);
    }

}
