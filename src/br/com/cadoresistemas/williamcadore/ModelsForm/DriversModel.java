package br.com.cadoresistemas.williamcadore.ModelsForm;

import java.util.Date;

public class DriversModel {
    private Long id;
    private Long id_business;
    private String full_name;
    private String cpf;
    private Date birthday;
    private String phone;
    private String phone2;
    private String phone3;
    private String addres;
    private String n_rg;
    private String n_cnh;
    private String n_register;
    private String category;
    private String n;
    private String district;
    private String city;
    private Long   uf;
    private String cep;
    private String sex;
    private Date created_at;
    private Date updated;
    private boolean inactive;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_business() {
        return id_business;
    }

    public void setId_business(Long id_business) {
        this.id_business = id_business;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getN_rg() {
        return n_rg;
    }

    public void setN_rg(String n_rg) {
        this.n_rg = n_rg;
    }

    public String getN_cnh() {
        return n_cnh;
    }

    public void setN_cnh(String n_cnh) {
        this.n_cnh = n_cnh;
    }

    public String getN_register() {
        return n_register;
    }

    public void setN_register(String n_register) {
        this.n_register = n_register;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getUf() {
        return uf;
    }

    public void setUf(Long uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public boolean getInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
