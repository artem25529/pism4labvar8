package com.es.server;

import java.io.Serializable;

public class UserException extends RuntimeException implements Serializable {
    public static final long serialVersionUID = 1L;

    public UserException(String message) {
        super(message);
    }
}
