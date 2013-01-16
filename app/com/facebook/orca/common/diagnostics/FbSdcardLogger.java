package com.facebook.orca.common.diagnostics;

import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.debug.FbLogWriter;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.SharedPrefKeys;
import java.text.SimpleDateFormat;

public class FbSdcardLogger
  implements INeedInit, FbLogWriter
{
  private static final Class<?> a = FbSdcardLogger.class;
  private static final SimpleDateFormat b = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
  private final OrcaSharedPreferences c;
  private final String d;
  private HandlerThread e;
  private Handler f;
  private volatile boolean g;
  private FbSdcardLogger.InternalHandler h;
  private OrcaSharedPreferences.OnSharedPreferenceChangeListener i;

  public FbSdcardLogger(PackageInfo paramPackageInfo, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.c = paramOrcaSharedPreferences;
    this.d = paramPackageInfo.packageName;
  }

  private void d()
  {
    monitorenter;
    try
    {
      boolean bool = this.c.a(SharedPrefKeys.j, false);
      if (bool)
        e();
      this.g = bool;
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

  private void e()
  {
    monitorenter;
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("logger");
        this.e.start();
        this.f = new Handler(this.e.getLooper());
        this.h = new FbSdcardLogger.InternalHandler(this, null);
      }
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

  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.g)
      this.f.post(new FbSdcardLogger.2(this, paramInt, paramString1, paramString2));
  }

  public void i_()
  {
    this.i = new FbSdcardLogger.1(this);
    this.c.a(this.i);
    d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.diagnostics.FbSdcardLogger
 * JD-Core Version:    0.6.0
 */