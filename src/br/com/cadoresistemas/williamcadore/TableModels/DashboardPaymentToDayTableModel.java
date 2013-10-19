package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class DashboardPaymentToDayTableModel {

    @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Veículo")
    private String id_truck;

    @Resolvable(colName = "Pagar à")
    private String pago_a;

    @Resolvable(colName = "Vencimento")
    private String data_vencimento;

    @Resolvable(colName = "Valor R$")
    private String valor;

    @Resolvable(colName = "N° Identificação")
    private String identificacao;

    public DashboardPaymentToDayTableModel(long id,String id_truck, String pago_a, String data_vencimento, String valor, String identificacao) {
        this.id = id;
        this.id_truck = id_truck;
        this.pago_a = pago_a;
        this.data_vencimento = data_vencimento;
        this.valor = valor;
        this.identificacao = identificacao;
    }
}