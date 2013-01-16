package com.facebook.orca.app;

import com.facebook.location.GetDeviceLocationExecutor;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.location.LocationServiceHandler;

class MessagesModule$LocationServiceHandlerProvider extends AbstractProvider<LocationServiceHandler>
{
  private MessagesModule$LocationServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public LocationServiceHandler a()
  {
    return new LocationServiceHandler((GetDeviceLocationExecutor)b(GetDeviceLocationExecutor.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.LocationServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */