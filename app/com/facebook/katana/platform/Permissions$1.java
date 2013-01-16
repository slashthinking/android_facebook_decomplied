package com.facebook.katana.platform;

import java.util.Comparator;
import java.util.Map;

class Permissions$1
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if ((Permissions.a(this.a).containsKey(paramString1)) && (Permissions.a(this.a).containsKey(paramString2)));
    for (int i = ((Permission)Permissions.a(this.a).get(paramString1)).a() - ((Permission)Permissions.a(this.a).get(paramString2)).a(); ; i = paramString1.compareTo(paramString2))
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.Permissions.1
 * JD-Core Version:    0.6.0
 */