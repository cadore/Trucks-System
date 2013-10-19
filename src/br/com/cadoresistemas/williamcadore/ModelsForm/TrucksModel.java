package br.com.cadoresistemas.williamcadore.ModelsForm;

import java.util.Date;

public class TrucksModel {
    Long id;
    Long id_business;
    Long n_truck;
    String board;
    String board1;
    String board2;
    String board3;
    String color;
    String mark;
    String model;
    String n_chassi;
    String n_renavam;
    String year_fabrication;
    String year_fabrication1;
    String year_fabrication2;
    String year_fabrication3;
    String year_model;
    Long driver;
    Long traction;
    Date created_at;
    Date updated;
    boolean inactive;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getN_truck() {
        return n_truck;
    }

    public void setN_truck(Long N_truck) {
        this.n_truck = N_truck;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String Board) {
        this.board = Board;
    }

    public String getBoard1() {
        return board1;
    }

    public void setBoard1(String Board1) {
        this.board1 = Board1;
    }

    public String getBoard2() {
        return board2;
    }

    public void setBoard2(String Board2) {
        this.board2 = Board2;
    }

    public String getBoard3() {
        return board3;
    }

    public void setBoard3(String Board3) {
        this.board3 = Board3;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String Color) {
        this.color = Color;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String Mark) {
        this.mark = Mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String Model) {
        this.model = Model;
    }

    public String getN_chassi() {
        return n_chassi;
    }

    public void setN_chassi(String N_chassi) {
        this.n_chassi = N_chassi;
    }

    public String getN_renavam() {
        return n_renavam;
    }

    public void setN_renavam(String N_renavam) {
        this.n_renavam = N_renavam;
    }

    public String getYear_fabrication() {
        return year_fabrication;
    }

    public void setYear_fabrication(String Year_fabrication) {
        this.year_fabrication = Year_fabrication;
    }

    public String getYear_fabrication1() {
        return year_fabrication1;
    }

    public void setYear_fabrication1(String Year_fabrication1) {
        this.year_fabrication1 = Year_fabrication1;
    }

    public String getYear_fabrication2() {
        return year_fabrication2;
    }

    public void setYear_fabrication2(String Year_fabrication2) {
        this.year_fabrication2 = Year_fabrication2;
    }

    public String getYear_fabrication3() {
        return year_fabrication3;
    }

    public void setYear_fabrication3(String Year_fabrication3) {
        this.year_fabrication3 = Year_fabrication3;
    }

    public String getYear_model() {
        return year_model;
    }

    public void setYear_model(String Year_model) {
        this.year_model = Year_model;
    }

    public Long getTraction() {
        return traction;
    }

    public void setTraction(Long Traction) {
        this.traction = Traction;
    }

    public Long getDriver() {
        return driver;
    }

    public void setDriver(Long Driver) {
        this.driver = Driver;
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

    public Long getId_business(){
        return id_business;
    }

    public void setId_business(Long id_business){
        this.id_business = id_business;
    }
}