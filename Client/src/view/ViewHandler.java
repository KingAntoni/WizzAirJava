package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import view.LogInView.LogInView;
import view.MenuView.CustomersMenu.CreateBookingView.CreateBooking;
import view.MenuView.CustomersMenu.MenuCustomers;
import view.MenuView.EmployeeMenu.MenuEmployees;
import view.UsersView.CreateCustomerAccountView.CustomerAccount;
import view.UsersView.CreateEmployeeAccountView.EmployeeAccount;
import view.UsersView.SelectUserTypeView.UserType;
import view.UsersView.ShowListOfUsers.UserList;
import viewModel.ViewModelFactory;

public class ViewHandler {
    private Stage primaryStage;
    private Scene currentScene;

    private ViewModelFactory viewModelFactory;
    private CreateBooking createBooking;
    private UserList userList;
    private LogInView loginView;
    private MenuCustomers menuCustomers;
    private MenuEmployees menuEmployees;
    private UserType selectUserType;
    private CustomerAccount createCustomer;
    private EmployeeAccount createEmployee;



    public ViewHandler(ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.currentScene = new Scene(new Region());
        openView("logIn");
    }

    public void openView(String id)
    {
        Region root = null;

        switch (id) {
            case "logIn" -> root =loadLoginView("LogInView/LogInView.fxml");
            case "menuCustomers" -> root =loadBookingView("MenuCustomers.fxml");
            case "menuEmployees" ->root = loadBookingView("MenuEmployees.fxml");
            case "selectUserType" -> root =loadSelectUserTypeView("UsersView/SelectUserTypeView/UserType.fxml");
            case "createCustomer" -> root =loadBookingView("CustomerAccount.fxml");
            case "createEmployee" -> root =loadBookingView("EmployeeAccount.fxml");
            case "createBooking" ->root = loadBookingView("MenuView/CustomersMenu/CreateBookingView/CreateBooking.fxml");
        }
        currentScene.setRoot(root);

        String title = "logIn";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    private Region loadBookingView(String fxmlFile)
    {
        if (createBooking == null)
        {
            try
            {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                createBooking = loader.getController();
                createBooking.innit(this,  viewModelFactory.getBookingViewModel(), root);
            }
            catch (Exception e)
            {

                e.printStackTrace();
            }
        }
        else
        {
            createBooking.reset();
        }
        return createBooking.getRoot();
    }

    private Region loadUserListView(String fxmlFile)
    {
        if (userList == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                userList = loader.getController();
                userList.init(this, viewModelFactory.getUserListViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            userList.reset();
        }
        return userList.getRoot();
    }

    private Region loadLoginView(String fxmlFile)
    {
        if (loginView == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                loginView = loader.getController();
                loginView.init(this, viewModelFactory.getLogInViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            loginView.reset();
        }
        return loginView.getRoot();
    }

    private Region loadSelectUserTypeView(String fxmlFile)
    {
        if (selectUserType == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                selectUserType = loader.getController();
                selectUserType.init(this, viewModelFactory.getUserTypeViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            selectUserType.reset();
        }
        return selectUserType.getRoot();
    }
}
