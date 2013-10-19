package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class UserTableModel {
    @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Nome")
    private String nome;

    @Resolvable(colName = "Login")
    private String login;

    @Resolvable(colName = "Admin")
    private boolean Administrador;

    @Resolvable(colName = "Inativo")
    private boolean inativo;

    @Resolvable(colName = "Relatórios")
    private boolean reports;

    public UserTableModel(long id, String nome,String login, boolean administrador, boolean inativo, boolean reports) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.Administrador = administrador;
        this.inativo = inativo;
        this.reports = reports;
    }
}
