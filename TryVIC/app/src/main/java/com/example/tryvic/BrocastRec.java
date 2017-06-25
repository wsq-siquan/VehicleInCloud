package com.example.tryvic;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

/**
 * Created by 王思全 on 2017/6/25.
 */
public class BrocastRec extends BroadcastReceiver {
    private static final String DYNAMIC = "com.example.tryvic.brocastrec";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(DYNAMIC)) {
            Bundle bundle = intent.getExtras();
            String str = bundle.getString("message");

            NotificationManager nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);


            Notification.Builder builder = new Notification.Builder(context);
            //Bitmap bm = BitmapFactory.decodeResource(context.getResources(),R.mipmap.dynamic);
            Intent notificationIntent =new Intent(context, MainActivity.class); // 点击该通知后要跳转的Activity
            PendingIntent contentItent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

            builder.setContentTitle("警报广播").setContentText(str).setTicker("警报WARNING").setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true).setContentIntent(contentItent);



            Notification notification = builder.build();


            // notification.setLatestEventInfo(this, "内容提示：", "我就是一个测试文件", pendingIntent);
            nm.notify(0,notification);



        }

    }
}
