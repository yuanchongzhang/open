package com.zhangyu.myokhttpopensource.myokhttp.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
public class Zhaiquan {

    /**
     * list : [{"id":"3","borrow_name":"余钱宝第3期","borrow_interest_rate":"12.00","borrow_duration":"6","borrow_duration_cn":"个月","need":"1723.45","progress":"97.52"},{"id":"12","borrow_name":"项目122306","borrow_interest_rate":"8.00","borrow_duration":"2","borrow_duration_cn":"天","need":"0.00","progress":"100.00"},{"id":"8","borrow_name":"只借1000一天时间，年利6","borrow_interest_rate":"6.00","borrow_duration":"0","borrow_duration_cn":"天","need":"0.00","progress":"100.00"},{"id":"10","borrow_name":"cc项目122306","borrow_interest_rate":"4.00","borrow_duration":"4","borrow_duration_cn":"个月","need":"0.00","progress":"100.00"},{"id":"4","borrow_name":"余钱宝第4期","borrow_interest_rate":"12.00","borrow_duration":"2","borrow_duration_cn":"个月","need":"0.00","progress":"100.00"},{"id":"1","borrow_name":"余钱宝第一期","borrow_interest_rate":"10.00","borrow_duration":"3","borrow_duration_cn":"个月","need":"0.00","progress":"100.00"},{"id":"6","borrow_name":"回来","borrow_interest_rate":"12.00","borrow_duration":"1","borrow_duration_cn":"个月","need":"0.00","progress":"100.00"}]
     * page : {"nowPage":"1","totalPages":"1","totalRows":"7","pageSize":"10"}
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

    public static class PageBean implements Parcelable {
        /**
         * nowPage : 1
         * totalPages : 1
         * totalRows : 7
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.nowPage);
            dest.writeString(this.totalPages);
            dest.writeString(this.totalRows);
            dest.writeString(this.pageSize);
        }

        public PageBean() {
        }

        protected PageBean(Parcel in) {
            this.nowPage = in.readString();
            this.totalPages = in.readString();
            this.totalRows = in.readString();
            this.pageSize = in.readString();
        }

        public static final Parcelable.Creator<PageBean> CREATOR = new Parcelable.Creator<PageBean>() {
            @Override
            public PageBean createFromParcel(Parcel source) {
                return new PageBean(source);
            }

            @Override
            public PageBean[] newArray(int size) {
                return new PageBean[size];
            }
        };
    }

    public static class ListBean implements Parcelable {
        /**
         * id : 3
         * borrow_name : 余钱宝第3期
         * borrow_interest_rate : 12.00
         * borrow_duration : 6
         * borrow_duration_cn : 个月
         * need : 1723.45
         * progress : 97.52
         */

        private String id;
        private String borrow_name;
        private String borrow_interest_rate;
        private String borrow_duration;
        private String borrow_duration_cn;
        private String need;
        private String progress;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getBorrow_duration() {
            return borrow_duration;
        }

        public void setBorrow_duration(String borrow_duration) {
            this.borrow_duration = borrow_duration;
        }

        public String getBorrow_duration_cn() {
            return borrow_duration_cn;
        }

        public void setBorrow_duration_cn(String borrow_duration_cn) {
            this.borrow_duration_cn = borrow_duration_cn;
        }

        public String getNeed() {
            return need;
        }

        public void setNeed(String need) {
            this.need = need;
        }

        public String getProgress() {
            return progress;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.borrow_name);
            dest.writeString(this.borrow_interest_rate);
            dest.writeString(this.borrow_duration);
            dest.writeString(this.borrow_duration_cn);
            dest.writeString(this.need);
            dest.writeString(this.progress);
        }

        public ListBean() {
        }

        protected ListBean(Parcel in) {
            this.id = in.readString();
            this.borrow_name = in.readString();
            this.borrow_interest_rate = in.readString();
            this.borrow_duration = in.readString();
            this.borrow_duration_cn = in.readString();
            this.need = in.readString();
            this.progress = in.readString();
        }

        public static final Parcelable.Creator<ListBean> CREATOR = new Parcelable.Creator<ListBean>() {
            @Override
            public ListBean createFromParcel(Parcel source) {
                return new ListBean(source);
            }

            @Override
            public ListBean[] newArray(int size) {
                return new ListBean[size];
            }
        };
    }
}
