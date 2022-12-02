package viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

import java.util.ArrayList;

public class UserListViewModel {
    private Model model;
    private ObservableList<String> items;
    public UserListViewModel(Model model)
    {
        this.model = model;
        this.items = FXCollections.observableArrayList();
    }

    public ObservableList<String> getItemsClient()
    {
        System.out.println("Property change for client list fired");
        items.clear();
        ArrayList<String> list = model.getUserListClient();
        for(int i=0;i<list.size();i++)
            items.add((list.get(i)));
        return items;
    }
    public ObservableList<String> getItemsEmployee()
    {
        System.out.println("Property change for employee list fired");
        items.clear();
        ArrayList<String> list = model.getUserListEmployee();
        for(int i=0;i<list.size();i++)
            items.add((list.get(i)));
        return items;
    }


}
