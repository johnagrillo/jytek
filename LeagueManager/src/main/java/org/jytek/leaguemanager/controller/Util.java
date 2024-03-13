package org.jytek.leaguemanager.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;
import org.jytek.leaguemanager.view.TmAthlete;
import org.jytek.leaguemanager.view.TmMtevent;

import java.util.List;

public class Util {

    public static void setPropertyValueFactory(List<Pair<TableColumn<?,?>, String>> pairs) {
        for (Pair<TableColumn<?, ?>, String> pair : pairs) {
            pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));
        }
    }

    public static void setPVF(TableColumn<?,?> tc, String prop) {
        tc.setCellValueFactory(new PropertyValueFactory<>(prop));
    }

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
    /**
     * @param stroke
     * @return
     */

    public static String eventToString(TmMtevent mtev) {
        return  mtev.getSex() + " " + + mtev.getLohi() + " " + mtev.getDistance() + " " + strokeToString(mtev.getStroke());
    }

    public static String atheteToString(TmAthlete ath) {
        return  ath.getLast() + " " + ath.getFirst() + " " + ath.getInitial();
    }


}
