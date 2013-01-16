package com.facebook.orca.app;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.login.OrcaAuthStateMachineMonitor;

class MessagesModule$OrcaAuthStateMachineMonitorProvider extends AbstractProvider<OrcaAuthStateMachineMonitor>
{
  private MessagesModule$OrcaAuthStateMachineMonitorProvider(MessagesModule paramMessagesModule)
  {
  }

  public OrcaAuthStateMachineMonitor a()
  {
    return new OrcaAuthStateMachineMonitor(LocalBroadcastManager.a((Context)b(Context.class, FromApplication.class)));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.OrcaAuthStateMachineMonitorProvider
 * JD-Core Version:    0.6.0
 */