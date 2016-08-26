package br.com.jgsi.celulamda.view;

import android.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import br.com.jgsi.celulamda.R;
import br.com.jgsi.celulamda.infra.DatabaseHelper;

/**
 * Created by guilhermewesley on 27/05/2016.
 */
public class CadastroViewModel   {

    private DatabaseHelper helper = null;
    private Button salvar;
    private Fragment fragment;

    public CadastroViewModel(View tela, Fragment fragment) {
        this.fragment = fragment;
        this.salvar = (Button) tela.findViewById(R.id.salvar);
        this.helper = getHelper();
    }

    public Button getSalvar() {
        return salvar;
    }

    protected DatabaseHelper getHelper(){
        if(helper == null){
            helper = OpenHelperManager.getHelper(fragment.getActivity(), DatabaseHelper.class);
        }
        return helper;
    }

    public void liberaRecursos() {
        if(helper !=null){
            OpenHelperManager.releaseHelper();
            helper=null;
        }
    }

    protected Fragment getFragment(){
        return fragment;
    }

}
