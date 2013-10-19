package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class InputsTableModel {
    @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Recebido De")
    private String received;

    @Resolvable(colName = "Descrição")
    private String description;

    @Resolvable(colName = "Caminhão")
    private String board;

    @Resolvable(colName = "Data")
    private String date;

    @Resolvable(colName = "Valor R$")
    private String value3;


    public InputsTableModel(long id, String recebido_de, String descricao, String caminhao, String data, String valor) {
        this.id = id;
        this.received = recebido_de;
        this.description = descricao;
        this.board = caminhao;
        this.date = data;
        this.value3 = valor;
           }

}
