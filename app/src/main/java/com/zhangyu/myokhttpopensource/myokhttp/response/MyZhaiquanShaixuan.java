package com.zhangyu.myokhttpopensource.myokhttp.response;

import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */

public class MyZhaiquanShaixuan {


    /**
     * borrow_type : [{"id":"0","name":"不限"},{"id":"1","name":"信用标"},{"id":"3","name":"秒标"},{"id":"4","name":"净值标"},{"id":"5","name":"抵押标"}]
     * borrow_interest_rate : [{"id":"0","name":"不限"},{"id":"1","name":"10%以下"},{"id":"2","name":"10%-15%"},{"id":"3","name":"15%-20%"},{"id":"4","name":"20%-25%"},{"id":"5","name":"25%以上"}]
     * borrow_duration : [{"id":"0","name":"不限"},{"id":"1","name":"1-3个月"},{"id":"2","name":"4-6个月"},{"id":"3","name":"7-9个月"},{"id":"4","name":"10-12个月"},{"id":"5","name":"13-24个月"},{"id":"6","name":"24个月以上"}]
     * borrow_status : [{"id":"0","name":"全部"},{"id":"2","name":"正在投标"},{"id":"6","name":"正在还款"},{"id":"7","name":"还款完成"}]
     * borrow_money : [{"id":"0","name":"全部"},{"id":"1","name":"1万以下"},{"id":"2","name":"1万-5万"},{"id":"3","name":"5万-10万"},{"id":"4","name":"10万-20万"},{"id":"5","name":"20万以上"}]
     * status : 1
     */

    private String status;
    private List<BorrowTypeBean> borrow_type;
    private List<BorrowInterestRateBean> borrow_interest_rate;
    private List<BorrowDurationBean> borrow_duration;
    private List<BorrowStatusBean> borrow_status;
    private List<BorrowMoneyBean> borrow_money;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BorrowTypeBean> getBorrow_type() {
        return borrow_type;
    }

    public void setBorrow_type(List<BorrowTypeBean> borrow_type) {
        this.borrow_type = borrow_type;
    }

    public List<BorrowInterestRateBean> getBorrow_interest_rate() {
        return borrow_interest_rate;
    }

    public void setBorrow_interest_rate(List<BorrowInterestRateBean> borrow_interest_rate) {
        this.borrow_interest_rate = borrow_interest_rate;
    }

    public List<BorrowDurationBean> getBorrow_duration() {
        return borrow_duration;
    }

    public void setBorrow_duration(List<BorrowDurationBean> borrow_duration) {
        this.borrow_duration = borrow_duration;
    }

    public List<BorrowStatusBean> getBorrow_status() {
        return borrow_status;
    }

    public void setBorrow_status(List<BorrowStatusBean> borrow_status) {
        this.borrow_status = borrow_status;
    }

    public List<BorrowMoneyBean> getBorrow_money() {
        return borrow_money;
    }

    public void setBorrow_money(List<BorrowMoneyBean> borrow_money) {
        this.borrow_money = borrow_money;
    }

    public static class BorrowTypeBean {
        /**
         * id : 0
         * name : 不限
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

    public static class BorrowInterestRateBean {
        /**
         * id : 0
         * name : 不限
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
         * id : 0
         * name : 不限
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

    public static class BorrowStatusBean {
        /**
         * id : 0
         * name : 全部
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
         * id : 0
         * name : 全部
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
