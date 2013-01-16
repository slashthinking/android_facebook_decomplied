package com.facebook.katana.features.composer;

import android.content.Context;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.service.method.FqlGetUserServerSettings;

 enum ComposerUserSettings$ComposerUserSettingsClient
  implements ManagedDataStore.Client<String, String>
{
  static
  {
    ComposerUserSettingsClient[] arrayOfComposerUserSettingsClient = new ComposerUserSettingsClient[1];
    arrayOfComposerUserSettingsClient[0] = INSTANCE;
    $VALUES = arrayOfComposerUserSettingsClient;
  }

  public String deserialize(String paramString)
  {
    return paramString;
  }

  public int getCacheTtl(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals("composer_share_location")));
    for (int i = 3600; ; i = 31536000)
      return i;
  }

  public String getDiskKeyPrefix()
  {
    return ComposerUserSettings.class.getSimpleName();
  }

  public String getDiskKeySuffix(String paramString)
  {
    return paramString;
  }

  public int getPersistentStoreTtl(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals("composer_share_location")));
    for (int i = 3600; ; i = 31536000)
      return i;
  }

  public void initiateNetworkRequest(Context paramContext, String paramString, NetworkRequestCallback<String, String> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.a(paramContext, false);
    if (localAppSession == null);
    while (true)
    {
      return;
      FqlGetUserServerSettings.a(localAppSession, paramContext, "structured_composer", paramString, paramNetworkRequestCallback);
    }
  }

  public boolean staleDataAcceptable(String paramString1, String paramString2)
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.ComposerUserSettings.ComposerUserSettingsClient
 * JD-Core Version:    0.6.0
 */