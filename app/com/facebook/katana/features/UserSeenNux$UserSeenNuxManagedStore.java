package com.facebook.katana.features;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class UserSeenNux$UserSeenNuxManagedStore extends ManagedDataStore<UserSeenNux.Project, Boolean>
{
  private final Map<UserSeenNux.Project, List<UserSeenNux.UserSeenNuxCallback>> m = Maps.a();

  public UserSeenNux$UserSeenNuxManagedStore(Context paramContext)
  {
    super(new UserSeenNuxManagedStoreClient(), paramContext);
  }

  private void a(UserSeenNux.Project paramProject, boolean paramBoolean)
  {
    synchronized (this.m)
    {
      if (this.m.containsKey(paramProject))
      {
        ImmutableList localImmutableList = ImmutableList.a((Collection)this.m.get(paramProject));
        this.m.clear();
        Iterator localIterator = localImmutableList.iterator();
        if (localIterator.hasNext())
          ((UserSeenNux.UserSeenNuxCallback)localIterator.next()).a(paramBoolean);
      }
    }
  }

  public void a(Context paramContext, boolean paramBoolean, UserSeenNux.Project paramProject, String paramString, Boolean paramBoolean1)
  {
    super.a(paramContext, paramBoolean, paramProject, paramString, paramBoolean1);
    if (!paramBoolean);
    while (true)
    {
      return;
      a(paramProject, paramBoolean1.booleanValue());
    }
  }

  public void a(UserSeenNux.Project paramProject, UserSeenNux.UserSeenNuxCallback paramUserSeenNuxCallback)
  {
    synchronized (this.m)
    {
      if (!this.m.containsKey(paramProject))
        this.m.put(paramProject, new ArrayList());
      ((List)this.m.get(paramProject)).add(paramUserSeenNuxCallback);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.UserSeenNux.UserSeenNuxManagedStore
 * JD-Core Version:    0.6.0
 */