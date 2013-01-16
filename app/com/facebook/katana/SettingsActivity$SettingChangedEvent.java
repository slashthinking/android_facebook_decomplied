package com.facebook.katana;

import com.facebook.analytics.HoneyClientEvent;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Actions;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;

class SettingsActivity$SettingChangedEvent extends HoneyClientEvent
{
  public SettingsActivity$SettingChangedEvent(SettingsActivity paramSettingsActivity, String paramString, Object paramObject)
  {
    super(FB4A_AnalyticEntities.Actions.a);
    f(paramString);
    e(FB4A_AnalyticEntities.UIElementsTypes.d);
    d(paramSettingsActivity.a());
    b("value", paramObject.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.SettingChangedEvent
 * JD-Core Version:    0.6.0
 */