module PRAKTIKUM7 {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics;
	opens model to javafx.base;
	
	opens controller to javafx.fxml;
	requires java.sql;
	
	exports application;
}
