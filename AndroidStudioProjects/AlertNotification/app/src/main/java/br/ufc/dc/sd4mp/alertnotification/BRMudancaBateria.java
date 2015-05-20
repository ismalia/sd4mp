package br.ufc.dc.sd4mp.alertnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BRMudancaBateria extends BroadcastReceiver {
    public BRMudancaBateria() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        String TESTE = "";
        Log.v(TESTE, "Broadcast mandado!");
        CharSequence text = "Mudança de bateria!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
