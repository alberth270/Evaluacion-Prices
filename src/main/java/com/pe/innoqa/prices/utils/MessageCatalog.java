package com.pe.innoqa.prices.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MessageCatalog {
    /**
     * Enum of ReturnCode.
     */
    @AllArgsConstructor
    @Getter
    public enum ReturnCode {

        SUCCESS("0", "Success"),
        ERROR("-1", "Error");

        private final String code;
        private final String description;
    }
}
