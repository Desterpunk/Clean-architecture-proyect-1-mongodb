package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;

public class UserMessage {

    public UserMessage() {
    }

    public String setEnMessage(User user){
        if (user.getUserAction().equalsIgnoreCase("saludar")){
            return "Hi mr/ms " + user.getUserName();
        }
        if (user.getUserAction().equalsIgnoreCase("nombre")){
            return "Your name is " + user.getUserName();
        }
        if (user.getUserAction().equalsIgnoreCase("despedir")){
            return "Goodbye mr/ms " + user.getUserName();
        }
        return "We don't have that action yet, sorry :)";
    }

    public String setEsMessage(User user){
        if (user.getUserAction().equalsIgnoreCase("saludar")){
            return "Hola " + user.getUserName();
        }
        if (user.getUserAction().equalsIgnoreCase("nombre")){
            return "Su nombre es " + user.getUserName();
        }
        if (user.getUserAction().equalsIgnoreCase("despedir")){
            return "Hasta luego " + user.getUserName();
        }
        return "No tenemos esa acción aún, Mil disculpas :)";
    }

}
