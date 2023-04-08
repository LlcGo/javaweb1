package com.lc;
import java.sql.*;

/**
 * @Author Lc
 * @Date 2023/4/8
 * @Description 演示jdbc的连接与增删改查
 */
public class TestJDBC {
    Connection connection; //连接数据库本身
    Statement stat; //语句对象 代表了sql语句对应的对象
    ResultSet rs; //查询语句返回的结果集合
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.190.100:3306/weekend" +
            "?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";
    /**
     * 要想获取数据库连接必须有四样
     * driver-class-name:驱动名称
     * url:连接mysql对应的数据库连接
     * username: 用户名
     * password: 密码
     * 异常的分类:runtimeException 可以捕获 期待你不捕获的时候报错 终端程序
     * CheckedException：必须处理的异常，期待必须处理 （可以绕过）
     */
    public void getConn(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,NAME,PASSWORD);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 所有的怎删改方法都统一用这个方法来做
     * @param sql 传入的sql语句
     * @return 影响的条数
     */
    public Integer modify(String sql,String param){
        Integer rst = 0;
        try {
            stat = connection.createStatement();
            rst= stat.executeUpdate(sql + (param != null? param:""));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rst;
    }

    public static void main(String[] args) {
        TestJDBC t = new TestJDBC();
        t.getConn();
        //在bank表中插入数据
//        String sql = "insert into bank values(4,'test',22500.5)";
//        String sql = "update bank set name = 'test123' where id = 4";
//        String sql = "delete from bank where id =";
//        Integer res = t.modify(sql,"4 or 1=1"); sql注入 用字符串凭借就会有安全性问题
//        System.out.println("执行sql的返回结果" + res);
//        String sql = "select * from bank where id = 3";
        String sql = "select * from bank";
        t.printRst(sql);
    }

    public void printRst(String sql){
        try {
            stat = connection.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double cash = rs.getDouble(3);
                System.out.println("banke:{id="+id+",name="+name+",cash="+cash+ "}");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
