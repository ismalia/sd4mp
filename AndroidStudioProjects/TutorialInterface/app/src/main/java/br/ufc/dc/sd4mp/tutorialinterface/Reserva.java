package br.ufc.dc.sd4mp.tutorialinterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
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
        EditText siapeEditText = (EditText) findViewById(R.id.siapeEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        DatePicker dataReservaEditText = (DatePicker) findViewById(R.id.datePicker);
        TimePicker horarioReservaEditText = (TimePicker) findViewById(R.id.timePicker);
        Spinner labsSpinner = (Spinner) findViewById(R.id.labSpinner);
//        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        ToggleButton reservaPrioritaria = (ToggleButton) findViewById(R.id.toggleButton);
//        EditText observacao = (EditText) findViewById(R.id.observacaoEditText);

        int ano = dataReservaEditText.getYear();
        int mes = dataReservaEditText.getMonth();
        int dia = dataReservaEditText.getDayOfMonth();

        int horas = horarioReservaEditText.getCurrentHour();
        int minutos = horarioReservaEditText.getCurrentMinute();

        String nomeProf = nomeProfEditText.getText().toString();
        String siape = siapeEditText.getText().toString();
        String emailProf = emailEditText.getText().toString();
        String dataReserva = Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(ano);
        String horarioReserva = Integer.toString(horas) + ":" + Integer.toString(minutos) + "h";
        String lab = labsSpinner.getSelectedItem().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[] {"ismaliadulce@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        email.putExtra(Intent.EXTRA_TEXT, "Identificação\n\n" +
                                          "Nome do professor: " + nomeProf + "\n" +
                                          "SIAPE: " + siape + "\n" +
                                          "Email: " + emailProf + "\n\n" +
                                          "Dados da reserva\n\n" +
                                          "Data da reserva: " + dataReserva + "\n" +
                                          "Horário da reserva: " + horarioReserva + "\n" +
                                          "Selecione o laboratório: " + lab);
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
