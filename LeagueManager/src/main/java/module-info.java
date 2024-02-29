module org.jytek.leaguemanager {
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires com.healthmarketscience.jackcess;
    requires org.apache.commons.lang3;
    requires javafx.graphics;
    requires javafx.controls;
    opens org.jytek.leaguemanager to javafx.fxml,javafx.base,javafx.controls,javafx.graphics;
    exports org.jytek.leaguemanager;
    exports org.jytek.leaguemanager.utilities;
    opens org.jytek.leaguemanager.utilities to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    exports org.jytek.leaguemanager.controller;
    opens org.jytek.leaguemanager.controller to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
    exports org.jytek.leaguemanager.view;
    opens org.jytek.leaguemanager.view to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
}