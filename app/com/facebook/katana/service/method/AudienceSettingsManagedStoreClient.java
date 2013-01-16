package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.ipc.model.PrivacySetting.Category;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;

class AudienceSettingsManagedStoreClient
  implements ManagedDataStore.Client<PrivacySetting.Category, AudienceSettings>
{
  public int a(PrivacySetting.Category paramCategory, AudienceSettings paramAudienceSettings)
  {
    return 300;
  }

  public AudienceSettings a(String paramString)
  {
    throw new UnsupportedOperationException("Cannot deserialize AudienceSettings");
  }

  public String a(PrivacySetting.Category paramCategory)
  {
    return paramCategory.toString();
  }

  public void a(Context paramContext, PrivacySetting.Category paramCategory, NetworkRequestCallback<PrivacySetting.Category, AudienceSettings> paramNetworkRequestCallback)
  {
    AudienceSettings.a(paramContext, paramCategory, paramNetworkRequestCallback);
  }

  public int b(PrivacySetting.Category paramCategory, AudienceSettings paramAudienceSettings)
  {
    return 0;
  }

  public boolean c(PrivacySetting.Category paramCategory, AudienceSettings paramAudienceSettings)
  {
    return true;
  }

  public String getDiskKeyPrefix()
  {
    return AudienceSettings.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.AudienceSettingsManagedStoreClient
 * JD-Core Version:    0.6.0
 */