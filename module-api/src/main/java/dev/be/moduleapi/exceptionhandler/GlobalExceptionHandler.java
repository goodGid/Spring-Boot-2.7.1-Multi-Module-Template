package dev.be.moduleapi.exceptionhandler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.response.CommonResponse;
import dev.be.modulecommon.enums.response.CodeEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CommonResponse<?> handlerCustomException(CustomException e) {
        return getCommonResponse(e.getReturnCode(), e.getReturnMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse<?> handleException(Exception e) {
        log.error("Unknown Exception", e);
        return getCommonResponse(CodeEnum.UNKNOWN_ERROR.getCode(),
                                 CodeEnum.UNKNOWN_ERROR.getMessage());
    }

    private CommonResponse<Object> getCommonResponse(String returnCode, String returnMessage) {
        return CommonResponse.builder()
                             .returnCode(returnCode)
                             .returnMessage(returnMessage)
                             .build();
    }

}
