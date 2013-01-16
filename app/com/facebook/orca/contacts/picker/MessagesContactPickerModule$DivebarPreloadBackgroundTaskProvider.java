package com.facebook.orca.contacts.picker;

import com.facebook.app.UserActivityManager;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.contacts.divebar.DivebarLoaderFactory;
import com.facebook.orca.contacts.divebar.DivebarPreloadBackgroundTask;
import com.facebook.orca.inject.AbstractProvider;

class MessagesContactPickerModule$DivebarPreloadBackgroundTaskProvider extends AbstractProvider<DivebarPreloadBackgroundTask>
{
  private MessagesContactPickerModule$DivebarPreloadBackgroundTaskProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public DivebarPreloadBackgroundTask a()
  {
    return new DivebarPreloadBackgroundTask((DivebarLoaderFactory)b(DivebarLoaderFactory.class), (UserActivityManager)b(UserActivityManager.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.DivebarPreloadBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */