package integrationPackage.utils;

import org.apache.logging.log4j.core.jmx.Server;

import java.sql.*;
import java.util.HashMap;

public class DB_Utilities {
    // Server server = Server.createTcpServer(args).start();
    public synchronized void getSqlResultInMap(String sql) throws SQLException, ClassNotFoundException {
      //  Server server = Server.createTcpServer(args).start();
        HashMap<String, String> data_map = new HashMap<>();
//HashMap<String, String>
//        try{
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
        conn.close();
    }
}
//            Connection con= DriverManager.getConnection(
//                    "jdbc:h2:tcp://localhost/~/testdb","sa","");
//spring.datasource.driverClassName=org.h2.Driver
//            //spring.datasource.url=jdbc:h2:mem:testdb
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery(sql);
//            ResultSetMetaData md = rs.getMetaData();
//
//            while (rs.next()) {
//                for (int i = 1; i <= md.getColumnCount(); i++) {
//                    data_map.put(md.getColumnName(i), rs.getString(i));
//                }
//            }
//            System.out.println(data_map);
//            con.close();
//        }catch(Exception e){ System.out.println(e);}
//        return data_map;
//    }
//                    "jdbc:h2:tcp://localhost/~/testdb","sa","");
//spring.datasource.driverClassName=org.h2.Driver
//        String jdbcURL = "jdbc:h2:mem://localhost:8010/~/testdb";
//        String username = "sa";
//        String password = "";
//
//        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
//        System.out.println("Connected to H2 in server mode.");
//
//        String sql1 = "SELECT * FROM students";
//
//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery(sql1);
//
//        int count = 0;
//
//        while (resultSet.next()) {
//            count++;
//
//            int ID = resultSet.getInt("ID");
//            String name = resultSet.getString("name");
//            System.out.println("Student #" + count + ": " + ID + ", " + name);
//        }
//
//        connection.close();
//    }



