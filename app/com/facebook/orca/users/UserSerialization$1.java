package com.facebook.orca.users;

import java.text.SimpleDateFormat;
import java.util.Locale;

class UserSerialization$1 extends ThreadLocal<SimpleDateFormat>
{
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("M/d/y", Locale.US);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserSerialization.1
 * JD-Core Version:    0.6.0
 */