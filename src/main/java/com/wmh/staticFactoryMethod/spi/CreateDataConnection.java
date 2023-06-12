package com.wmh.staticFactoryMethod.spi;

import com.wmh.staticFactoryMethod.IDataConnection;

/**
 * @author wmh
 */
public interface CreateDataConnection {

    /**
     * 创建连接
     * @return
     */
    IDataConnection getDataConnection();
}
