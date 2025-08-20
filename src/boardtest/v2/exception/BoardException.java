package boardtest.v2.exception;

import boardtest.v2.common.ErrorCode;

public class BoardException extends RuntimeException {

    private final ErrorCode error;

    public BoardException(ErrorCode error) {
        super(error.getMsg());
        this.error = error;
    }
}
