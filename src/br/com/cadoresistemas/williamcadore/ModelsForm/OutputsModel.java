package br.com.cadoresistemas.williamcadore.ModelsForm;

import java.util.Date;

public class OutputsModel {
    private Long id;
    private Long id_business;
    private Long id_freight;
    private Double value1;
    private Double value2;
    private Double value3;
    private Date date;
    private String paid;
    private String description;
    private Long id_truck;
    private Date created_at;
    private Date updated;
    private boolean inactive;
    private int qnt;

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

    public Long getId_freight() {
        return id_freight;
    }

    public void setId_freight(Long id_freight) {
        this.id_freight = id_freight;
    }

    public Double getValue1() {
        return value1;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    public Double getValue3() {
        return value3;
    }

    public void setValue3(Double value3) {
        this.value3 = value3;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId_truck() {
        return id_truck;
    }

    public void setId_truck(Long id_truck) {
        this.id_truck = id_truck;
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

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
}