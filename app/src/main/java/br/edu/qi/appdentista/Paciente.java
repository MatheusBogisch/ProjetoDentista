package br.edu.qi.appdentista;

import java.io.Serializable;

public class Paciente implements Serializable {
    private int id;
    private String nome;
    private int idade;
    private String dataConsulta;
    private String procedimento;
    private String doutor;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getDoutor() {
        return doutor;
    }

    public void setDoutor(String doutor) {
        this.doutor = doutor;
    }

    @Override
    public String toString() {
        return
                "\n" + "ID:" + this.id + "\n " +
                "Nome: '" + this.nome + "\n" +
                "Idade: " + this.idade + "\n" +
                "Data de consulta:" + this.dataConsulta + "\n" +
                "Procedimento: " + this.procedimento + "\n" +
                "Doutor:" + this.doutor ;
    }
}
