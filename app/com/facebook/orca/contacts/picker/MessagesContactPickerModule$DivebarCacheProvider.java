package com.facebook.orca.contacts.picker;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.contacts.divebar.DivebarCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.PayForPlayPresence;
import com.facebook.orca.presence.PresenceManager;

class MessagesContactPickerModule$DivebarCacheProvider extends AbstractProvider<DivebarCache>
{
  private MessagesContactPickerModule$DivebarCacheProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public DivebarCache a()
  {
    return new DivebarCache((Clock)b(Clock.class), (PresenceManager)b(PresenceManager.class), a(PayForPlayPresence.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.DivebarCacheProvider
 * JD-Core Version:    0.6.0
 */