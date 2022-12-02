package viewModel;

import model.Model;

public class ViewModelFactory {
    private CreateBookingViewModel createBookingViewModel;
    private UserListViewModel userListViewModel;
    private LogInViewModel logInViewModel;
    private UserTypeViewModel userTypeViewModel;
    public ViewModelFactory(Model model){
        this.createBookingViewModel =new CreateBookingViewModel(model);
        this.userListViewModel=new UserListViewModel(model);
        this.logInViewModel=new LogInViewModel(model);
        this.userTypeViewModel=new UserTypeViewModel(model);
    }

    public UserTypeViewModel getUserTypeViewModel() {
        return userTypeViewModel;
    }

    public CreateBookingViewModel getBookingViewModel() {
        return createBookingViewModel;
    }

    public UserListViewModel getUserListViewModel() {
        return userListViewModel;
    }

    public LogInViewModel getLogInViewModel() {
        return logInViewModel;
    }
}
