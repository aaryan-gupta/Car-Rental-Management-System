package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPwd;

    @FXML
    void doLogin(ActionEvent event) {
    	String uidString = txtLogin.getText();
    	String pwdString = txtPwd.getText();
    	try {
			ps = connection.prepareStatement("select * from login where uid=? and pwd=?");
			ps.setString(1, uidString);
			ps.setString(2, pwdString);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()) {
				try {
					Parent rootParent = FXMLLoader.load(getClass().getClassLoader().getResource("dashboard/Dashboard.fxml"));
					Scene scene = new Scene(rootParent);
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.show();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				txtLogin.setText("");
				txtPwd.setText("");
			}
			else System.out.println("INVALID");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    Connection connection;
    PreparedStatement ps;

    @FXML
    void initialize() {
        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtPwd != null : "fx:id=\"txtPwd\" was not injected: check your FXML file 'Login.fxml'.";
        connection = Connect.getConnection();
    }
}
