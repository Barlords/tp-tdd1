package fr.esgi.cleancode.model;

import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
@Builder
public class SocialSecurityNumber {

    String number;

}