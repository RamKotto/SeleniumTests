package ru.saraev.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtils {

    public static String getUniqueString(String str) {
        return str.concat(LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss")));
    }
}
