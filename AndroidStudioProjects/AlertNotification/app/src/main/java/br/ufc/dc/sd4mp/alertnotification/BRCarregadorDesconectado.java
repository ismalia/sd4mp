package br.ufc.dc.sd4mp.alertnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BRCarregadorDesconectado extends BroadcastReceiver {
    public BRCarregadorDesconectado() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setTicker("Status");
        builder.setContentTitle("Alerta!");
        builder.setContentText("Carregador desconectado!");
        builder.setSmallIcon(android.R.drawable.ic_lock_idle_charging);
        Notification notification = builder.build();
        manager.notify(R.string.app_name, notification);
    }
}
