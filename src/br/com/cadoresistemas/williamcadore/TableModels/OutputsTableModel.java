package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class OutputsTableModel {
    @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Pago à")
    private String paid;

    @Resolvable(colName = "Descrição")
    private String description;

    @Resolvable(colName = "Veículo")
    private String board;

    @Resolvable(colName = "Data")
    private String date;

    @Resolvable(colName = "Valor R$")
    private String value3;


    public OutputsTableModel(long id, String pago_a, String descricao, String caminhao, String data, String valor) {
        this.id = id;
        this.paid = pago_a;
        this.description = descricao;
        this.board = caminhao;
        this.date = data;
        this.value3 = valor;
           }
}
