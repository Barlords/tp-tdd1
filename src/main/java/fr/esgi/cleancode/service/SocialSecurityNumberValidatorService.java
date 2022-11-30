package fr.esgi.cleancode.service;

import org.apache.commons.lang3.StringUtils;

public class SocialSecurityNumberValidatorService {

    public static boolean isValidSSN(String socialSecurityNumber) {
        return null != socialSecurityNumber &&
                15 == socialSecurityNumber.length() &&
                StringUtils.isNumeric(socialSecurityNumber);
    }
}
