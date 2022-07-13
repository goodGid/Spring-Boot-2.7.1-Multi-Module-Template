
package dev.be.moduleapi.exception;

import dev.be.modulecommon.enums.response.CodeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomException extends RuntimeException {
    private String returnCode;
    private String returnMessage;

    public CustomException(CodeEnum codeEnum) {
        super(codeEnum.getMessage());
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    public CustomException(String returnCode, String returnMessage) {
        super(returnMessage);
        setReturnCode(returnCode);
        setReturnMessage(returnMessage);
    }

    public CustomException(String returnCode, String returnMessage, Throwable cause) {
        super(returnMessage, cause);
        setReturnCode(returnCode);
        setReturnMessage(returnMessage);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

}