package driversControlPanel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class Drivers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtMobile;

    @FXML
    private ImageView aadhar;

    @FXML
    private ImageView licence;

    @FXML
    private TextArea txtAddress;

    @FXML
    private Label lblAadhar;

    @FXML
    private Label lblDL;

    @FXML
    void doClear(ActionEvent event) {
    	txtName.clear();
    	txtMobile.clear();
    	txtAddress.clear();
    	lblAadhar.setText("");
    	lblDL.setText("");
    	aadhar.setImage(null);
    	licence.setImage(null);
    }

    @FXML
    void doDelete(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("delete from drivers where mobile=?");
			ps.setString(1, txtMobile.getText());
			ps.executeUpdate();
			System.out.println("DELETED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doSave(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("insert into drivers (name, mobile, address, dl, uid) values (?, ?, ?, ?, ?)");
			ps.setString(1, txtName.getText());
			ps.setString(2, txtMobile.getText());
			ps.setString(3, txtAddress.getText());
			ps.setString(4, aadharPath);
			ps.setString(5, dlPath);
			ps.executeUpdate();
			System.out.println("SAVED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doSearch(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("select * from drivers where mobile=?");
			ps.setString(1, txtMobile.getText());
	    	ResultSet set = ps.executeQuery();
	    	if(set.next()) {
	    		txtName.setText(set.getString("name"));
	    		txtMobile.setText(set.getString("mobile"));
	    		txtAddress.setText(set.getString("address"));
	    		try {
					FileInputStream fileInputStream = new FileInputStream(set.getString("uid"));
					Image image = new Image(fileInputStream);
					aadhar.setImage(image);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	    		try {
					FileInputStream fileInputStream = new FileInputStream(set.getString("dl"));
					Image image = new Image(fileInputStream);
					licence.setImage(image);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	    	}
	    	else System.out.println("INVALID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doUpdate(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("update drivers set name=?, address=?, dl=?, uid=? where mobile=?");
			ps.setString(1, txtName.getText());
			ps.setString(2, txtAddress.getText());
			ps.setString(3, dlPath);
			ps.setString(4, aadharPath);
			ps.setString(5, txtMobile.getText());
			ps.executeUpdate();
			System.out.println("UPDATED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doUploadAadhar(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	File file = fileChooser.showOpenDialog(null);
    	aadharPath = file.getAbsolutePath();
    	FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	Image image = new Image(fileInputStream);
    	aadhar.setImage(image);
    }

    @FXML
    void doUploadDL(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	File file = fileChooser.showOpenDialog(null);
    	dlPath = file.getAbsolutePath();
    	FileInputStream fileInputStream = null;
    	try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	Image image = new Image(fileInputStream);
    	licence.setImage(image);
    }
    
    Connection connection;
    PreparedStatement ps;
    String aadharPath, dlPath;

    @FXML
    void initialize() {
    	assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'Drivers.fxml'.";
        assert txtMobile != null : "fx:id=\"txtMobile\" was not injected: check your FXML file 'Drivers.fxml'.";
        assert aadhar != null : "fx:id=\"aadhar\" was not injected: check your FXML file 'Drivers.fxml'.";
        assert licence != null : "fx:id=\"licence\" was not injected: check your FXML file 'Drivers.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'Drivers.fxml'.";
        assert lblAadhar != null : "fx:id=\"lblAadhar\" was not injected: check your FXML file 'Drivers.fxml'.";
        assert lblDL != null : "fx:id=\"lblDL\" was not injected: check your FXML file 'Drivers.fxml'.";
        connection = Connect.getConnection();
    }
}
