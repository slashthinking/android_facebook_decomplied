package com.facebook.katana;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LogoutReason;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.orca.activity.FbFragmentActivity;

public class LogoutActivity extends FbFragmentActivity
{
  private boolean n;
  private AppSessionListener o = new LogoutActivity.1(this);

  public static void a(Activity paramActivity)
  {
    LogoutActivity.2 local2 = new LogoutActivity.2(paramActivity);
    AlertDialogs.a(paramActivity, paramActivity.getString(2131362961), 17301659, paramActivity.getString(2131363205), paramActivity.getString(2131362849), local2, paramActivity.getString(2131362848), null, null, true).show();
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903141);
  }

  protected void onPause()
  {
    super.onPause();
    AppSession localAppSession = AppSession.b(this, false);
    if (localAppSession != null)
      localAppSession.b(this.o);
  }

  protected void onResume()
  {
    super.onResume();
    if (this.n);
    while (true)
    {
      return;
      AppSession localAppSession = AppSession.b(this, false);
      if (localAppSession != null)
      {
        localAppSession.a(this.o);
        localAppSession.a(this, AppSession.LogoutReason.USER_INITIATED);
        this.n = true;
        continue;
      }
      LoginActivity.b(this);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.LogoutActivity
 * JD-Core Version:    0.6.0
 */