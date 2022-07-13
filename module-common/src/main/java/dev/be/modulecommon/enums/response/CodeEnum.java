package dev.be.modulecommon.enums.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {
    SUCCESS("0000", "Success."),
    NOT_IDENTITY_VERIFIED_USER("4000", "The user's identity has not been verified."),
    UNKNOWN_ERROR("9999", "Unable to process your request. Please try again later.");

    private String code;
    private String message;
}