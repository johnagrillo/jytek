package org.jytek.leaguemanager.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;
import org.jytek.leaguemanager.view.MmAthlete;
import org.jytek.leaguemanager.view.MmEvent;
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
    public static String strokeToString(String stroke) {
        return switch (stroke) {
            case "A" -> "Free";
            case "B" -> "Back";
            case "C" -> "Breast";
            case "D" -> "Fly";
            case "E" -> "IM";
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
    public static String eventToString(MmEvent ev) {
        return ev.getEventSex() + " " + + ev.getLowAge() + "-" + ev.getHighAge() + " " +
                Integer.toString((int) ev.getEventDist().doubleValue()) + " " +
                strokeToString(ev.getEventStroke());
    }

    public static String atheteToString(TmAthlete ath) {
        return  ath.getLast() + " " + ath.getFirst() + " " + ath.getInitial();
    }

    public static String atheteToString(MmAthlete ath) {
        return  ath.getLastName() + " " + ath.getFirstName() + " " + ath.getInitial();
    }


}
