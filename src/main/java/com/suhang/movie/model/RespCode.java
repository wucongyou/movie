package com.suhang.movie.model;

/**
 * @author hang.su
 * @since 2017-04-25 下午8:16
 */
public enum RespCode {

    OK(0, "ok"),

    INCORRECT_ACCOUNT_OR_PASSWORD(-101, "incorrect account or password"),
    LOCKED_ACCOUNT(-102, "locked account"),
    RETRY_LIMITED(-103, "retry limited"),
    UNAUTHENTICATED(-104, "unauthenticated"),
    UNAUTHORIZED(-105, "unauthorized"),
    USER_ALREADY_LOGIN(-106, "user already login"),
    UNKNOWN_AUTHENTICATION_ERROR(-107, "unknown authentication error"),

    INVALID_CLIENT(-201, "invalid client"),
    UNAUTHORIZED_CLIENT(-202, "unauthorized client"),
    INVALID_AUTHORIZATION_CODE(-203, "invalid authorization code"),
    UNSUPPORTED_GRANT_TYPE(-204, "unsupported grant type"),
    NEED_REDIRECT_URI(-205, "need redirect uri"),
    UNKNOWN_OAUTH_PROBLEM(-206, "unknown oauth problem"),

    INVALID_SERVICE(-301, "invalid service"),
    INVALID_SSO_TOKEN(-302, "invalid sso token"),

    WRONG_ARGUMENT(-400, "wrong argument"),
    SERVER_ERROR(-500, "server error"),

    FAILED_TO_UPDATE(-600, "failed to update"),

    USERNAME_ALREADY_EXISTS(-1001, "username already exists"),
    USER_NOT_EXISTS(-1002, "user not exists"),
    ROLE_NOT_EXISTS(-1003, "role not exists"),
    PERMISSION_NOT_EXISTS(-1004, "permission not exists"),

    CLIENT_NOT_EXISTS(-1101, "client not exists"),

    SERVICE_NOT_EXISTS(-1201, "service not exists"),
    SERVICE_NAME_ALREADY_EXISTS(-1202, "service name already exists"),;

    public int code;
    public String message;

    RespCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
