package view.UsersView.SelectUserTypeView;

import javafx.scene.layout.Region;
import view.ViewHandler;
import viewModel.UserTypeViewModel;

public class UserType {
    private Region root;
    private ViewHandler viewHandler;
    private UserTypeViewModel viewModel;

    public void init(ViewHandler viewHandler, UserTypeViewModel userTypeViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.root = root;
        this.viewModel = userTypeViewModel;
    }

    public Region getRoot() {
        return root;
    }
    public void reset()
    {

    }
}
