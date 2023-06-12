package com.wmh.staticFactoryMethod.spi;

import com.wmh.staticFactoryMethod.IDataConnection;
import com.wmh.staticFactoryMethod.impl.FileDataConnection;

/**
 * @author wmh
 * 这里使用Java spi
 */
public class CreateFileDataConnection implements CreateDataConnection{
    @Override
    public IDataConnection getDataConnection() {
        return new FileDataConnection();
    }
}
