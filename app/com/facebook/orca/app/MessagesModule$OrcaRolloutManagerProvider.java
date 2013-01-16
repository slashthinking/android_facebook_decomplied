package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.rollout.OrcaRolloutManager;

class MessagesModule$OrcaRolloutManagerProvider extends AbstractProvider<OrcaRolloutManager>
{
  private MessagesModule$OrcaRolloutManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public OrcaRolloutManager a()
  {
    return new OrcaRolloutManager((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaAppType)b(OrcaAppType.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OrcaRolloutManagerProvider
 * JD-Core Version:    0.6.0
 */