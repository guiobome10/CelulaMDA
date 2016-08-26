package br.com.jgsi.celulamda.model;

/**
 * Created by guilhermewesley on 17/05/2016.
 */
public enum TipoMembro {

    LIDER(1, "Líder"),
    LIDER_EM_TREINAMENTO(2, "Líder em Treinamento"),
    ANFITRIAO(3, "Anfitrião"),
    MEMBRO(4, "Membro"),
    VISITANTE(5, "Visitante");

    private final int codigo;
    private final String descricao;

    TipoMembro(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    private int codigo(){return codigo;}
    private String descricao(){return descricao;}

    public TipoMembro getCodigo(int codigo){
        for(TipoMembro tipoMembro : TipoMembro.values()){
            if(tipoMembro.codigo() == codigo) return tipoMembro;
        }
        return null;
    }

    public TipoMembro getDescricao(String descricao){
        for(TipoMembro tipoMembro : TipoMembro.values()){
            if(tipoMembro.descricao().equals(descricao)) return tipoMembro;
        }
        return null;
    }
}
