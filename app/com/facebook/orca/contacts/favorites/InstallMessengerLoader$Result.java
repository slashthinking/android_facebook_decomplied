package com.facebook.orca.contacts.favorites;

import com.facebook.orca.users.MobileAppData;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InstallMessengerLoader$Result
{
  private final ImmutableList<User> a;

  public InstallMessengerLoader$Result(ImmutableList<User> paramImmutableList)
  {
    this.a = paramImmutableList;
  }

  public ImmutableList<User> a()
  {
    return this.a;
  }

  public ImmutableList<User> a(List<Long> paramList)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    if (this.a != null)
    {
      Iterator localIterator1 = this.a.iterator();
      while (true)
      {
        if (!localIterator1.hasNext())
          break label100;
        User localUser = (User)localIterator1.next();
        MobileAppData localMobileAppData = localUser.C();
        if (localMobileAppData == null)
          continue;
        Iterator localIterator2 = paramList.iterator();
        if (!localIterator2.hasNext())
          continue;
        if (!localMobileAppData.a((Long)localIterator2.next()).booleanValue())
          break;
        localBuilder.b(localUser);
      }
    }
    label100: return localBuilder.b();
  }

  public ImmutableList<User> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(256002347743983L));
    localArrayList.add(Long.valueOf(237759909591655L));
    localArrayList.add(Long.valueOf(172336202840178L));
    return a(localArrayList);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null)
      localStringBuilder.append("mobileAppDataFriends: ").append(this.a.size());
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.favorites.InstallMessengerLoader.Result
 * JD-Core Version:    0.6.0
 */