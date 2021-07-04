package com.grantcs.usermanagementsystem.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class UserApplicationService {
    private final MessageSource messageSource;

    public UserApplicationService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Generate a gender Map
     */
    public Map<String, Integer> getGenderMap() {
        var genderMap = new LinkedHashMap<String, Integer>();

        var male = messageSource.getMessage("male", null, Locale.ENGLISH);
        var female = messageSource.getMessage("female", null, Locale.ENGLISH);

        genderMap.put(male, 1);
        genderMap.put(female, 2);

        return genderMap;
    }
}
