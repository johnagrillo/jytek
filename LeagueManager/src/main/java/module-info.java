module org.jytek.leaguemanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires com.healthmarketscience.jackcess;
    requires org.apache.commons.lang3;
    opens org.jytek.leaguemanager to javafx.fxml;
    exports org.jytek.leaguemanager;
}