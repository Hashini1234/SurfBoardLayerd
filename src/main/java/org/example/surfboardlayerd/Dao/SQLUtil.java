package org.example.surfboardlayerd.Dao;

import org.example.surfboardlayerd.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
//    public static ResultSet executeQuery(String sql, Object... ob) throws SQLException, ClassNotFoundException {
//        Connection conn = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        for (int i = 0; i < ob.length; i++) {
//            pstm.setObject(i + 1, ob[i]);
//        }
//        return pstm.executeQuery();
//    }
//    public static boolean executeUpdate(String sql, Object... ob) throws SQLException, ClassNotFoundException {
//        Connection conn = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        for (int i = 0; i < ob.length; i++) {
//            pstm.setObject(i + 1, ob[i]);
//        }
//        return pstm.executeUpdate()>0;
//    }

    public static <T>T execute(String sql,Object... args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i + 1, args[i]);
        }
        if (sql.startsWith("SELECT")) {
            return (T) pstm.executeQuery();
        } else {
            return (T) (Boolean) (pstm.executeUpdate()> 0);
        }
    }
}
