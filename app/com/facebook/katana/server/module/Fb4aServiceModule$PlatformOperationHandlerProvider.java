package com.facebook.katana.server.module;

import android.content.Context;
import com.facebook.katana.platform.Permissions;
import com.facebook.katana.server.handler.PlatformOperationHandler;
import com.facebook.katana.server.protocol.AuthorizeAppMethod;
import com.facebook.katana.server.protocol.GetNativeGdpNuxStatusMethod;
import com.facebook.katana.server.protocol.GetPermissionsDescriptionMethod;
import com.facebook.katana.server.protocol.UpdateNativeGdpNuxStatusMethod;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.fasterxml.jackson.databind.ObjectMapper;

class Fb4aServiceModule$PlatformOperationHandlerProvider extends AbstractProvider<PlatformOperationHandler>
{
  private Fb4aServiceModule$PlatformOperationHandlerProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public PlatformOperationHandler a()
  {
    return new PlatformOperationHandler((Context)b(Context.class, FromApplication.class), (ObjectMapper)b(ObjectMapper.class), a(SingleMethodRunner.class), (AuthorizeAppMethod)b(AuthorizeAppMethod.class), (GetPermissionsDescriptionMethod)b(GetPermissionsDescriptionMethod.class), (Permissions)b(Permissions.class), (UpdateNativeGdpNuxStatusMethod)b(UpdateNativeGdpNuxStatusMethod.class), (GetNativeGdpNuxStatusMethod)b(GetNativeGdpNuxStatusMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.PlatformOperationHandlerProvider
 * JD-Core Version:    0.6.0
 */