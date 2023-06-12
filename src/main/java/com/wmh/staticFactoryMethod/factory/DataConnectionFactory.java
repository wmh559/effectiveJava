package com.wmh.staticFactoryMethod.factory;

import com.wmh.staticFactoryMethod.IDataConnection;
import com.wmh.staticFactoryMethod.constant.Constant;
import com.wmh.staticFactoryMethod.impl.DefaultDataConnection;
import com.wmh.staticFactoryMethod.impl.FileDataConnection;
import com.wmh.staticFactoryMethod.spi.CreateDataConnection;

import java.util.ServiceLoader;

/**
 * 数据连接工厂类
 * @author wmh
 */
public class DataConnectionFactory {

    /**
     * 使用静态工厂方法代替构造器的好处
     */

    private static final IDataConnection INSTANCE = new DefaultDataConnection();

    /**
     * 1、与构造器相比静态工厂有名称
     * 见名知义，创建默认的数据连接
     */
    public static IDataConnection getDefaultDataConnection() {
        return new DefaultDataConnection();
    }

    /**
     * 2、不必在每次调用的时候都创建一个新的对象
     */
    public static IDataConnection getInstance() {
        return INSTANCE;
    }
    /**
     * 3、可以返回原返回类型的任何子类
     */
    public static IDataConnection getFileDataConnection() {
        return new FileDataConnection();
    }

    /**
     * 4、所返回的对象的类可以随着每次调用而发生变化
     */
    public static IDataConnection getDataConnectionByType(String type) {
        if (Constant.FileDataConnection.equals(type)) {
            return new FileDataConnection();
        } else if (Constant.DefaultDataConnection.equals(type)){
            return new DefaultDataConnection();
        }
        return null;
    }

    /**
     * 5、方法返回的对象所属的类在编写包含该静态工厂方法的类时可以不存在
     */
    public static IDataConnection getDataConnection() {
        ServiceLoader<CreateDataConnection> load = ServiceLoader.load(CreateDataConnection.class);
        for (CreateDataConnection dataConnection : load) {
            IDataConnection connection = dataConnection.getDataConnection();
            if (connection != null) {
                return connection;
            }
        }
        return null;
    }

}
