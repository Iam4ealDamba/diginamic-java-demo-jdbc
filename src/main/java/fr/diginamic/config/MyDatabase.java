package fr.diginamic.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class MyDatabase {
  public Connection connection;

  public MyDatabase() {
    connect();
  }

  private void connect() {
    ResourceBundle config = ResourceBundle.getBundle("application");
    String url = config.getString("database.url");
    String user = config.getString("database.user");
    String pwd = config.getString("database.password");

    Properties props = new Properties();
    props.setProperty("user", user);
    props.setProperty("password", pwd);
    props.setProperty("useSSL", "false");

    try {
      this.connection = DriverManager.getConnection(url, props);
    } catch (SQLException e) {
      System.out.println("An error occured on DB connection: " + e.getMessage());
    }
  }

  public void close() {
    try {
      this.connection.close();
      System.out.println("DB connection closed");
    } catch (SQLException e) {
      System.out.println("An error occured on DB close: " + e.getMessage());
    }
  }

  public Connection getConnection() {
    return this.connection;
  }
}
