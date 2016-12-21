package com.lyh.hodgepodge.model;

import java.io.Serializable;

/**
 * Created by lyh on 2016/12/21.
 */

public class BaseData implements Serializable{
    public boolean error;

    @Override
    public String toString() {
        return "BaseData{" +"error=" + error + '}';
    }
}
