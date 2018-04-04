package org.google.dto;

/**
 * Created by wbcaoa on 2018/3/27.
 */
public class FileInfo {

    public FileInfo(String path){
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
