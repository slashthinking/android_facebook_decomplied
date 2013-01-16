package com.facebook.katana.activity.media;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.SharedPrefKeys;

class Fb4aPhotosModule$IsNewGalleryEnabledProvider extends AbstractProvider<Boolean>
{
  private Fb4aPhotosModule$IsNewGalleryEnabledProvider(Fb4aPhotosModule paramFb4aPhotosModule)
  {
  }

  public Boolean a()
  {
    return Boolean.valueOf(((OrcaSharedPreferences)b(OrcaSharedPreferences.class)).a(SharedPrefKeys.w, false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aPhotosModule.IsNewGalleryEnabledProvider
 * JD-Core Version:    0.6.0
 */