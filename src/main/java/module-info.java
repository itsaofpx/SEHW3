module ku.cs.register {
    requires javafx.controls;
    requires javafx.fxml;


    opens ku.cs.register to javafx.fxml;
    exports ku.cs.register;
}