package com.facebook.device_id;

import com.facebook.content.SecureBroadcastReceiver;

public class UniqueIdSupplier extends SecureBroadcastReceiver
{
  public UniqueIdSupplier()
  {
    super("com.facebook.GET_UNIQUE_ID", new UniqueIdRequestAction());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.device_id.UniqueIdSupplier
 * JD-Core Version:    0.6.0
 */