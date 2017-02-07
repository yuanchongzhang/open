package com.zhangyu.myokhttpopensource.myokhttp.response;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */

public class DemoResponse {


    /**
     * sex : [{"id":"1","name":"男"},{"id":"2","name":"女"}]
     * borrow_money : [{"id":"1000","name":"1000元"},{"id":"2000","name":"2000元"},{"id":"3000","name":"3000元"},{"id":"4000","name":"4000元"},{"id":"10000","name":"10000元"}]
     * borrow_use : [{"id":"1","name":"短期周转"},{"id":"2","name":"生意周转"},{"id":"3","name":"生活周转"},{"id":"4","name":"购物消费"},{"id":"5","name":"不提现借款"},{"id":"6","name":"创业借款"},{"id":"7","name":"其它借款"}]
     * borrow_duration : [{"id":"1","name":"1个月"},{"id":"2","name":"2个月"},{"id":"3","name":"3个月"},{"id":"4","name":"4个月"},{"id":"5","name":"5个月"},{"id":"6","name":"6个月"},{"id":"7","name":"7个月"},{"id":"8","name":"8个月"},{"id":"9","name":"9个月"},{"id":"10","name":"10个月"},{"id":"11","name":"11个月"},{"id":"12","name":"12个月"}]
     * status : 1
     */

    private String status;
    private List<SexBean> sex;
    private List<BorrowMoneyBean> borrow_money;
    private List<BorrowUseBean> borrow_use;
    private List<BorrowDurationBean> borrow_duration;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SexBean> getSex() {
        return sex;
    }

    public void setSex(List<SexBean> sex) {
        this.sex = sex;
    }

    public List<BorrowMoneyBean> getBorrow_money() {
        return borrow_money;
    }

    public void setBorrow_money(List<BorrowMoneyBean> borrow_money) {
        this.borrow_money = borrow_money;
    }

    public List<BorrowUseBean> getBorrow_use() {
        return borrow_use;
    }

    public void setBorrow_use(List<BorrowUseBean> borrow_use) {
        this.borrow_use = borrow_use;
    }

    public List<BorrowDurationBean> getBorrow_duration() {
        return borrow_duration;
    }

    public void setBorrow_duration(List<BorrowDurationBean> borrow_duration) {
        this.borrow_duration = borrow_duration;
    }

    public static class SexBean {
        /**
         * id : 1
         * name : 男
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

    public static class BorrowMoneyBean {
        /**
         * id : 1000
         * name : 1000元
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

    public static class BorrowUseBean {
        /**
         * id : 1
         * name : 短期周转
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

    public static class BorrowDurationBean {
        /**
         * id : 1
         * name : 1个月
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
