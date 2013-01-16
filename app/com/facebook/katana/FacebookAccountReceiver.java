package com.facebook.katana;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LogoutReason;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.provider.UserValuesManager;

public class FacebookAccountReceiver extends BroadcastReceiver
{
  private static final Class<?> a = FacebookAccountReceiver.class;

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Log.a(a, 3))
      Log.e(a, "----> onReceive");
    String str = UserValuesManager.c(paramContext);
    if (str == null)
      if (Log.a(a, 3))
        Log.e(a, "Account does not exist.");
    while (true)
    {
      return;
      if (FacebookAuthenticationService.a(paramContext, str) != null)
      {
        if (!Log.a(a, 3))
          continue;
        Log.e(a, "Account still exists: " + str);
        continue;
      }
      AppSession localAppSession = AppSession.a(paramContext, false);
      if (localAppSession == null)
        continue;
      if (Log.a(a, 3))
        Log.e(a, "Session status: " + localAppSession.i());
      switch (FacebookAccountReceiver.1.a[localAppSession.i().ordinal()])
      {
      case 1:
      default:
        break;
      case 2:
        if (Log.a(a, 3))
          Log.e(a, "Logging out: " + str);
        localAppSession.a(paramContext, AppSession.LogoutReason.ACCOUNT_REMOVED);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FacebookAccountReceiver
 * JD-Core Version:    0.6.0
 */