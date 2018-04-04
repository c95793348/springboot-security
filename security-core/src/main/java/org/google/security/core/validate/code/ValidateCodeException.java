package org.google.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by wbcaoa on 2018/3/30.
 */
public class ValidateCodeException extends AuthenticationException{


    public ValidateCodeException(String msg) {
        super(msg);
    }
}
