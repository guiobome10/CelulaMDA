package br.com.jgsi.celulamda.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.jgsi.celulamda.R;
import br.com.jgsi.celulamda.infra.DatabaseHelper;
import br.com.jgsi.celulamda.model.Celula;
import br.com.jgsi.celulamda.util.DateFormatter;
import br.com.jgsi.celulamda.widget.DatePickerFragment;
import br.com.jgsi.celulamda.widget.DatePickerUser;

/**
 * Created by guilhermewesley on 27/05/2016.
 */
public class CelulaViewModel extends CadastroViewModel implements Serializable {

    private static final int DATE_DIALOG_ID = 0;
    private Celula celula;
    private EditText numero;
    private EditText nome;
    private Button campoDataAbertura;
    
    private Button campoDataAtivo;
    private Calendar dataAtiva;

    public CelulaViewModel(View tela, final Fragment fragment) {
        super(tela, fragment);
        this.numero = (EditText) tela.findViewById(R.id.numero);
        this.nome = (EditText) tela.findViewById(R.id.nome);
        this.campoDataAbertura = (Button) tela.findViewById(R.id.dataAbertura);
        this.campoDataAbertura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(fragment.getFragmentManager(), "datePicker");
            }
        });
        getSalvar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getHelper().getCelulaDAO().createOrUpdate(celula);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void inicializaCampos(){
        celula = new Celula();
        setNumero(String.valueOf(celula.getNumero()));
        setNome(celula.getNome());
    }

    public EditText getNumero() {
        return numero;
    }

    public EditText getNome() {
        return nome;
    }

    public void setNumero(String numero) {
        this.numero.setText(numero);
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public void showDateDialog(Button campoDataAtual, Calendar date) {
        campoDataAtivo = campoDataAtual;
        dataAtiva = date;
        getFragment().getActivity().showDialog(DATE_DIALOG_ID);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dataAtiva.set(Calendar.YEAR, year);
            dataAtiva.set(Calendar.MONTH, monthOfYear);
            dataAtiva.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDisplay(campoDataAtivo, dataAtiva);
            unregisterDateDisplay();
        }
    };

    private void unregisterDateDisplay() {
        campoDataAtivo = null;
        dataAtiva = null;
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this.getFragment().getActivity(), dateSetListener, dataAtiva.get(Calendar.YEAR), dataAtiva.get(Calendar.MONTH), dataAtiva.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }

    protected void onPrepareDialog(int id, Dialog dialog) {
        getFragment().getActivity().onPrepareDialog(id, dialog);
        switch (id) {
            case DATE_DIALOG_ID:
                ((DatePickerDialog) dialog).updateDate(dataAtiva.get(Calendar.YEAR), dataAtiva.get(Calendar.MONTH), dataAtiva.get(Calendar.DAY_OF_MONTH));
                break;
        }
    }

}
