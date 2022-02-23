package driversDisplayBoard;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DriversDB {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<UserBeanDrivers> tblRecords;

    @FXML
    void doShowAll(ActionEvent event) {
    	TableColumn<UserBeanDrivers, Integer> didColumn = new TableColumn<UserBeanDrivers, Integer>("Driver's ID");
    	didColumn.setCellValueFactory(new PropertyValueFactory<>("did"));
    	didColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanDrivers, String> nameColumn = new TableColumn<UserBeanDrivers, String>("Name");
    	nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    	nameColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanDrivers, String> MobileColumn = new TableColumn<UserBeanDrivers, String>("Mobile");
    	MobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	MobileColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanDrivers, String> addressColumn = new TableColumn<UserBeanDrivers, String>("Address");
    	addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    	addressColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanDrivers, String> dlColumn = new TableColumn<UserBeanDrivers, String>("Driving License");
    	dlColumn.setCellValueFactory(new PropertyValueFactory<>("dl"));
    	dlColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanDrivers, String> uidColumn = new TableColumn<UserBeanDrivers, String>("Driver's UID");
    	uidColumn.setCellValueFactory(new PropertyValueFactory<>("uid"));
    	uidColumn.setMinWidth(100);
    	
    	getFetchRecords();
    	
    	tblRecords.getColumns().clear();
    	tblRecords.getColumns().addAll(didColumn, nameColumn, MobileColumn, addressColumn, dlColumn, uidColumn);
    	ObservableList<UserBeanDrivers> list = getFetchRecords();
    	tblRecords.setItems(list);
    	
    }
    
    ObservableList<UserBeanDrivers> getFetchRecords() {
    	list = FXCollections.observableArrayList();
    	try {
    		ps = connection.prepareStatement("select * from drivers");
    		ResultSet set = ps.executeQuery();
    		while(set.next()) {
    			int did = set.getInt(String.valueOf("did"));
    			String nameString = set.getString("name");
    			String mobileString = set.getString("mobile");
    			String addressString = set.getString("address");
    			String dlString = set.getString("dl");
    			String uidString = set.getString("uid");
    			UserBeanDrivers bean = new UserBeanDrivers(did, nameString, mobileString, addressString, dlString, uidString);
    			list.add(bean);
    		}
    	}
    	catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return list;
    }
    
    Connection connection;
    PreparedStatement ps;
    ObservableList<UserBeanDrivers> list;

    @FXML
    void initialize() {
        assert tblRecords != null : "fx:id=\"tblRecords\" was not injected: check your FXML file 'DriversDB.fxml'.";
        connection = Connect.getConnection();
    }
}
