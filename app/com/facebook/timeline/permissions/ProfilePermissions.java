package com.facebook.timeline.permissions;

import com.facebook.common.util.Log;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class ProfilePermissions
{
  private BitSet a = new BitSet(ProfilePermissions.Permission.values().length);

  public ProfilePermissions()
  {
  }

  public ProfilePermissions(List<String> paramList)
  {
    this();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        ProfilePermissions.Permission localPermission = ProfilePermissions.Permission.valueOf(str);
        this.a.set(localPermission.getBit());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Log.b("Got unknown profile permission: " + str);
      }
    }
  }

  public boolean a(ProfilePermissions.Permission paramPermission)
  {
    return this.a.get(paramPermission.getBit());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.permissions.ProfilePermissions
 * JD-Core Version:    0.6.0
 */