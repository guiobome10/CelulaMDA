package br.com.jgsi.celulamda.widget;

import android.view.View;
import android.widget.Button;

import java.util.Calendar;

import br.com.jgsi.celulamda.util.DateFormatter;

/**
 * Created by guilhermewesley on 25/08/2016.
 */
public class DefaultDatePickerUser implements DatePickerUser {

    private Button botaoData;

    public DefaultDatePickerUser(Button botaoData) {
        this.botaoData = botaoData;
    }

    @Override
    public void setData(Calendar data) {
        this.botaoData.setText(DateFormatter.formata(data));
    }
}
