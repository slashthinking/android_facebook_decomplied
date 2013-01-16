package com.facebook.katana.settings;

import android.content.Context;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.katana.features.FetchAppLoggedOutSettingsMethod.Mode;
import com.facebook.katana.features.FetchAppLoggedOutSettingsMethod.Result;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import java.util.Locale;

public class AppLoggedOutSettingsManager
{
  private static final String e = AppLoggedOutSettingsManager.class.getSimpleName();
  private FetchAppLoggedOutSettingsMethod.Result a;
  private boolean b;
  private final UniqueIdForDeviceHolder c;
  private final SingleMethodRunner d;

  public AppLoggedOutSettingsManager(UniqueIdForDeviceHolder paramUniqueIdForDeviceHolder, SingleMethodRunner paramSingleMethodRunner)
  {
    this.c = paramUniqueIdForDeviceHolder;
    this.d = paramSingleMethodRunner;
    this.b = false;
    this.a = null;
  }

  private String e()
  {
    return f().registrationMode.toUpperCase(Locale.ENGLISH);
  }

  private FetchAppLoggedOutSettingsMethod.Result f()
  {
    if (this.a == null);
    for (FetchAppLoggedOutSettingsMethod.Result localResult = new FetchAppLoggedOutSettingsMethod.Result(); ; localResult = this.a)
      return localResult;
  }

  public void a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (this.b)
      {
        monitorexit;
      }
      else
      {
        this.b = true;
        monitorexit;
        new AppLoggedOutSettingsManager.1(this).execute(new Void[0]);
      }
    }
    finally
    {
      monitorexit;
    }
  }

  public void a(FetchAppLoggedOutSettingsMethod.Result paramResult)
  {
    if (paramResult == null)
      paramResult = new FetchAppLoggedOutSettingsMethod.Result();
    this.a = paramResult;
    monitorenter;
    try
    {
      this.b = false;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean a()
  {
    return StringUtils.a(FetchAppLoggedOutSettingsMethod.Mode.NATIVE.toString(), e());
  }

  public boolean b()
  {
    if ((StringUtils.a(FetchAppLoggedOutSettingsMethod.Mode.IN_APP.toString(), e())) || (a()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public String c()
  {
    return f().a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.settings.AppLoggedOutSettingsManager
 * JD-Core Version:    0.6.0
 */