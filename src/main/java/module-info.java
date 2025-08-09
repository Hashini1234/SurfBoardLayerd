module org.example.surfboardlayerd {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.surfboardlayerd to javafx.fxml;
    exports org.example.surfboardlayerd;
}