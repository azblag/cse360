module cse360_A1_BlakeGuinn {
	requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.fxml;
    exports application;
}
