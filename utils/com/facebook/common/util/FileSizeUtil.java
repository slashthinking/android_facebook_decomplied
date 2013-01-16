package com.facebook.common.util;

import android.content.res.Resources;

public class FileSizeUtil
{
  private final Resources a;

  public FileSizeUtil(Resources paramResources)
  {
    this.a = paramResources;
  }

  public String a(int paramInt)
  {
    String str;
    if (paramInt < 2048)
    {
      Resources localResources3 = this.a;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(paramInt);
      str = localResources3.getString(2131362204, arrayOfObject3);
    }
    while (true)
    {
      return str;
      int i = paramInt / 1024;
      if (i < 2048)
      {
        Resources localResources2 = this.a;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(i);
        str = localResources2.getString(2131362205, arrayOfObject2);
      }
      else
      {
        int j = i / 1024;
        Resources localResources1 = this.a;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(j);
        str = localResources1.getString(2131362206, arrayOfObject1);
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.FileSizeUtil
 * JD-Core Version:    0.6.2
 */