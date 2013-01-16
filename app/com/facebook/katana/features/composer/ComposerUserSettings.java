package com.facebook.katana.features.composer;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.service.method.FqlGetUserServerSettings;

public class ComposerUserSettings
{
  private static ManagedDataStore<String, String> a;

  public static FqlGetUserServerSettings a(Context paramContext, AppSession paramAppSession, String paramString)
  {
    return FqlGetUserServerSettings.b(paramAppSession, paramContext, "structured_composer", paramString, c(paramContext));
  }

  public static String a(Context paramContext, String paramString)
  {
    return (String)c(paramContext).a(paramString);
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    c(paramContext).a(paramContext, true, paramString1, paramString2, paramString2);
  }

  public static boolean a(Context paramContext)
  {
    return "1".equals(a(paramContext, "composer_share_location"));
  }

  public static boolean b(Context paramContext)
  {
    return true;
  }

  protected static ManagedDataStore<String, String> c(Context paramContext)
  {
    if (a == null)
      a = new ManagedDataStore(ComposerUserSettings.ComposerUserSettingsClient.INSTANCE, paramContext);
    return a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.ComposerUserSettings
 * JD-Core Version:    0.6.0
 */