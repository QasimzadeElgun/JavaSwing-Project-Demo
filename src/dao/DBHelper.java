
package dao;

import java.io.FileReader;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Properties;
public class DBHelper {

    public static Connection getConnection() throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("config.properties"));
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
//        Context context = new InitialContext();
//        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/CourseWeb");
//  Connection c = dataSource.getConnection();
        return c;
    }


}
