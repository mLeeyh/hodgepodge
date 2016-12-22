package com.lyh.hodgepodge.model;

import com.lyh.hodgepodge.model.entity.Baisi;

import java.util.List;

/**
 * Created by lyh on 2016/12/22.
 */

public class BaisiData extends BaseData{
    public List<Baisi> results;

    @Override
    public String toString() {
        return "BaisiData{" +
                "results=" + results +
                '}';
    }
}
