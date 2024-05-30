package fr.diginamic.props;

import java.util.ResourceBundle;

public class TestConfigurationProps {
  public static void main(String[] args) {
    ResourceBundle config = ResourceBundle.getBundle("application");
    String url = config.getString("database.url");

    System.out.println(url);
  }
}
