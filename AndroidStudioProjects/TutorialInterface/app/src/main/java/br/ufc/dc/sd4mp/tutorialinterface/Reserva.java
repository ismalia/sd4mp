package br.ufc.dc.sd4mp.tutorialinterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.ToggleButton;


public class Reserva extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        // Povoamento do spinner de laboratórios
        Spinner spinner = (Spinner) findViewById(R.id.labSpinner);
        String[] laboratorios = getResources().getStringArray(R.array.labs);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, laboratorios);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void send(View view) {
        EditText nomeProfEditText = (EditText) findViewById(R.id.nomeProfEditText);
        String nomeProf = nomeProfEditText.getText().toString();

        EditText siapeEditText = (EditText) findViewById(R.id.siapeEditText);
        String siape = siapeEditText.getText().toString();

        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        String emailProf = emailEditText.getText().toString();

        DatePicker dataReservaEditText = (DatePicker) findViewById(R.id.datePicker);
        int ano = dataReservaEditText.getYear();
        int mes = dataReservaEditText.getMonth();
        int dia = dataReservaEditText.getDayOfMonth();
        String dataReserva = Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(ano);

        TimePicker horarioReservaEditText = (TimePicker) findViewById(R.id.timePicker);
        int horas = horarioReservaEditText.getCurrentHour();
        int minutos = horarioReservaEditText.getCurrentMinute();
        String horarioReserva = Integer.toString(horas) + ":" + Integer.toString(minutos) + "h";

        Spinner labsSpinner = (Spinner) findViewById(R.id.labSpinner);
        String lab = labsSpinner.getSelectedItem().toString();

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        String precisaDatashow = null;
        int radioButtonID = radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));
        switch (radioButtonID) {
            case 0:
                precisaDatashow = "Sim";
                break;
            case 1:
                precisaDatashow = "Não";
                break;
            case 2:
                precisaDatashow = "Talvez";
                break;
        }

        String configuracaoDesejada = "";
        CheckBox androidCheckBox = (CheckBox) findViewById(R.id.androidStudioSDKCheckBox);
        CheckBox javaCheckBox = (CheckBox) findViewById(R.id.javaSDKCheckBox);
        CheckBox linuxCheckBox = (CheckBox) findViewById(R.id.linuxCheckBox);
        CheckBox windowsCheckBox = (CheckBox) findViewById(R.id.windowsCheckBox);
        if (androidCheckBox.isChecked()) {
            configuracaoDesejada = configuracaoDesejada.concat("Android Studio + Android SDK\n");
        }
        if (javaCheckBox.isChecked()) {
            configuracaoDesejada = configuracaoDesejada.concat("Java SDK\n");
        }
        if (linuxCheckBox.isChecked()) {
            configuracaoDesejada = configuracaoDesejada.concat("Sistema Operacional Linux\n");
        }
        if (windowsCheckBox.isChecked()) {
            configuracaoDesejada = configuracaoDesejada.concat("Sistema Operacional Windows\n");
        }

        ToggleButton reservaPrioritariaButton = (ToggleButton) findViewById(R.id.toggleButton);
        String reservaPrioritaria = null;
        if (reservaPrioritariaButton.isChecked()) {
            reservaPrioritaria = "Sim";
        }
        else {
            reservaPrioritaria = "Não";
        }

        EditText observacaoEditText = (EditText) findViewById(R.id.observacaoEditText);
        String observacao = observacaoEditText.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[] {"ismaliadulce@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Formulário para Reserva de Laboratório");
        email.putExtra(Intent.EXTRA_TEXT, "==========\n" +
                                          "Identificação\n" +
                                          "==========\n\n" +
                                          "Nome do professor: " + nomeProf + "\n" +
                                          "SIAPE: " + siape + "\n" +
                                          "Email: " + emailProf + "\n\n" +
                                          "==============\n" +
                                          "Dados da reserva\n" +
                                          "==============\n\n" +
                                          "Data da reserva: " + dataReserva + "\n" +
                                          "Horário da reserva: " + horarioReserva + "\n" +
                                          "Selecione o laboratório: " + lab + "\n" +
                                          "Vai precisar de datashow? " + precisaDatashow + "\n" +
                                          "Configuração desejada dos computadores:\n" + configuracaoDesejada +
                                          "Reserva prioritária? " + reservaPrioritaria + "\n" +
                                          "Observação: " + observacao);
        email.setType("plain/text");
        startActivity(Intent.createChooser(email, "Sending mail..."));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reserva, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
