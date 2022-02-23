package customersDisplayBoard;

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

public class CustomersDB {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<UserBeanCustomers> tblRecords;

    @FXML
    void doBillPaid(ActionEvent event) {
    	TableColumn<UserBeanCustomers, String> MobileColumn = new TableColumn<UserBeanCustomers, String>("Mobile");
    	MobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	MobileColumn.setMinWidth(100);
    	
    	getFetchPaid();
    	
    	tblRecords.getColumns().clear();
    	tblRecords.getColumns().addAll(MobileColumn);
    	ObservableList<UserBeanCustomers> list = getFetchPaid();
    	tblRecords.setItems(list);
    }
    
    ObservableList<UserBeanCustomers> getFetchPaid() {
    	list = FXCollections.observableArrayList();
    	try {
    		ps = connection.prepareStatement("select * from billing where status=1 ");
    		ResultSet set = ps.executeQuery();
    		while(set.next()) {
    			String mobileString = set.getString("customersMobile");
    			int status = set.getInt(String.valueOf("status"));
    			UserBeanCustomers bean = new UserBeanCustomers(mobileString, status);
    			list.add(bean);
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
		}
    	return list;
    }

    @FXML
    void doBillUnpaid(ActionEvent event) {
    	TableColumn<UserBeanCustomers, String> MobileColumn = new TableColumn<UserBeanCustomers, String>("Mobile");
    	MobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	MobileColumn.setMinWidth(100);
    	
    	getFetchUnPaid();
    	
    	tblRecords.getColumns().clear();
    	tblRecords.getColumns().addAll(MobileColumn);
    	ObservableList<UserBeanCustomers> list = getFetchUnPaid();
    	tblRecords.setItems(list);
    }
    
    ObservableList<UserBeanCustomers> getFetchUnPaid() {
    	list = FXCollections.observableArrayList();
    	try {
    		ps = connection.prepareStatement("select * from billing where status=0");
    		ResultSet set = ps.executeQuery();
    		while(set.next()) {
    			String mobileString = set.getString("customersMobile");
    			int status = set.getInt(String.valueOf("status"));
    			UserBeanCustomers bean = new UserBeanCustomers(mobileString, status);
    			list.add(bean);
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
		}
    	return list;
    }

    @FXML
    void doShowAll(ActionEvent event) {
    	TableColumn<UserBeanCustomers, Integer> cidColumn = new TableColumn<UserBeanCustomers, Integer>("Customer's ID");
    	cidColumn.setCellValueFactory(new PropertyValueFactory<>("cid"));
    	cidColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanCustomers, String> nameColumn = new TableColumn<UserBeanCustomers, String>("Name");
    	nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    	nameColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanCustomers, String> MobileColumn = new TableColumn<UserBeanCustomers, String>("Mobile");
    	MobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	MobileColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanCustomers, String> addressColumn = new TableColumn<UserBeanCustomers, String>("Address");
    	addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    	addressColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanCustomers, String> dateColumn = new TableColumn<UserBeanCustomers, String>("Date");
    	dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    	dateColumn.setMinWidth(100);
    	
    	TableColumn<UserBeanCustomers, String> timeColumn = new TableColumn<UserBeanCustomers, String>("Time");
    	timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
    	timeColumn.setMinWidth(100);

    	TableColumn<UserBeanCustomers, String> destinationColumn = new TableColumn<UserBeanCustomers, String>("Destination");
    	destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
    	destinationColumn.setMinWidth(100);

    	TableColumn<UserBeanCustomers, Integer> daysColumn = new TableColumn<UserBeanCustomers, Integer>("Days");
    	daysColumn.setCellValueFactory(new PropertyValueFactory<>("days"));
    	daysColumn.setMinWidth(100);

    	TableColumn<UserBeanCustomers, Integer> requirementColumn = new TableColumn<UserBeanCustomers, Integer>("Car");
    	requirementColumn.setCellValueFactory(new PropertyValueFactory<>("requirement"));
    	requirementColumn.setMinWidth(100);
    	
    	getFetchRecords();
    	
    	tblRecords.getColumns().clear();
    	tblRecords.getColumns().addAll(cidColumn, nameColumn, MobileColumn, addressColumn, dateColumn, timeColumn, destinationColumn, daysColumn, requirementColumn);
    	ObservableList<UserBeanCustomers> list = getFetchRecords();
    	tblRecords.setItems(list);
    }
    
    ObservableList<UserBeanCustomers> getFetchRecords() {
    	list = FXCollections.observableArrayList();
    	try {
    		ps = connection.prepareStatement("select * from customers");
    		ResultSet set = ps.executeQuery();
    		while(set.next()) {
    			int cid = set.getInt(String.valueOf("cid"));
    			String nameString = set.getString("name");
    			String mobileString = set.getString("mobile");
    			String addressString = set.getString("address");
    			String dateString = set.getString("date");
    			String timeString = set.getString("time");
    			String destinationString = set.getString("destination");
    			int days = set.getInt(String.valueOf("days"));
    			String requirementString = set.getString("requirement");
    			UserBeanCustomers bean = new UserBeanCustomers(cid, nameString, mobileString, addressString, dateString, timeString, destinationString, days, requirementString);
    			list.add(bean);
    		}
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
		}
    	return list;
    }
    
    Connection connection;
    PreparedStatement ps;
    ObservableList<UserBeanCustomers> list;

    @FXML
    void initialize() {
        assert tblRecords != null : "fx:id=\"tblRecords\" was not injected: check your FXML file 'CustomersDB.fxml'.";
        connection = Connect.getConnection();
    }
}
