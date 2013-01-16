package android_src.mms.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.facebook.orca.debug.BLog;

class TransactionService$ConnectivityBroadcastReceiver extends BroadcastReceiver
{
  private TransactionService$ConnectivityBroadcastReceiver(TransactionService paramTransactionService)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (BLog.b(2))
      BLog.d("fb-mms:TransactionService", "ConnectivityBroadcastReceiver.onReceive() action: " + str);
    if (!str.equals("android.net.conn.CONNECTIVITY_CHANGE"));
    while (true)
    {
      return;
      paramIntent.getBooleanExtra("noConnectivity", false);
      NetworkInfo localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if (BLog.b(2))
        BLog.a("fb-mms:TransactionService", "Handle ConnectivityBroadcastReceiver.onReceive(): " + localNetworkInfo);
      if ((localNetworkInfo == null) || (localNetworkInfo.getType() != 2))
      {
        if (BLog.b(2))
          BLog.a("fb-mms:TransactionService", "   type is not TYPE_MOBILE_MMS, bail");
        if ((localNetworkInfo == null) || (!"2GVoiceCallEnded".equals(localNetworkInfo.getReason())))
          continue;
        if (BLog.b(2))
          BLog.a("fb-mms:TransactionService", "   reason is 2GVoiceCallEnded, retrying mms connectivity");
        TransactionService.b(this.a);
        continue;
      }
      if (!localNetworkInfo.isConnected())
      {
        if (!BLog.b(2))
          continue;
        BLog.a("fb-mms:TransactionService", "   TYPE_MOBILE_MMS not connected, bail");
        continue;
      }
      TransactionSettings localTransactionSettings = new TransactionSettings(this.a, localNetworkInfo.getExtraInfo());
      if (TextUtils.isEmpty(localTransactionSettings.a()))
      {
        BLog.a("fb-mms:TransactionService", "   empty MMSC url, bail");
        continue;
      }
      TransactionService.b(this.a);
      TransactionService.d(this.a).a(null, localTransactionSettings);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.transaction.TransactionService.ConnectivityBroadcastReceiver
 * JD-Core Version:    0.6.0
 */