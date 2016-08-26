package br.com.jgsi.celulamda.model;

/**
 * Created by guilhermewesley on 17/05/2016.
 */
public enum TipoMeta {
    KILO_MEMBRO(1, "Kilo do amor(Membro)"),
    KILO_CELULA(2, "Kilo do amor(Célula)"),
    KILO_SETOR(3, "Kilo do amor(Setor)"),
    KILO_DISTRITO(4, "Kilo do amor(Distrito)"),
    KILO_IGREJA(5, "Kilo do amor(Igreja)"),
    BATISMO(6, "Batismo"),
    ENCONTRO_COM_DEUS(7, "Encontro com Deus"),
    MULTIPLICACAO(8, "Multiplicação");


    private final int codigo;
    private final String descricao;

    TipoMeta(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    private int codigo(){return codigo;}
    private String descricao(){return descricao;}

    public TipoMeta getCodigo(int codigo){
        for(TipoMeta tipoMembro : TipoMeta.values()){
            if(tipoMembro.codigo() == codigo) return tipoMembro;
        }
        return null;
    }

    public TipoMeta getDescricao(String descricao){
        for(TipoMeta tipoMembro : TipoMeta.values()){
            if(tipoMembro.descricao().equals(descricao)) return tipoMembro;
        }
        return null;
    }

    }
