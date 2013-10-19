package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;


public class TrucksTableModel {
     @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Placa")
    private String board;

    @Resolvable(colName = "Marca")
    private String mark;

    @Resolvable(colName = "Modelo")
    private String model;

    @Resolvable(colName = "Cor")
    private String color;

    @Resolvable(colName = "Tração")
    private String traction;

    @Resolvable(colName = "Motorista")
    private String driver;

    public TrucksTableModel(long id, String placa, String marca, String modelo, String cor, String tracao, String motorista) {
        this.id = id;
        this.board = placa;
        this.mark = marca;
        this.model = modelo;
        this.color = cor;
        this.traction = tracao;
        this.driver = motorista;
    }

}
