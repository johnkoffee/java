package roman.taska4;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DB {
    private String defaultHost = "jdbc:postgresql://localhost:5432/javadb";//postgres";
    private String defaultLogin = "postgres";
    private String defaultPassword = "1";
    
    
    private Connection connection = null;
    private Statement statement = null;
    
    private Boolean loggined = false;
    private String login = "";
    
    public DB(){
        try{
            Class.forName("org.postgresql.Driver").newInstance();
        } catch(Exception e) {
            System.out.println("ERROR: Connector driver is missing.\n" + e.getMessage());
        }
        try{
            connection = DriverManager.getConnection(defaultHost, defaultLogin, defaultPassword);
        } catch(SQLException e) {
            System.out.println("ERROR: Connection to DB.\n" + e.getMessage());
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR: Can't create statement");
        }
    }
    
    public void ClearDB(){
        if (connection == null) {
            System.out.println("ERROR: You did not connect to database");
            return;
        }

        try {		
            String query = "DELETE FROM "
                            + "users ";
            statement.executeUpdate(query);
            System.out.println("DataBase was cleaned.");
        } catch (SQLException e) {
            System.out.println( "ERROR: " + e.getMessage() );
        }
        //DELETE FROM users
        //WHERE <condition>;
    }
    public void Register(String login, String password, String fio, String message){
        if (connection == null) {
            System.out.println("ERROR: You did not connect to database");
            return;
        }

        long currentTime = System.currentTimeMillis();
        String updateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
        try {		
            String query = "INSERT INTO "
                            + "users "
                            + "(login, password, fio, message, lastlogintime) "
                            + "VALUES "
                            + "('" + login.hashCode() + "', " + password.hashCode() + ", '" + fio + "', '"+ message + "', '" + updateTime + "')";
            statement.executeUpdate(query);
            System.out.println("Registered new USER: " + login);
        } catch (SQLException e) {
            System.out.println( "ERROR: " + e.getMessage() );
        }
    }
    public void Login(String login, String password){
        if (connection == null) {
            System.out.println("ERROR: You did not connect to database");
            return;
        }

        ResultSet users;
        try {
            users = statement.executeQuery(""
                    + "SELECT login "
                    + "FROM users "
                    + "WHERE "
                    + "login = " + login.hashCode() + " AND " 
                    + "password = " + password.hashCode() + "");	
            if (users.next()) {
                long currentTime = System.currentTimeMillis(); 
                String updateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);

                String query = ""
                        + "UPDATE users SET lastlogintime = '" + updateTime + "' "
                        + "WHERE login = " + login.hashCode() + "";
                statement.executeUpdate(query);
                System.out.println("Loggined USER: " + login);
                this.login = login;
                loggined = true;
            }else{
                System.out.println("ERROR: There is no combination with this login '" + login + "' and password");
            }
            users.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());		
        }
    }
    public void Logout(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public Boolean GetLoggined(){
        return this.loggined;
    }
    
    public String TopByTime(Integer count, Boolean last){
        if (connection == null) {
            System.out.println("ERROR: You did not connect to database");
            return "";
        }
        String res = "";
        ResultSet request;
        try {
            request = statement.executeQuery(""
                    + "SELECT fio, lastlogintime "
                    + "FROM users "
                    + "ORDER BY lastlogintime " + (last ? "desc" : "") );
            System.out.println("TOP " + count + " " +(last ? "LATEST" : "OLDEST") + " USERS:");
            Integer i = 0;
            while (request.next() && i < count) {
                    res +=((i + 1) + ". " + request.getString("fio")+ " > " + request.getString("lastlogintime"));
                    res += "\r\n";
                    i++;
            }			
            request.close();
        } catch (SQLException e) {
            System.out.println("ERROR: Can't do show");
        }	
        System.out.print(res);
        return res;
    }
    public Integer DisplayCount(){
        if (connection == null) {
            System.out.println("ERROR: You did not connect to database");
            return -1;
        }

        ResultSet request;
        int count = 0;
        try {
            request = statement.executeQuery(""
                    + "SELECT COUNT(*) as total "
                    + "FROM users ");		
            while (request.next()){
                count = request.getInt("total");
                System.out.println("Users count = " + count);
            }		
            request.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            return -1;
        }		
        return count;
    }
    public String DisplayMessage(){
        if (connection == null) {
            System.out.println("ERROR: You did not connect to database");
            return "";
        }
        String res = "";
        
        ResultSet users;
        try {
            users = statement.executeQuery(""
                    + "SELECT message "
                    + "FROM users "
                    + "WHERE "
                    + "login = " + this.login.hashCode());	
            if (users.next()) {
                res += ( "Message: " );
                res += "\r\n";
                res += ( users.getString("message") );
                res += "\r\n";
            }
            users.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());		
        }
        System.out.print(res);
        return res;
    }
    public void DisplayAllMessage(){
        if (connection == null) {
            System.out.println("ERROR: You did not connect to database");
            return;
        }

        ResultSet request;
        try {
            request = statement.executeQuery(""
                    + "SELECT fio, message "
                    + "FROM users ");
            while (request.next()) {
                    System.out.println("Message of " + request.getString("fio") + ": " + request.getString("message"));
            }	
            request.close();
        } catch (SQLException e) {
            System.out.println("ERROR: Can't do show");
        }
    }
    public void SetNewMessage(String message){
        if (connection == null) {
            System.out.println("ERROR: You did not connect to database");
            return;
        }

        ResultSet users;
        try {
            users = statement.executeQuery(""
                    + "SELECT login "
                    + "FROM users "
                    + "WHERE "
                    + "login = " + this.login.hashCode() );	
            if (users.next()) {
                String query = ""
                        + "UPDATE users SET message = '" + message + "' "
                        + "WHERE login = " + this.login.hashCode() + "";
                statement.executeUpdate(query);
            }
            users.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());		
        }
    }
}
