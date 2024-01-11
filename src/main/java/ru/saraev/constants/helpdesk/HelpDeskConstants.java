package ru.saraev.constants.helpdesk;

import lombok.Getter;

@Getter
public enum HelpDeskConstants {
    SUMMARY("мое-саммари"),
    DESCRIPTION("какой-то дескрипшн"),
    EMAIL("black8.tabls@gmail.com"),
    COMMENT("Hello World!");

    private final String constant;

    HelpDeskConstants(String constant) {
        this.constant = constant;
    }
}
