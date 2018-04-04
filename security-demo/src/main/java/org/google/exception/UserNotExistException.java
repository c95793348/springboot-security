package org.google.exception;

/**
 * Created by wbcaoa on 2018/3/27.
 */
public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id){
        super("用户不存在!");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
