package br.ufc.dc.sd4mp.alertnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onCheckboxChecked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        int id = view.getId();

        if (id == R.id.mudancaBateriaCheckBox) {
            if (checked) {
                Intent intent = new Intent("br.ufc.dc.sd4mp.MUDANCA_BATERIA");
                sendBroadcast(intent);
            }
        }
        if (id == R.id.modoAviaoCheckBox) {
            if (checked) {
                Intent intent = new Intent("br.ufc.dc.sd4mp.MODO_AVIAO");
                sendBroadcast(intent);
            }
        }
        if (id == R.id.carregadorConectadoCheckBox) {
            if (checked) {
                Intent intent = new Intent("br.ufc.dc.sd4mp.CARREGADOR_CONECTADO");
                sendBroadcast(intent);
            }
        }
        if (id == R.id.carregadorDesconectadoCheckBox) {
            if (checked) {
                Intent intent = new Intent("br.ufc.dc.sd4mp.CARREGADOR_DESCONECTADO");
                sendBroadcast(intent);
            }
        }
    }

    public void checkStatus() {
        CheckBox mudancaBateriaCB = (CheckBox) findViewById(R.id.mudancaBateriaCheckBox);
        CheckBox modoAviaoCB = (CheckBox) findViewById(R.id.modoAviaoCheckBox);
        CheckBox carregadorConectadoCB = (CheckBox) findViewById(R.id.carregadorConectadoCheckBox);
        CheckBox carregadorDesconectadoCB = (CheckBox) findViewById(R.id.carregadorDesconectadoCheckBox);

        // Mudança de bateria

        // Modo avião

        // Carregador conectado

        // Carregador desconectado
    }
}
