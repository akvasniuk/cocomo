module com.example.cocomo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cocomo to javafx.fxml;
    exports com.example.cocomo;
}