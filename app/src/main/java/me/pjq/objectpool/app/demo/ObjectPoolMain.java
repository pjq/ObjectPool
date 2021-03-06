package me.pjq.objectpool.app.demo;

import java.sql.Connection;

/**
 * Created by pengjianqing on 6/19/14.
 */
public class ObjectPoolMain {

    public static void main(String []args){
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "org.hsqldb.jdbcDriver", "jdbc:hsqldb://localhost/mydb",
                "sa", "secret");

        //Get a connection
        Connection connection = pool.acquare();


        //return the connection
        pool.release(connection);
    }
}
