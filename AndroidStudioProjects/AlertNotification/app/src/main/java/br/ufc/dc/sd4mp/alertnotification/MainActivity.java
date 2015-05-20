package br.ufc.dc.sd4mp.alertnotification;

import android.content.Context;
import android.content.Intent;
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
//                iniciarBRMudancaBateria(view);
            }
        }
        if (id == R.id.modoAviaoCheckBox) {
            if (checked) {
                Intent modoAviaoIntent = new Intent();
                modoAviaoIntent.setAction("android.intent.action.AIRPLANE_MODE");
                sendBroadcast(modoAviaoIntent);
            }
        }
        if (id == R.id.carregadorConectadoCheckBox) {
            if (checked) {

            }
        }
        if (id == R.id.carregadorDesconectadoCheckBox) {
            if (checked) {

            }
        }
    }

    public void iniciarBRMudancaBateria(View view) {
        Intent mudancaBateriaIntent = new Intent();
        mudancaBateriaIntent.setAction("android.intent.action.BATTERY_CHANGED");
        sendBroadcast(mudancaBateriaIntent);
    }
}
