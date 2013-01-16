package android_src.mms.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.orca.debug.BLog;

public class MessagingNotification$OnDeletedReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (BLog.b(2))
      BLog.b("fb-mms:MessagingNotification", "[MessagingNotification] clear notification: mark all msgs seen");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.MessagingNotification.OnDeletedReceiver
 * JD-Core Version:    0.6.0
 */