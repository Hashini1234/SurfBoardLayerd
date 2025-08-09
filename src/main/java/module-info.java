module org.example.surfboardlayerd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;


    opens org.example.surfboardlayerd to javafx.fxml;
    exports org.example.surfboardlayerd;
}