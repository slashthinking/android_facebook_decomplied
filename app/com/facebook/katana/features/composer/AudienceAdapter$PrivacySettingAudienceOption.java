package com.facebook.katana.features.composer;

import android.content.Context;
import com.facebook.ipc.model.PrivacySetting;

public class AudienceAdapter$PrivacySettingAudienceOption
  implements AudienceOption
{
  PrivacySetting a;

  public AudienceAdapter$PrivacySettingAudienceOption(AudienceAdapter paramAudienceAdapter, PrivacySetting paramPrivacySetting)
  {
    this.a = paramPrivacySetting;
  }

  public int a()
  {
    int i;
    if (this.a.value.equals("EVERYONE"))
      i = 2130837542;
    while (true)
    {
      return i;
      if (this.a.value.equals("ALL_FRIENDS"))
      {
        i = 2130837545;
        continue;
      }
      if (this.a.value.equals("SELF"))
      {
        i = 2130837547;
        continue;
      }
      if (this.a.value.equals("FRIENDS_OF_FRIENDS"))
      {
        i = 2130837544;
        continue;
      }
      if (this.a.value.equals("CUSTOM"))
      {
        if (this.a.equals(PrivacySetting.FB_ONLY))
        {
          i = 2130837543;
          continue;
        }
        i = 2130837541;
        continue;
      }
      i = -1;
    }
  }

  public String b()
  {
    String str;
    if (this.a.value.equals("EVERYONE"))
      str = AudienceAdapter.a(this.b).getString(2131363053);
    while (true)
    {
      return str;
      if (this.a.value.equals("ALL_FRIENDS"))
      {
        str = AudienceAdapter.a(this.b).getString(2131363056);
        continue;
      }
      if (this.a.value.equals("SELF"))
      {
        str = AudienceAdapter.a(this.b).getString(2131363058);
        continue;
      }
      if (this.a.value.equals("FRIENDS_OF_FRIENDS"))
      {
        str = AudienceAdapter.a(this.b).getString(2131363054);
        continue;
      }
      if (this.a.value.equals("CUSTOM"))
      {
        str = this.a.description;
        continue;
      }
      str = null;
    }
  }

  public AudienceOption.Type c()
  {
    return AudienceOption.Type.PRIVACY_SETTING;
  }

  public PrivacySetting d()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.composer.AudienceAdapter.PrivacySettingAudienceOption
 * JD-Core Version:    0.6.0
 */