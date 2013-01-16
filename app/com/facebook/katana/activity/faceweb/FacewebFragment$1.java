package com.facebook.katana.activity.faceweb;

import android.content.Context;
import com.facebook.ipc.model.PrivacySetting.Category;
import com.facebook.katana.features.composer.ComposerUserSettings;
import com.facebook.katana.service.method.AudienceSettings;

class FacewebFragment$1
  implements Runnable
{
  public void run()
  {
    if (this.a != null)
    {
      FacewebFragment.a(this.b, AudienceSettings.a(this.a, PrivacySetting.Category.composer_sticky));
      ComposerUserSettings.a(this.a, "composer_share_location");
      ComposerUserSettings.a(this.a, "composer_tour_completed");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.1
 * JD-Core Version:    0.6.0
 */