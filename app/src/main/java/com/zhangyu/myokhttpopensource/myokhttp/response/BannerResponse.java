package com.zhangyu.myokhttpopensource.myokhttp.response;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class BannerResponse {


    /**
     * message : 1
     * bannerlist : [{"picurl":"uploads/image/20160708/1467957818.jpg","type":"1","info":"-1"},{"picurl":"uploads/image/20160708/1467959961.jpg","type":"1","info":"-1"},{"picurl":"uploads/image/20160708/1467960450.jpg","type":"1","info":"-1"},{"picurl":"uploads/image/20160708/1467956056.jpg","type":"1","info":"-1"},{"picurl":"uploads/image/20160708/1467951019.jpg","type":"1","info":"-1"}]
     * flaglist : [{"picurl":"uploads/image/20160708/1467960532.jpg","type":"1","info":"1","name":"粮油区"},{"picurl":"uploads/image/20160708/1467953707.jpg","type":"1","info":"7","name":"禽肉蛋区"},{"picurl":"uploads/image/20160708/1467960371.jpg","type":"1","info":"3","name":"蔬菜区-叶菜"},{"picurl":"uploads/image/20160708/1467955532.jpg","type":"1","info":"4","name":"水果区"},{"picurl":"uploads/image/20160708/1467960602.jpg","type":"1","info":"5","name":"蔬菜区-根茎类"}]
     * guanggaolist : [{"title":"天天特价","picurl":"uploads/image/20151208/1449556122.png","type":"1","info":"3"},{"title":"新品尝鲜","picurl":"uploads/image/20151208/1449561067.png","type":"1","info":"5"},{"title":"人气销冠","picurl":"uploads/image/20151208/1449563799.png","type":"1","info":"7"}]
     * enjoylist : [{"pid":"35","title":"蜜桔","picurl":"uploads/image/20151207/1449482136.png","unit":"盒","price":"54.00","isshopcart":"0","salenumber":"0"},{"pid":"34","title":"砂糖桔","picurl":"uploads/image/20151207/1449485088.png","unit":"袋","price":"42.00","isshopcart":"0","salenumber":"0"},{"pid":"33","title":"雪花梨","picurl":"uploads/image/20151201/1448940854.jpg","unit":"袋","price":"52.00","isshopcart":"0","salenumber":"0"},{"pid":"32","title":"澳洲青苹","picurl":"uploads/image/20151201/1448934355.jpg","unit":"袋","price":"98.00","isshopcart":"0","salenumber":"0"},{"pid":"31","title":"红富士苹果","picurl":"uploads/image/20151201/1448942156.jpg","unit":"盒","price":"69.00","isshopcart":"0","salenumber":"0"},{"pid":"18","title":"大头梨","picurl":"uploads/image/20151130/1448876314.jpg","unit":"袋","price":"50.00","isshopcart":"0","salenumber":"0"},{"pid":"17","title":"冰糖心","picurl":"uploads/image/20151130/1448880024.jpg","unit":"袋","price":"25.00","isshopcart":"0","salenumber":"0"},{"pid":"16","title":"杨梅","picurl":"uploads/image/20151130/1448872128.jpg","unit":"斤","price":"15.90","isshopcart":"0","salenumber":"0"},{"pid":"15","title":"草莓","picurl":"uploads/image/20151130/1448874043.jpg","unit":"盒","price":"10.00","isshopcart":"0","salenumber":"0"},{"pid":"14","title":"鲜柠檬","picurl":"uploads/image/20151130/1448868592.jpg","unit":"个","price":"3.50","isshopcart":"0","salenumber":"22"}]
     * nextpage : 2
     * ispage : 1
     */

    private String message;
    private String nextpage;
    private String ispage;
    private List<BannerlistBean> bannerlist;
    private List<FlaglistBean> flaglist;
    private List<GuanggaolistBean> guanggaolist;
    private List<EnjoylistBean> enjoylist;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNextpage() {
        return nextpage;
    }

    public void setNextpage(String nextpage) {
        this.nextpage = nextpage;
    }

    public String getIspage() {
        return ispage;
    }

    public void setIspage(String ispage) {
        this.ispage = ispage;
    }

    public List<BannerlistBean> getBannerlist() {
        return bannerlist;
    }

    public void setBannerlist(List<BannerlistBean> bannerlist) {
        this.bannerlist = bannerlist;
    }

    public List<FlaglistBean> getFlaglist() {
        return flaglist;
    }

    public void setFlaglist(List<FlaglistBean> flaglist) {
        this.flaglist = flaglist;
    }

    public List<GuanggaolistBean> getGuanggaolist() {
        return guanggaolist;
    }

    public void setGuanggaolist(List<GuanggaolistBean> guanggaolist) {
        this.guanggaolist = guanggaolist;
    }

    public List<EnjoylistBean> getEnjoylist() {
        return enjoylist;
    }

    public void setEnjoylist(List<EnjoylistBean> enjoylist) {
        this.enjoylist = enjoylist;
    }

    public static class BannerlistBean {
        /**
         * picurl : uploads/image/20160708/1467957818.jpg
         * type : 1
         * info : -1
         */

        private String picurl;
        private String type;
        private String info;

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public static class FlaglistBean {
        /**
         * picurl : uploads/image/20160708/1467960532.jpg
         * type : 1
         * info : 1
         * name : 粮油区
         */

        private String picurl;
        private String type;
        private String info;
        private String name;

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class GuanggaolistBean {
        /**
         * title : 天天特价
         * picurl : uploads/image/20151208/1449556122.png
         * type : 1
         * info : 3
         */

        private String title;
        private String picurl;
        private String type;
        private String info;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    public static class EnjoylistBean {
        /**
         * pid : 35
         * title : 蜜桔
         * picurl : uploads/image/20151207/1449482136.png
         * unit : 盒
         * price : 54.00
         * isshopcart : 0
         * salenumber : 0
         */

        private String pid;
        private String title;
        private String picurl;
        private String unit;
        private String price;
        private String isshopcart;
        private String salenumber;

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getIsshopcart() {
            return isshopcart;
        }

        public void setIsshopcart(String isshopcart) {
            this.isshopcart = isshopcart;
        }

        public String getSalenumber() {
            return salenumber;
        }

        public void setSalenumber(String salenumber) {
            this.salenumber = salenumber;
        }
    }
}
