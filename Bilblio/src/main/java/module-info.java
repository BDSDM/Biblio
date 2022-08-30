module com.destin.bilblio {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
requires org.hibernate.orm.core;
    requires java.desktop;

    opens com.destin.bilblio;


    exports com.destin.bilblio;
}