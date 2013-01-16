package com.facebook.katana.features;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.service.method.FqlGetUserSeenNux;

class UserSeenNuxManagedStoreClient
  implements ManagedDataStore.Client<UserSeenNux.Project, Boolean>
{
  public static final String a = UserSeenNux.class.getSimpleName();

  public int a(UserSeenNux.Project paramProject, Boolean paramBoolean)
  {
    return 3600;
  }

  public Boolean a(String paramString)
  {
    return Boolean.valueOf(paramString);
  }

  public String a(UserSeenNux.Project paramProject)
  {
    return "user_seen_nux";
  }

  public void a(Context paramContext, UserSeenNux.Project paramProject, NetworkRequestCallback<UserSeenNux.Project, Boolean> paramNetworkRequestCallback)
  {
    FqlGetUserSeenNux.a(paramContext, paramProject, paramNetworkRequestCallback);
  }

  public int b(UserSeenNux.Project paramProject, Boolean paramBoolean)
  {
    return 3600;
  }

  public boolean c(UserSeenNux.Project paramProject, Boolean paramBoolean)
  {
    return false;
  }

  public String getDiskKeyPrefix()
  {
    return UserSeenNux.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.UserSeenNuxManagedStoreClient
 * JD-Core Version:    0.6.0
 */