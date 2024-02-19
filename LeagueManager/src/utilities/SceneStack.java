package utilities;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class SceneStack {
    private static Stage stage_;
    private final Stage stage;

    private static Stack<Pair<Scene, String>> scenes = new Stack<>();

    private static SceneStack vs;

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 750;


    private SceneStack(final Stage stage) {
        this.stage = stage;
    }


    public static void start(Stage stage) {
        SceneStack.stage_ = stage;

    }


    public static void setStage(Stage stage) {
        stage_ = stage;
    }


    public static synchronized FXMLLoader pushView(String view, String title, int w, int h) {
        final String path = view;

        if (null == SceneStack.vs) {
            vs = new SceneStack(stage_);
        }

        final FXMLLoader fxmlLoader = new FXMLLoader(vs.getClass().getResource(path));
        final Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), w, h);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage_.setScene(scene);
        stage_.setTitle("League Manager: " + title);
        stage_.show();
        scenes.push(new Pair<Scene, String>(scene, title));
        return fxmlLoader;
    }

    public static synchronized void popView() {
        try {
            Pair<Scene, String> popped = scenes.pop();

            Scene parent = scenes.peek().getKey();
            String title = scenes.peek().getValue();

            stage_.setScene(parent);
            stage_.show();
            stage_.setTitle(title);

        } catch (final EmptyStackException e) {
            // happens when running standalone
        }
    }
}


//public static void pushLogin() {
//    pushView("login.fxml", "public search page");
//}