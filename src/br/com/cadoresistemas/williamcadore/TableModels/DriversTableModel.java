package br.com.cadoresistemas.williamcadore.TableModels;

import com.towel.el.annotation.Resolvable;

public class DriversTableModel {

    @Resolvable(colName = "Id")
    private long id;

    @Resolvable(colName = "Nome")
    private String full_name;

    @Resolvable(colName = "CPF")
    private String cpf;

    @Resolvable(colName = "Nascimento")
    private String birthday;

    @Resolvable(colName = "Telefone")
    private String phone;

    @Resolvable(colName = "Sexo")
    private String sex;

    @Resolvable(colName = "Ativo")
    private boolean active;

    public DriversTableModel(long id, String nome, String cpf, String birthday, String telefone, String sexo, boolean active) {
        this.id = id;
        this.full_name = nome;
        this.cpf = cpf;
        this.birthday = birthday;
        this.phone = telefone;
        this.sex = sexo;
        this.active = active;
     }
}
