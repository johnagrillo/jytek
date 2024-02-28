module org.jytek.leaguemanager {
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires com.healthmarketscience.jackcess;
    requires org.apache.commons.lang3;
    requires javafx.graphics;
    requires javafx.controls;
    opens org.jytek.leaguemanager to javafx.fxml,javafx.base,javafx.controls,javafx.graphics;
    opens org.jytek.leaguemanager.view to javafx.base;
    opens org.jytek.leaguemanager.controller to javafx.fxml;
    exports org.jytek.leaguemanager;
}