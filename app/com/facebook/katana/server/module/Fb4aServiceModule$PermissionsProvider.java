package com.facebook.katana.server.module;

import android.content.Context;
import com.facebook.katana.platform.Permissions;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class Fb4aServiceModule$PermissionsProvider extends AbstractProvider<Permissions>
{
  private Fb4aServiceModule$PermissionsProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public Permissions a()
  {
    return new Permissions((Context)b(Context.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.PermissionsProvider
 * JD-Core Version:    0.6.0
 */