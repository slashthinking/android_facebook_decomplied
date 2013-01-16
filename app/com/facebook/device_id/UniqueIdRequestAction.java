package com.facebook.device_id;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.SharedPrefKeys;

class UniqueIdRequestAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  private static final Class<?> a = UniqueIdRequestAction.class;
  private OrcaSharedPreferences b;

  private void a(Context paramContext)
  {
    AppInitLockHelper.a(paramContext);
    this.b = ((OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class));
  }

  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    BLog.b(a, "answering device id query");
    String str2;
    long l2;
    if (paramBroadcastReceiverLike.getResultCode() == -1)
    {
      str2 = paramBroadcastReceiverLike.getResultData();
      l2 = paramBroadcastReceiverLike.getResultExtras(true).getLong("device_id_generated_timestamp_ms", 9223372036854775807L);
      if ((str2 != null) && (System.currentTimeMillis() - l2 > 172800000L))
      {
        BLog.b(a, "stable device id already found skipping");
        return;
      }
    }
    for (UniqueDeviceId localUniqueDeviceId = new UniqueDeviceId(str2, l2); ; localUniqueDeviceId = null)
    {
      a(paramContext);
      String str1 = this.b.a(SharedPrefKeys.e, null);
      long l1 = this.b.a(SharedPrefKeys.f, 9223372036854775807L);
      if ((str1 == null) || (l1 == 9223372036854775807L))
      {
        BLog.b(a, "no id found");
        break;
      }
      if ((localUniqueDeviceId != null) && (l1 > localUniqueDeviceId.b()))
      {
        BLog.b(a, "previously broadcasted device id is older. skipping");
        break;
      }
      paramBroadcastReceiverLike.setResultCode(-1);
      paramBroadcastReceiverLike.setResultData(str1);
      Bundle localBundle = new Bundle();
      localBundle.putLong("device_id_generated_timestamp_ms", l1);
      paramBroadcastReceiverLike.setResultExtras(localBundle);
      BLog.b(a, "device id found: " + str1);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.UniqueIdRequestAction
 * JD-Core Version:    0.6.0
 */