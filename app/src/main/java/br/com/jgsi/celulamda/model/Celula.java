package br.com.jgsi.celulamda.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.joda.time.DateTime;

/**
 * Created by guilhermewesley on 16/05/2016.
 */
@DatabaseTable
public class Celula  {

    @DatabaseField(id = true)
    private int numero;

    @DatabaseField
    private String nome;

    @DatabaseField
    private DateTime dataAbertura;

    @DatabaseField
    private String endereco;

    @DatabaseField
    private int diaReuniao;

    @DatabaseField
    private String horarioReuniao;

    @DatabaseField
    private Long numeroCelulaMae;

    @DatabaseField
    private TipoCelula tipoCelula;

    @DatabaseField
    private DateTime dataUltimaMultiplicacao;

    public Celula() {   }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(DateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getDiaReuniao() {
        return diaReuniao;
    }

    public void setDiaReuniao(int diaReuniao) {
        this.diaReuniao = diaReuniao;
    }

    public String getHorarioReuniao() {
        return horarioReuniao;
    }

    public void setHorarioReuniao(String horarioReuniao) {
        this.horarioReuniao = horarioReuniao;
    }

    public Long getNumeroCelulaMae() {
        return numeroCelulaMae;
    }

    public void setNumeroCelulaMae(Long numeroCelulaMae) {
        this.numeroCelulaMae = numeroCelulaMae;
    }

    public TipoCelula getTipoCelula() {
        return tipoCelula;
    }

    public void setTipoCelula(TipoCelula tipoCelula) {
        this.tipoCelula = tipoCelula;
    }

    public DateTime getDataUltimaMultiplicacao() {
        return dataUltimaMultiplicacao;
    }

    public void setDataUltimaMultiplicacao(DateTime dataUltimaMultiplicacao) {
        this.dataUltimaMultiplicacao = dataUltimaMultiplicacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Celula celula = (Celula) o;
        return numero == celula.numero;
    }

    @Override
    public int hashCode() {
        return numero;
    }
}
