package br.ufc.dc.sd4mp.alertnotification;

import android.app.Notification;
import android.app.NotificationManager;
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
        NotificationManager manager;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setTicker("Status");
        builder.setContentTitle("Alerta!");
        builder.setContentText("Mudança de bateria!");
        builder.setSmallIcon(android.R.drawable.stat_notify_error);
        Notification notification = builder.build();
        manager.notify(R.string.app_name, notification);
    }
}
