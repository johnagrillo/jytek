package org.jytek.leaguemanager.utilities;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;

import java.util.List;

public class Util {


    public static String strokeToString(Short stroke) {
        switch(stroke) {
            case 1:
                return "Free";
            case 2:
                return "Back";
            case 3:
                return "Breast";
            case 4:
                return "Fly";
            case 5:
                return "IM";
        }
        return "Other";

    }

    public static void setPropertyValueFactory(List<Pair<TableColumn, String>> pairs) {
        for (Pair<TableColumn, String> pair : pairs) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }
    }
}
