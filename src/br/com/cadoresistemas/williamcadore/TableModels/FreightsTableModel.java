package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class FreightsTableModel {
     @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Data Saída")
    private String date_exit;

    @Resolvable(colName = "Veiculo")
    private String truck;

    @Resolvable(colName = "Motorista")
    private String driver;

    @Resolvable(colName = "Nº Nota")
    private String note;

    @Resolvable(colName = "Produto")
    private String product;

    @Resolvable(colName = "Peso")
    private String weight;

    @Resolvable(colName = "Liquido")
    private String total3;

    public FreightsTableModel(long id, String date_exit, String caminhao, String motorista, String n_nota,String produto, String peso, String total3) {
        this.id = id;
        this.truck = caminhao;
        this.driver = motorista;
        this.note = n_nota;
        this.product = produto;
        this.weight = peso;
        this.date_exit = date_exit;
        this.total3 = total3;
    }
}
