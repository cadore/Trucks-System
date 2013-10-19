package br.com.cadoresistemas.williamcadore.ModelsForm;

import java.util.Date;

public class LogsModel {

   Long id;
   Long id_business;
   String login;
   Date date;
   boolean valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String Login) {
        this.login = Login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean Valid) {
        this.valid = Valid;
    }

    public Long getId_business(){
        return id_business;
    }

    public void setId_business(Long id_business){
        this.id_business = id_business;
    }
}
