package br.ufc.dc.sd4mp.alertnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BRModoAviao extends BroadcastReceiver {
    public BRModoAviao() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager;
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setTicker("Status");
        builder.setContentTitle("Alerta!");
        builder.setContentText("Modo avião!");
        builder.setSmallIcon(R.mipmap.airplane_icon);
        Notification notification = builder.build();
        manager.notify(R.string.app_name, notification);
    }
}
