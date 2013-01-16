package com.facebook.orca.users;

import android.content.res.Resources;
import com.facebook.orca.presence.Availability;
import com.facebook.orca.presence.PresenceState;

public class LastActiveHelper
{
  private final Resources a;

  public LastActiveHelper(Resources paramResources)
  {
    this.a = paramResources;
  }

  public long a(long paramLong, boolean paramBoolean, Availability paramAvailability)
  {
    long l1 = 0L;
    if (paramLong == l1)
      return l1;
    long l2 = System.currentTimeMillis() - paramLong;
    if ((paramAvailability == Availability.AVAILABLE) || ((paramBoolean) && (l2 < 3600000L)))
      paramLong = System.currentTimeMillis();
    while (true)
    {
      l1 = paramLong;
      break;
      if (l2 <= 345600000L)
        continue;
      paramLong = l1;
    }
  }

  public String a(long paramLong)
  {
    String str;
    if (paramLong == 0L)
      str = null;
    while (true)
    {
      return str;
      int i = (int)((System.currentTimeMillis() - paramLong) / 1000L);
      int j = i / 60;
      int k = j / 60;
      int m = k / 24;
      if (i < 60)
      {
        str = this.a.getString(2131362692);
        continue;
      }
      if (j == 1)
      {
        str = this.a.getString(2131362693);
        continue;
      }
      if (j < 60)
      {
        Resources localResources3 = this.a;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = Integer.valueOf(j);
        str = localResources3.getString(2131362694, arrayOfObject3);
        continue;
      }
      if (k == 1)
      {
        str = this.a.getString(2131362695);
        continue;
      }
      if (k < 24)
      {
        Resources localResources2 = this.a;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(k);
        str = localResources2.getString(2131362696, arrayOfObject2);
        continue;
      }
      if (m == 1)
      {
        str = this.a.getString(2131362697);
        continue;
      }
      Resources localResources1 = this.a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(m);
      str = localResources1.getString(2131362698, arrayOfObject1);
    }
  }

  public String a(LastActive paramLastActive, PresenceState paramPresenceState, LastActiveHelper.LastActiveFormat paramLastActiveFormat)
  {
    String str;
    if (paramLastActive == null)
      str = null;
    while (true)
    {
      return str;
      long l = a(paramLastActive.a(), paramLastActive.b(), paramPresenceState.a());
      if (LastActiveHelper.LastActiveFormat.SHORT == paramLastActiveFormat)
      {
        str = b(l);
        continue;
      }
      str = a(l);
    }
  }

  public String b(long paramLong)
  {
    String str;
    if (paramLong == 0L)
      str = null;
    while (true)
    {
      return str;
      int i = (int)((System.currentTimeMillis() - paramLong) / 1000L);
      int j = i / 60;
      int k = j / 60;
      int m = k / 24;
      if (i < 60)
      {
        Resources localResources4 = this.a;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Integer.valueOf(1);
        str = localResources4.getString(2131362701, arrayOfObject4);
        continue;
      }
      if (j < 60)
      {
        Resources localResources3 = this.a;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = Integer.valueOf(j);
        str = localResources3.getString(2131362701, arrayOfObject3);
        continue;
      }
      if (k < 24)
      {
        Resources localResources2 = this.a;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(k);
        str = localResources2.getString(2131362702, arrayOfObject2);
        continue;
      }
      Resources localResources1 = this.a;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(m);
      str = localResources1.getString(2131362703, arrayOfObject1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.LastActiveHelper
 * JD-Core Version:    0.6.0
 */