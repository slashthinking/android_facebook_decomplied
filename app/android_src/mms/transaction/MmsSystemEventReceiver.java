package android_src.mms.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android_src.mms.ClassesToUse;
import android_src.mms.util.PduCache;
import com.facebook.orca.debug.BLog;

public class MmsSystemEventReceiver extends BroadcastReceiver
{
  private static MmsSystemEventReceiver a;

  public static void a(Context paramContext)
  {
    b(paramContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.ANY_DATA_STATE");
    if (BLog.b(2))
      BLog.a("fb-mms:MmsSystemEventReceiver", "registerForConnectionStateChanges");
    if (a == null)
      a = new MmsSystemEventReceiver();
    paramContext.registerReceiver(a, localIntentFilter);
  }

  public static void b(Context paramContext)
  {
    if (BLog.b(2))
      BLog.a("fb-mms:MmsSystemEventReceiver", "unRegisterForConnectionStateChanges");
    if (a != null);
    try
    {
      paramContext.unregisterReceiver(a);
      label27: return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label27;
    }
  }

  private static void c(Context paramContext)
  {
    if (BLog.b(2))
      BLog.a("fb-mms:MmsSystemEventReceiver", "wakeUpService: start transaction service ...");
    paramContext.startService(new Intent(paramContext, ClassesToUse.a));
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (BLog.b(2))
      BLog.a("fb-mms:MmsSystemEventReceiver", "Intent received: " + paramIntent);
    String str1 = paramIntent.getAction();
    if (str1.equals("android.intent.action.CONTENT_CHANGED"))
    {
      Uri localUri = (Uri)paramIntent.getParcelableExtra("deleted_contents");
      PduCache.b().a(localUri);
    }
    while (true)
    {
      return;
      if (str1.equals("android.intent.action.ANY_DATA_STATE"))
      {
        String str2 = paramIntent.getStringExtra("state");
        if (BLog.b(2))
          BLog.a("fb-mms:MmsSystemEventReceiver", "ANY_DATA_STATE event received: " + str2);
        if (!str2.equals("CONNECTED"))
          continue;
        c(paramContext);
        continue;
      }
      if (!str1.equals("android.intent.action.BOOT_COMPLETED"))
        continue;
      MessagingNotification.a(paramContext, false, false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.MmsSystemEventReceiver
 * JD-Core Version:    0.6.0
 */