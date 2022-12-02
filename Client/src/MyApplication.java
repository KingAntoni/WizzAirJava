import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Model;
import model.ModelManager;
import view.ViewHandler;
import viewModel.UserListViewModel;
import viewModel.ViewModelFactory;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Model model = new ModelManager("Bob","George");
        UserListViewModel userListViewModel = new UserListViewModel(model);
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);




        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);

        stage.setOnCloseRequest((WindowEvent event1) -> {
            model.removeUserClient();
            model.removeUserEmployee();
        });
    }
}
