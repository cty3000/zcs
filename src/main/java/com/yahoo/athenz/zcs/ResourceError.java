//
// This file generated by rdl 1.4.15. Do not modify!
//
package com.yahoo.athenz.zcs;

public class ResourceError {

    public int code;
    public String message;

    public ResourceError code(int code) {
        this.code = code;
        return this;
    }
    public ResourceError message(String message) {
        this.message = message;
        return this;
    }

    public String toString() {
        return "{code: " + code + ", message: \"" + message + "\"}";
    }

}
