package sample;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.lang.invoke.ConstantCallSite;
import java.sql.*;


public class DatabaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        //System.out.println(connectionString);

        Class.forName("com.mysql.jdbc.Driver");//Welcher Driver wird benutzt
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        //Verbindungsaufbau zur Datenbank kann über die Klasse DriverManager erfolgen
        return dbConnection;

    }
    public void shutDown() throws SQLException {
        if(dbConnection !=null){ //wenn dbConnection nicht gleich null
            dbConnection.close();
        }
    }
    public void signUpUser(User user){
        String insert = "INSERT INTO " + Constant.USER + "(" +     // Insert user in DB
                Constant.USERNAME + "," +
                Constant.EMAIL + "," +
                Constant.PASSWORD + "," +
                Constant.CREDITIONDATE + "," +
                Constant.PASSWORD_RESET + "," +
                Constant.USER_TOKEN + "," +
                Constant.TOKEN_TIMESTAMP + "," +
                Constant.IS_DELETED + ")" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";//anstatt "?" werden die Werte gesetzt
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(insert);//mit prepairedStatemnent die Werten angesetzt
            prST.setString(1, user.getUsername());;
            prST.setString(2, user.getEmail());
            prST.setString(3, user.getPassword());
            prST.setString(4, user.getCreationdate());
            prST.setString(5, user.getPassword_reset());
            prST.setString(6, user.getUser_token());
            prST.setString(7, user.getToken_timestamp());
            prST.setString(8, user.getIs_deleted());
            int result = prST.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM" + Constant.USER + "(" +
                Constant.USERNAME + "," +
                Constant.EMAIL + "," +
                Constant.PASSWORD + "," +
                Constant.CREDITIONDATE + "," +
                Constant.PASSWORD_RESET + "," +
                Constant.USER_TOKEN + "," +
                Constant.TOKEN_TIMESTAMP + "," +
                Constant.IS_DELETED + "," + ")";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setString(1, user.getUsername());
            prST.setString(2, user.getPassword());
            resultSet=prST.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
