package com.facebook.katana.features;

import android.content.Context;

public class UserSeenNux
{
  private static final Class<?> a = UserSeenNux.class;
  private static UserSeenNux.UserSeenNuxManagedStore b;

  private static UserSeenNux.UserSeenNuxManagedStore a(Context paramContext)
  {
    if (b == null)
      b = new UserSeenNux.UserSeenNuxManagedStore(paramContext);
    return b;
  }

  public static void a(Context paramContext, UserSeenNux.Project paramProject)
  {
    a(paramContext).b(paramProject);
  }

  public static void a(Context paramContext, UserSeenNux.Project paramProject, UserSeenNux.UserSeenNuxCallback paramUserSeenNuxCallback)
  {
    UserSeenNux.UserSeenNuxManagedStore localUserSeenNuxManagedStore = a(paramContext);
    localUserSeenNuxManagedStore.a(paramProject, paramUserSeenNuxCallback);
    Boolean localBoolean = (Boolean)localUserSeenNuxManagedStore.a(paramProject);
    if (localBoolean != null)
      UserSeenNux.UserSeenNuxManagedStore.a(localUserSeenNuxManagedStore, paramProject, localBoolean.booleanValue());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.UserSeenNux
 * JD-Core Version:    0.6.0
 */