package database;

import java.sql.*;

public class Connect {

    // Constructor without args
    public Connect() {
        // (1. load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // connect MySQL
    public Statement connect(String url, String userName, String password)
            throws SQLException {

        // (2. connect MySQL
        Connection connection = DriverManager.getConnection(url, userName, password);

        // (3. new Object to do sth
        return connection.createStatement();
    }

    // 1. add
    public boolean sqlAdd(Statement statement, Object[] obj) throws SQLException {

        String name = obj[0].toString();
        String id = obj[1].toString();
        String sex = obj[2].toString();
        String age = obj[3].toString();
        String sql = "insert into employee(name,id,sex,age) values('" + name + "'," + id + ",'" + sex + "'," + age +");";
        // (4. execute sql
        return statement.executeUpdate(sql) == 1;
    }

    // 2.delete
    public boolean sqlDelete(Statement statement, Object[] obj) throws SQLException{

        ResultSet atFirst = statement.getResultSet();
        ResultSet atLast;
        String name = obj[0].toString();
        String id = obj[1].toString();
        String sql = "delete from employee where name='" + name + "' and" + " id=" + id + ";";
        statement.executeUpdate(sql);
        atLast = statement.getResultSet();

        return atFirst == atLast;
    }

    // 3.update
    public boolean sqlUpdate(Statement statement, Object[] oldData, Object[] newData) throws SQLException {

        String oldName = oldData[0].toString();
        String oldId = oldData[1].toString();

        String name = newData[0].toString();
        String id = newData[1].toString();
        String sex = newData[2].toString();
        String age = newData[3].toString();
        String sql = "update employee set name='" + name + "',id=" + id + ",sex='" + sex + "',age=" + age + " where name='" + oldName + "' and id=" + oldId + ";";

        return statement.executeUpdate(sql) == 1;
    }

    // 4.select
    public ResultSet sqlSelect(Statement statement, Object[] obj) throws SQLException{

        String name = obj[0].toString();
        String id = obj[1].toString();
        String sql = "select * from employee where name='" + name + "' and id=" + id +";";

        return statement.executeQuery(sql);
    }

    // 5.selectAll
    public ResultSet sqlSelectAll(Statement statement) throws SQLException{

        String sql = "select * from employee;";

        return statement.executeQuery(sql);
    }
}
