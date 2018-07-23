package bigzeng.com.dailylife.bean;

import java.util.List;

/**
 * Created by admin on 2018/7/19.
 */

public class WeatherInfoBean {

    /**
     * code : 200
     * msg : 成功!
     * data : {"yesterday":{"date":"18日星期三","high":"高温 31℃","fx":"无持续风向","low":"低温 26℃","fl":"<![CDATA[<3级]]>","type":"多云"},"city":"深圳","aqi":"27","forecast":[{"date":"19日星期四","high":"高温 31℃","fengli":"<![CDATA[3-4级]]>","low":"低温 27℃","fengxiang":"东风","type":"雷阵雨"},{"date":"20日星期五","high":"高温 32℃","fengli":"<![CDATA[<3级]]>","low":"低温 27℃","fengxiang":"无持续风向","type":"雷阵雨"},{"date":"21日星期六","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 27℃","fengxiang":"无持续风向","type":"多云"},{"date":"22日星期天","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 28℃","fengxiang":"无持续风向","type":"多云"},{"date":"23日星期一","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 26℃","fengxiang":"无持续风向","type":"多云"}],"ganmao":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","wendu":"29"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * yesterday : {"date":"18日星期三","high":"高温 31℃","fx":"无持续风向","low":"低温 26℃","fl":"<![CDATA[<3级]]>","type":"多云"}
         * city : 深圳
         * aqi : 27
         * forecast : [{"date":"19日星期四","high":"高温 31℃","fengli":"<![CDATA[3-4级]]>","low":"低温 27℃","fengxiang":"东风","type":"雷阵雨"},{"date":"20日星期五","high":"高温 32℃","fengli":"<![CDATA[<3级]]>","low":"低温 27℃","fengxiang":"无持续风向","type":"雷阵雨"},{"date":"21日星期六","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 27℃","fengxiang":"无持续风向","type":"多云"},{"date":"22日星期天","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 28℃","fengxiang":"无持续风向","type":"多云"},{"date":"23日星期一","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 26℃","fengxiang":"无持续风向","type":"多云"}]
         * ganmao : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
         * wendu : 29
         */

        private YesterdayBean yesterday;
        private String city;
        private String aqi;
        private String ganmao;
        private String wendu;
        private List<ForecastBean> forecast;

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 18日星期三
             * high : 高温 31℃
             * fx : 无持续风向
             * low : 低温 26℃
             * fl : <![CDATA[<3级]]>
             * type : 多云
             */

            private String date;
            private String high;
            private String fx;
            private String low;
            private String fl;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class ForecastBean {
            /**
             * date : 19日星期四
             * high : 高温 31℃
             * fengli : <![CDATA[3-4级]]>
             * low : 低温 27℃
             * fengxiang : 东风
             * type : 雷阵雨
             */

            private String date;
            private String high;
            private String fengli;
            private String low;
            private String fengxiang;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
