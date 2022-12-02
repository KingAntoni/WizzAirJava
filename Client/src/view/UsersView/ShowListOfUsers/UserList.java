package view.UsersView.ShowListOfUsers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import view.ViewHandler;
import viewModel.UserListViewModel;

public class UserList {
    @FXML
    ListView<String> userList;
    private Region root;

    private ViewHandler viewHandler;
    private UserListViewModel userListViewModel;

    public void init(ViewHandler viewHandler, UserListViewModel userListViewModel, Region root)
    {
        this.viewHandler = viewHandler;
        this.root = root;
        this.userListViewModel = userListViewModel;
        this.userList.setItems(userListViewModel.getItemsClient());
        this.userList.setItems(userListViewModel.getItemsEmployee());
    }

    public Region getRoot()
    {
        return root;
    }

    public void reset()
    {

    }
    public void getUserListClient(){
        userListViewModel.getItemsClient();
    }
    public void getUserListEmployee(){
        userListViewModel.getItemsEmployee();
    }

    private @FXML void onBack()
    {
        viewHandler.openView("userList");
    }
}
