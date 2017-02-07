package com.zhangyu.myokhttpopensource.myokhttp.model;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */

public class NewZhaiquan {


    /**
     * list : [{"id":"1","transfer_price":"1000.00","status":"1","money":"1024.99","period":"3","borrow_name":"余钱宝第一期","borrow_interest_rate":"10.00","period_cn":"期"},{"id":"11","transfer_price":"1.00","status":"1","money":"10249.99","period":"3","borrow_name":"余钱宝第一期","borrow_interest_rate":"10.00","period_cn":"期"},{"id":"10","transfer_price":"123.00","status":"1","money":"307.50","period":"3","borrow_name":"余钱宝第一期","borrow_interest_rate":"10.00","period_cn":"期"},{"id":"14","transfer_price":"50.00","status":"3","money":"50.76","period":"2","borrow_name":"余钱宝第4期","borrow_interest_rate":"12.00","period_cn":"期"},{"id":"13","transfer_price":"1000.00","status":"3","money":"1013.33","period":"1","borrow_name":"cc项目122306","borrow_interest_rate":"4.00","period_cn":"期"},{"id":"12","transfer_price":"1.00","status":"3","money":"50.76","period":"2","borrow_name":"余钱宝第4期","borrow_interest_rate":"12.00","period_cn":"期"},{"id":"9","transfer_price":"36900.00","status":"3","money":"36900.00","period":"3","borrow_name":"余钱宝第一期","borrow_interest_rate":"10.00","period_cn":"期"},{"id":"8","transfer_price":"35600.00","status":"3","money":"36936.90","period":"3","borrow_name":"余钱宝第一期","borrow_interest_rate":"10.00","period_cn":"期"},{"id":"7","transfer_price":"250.00","status":"3","money":"251.84","period":"3","borrow_name":"余钱宝第一期","borrow_interest_rate":"10.00","period_cn":"期"},{"id":"6","transfer_price":"980.00","status":"3","money":"980.69","period":"3","borrow_name":"余钱宝第一期","borrow_interest_rate":"10.00","period_cn":"期"}]
     * page : {"nowPage":"1","totalPages":"2","totalRows":"15","pageSize":"10"}
     * status : 1
     */

    private PageBean page;
    private String status;
    private List<ListBean> list;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class PageBean {
        /**
         * nowPage : 1
         * totalPages : 2
         * totalRows : 15
         * pageSize : 10
         */

        private String nowPage;
        private String totalPages;
        private String totalRows;
        private String pageSize;

        public String getNowPage() {
            return nowPage;
        }

        public void setNowPage(String nowPage) {
            this.nowPage = nowPage;
        }

        public String getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(String totalPages) {
            this.totalPages = totalPages;
        }

        public String getTotalRows() {
            return totalRows;
        }

        public void setTotalRows(String totalRows) {
            this.totalRows = totalRows;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }
    }

    public static class ListBean {
        /**
         * id : 1
         * transfer_price : 1000.00
         * status : 1
         * money : 1024.99
         * period : 3
         * borrow_name : 余钱宝第一期
         * borrow_interest_rate : 10.00
         * period_cn : 期
         */

        private String id;
        private String transfer_price;
        private String status;
        private String money;
        private String period;
        private String borrow_name;
        private String borrow_interest_rate;
        private String period_cn;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTransfer_price() {
            return transfer_price;
        }

        public void setTransfer_price(String transfer_price) {
            this.transfer_price = transfer_price;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getBorrow_name() {
            return borrow_name;
        }

        public void setBorrow_name(String borrow_name) {
            this.borrow_name = borrow_name;
        }

        public String getBorrow_interest_rate() {
            return borrow_interest_rate;
        }

        public void setBorrow_interest_rate(String borrow_interest_rate) {
            this.borrow_interest_rate = borrow_interest_rate;
        }

        public String getPeriod_cn() {
            return period_cn;
        }

        public void setPeriod_cn(String period_cn) {
            this.period_cn = period_cn;
        }
    }
}
