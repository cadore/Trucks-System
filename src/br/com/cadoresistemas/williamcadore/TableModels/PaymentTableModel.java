package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class PaymentTableModel {

    @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Veiculo")
    private String id_truck;

    @Resolvable(colName = "Pagar à")
    private String pago_a;

    @Resolvable(colName = "Observação")
    private String observação;

    @Resolvable(colName = "Vencimento")
    private String data_vencimento;

    @Resolvable(colName = "Valor R$")
    private String valor;

    @Resolvable(colName = "N° Identificação")
    private String identificacao;

    @Resolvable(colName = "Paga?")
    private boolean paid;

    public PaymentTableModel(long id, String id_truck, String pago_a, String observação, String data_vencimento, String valor, String identificacao, boolean paid) {
        this.id = id;
        this.id_truck = id_truck;
        this.pago_a = pago_a;
        this.observação = observação;
        this.data_vencimento = data_vencimento;
        this.valor = valor;
        this.identificacao = identificacao;
        this.paid = paid;
    }
}
