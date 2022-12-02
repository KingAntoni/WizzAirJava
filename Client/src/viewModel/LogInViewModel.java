package viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class LogInViewModel {
    private StringProperty usernameProperty;
    private StringProperty passwordProperty;
    private Model model;
    public LogInViewModel(Model model)
    {
        this.passwordProperty=new SimpleStringProperty();
        this.usernameProperty=new SimpleStringProperty();
        this.model=model;
    }

    public StringProperty getPasswordProperty() {
        return passwordProperty;
    }

    public StringProperty getUsernameProperty() {
        return usernameProperty;
    }

    public boolean login()
    {
       if(checkInfo())
       {
           //return model.login(usernameProperty.get(),passwordProperty.get()) ?
       }

           return false;

    }

    public boolean checkInfo()
    {
        if (passwordProperty.get().length()==0||usernameProperty.get().length()==0)
        {
            return false;
        }
        else {
            return true;
        }
    }
}
