package br.com.cadoresistemas.williamcadore.ModelsForm;

import java.util.Date;

public class UserModel {
    Long id;
    Long id_business;
    String fullName;
    String contact;
    String email;
    Date birthdate;
    String login;
    String password;
    private boolean admin;
    private boolean inactiveUser;
    private boolean reports;
    Date created_at;
    Date updated;
    boolean inactive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_Business() {
        return id_business;
    }

    public void setId_Business(Long id_Business) {
        this.id_business = id_Business;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getInactiveUser() {
        return inactiveUser;
    }

    public void setInactiveUser(boolean inactiveUser) {
        this.inactiveUser = inactiveUser;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date Created_at) {
        this.created_at = Created_at;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date Updated) {
        this.updated = Updated;
    }

    public boolean getInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean getReports() {
        return reports;
    }

    public void setReports(boolean reports) {
        this.reports = reports;
    }
}
