package com.facebook.orca.app;

import com.facebook.hardware.DeviceInfoSerializer;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$DeviceInfoSerializerProvider extends AbstractProvider<DeviceInfoSerializer>
{
  private FbBaseModule$DeviceInfoSerializerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public DeviceInfoSerializer a()
  {
    return new DeviceInfoSerializer();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.DeviceInfoSerializerProvider
 * JD-Core Version:    0.6.0
 */