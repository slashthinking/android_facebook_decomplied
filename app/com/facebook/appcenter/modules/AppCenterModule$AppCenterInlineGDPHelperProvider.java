package com.facebook.appcenter.modules;

import com.facebook.appcenter.model.AppPrivacyOptionList;
import com.facebook.appcenter.util.AppCenterInlineGDPHelper;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppCenterInlineGDPHelperProvider extends AbstractProvider<AppCenterInlineGDPHelper>
{
  private AppCenterModule$AppCenterInlineGDPHelperProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppCenterInlineGDPHelper a()
  {
    return new AppCenterInlineGDPHelper(AppCenterModule.a(this.a), (AppPrivacyOptionList)b(AppPrivacyOptionList.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterInlineGDPHelperProvider
 * JD-Core Version:    0.6.0
 */