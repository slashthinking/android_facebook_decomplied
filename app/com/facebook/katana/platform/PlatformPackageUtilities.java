package com.facebook.katana.platform;

import android.app.ActivityManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Base64;
import com.facebook.orca.debug.BLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PlatformPackageUtilities
{
  private static final Class<?> a = PlatformPackageUtilities.class;
  private final PackageManager b;
  private final ActivityManager c;

  public PlatformPackageUtilities(PackageManager paramPackageManager, ActivityManager paramActivityManager)
  {
    this.b = paramPackageManager;
    this.c = paramActivityManager;
  }

  private byte[] c(String paramString)
  {
    try
    {
      localPackageInfo = this.b.getPackageInfo(paramString, 64);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        PackageInfo localPackageInfo;
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
        localMessageDigest.update(localPackageInfo.signatures[0].toByteArray());
        for (arrayOfByte = localMessageDigest.digest(); ; arrayOfByte = null)
        {
          return arrayOfByte;
          localNameNotFoundException = localNameNotFoundException;
          BLog.e(a, "Failed to read calling package's signature.");
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        while (true)
        {
          BLog.e(a, "Failed to instantiate SHA-1 algorithm. It is evidently missing from this system.");
          byte[] arrayOfByte = null;
        }
      }
    }
  }

  public String a(int paramInt)
  {
    String[] arrayOfString = this.b.getPackagesForUid(paramInt);
    if (arrayOfString.length > 0);
    for (String str = a(arrayOfString[0]); ; str = "")
      return str;
  }

  public String a(String paramString)
  {
    return Base64.encodeToString(c(paramString), 9);
  }

  public String b(String paramString)
  {
    try
    {
      ApplicationInfo localApplicationInfo = this.b.getApplicationInfo(paramString, 0);
      String str2 = this.b.getApplicationLabel(localApplicationInfo).toString();
      str1 = str2;
      return str1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        String str1 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformPackageUtilities
 * JD-Core Version:    0.6.0
 */