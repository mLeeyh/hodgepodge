package com.lyh.hodgepodge.model;

import com.lyh.hodgepodge.model.entity.ReadType;

import java.util.List;

/**
 * Created by lyh on 2017/1/9.
 */

public class ReadTypeData {
    public List<ReadType.ShowapiResBodyBean.TypeListBean> list;

    @Override
    public String toString() {
        return "ReadTypeData{" +
                "list=" + list +
                '}';
    }
}
