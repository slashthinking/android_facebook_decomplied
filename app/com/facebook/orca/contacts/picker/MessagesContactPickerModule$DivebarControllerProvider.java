package com.facebook.orca.contacts.picker;

import android.support.v4.content.LocalBroadcastManager;
import android.view.inputmethod.InputMethodManager;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.ui.titlebar.DivebarController;
import com.facebook.orca.contacts.divebar.DivebarViewListener;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesContactPickerModule$DivebarControllerProvider extends AbstractProvider<DivebarController>
{
  private MessagesContactPickerModule$DivebarControllerProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public DivebarController a()
  {
    return new DivebarController((InputMethodManager)b(InputMethodManager.class), (DataCache)b(DataCache.class), (AnalyticsLogger)b(AnalyticsLogger.class), (OrcaAppType)b(OrcaAppType.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), a(Boolean.class, IsClientSmsEnabled.class), c(DivebarViewListener.class), (LocalBroadcastManager)b(LocalBroadcastManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.DivebarControllerProvider
 * JD-Core Version:    0.6.0
 */