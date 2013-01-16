package com.facebook.orca.app;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.common.names.NameJoiner;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.login.AuthStateMachineMonitor;
import com.facebook.orca.login.LoginAfterAuthCoordinator;
import com.facebook.orca.login.WildfireAnalyticsUtils;
import com.facebook.orca.login.WildfireRegistrationOperation;
import com.facebook.orca.nux.OrcaNuxManager;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesModule$WildfireRegistrationOperationProvider extends AbstractProvider<WildfireRegistrationOperation>
{
  private MessagesModule$WildfireRegistrationOperationProvider(MessagesModule paramMessagesModule)
  {
  }

  public WildfireRegistrationOperation a()
  {
    return new WildfireRegistrationOperation((AnalyticsLogger)b(AnalyticsLogger.class), (AuthStateMachineMonitor)b(AuthStateMachineMonitor.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaNuxManager)b(OrcaNuxManager.class), (WildfireAnalyticsUtils)b(WildfireAnalyticsUtils.class), (LoginAfterAuthCoordinator)b(LoginAfterAuthCoordinator.class), (NameJoiner)b(NameJoiner.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.WildfireRegistrationOperationProvider
 * JD-Core Version:    0.6.0
 */