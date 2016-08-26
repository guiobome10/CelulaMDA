package br.com.jgsi.celulamda.widget;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.jgsi.celulamda.R;

public class DatePickerFragment extends DialogFragment {


    private Calendar data;
    DatePickerUser user;

    public interface DatePickerUser {
        void setData(Calendar data);
    }

    public DatePickerFragment() {
        this.data = Calendar.getInstance();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        if(getArguments() != null ){
            if(getArguments().getSerializable(getString(R.string.data)) != null)
                this.data = (Calendar) getArguments().getSerializable(getString(R.string.data));
        }
        int year = data.get(Calendar.YEAR);
        int month = data.get(Calendar.MONTH);
        int day = data.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), user, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        data = new GregorianCalendar(year, month, day);
        user.setData(data);
    }


}