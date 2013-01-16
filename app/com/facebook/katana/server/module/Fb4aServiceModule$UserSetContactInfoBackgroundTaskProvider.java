package com.facebook.katana.server.module;

import com.facebook.katana.provider.KeyValueManager;
import com.facebook.katana.server.background.UserSetContactInfoBackgroundTask;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class Fb4aServiceModule$UserSetContactInfoBackgroundTaskProvider extends AbstractProvider<UserSetContactInfoBackgroundTask>
{
  private Fb4aServiceModule$UserSetContactInfoBackgroundTaskProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public UserSetContactInfoBackgroundTask a()
  {
    return new UserSetContactInfoBackgroundTask(Fb4aServiceModule.a(this.a), (KeyValueManager)b(KeyValueManager.class), (Clock)b(Clock.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), a(String.class, MeUserId.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.UserSetContactInfoBackgroundTaskProvider
 * JD-Core Version:    0.6.0
 */