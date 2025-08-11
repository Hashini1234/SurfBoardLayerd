module org.example.surfboardlayerd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;

    opens org.example.surfboardlayerd to javafx.fxml;
    opens org.example.surfboardlayerd.controller to javafx.fxml;

    exports org.example.surfboardlayerd;
    exports org.example.surfboardlayerd.controller;
}
