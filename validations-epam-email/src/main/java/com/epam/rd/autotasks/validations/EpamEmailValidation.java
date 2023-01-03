package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {

        String regex = "^[A-Za-z0-9]+_+[A-Za-z0-9]+" + "@epam.com$";
        Pattern epamEmailValidationPattern = Pattern.compile(regex);
        if (email == null) {
            return false;
        }
        return epamEmailValidationPattern.matcher(email).matches();
    }
}





