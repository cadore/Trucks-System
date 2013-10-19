package br.com.cadoresistemas.williamcadore.ModelsForm;

import java.util.Date;

public class BusinessModel {

    private Long id;
    private Long number_of_trucks;
    private String corporate_name;
    private String fantasy_name;
    private String cnpj;
    private String state_registration;
    private String observation;
    private Date created_at;
    private Date update_at;
    private Long uf;
    private Long type;
    private String adress;
    private String email;
    private String district;
    private String phone;
    private String phone2;
    private String phone3;
    private String city;
    private String cep;
    private boolean inactive;
    private boolean inactive_business;
    private Date date_expiry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorporate_name() {
        return corporate_name;
    }

    public void setCorporate_name(String corporate_name) {
        this.corporate_name = corporate_name;
    }

    public String getFantasy_name() {
        return fantasy_name;
    }

    public void setFantasy_name(String fantasy_name) {
        this.fantasy_name = fantasy_name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getState_registration() {
        return state_registration;
    }

    public void setState_registration(String state_registration) {
        this.state_registration = state_registration;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public Long getUf() {
        return uf;
    }

    public void setUf(Long uf) {
        this.uf = uf;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean isInactive_business() {
        return inactive_business;
    }

    public void setInactive_business(boolean inactive_business) {
        this.inactive_business = inactive_business;
    }

    public Long getNumber_of_trucks() {
        return number_of_trucks;
    }

    public void setNumber_of_trucks(Long number_of_trucks) {
        this.number_of_trucks = number_of_trucks;
    }

    public Date getDate_expiry() {
        return date_expiry;
    }

    public void setDate_expiry(Date date_expiry) {
        this.date_expiry = date_expiry;
    }
}