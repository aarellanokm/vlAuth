package com.knowmadmood.vlauth.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class VLAuthUtils {

    public String dateFormat(String pattern, LocalDate date){
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

}
