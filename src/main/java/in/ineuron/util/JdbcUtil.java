package in.ineuron.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//Using Hikaricp configuration for connection pooling
public class JdbcUtil {
    private JdbcUtil(){

    }
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getJdbcConnection() throws SQLException, IOException {
//        Getting connection through physical objects
//        Connection connection = PhysicalConnection();

        //HikariCP logical connection approach
        HikariConfig hikariConfig = new HikariConfig("src//main//java//in//ineuron//properties//db.properties");

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

        Connection connection = hikariDataSource.getConnection();

        return connection ;
    }
    @SuppressWarnings("unused")
    private  static Connection PhysicalConnection() throws IOException, SQLException {
        String url,username,password ;
        FileInputStream fis = new FileInputStream("src/main/java/in/ineuron/properties/db.properties");

        Properties properties = new Properties();
        properties.load(fis);
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        return DriverManager.getConnection(url,username,password);
    }
}
