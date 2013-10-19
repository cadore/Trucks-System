package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class LogsTableModel {
    @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Login")
    private String login;

    @Resolvable(colName = "Data/Hora")
    private String date;

    @Resolvable(colName = "Valido")
    private boolean valid;


    public LogsTableModel(long id, String login, String date, boolean valid) {
        this.id = id;
        this.login = login;
        this.date = date;
        this.valid = valid;
      }

}
