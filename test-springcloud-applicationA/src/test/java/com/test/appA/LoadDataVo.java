package com.test.appA;


import java.math.BigDecimal;
import java.util.List;

// 爬取数据对象
public class LoadDataVo {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private String message;

    private Data data;

    public static class Data {
        public List<Item> getRecords() {
            return records;
        }

        public void setRecords(List<Item> records) {
            this.records = records;
        }

        private List<Item> records;
    }

    public static class Item {

        private String albumId;

        public String getAlbumId() {
            return albumId;
        }

        public void setAlbumId(String albumId) {
            this.albumId = albumId;
        }

        public String getAlbumName() {
            return albumName;
        }

        public void setAlbumName(String albumName) {
            this.albumName = albumName;
        }

        public String getPlatformName() {
            return platformName;
        }

        public void setPlatformName(String platformName) {
            this.platformName = platformName;
        }

        public String getThumbPic() {
            return thumbPic;
        }

        public void setThumbPic(String thumbPic) {
            this.thumbPic = thumbPic;
        }

        public Integer getHot() {
            return hot;
        }

        public void setHot(Integer hot) {
            this.hot = hot;
        }

        public String getConsignmentFloorPrice() {
            return consignmentFloorPrice;
        }

        public void setConsignmentFloorPrice(String consignmentFloorPrice) {
            this.consignmentFloorPrice = consignmentFloorPrice;
        }

        public BigDecimal getFluctuation() {
            return fluctuation;
        }

        public void setFluctuation(BigDecimal fluctuation) {
            this.fluctuation = fluctuation;
        }

        private String albumName;

        private String platformName;

        private String thumbPic;

        private Integer hot;
        // 地板价
        private String consignmentFloorPrice;
        // 涨跌幅
        private BigDecimal fluctuation;
    }
}


