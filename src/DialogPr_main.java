import controller.HomeworkController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class DialogPr_main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        try{
            Parent root = FXMLLoader.load(getClass().getResource("/controller/main.fxml"));
            var scene = new Scene(root);
            this.primaryStage.setTitle("Отчетное задание по Основам программирования");
            this.primaryStage.setScene(scene);
            this.primaryStage.show();

            var hwc = new HomeworkController();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        launch(args);
    }
}
