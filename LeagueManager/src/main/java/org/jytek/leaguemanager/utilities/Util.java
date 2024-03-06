package org.jytek.leaguemanager.utilities;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;

import java.util.List;

public class Util {


    public static String strokeToString(Short stroke) {
        return switch (stroke) {
            case 1 -> "Free";
            case 2 -> "Back";
            case 3 -> "Breast";
            case 4 -> "Fly";
            case 5 -> "IM";
            default -> "Other";
        };

    }

    public static void setPropertyValueFactory(List<Pair<TableColumn<?,?>, String>> pairs) {
        for (Pair<TableColumn<?,?>, String> pair : pairs) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }

    }
    public static void setPVF(TableColumn<?,?> tc, String prop) {
            tc.setCellValueFactory(new PropertyValueFactory<>(prop));
        }
    }





