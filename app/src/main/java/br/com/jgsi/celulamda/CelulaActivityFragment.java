package br.com.jgsi.celulamda;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import br.com.jgsi.celulamda.infra.DatabaseHelper;
import br.com.jgsi.celulamda.model.Celula;
import br.com.jgsi.celulamda.view.CelulaViewModel;
import br.com.jgsi.celulamda.view.ViewUtil;

/**
 * A placeholder fragment containing a simple view.
 */
public class CelulaActivityFragment extends Fragment {

    private CelulaViewModel celulaViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflated = inflater.inflate(R.layout.fragment_celula, container, false);
        celulaViewModel = new CelulaViewModel(inflated, this);
        return inflated;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        celulaViewModel.liberaRecursos();
        celulaViewModel = null;
    }
}
