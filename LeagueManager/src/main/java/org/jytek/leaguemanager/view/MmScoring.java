package org.jytek.leaguemanager.view;

import org.jytek.leaguemanager.database.KeyValue;
import com.healthmarketscience.jackcess.Row;
import java.util.*;

/**
 * parsed from mdb-schema
 * CREATE TABLE [Scoring]
 * (
 * [score_divno]			Integer,
 * [score_sex]			Text (2),
 * [score_place]			Integer,
 * [ind_score]			Single,
 * [rel_score]			Single
 * );
 */
public class MmScoring implements KeyValue<Integer, MmScoring> {

    /**
     * Name of Table
     **/
    public static final String NAME = "Scoring";

    /**
     * Private Constructor
     **/
    private MmScoring() {
    }

    /**
     * Read MmScoring object from Row.
     * Intellij shows this warning:
     * Direct access to non-public field 'xxx' of another object
     *
     * @param row from jackcess database
     * @return MmScoring
     **/
    public static MmScoring read(final Row row){
        final var obj = new MmScoring();
        obj.scoreDivno = (Short) row.get(MmScoring.SCORE_DIVNO);
        obj.scoreSex = (String) row.get(MmScoring.SCORE_SEX);
        obj.scorePlace = (Short) row.get(MmScoring.SCORE_PLACE);
        obj.indScore = (Float) row.get(MmScoring.IND_SCORE);
        obj.relScore = (Float) row.get(MmScoring.REL_SCORE);
        return obj;
    }

    public MmScoring getValue(){
        return this;
    }

    public Integer getKey(){
        return scoreDivno.intValue();
    }


    // 
    // Column names
    //
    public static final String SCORE_DIVNO = "score_divno";
    public static final String SCORE_SEX = "score_sex";
    public static final String SCORE_PLACE = "score_place";
    public static final String IND_SCORE = "ind_score";
    public static final String REL_SCORE = "rel_score";
    // 
    // members
    //
    private Short scoreDivno = null;
    private String scoreSex = null;
    private Short scorePlace = null;
    private Float indScore = null;
    private Float relScore = null;

    //
    // getters
    //

    /**
     * Getter for scoreDivno
     * @return Short
     */
    public Short getscoreDivno() {
        return scoreDivno;
    }

    /**
     * Getter for scoreSex
     * @return String
     */
    public String getscoreSex() {
        return scoreSex;
    }

    /**
     * Getter for scorePlace
     * @return Short
     */
    public Short getscorePlace() {
        return scorePlace;
    }

    /**
     * Getter for indScore
     * @return Float
     */
    public Float getindScore() {
        return indScore;
    }

    /**
     * Getter for relScore
     * @return Float
     */
    public Float getrelScore() {
        return relScore;
    }
}
/* FXML 
<TableView fx:id=tvMmScoring" layoutX="16.0" layoutY="100.0" prefHeight="513.0" prefWidth="548.0">
  <columns>
    <TableColumn fx:id="tcMmScoringscore_divno" prefWidth="150.0" sortable="true" text="score_divno" />
    <TableColumn fx:id="tcMmScoringscore_sex" prefWidth="150.0" sortable="true" text="score_sex" />
    <TableColumn fx:id="tcMmScoringscore_place" prefWidth="150.0" sortable="true" text="score_place" />
    <TableColumn fx:id="tcMmScoringind_score" prefWidth="150.0" sortable="true" text="ind_score" />
    <TableColumn fx:id="tcMmScoringrel_score" prefWidth="150.0" sortable="true" text="rel_score" />
</columns>
</TableView>
*/



/* Controller 
@FXML
private TableView<MmScoring> tvMmScoring;
@FXML
private TableColumn<MmScoring,Short> tcMmScoringscore_divno;
@FXML
private TableColumn<MmScoring,String> tcMmScoringscore_sex;
@FXML
private TableColumn<MmScoring,Short> tcMmScoringscore_place;
@FXML
private TableColumn<MmScoring,Float> tcMmScoringind_score;
@FXML
private TableColumn<MmScoring,Float> tcMmScoringrel_score;
*/



/* Populate  Data 



for (Pair<TableColumn, String> pair : Arrays.asList(
new Pair(tcscore_divno,"score_divno"),
    new Pair(tcscore_sex,"score_sex"),
    new Pair(tcscore_place,"score_place"),
    new Pair(tcind_score,"ind_score"),
    new Pair(tcrel_score,"rel_score")
)) {
 pair.getKey().setCellValueFactory(new PropertyValueFactory<>(pair.getValue()));  }
*/
