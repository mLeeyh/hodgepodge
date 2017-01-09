package com.lyh.hodgepodge.model.entity;

import java.util.List;

/**
 * Created by lyh on 2017/1/9.
 */

public class ReadType {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"typeList":[{"id":"1","name":"家事"},{"id":"2","name":"国事"},{"id":"3","name":"天下事"},{"id":"5","name":"有趣的事"},{"id":"6","name":"历史故事"},{"id":"11","name":"书中事"},{"id":"7","name":"心事"},{"id":"4","name":"男人的事"},{"id":"8","name":"女人的事"},{"id":"12","name":"读者文摘"},{"id":"9","name":"看点"},{"id":"10","name":"侃点"},{"id":"17","name":"段子"},{"id":"13","name":"经典语句"}]}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * typeList : [{"id":"1","name":"家事"},{"id":"2","name":"国事"},{"id":"3","name":"天下事"},{"id":"5","name":"有趣的事"},{"id":"6","name":"历史故事"},{"id":"11","name":"书中事"},{"id":"7","name":"心事"},{"id":"4","name":"男人的事"},{"id":"8","name":"女人的事"},{"id":"12","name":"读者文摘"},{"id":"9","name":"看点"},{"id":"10","name":"侃点"},{"id":"17","name":"段子"},{"id":"13","name":"经典语句"}]
         */

        private int ret_code;
        private List<TypeListBean> typeList;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<TypeListBean> getTypeList() {
            return typeList;
        }

        public void setTypeList(List<TypeListBean> typeList) {
            this.typeList = typeList;
        }

        public static class TypeListBean {
            @Override
            public String toString() {
                return "TypeListBean{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        '}';
            }

            /**
             * id : 1
             * name : 家事
             */

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
