package com.wmh.builder;


/**
 * 数据连接池
 * @author wmh
 */

public class DataConnectionPool {

    /**
     * 数据连接类型
     */
    private final String dataConnectionType;
    /**
     * 最大连接数
     */
    private final Integer max;
    /**
     * 最小连接数
     */
    private final Integer min;
    /**
     * 超时时间
     */
    private final Integer timeOut;

    public static class Builder {

        private final String dataConnectionType;

        private  Integer max = 10;

        private  Integer min = 5;

        private  Integer timeOut = 10;

        public Builder(String dataConnectionType) {
            this.dataConnectionType = dataConnectionType;
        }

        public Builder max(Integer max) {
            this.max = max;
            return this;
        }
        public Builder min(Integer min) {
            this.min = min;
            return this;
        }
        public Builder timeOut(Integer timeOut) {
            this.timeOut = timeOut;
            return this;
        }

        public DataConnectionPool build() {
            return new DataConnectionPool(this);
        }
    }

    public DataConnectionPool(Builder builder) {
        dataConnectionType = builder.dataConnectionType;
        max = builder.max;
        min = builder.min;
        timeOut = builder.timeOut;
    }

    @Override
    public String toString() {
        return "DataConnectionPool{" +
                "dataConnectionType='" + dataConnectionType + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", timeOut=" + timeOut +
                '}';
    }

}
