package com.jacobs.akka.memorydb;

import java.io.Serializable;

/**
 * @author lichao <lichao@kuaishou.com>
 * Created on 2019-05-18
 */
public class KeyNotFoundException extends Exception implements Serializable {
    public final String key;

    public KeyNotFoundException(String key) {
        this.key = key;
    }
}
