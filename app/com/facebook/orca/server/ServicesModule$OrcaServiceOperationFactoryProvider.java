package com.facebook.orca.server;

import android.content.Context;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class ServicesModule$OrcaServiceOperationFactoryProvider extends AbstractProvider<OrcaServiceOperationFactory>
{
  private ServicesModule$OrcaServiceOperationFactoryProvider(ServicesModule paramServicesModule)
  {
  }

  public OrcaServiceOperationFactory a()
  {
    return new OrcaServiceOperationFactory((Context)b(Context.class), (OrcaServiceRegistry)b(OrcaServiceRegistry.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ServicesModule.OrcaServiceOperationFactoryProvider
 * JD-Core Version:    0.6.0
 */