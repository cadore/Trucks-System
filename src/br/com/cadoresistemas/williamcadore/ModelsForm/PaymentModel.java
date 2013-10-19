package br.com.cadoresistemas.williamcadore.ModelsForm;

import java.util.Date;

public class PaymentModel {
    private Long id;
    private Long id_business;
    private Long id_truck;
    private String payment;
    private String observation;
    private Date date_expiry;
    private Double valor;
    private String identify;
    private Date created_at;
    private Date updated;
    boolean inactive;
    boolean paid;
    private int qnt;
    private int qnt_paid;
    private int qnt_no_paid;
    private int qnt_expiry;
    private Double valor_paid;
    private Double valor_no_paid;
    private Double valor_expiry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_truck() {
        return id_truck;
    }

    public void setId_truck(Long id_truck) {
        this.id_truck = id_truck;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String Payment) {
        this.payment = Payment;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String Observation) {
        this.observation = Observation;
    }

    public Date getDate_expiry() {
        return date_expiry;
    }

    public void setDate_expiry(Date Date_expiry) {
        this.date_expiry = Date_expiry;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double Valor) {
        this.valor = Valor;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String Identify) {
        this.identify = Identify;
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

    public void setInactive(boolean Inactive) {
        this.inactive = Inactive;
    }

    public boolean getPaid() {
        return paid;
    }

    public void setPaid(boolean Paid) {
        this.paid = Paid;
    }

    public Long getId_business(){
        return id_business;
    }

    public void setId_business(Long id_business){
        this.id_business = id_business;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public int getQnt_paid() {
        return qnt_paid;
    }

    public void setQnt_paid(int qnt_paid) {
        this.qnt_paid = qnt_paid;
    }

    public int getQnt_no_paid() {
        return qnt_no_paid;
    }

    public void setQnt_no_paid(int qnt_no_paid) {
        this.qnt_no_paid = qnt_no_paid;
    }

    public Double getValor_paid() {
        return valor_paid;
    }

    public void setValor_paid(Double valor_paid) {
        this.valor_paid = valor_paid;
    }

    public Double getValor_no_paid() {
        return valor_no_paid;
    }

    public void setValor_no_paid(Double valor_no_paid) {
        this.valor_no_paid = valor_no_paid;
    }

    public int getQnt_expiry() {
        return qnt_expiry;
    }

    public void setQnt_expiry(int qnt_expiry) {
        this.qnt_expiry = qnt_expiry;
    }

    public Double getValor_expiry() {
        return valor_expiry;
    }

    public void setValor_expiry(Double valor_expiry) {
        this.valor_expiry = valor_expiry;
    }
}
