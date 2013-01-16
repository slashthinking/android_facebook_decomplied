package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.UiCounters;

class MessagesModule$UiCountersProvider extends AbstractProvider<UiCounters>
{
  private MessagesModule$UiCountersProvider(MessagesModule paramMessagesModule)
  {
  }

  public UiCounters a()
  {
    return new UiCounters((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.UiCountersProvider
 * JD-Core Version:    0.6.0
 */