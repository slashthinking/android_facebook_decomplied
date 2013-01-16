package com.facebook.orca.database;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;

public class AddressBookPeriodicRunner$AlarmActionReceiver
  implements SecureBroadcastReceiver.ActionReceiver
{
  private AddressBookPeriodicRunner a;

  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    AppInitLockHelper.a(paramContext);
    this.a = ((AddressBookPeriodicRunner)FbInjector.a(paramContext).a(AddressBookPeriodicRunner.class));
    this.a.d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.AddressBookPeriodicRunner.AlarmActionReceiver
 * JD-Core Version:    0.6.0
 */