package br.ufc.dc.sd4mp.todo.mytodolist;

import java.sql.Timestamp;

/**
 * Created by 0322851 on 11/05/15.
 */
public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private Timestamp dataDeCriacao;
    private boolean concluido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Timestamp dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public boolean estaConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
