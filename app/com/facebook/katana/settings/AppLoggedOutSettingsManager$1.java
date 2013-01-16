package com.facebook.katana.settings;

import android.os.AsyncTask;
import com.facebook.common.util.ErrorReporting;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.katana.features.FetchAppLoggedOutSettingsMethod;
import com.facebook.katana.features.FetchAppLoggedOutSettingsMethod.Params;
import com.facebook.katana.features.FetchAppLoggedOutSettingsMethod.Result;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class AppLoggedOutSettingsManager$1 extends AsyncTask<Void, Void, Void>
{
  protected Void a(Void[] paramArrayOfVoid)
  {
    try
    {
      this.a.a((FetchAppLoggedOutSettingsMethod.Result)AppLoggedOutSettingsManager.b(this.a).a(new FetchAppLoggedOutSettingsMethod(), new FetchAppLoggedOutSettingsMethod.Params(AppLoggedOutSettingsManager.a(this.a).b())));
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        ErrorReporting.a(AppLoggedOutSettingsManager.d(), "fetching logged out settings failed", localException);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.settings.AppLoggedOutSettingsManager.1
 * JD-Core Version:    0.6.0
 */