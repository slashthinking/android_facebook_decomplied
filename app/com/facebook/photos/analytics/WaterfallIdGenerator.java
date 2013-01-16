package com.facebook.photos.analytics;

import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.common.util.StringUtil;
import java.util.Date;
import java.util.UUID;

public class WaterfallIdGenerator
{
  private final UniqueIdForDeviceHolder a;

  public WaterfallIdGenerator(UniqueIdForDeviceHolder paramUniqueIdForDeviceHolder)
  {
    this.a = paramUniqueIdForDeviceHolder;
  }

  public String a()
  {
    Object[] arrayOfObject;
    if (this.a != null)
    {
      String str2 = this.a.b();
      arrayOfObject = new Object[2];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = Long.toString(new Date().getTime());
    }
    for (String str1 = Long.toString(StringUtil.e(StringUtil.a("%s%s", arrayOfObject))); ; str1 = UUID.randomUUID().toString())
      return str1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.analytics.WaterfallIdGenerator
 * JD-Core Version:    0.6.0
 */