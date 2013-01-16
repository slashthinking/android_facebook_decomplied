package com.facebook.katana;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.facebook.app.DelegatingApplication;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbCrashReporter;
import com.facebook.dalvik.DalvikReplaceBuffer;
import com.facebook.dex_tricks.DexLibLoader;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.common.util.SecureHashUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.inject.FbInjectorProvider;
import org.acra.ACRA;
import org.acra.ErrorReporter;
import org.acra.sender.HttpPostSender;

public class FacebookApplication extends DelegatingApplication<FacebookApplicationImpl>
  implements FbInjectorProvider
{
  private Class<?> a = FacebookApplication.class;
  private OrcaAppType b;

  private OrcaAppType g()
  {
    OrcaAppType localOrcaAppType;
    try
    {
      Signature[] arrayOfSignature = getPackageManager().getPackageInfo(BuildConstants.b(), 64).signatures;
      int i = arrayOfSignature.length;
      for (int j = 0; j < i; j++)
      {
        String str = SecureHashUtil.b(arrayOfSignature[j].toByteArray());
        if (str.equals(FacebookAppTypes.a.f()))
        {
          localOrcaAppType = FacebookAppTypes.a;
          break label95;
        }
        if (!str.equals(FacebookAppTypes.b.f()))
          continue;
        localOrcaAppType = FacebookAppTypes.b;
        break label95;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localOrcaAppType = FacebookAppTypes.c;
    }
    label95: return localOrcaAppType;
  }

  protected void b()
  {
    ACRA.init(new FbCrashReporter(this));
    this.b = g();
    String str;
    if (BuildConstants.a())
      str = "https://www.facebook.com/mobile/android_beta_crash_logs/";
    while (true)
    {
      ErrorReporter localErrorReporter = ErrorReporter.getInstance();
      localErrorReporter.setReportSender(new HttpPostSender(str, null));
      localErrorReporter.putCustomData("app", this.b.a());
      localErrorReporter.putCustomData("fb_app_id", this.b.b());
      if (BuildConstants.a())
        localErrorReporter.setMaxReportSize(1048576L);
      try
      {
        localErrorReporter.putCustomData("android_id", Settings.Secure.getString(getContentResolver(), "android_id"));
        label102: return;
        str = "https://www.facebook.com/mobile/android_crash_logs/";
      }
      catch (SecurityException localSecurityException)
      {
        break label102;
      }
    }
  }

  public FbInjector d()
  {
    return ((FacebookApplicationImpl)c()).d();
  }

  protected FacebookApplicationImpl f()
  {
    DexLibLoader.a(this, false);
    if (Build.VERSION.SDK_INT < 11)
      DalvikReplaceBuffer.c();
    return new FacebookApplicationImpl(this, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FacebookApplication
 * JD-Core Version:    0.6.0
 */