package com.lc;

import java.sql.*;

/**
 * @Author Lc
 * @Date 2023/4/8
 * @Description
 */
public class Jdbc2Prepared {
    Connection connection; //连接数据库本身
    PreparedStatement pst; //语句对象 代表了sql语句对应的对象
    ResultSet rs; //查询语句返回的结果集合
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.190.100:3306/weekend" +
            "?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";

    public void getConn(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,NAME,PASSWORD);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer modify(String sql,String...params) throws SQLException {
        pst = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i+1,params[i]);
        }
        return pst.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {
        Jdbc2Prepared jdbc = new Jdbc2Prepared();
        jdbc.getConn();
        String sql = "insert into bank(name,cash) values(?,?),(?,?),(?,?)";
        Integer cnt = jdbc.modify(sql,"test1","12.5","test2","255","test3","890.4");
        System.out.println("执行的结果:" + cnt);
    }
}
