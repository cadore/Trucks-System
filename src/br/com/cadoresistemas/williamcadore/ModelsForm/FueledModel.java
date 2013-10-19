package br.com.cadoresistemas.williamcadore.ModelsForm;

import java.util.Date;

public class FueledModel {
    private Long id;
    private Long id_freigth;
    private Long id_business;
    private Long id_truck;
    private Date date;
    private String station;
    private String city;
    private Long uf;
    private Double km;
    private Double liters;
    private Double rs_liter;
    private Double total;
    private Date created_at;
    private Date updated;
    private boolean inactive;
    private Double discount;
    private Double sub_total;

 public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFreight() {
        return id;
    }

    public void setIdFreight(Long idFreight) {
        this.id = idFreight;
    }

    public Long getIdTruck() {
        return id_truck;
    }

    public void setIdTruck(Long idTruck) {
        this.id_truck = idTruck;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date Date) {
        this.date = Date;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String Station) {
        this.station = Station;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String City) {
        this.city = City;
    }

    public Long getUf() {
        return uf;
    }

    public void setUf(Long Uf) {
        this.uf = Uf;
    }
    public Double getKm() {
        return km;
    }

    public void setKm(Double Km) {
        this.km = Km;
    }


    public Double getLiters() {
        return liters;
    }

    public void setLiters(Double Liters) {
        this.liters = Liters;
    }


    public Double getRs_liter() {
        return rs_liter;
    }

    public void setRs_liter(Double Rs_liter) {
        this.rs_liter = Rs_liter;
    }


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double Total) {
        this.total = Total;
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

    public void setInacctive(boolean Inactive) {
        this.inactive = Inactive;
    }

    public Long getId_business(){
        return id_business;
    }

    public void setId_business(Long id_business){
        this.id_business = id_business;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(Double sub_total) {
        this.sub_total = sub_total;
    }
}
