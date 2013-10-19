package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class FueledTableModel {
     @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Data")
    private String date;

    @Resolvable(colName = "Posto")
    private String station;

    @Resolvable(colName = "Litros")
    private String liters;

    @Resolvable(colName = "R$ Litros")
    private String rs_liters;

    @Resolvable(colName = "Total R$")
    private String total;

    @Resolvable(colName = "Km")
    private String km;

    public FueledTableModel(long id, String date, String station, String km, String liters, String rs_liters,String total) {
    this.id = id;
    this.date = date;
    this.station = station;
    this.km = km;
    this.liters = liters;
    this.rs_liters = rs_liters;
    this.total = total;
    }
}
