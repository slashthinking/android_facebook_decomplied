package com.facebook.katana.features.places;

import android.content.Context;
import android.location.Location;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.service.method.FqlGetAtTags;

public class SelectAtTagFetcher
{
  public static final Class<?> a = SelectAtTagFetcher.class;
  protected static ManagedDataStore<SelectAtTagFetcher.SelectAtTagArgType, FqlGetAtTags> b;

  protected static ManagedDataStore<SelectAtTagFetcher.SelectAtTagArgType, FqlGetAtTags> a(Context paramContext)
  {
    if (b == null)
      b = new ManagedDataStore(new SelectAtTagManagedStoreClient(), ManagedDataStore.Mode.SINGLE_REQUEST_BY_KEY, paramContext);
    return b;
  }

  public static FqlGetAtTags a(Context paramContext, SelectAtTagFetcher.SelectAtTagArgType paramSelectAtTagArgType)
  {
    FqlGetAtTags localFqlGetAtTags = (FqlGetAtTags)a(paramContext).a(paramSelectAtTagArgType);
    if (localFqlGetAtTags == null);
    for (localFqlGetAtTags = null; ; localFqlGetAtTags = null)
    {
      do
        return localFqlGetAtTags;
      while ((a(paramSelectAtTagArgType.a, localFqlGetAtTags.f)) && (paramSelectAtTagArgType.c == localFqlGetAtTags.h) && (paramSelectAtTagArgType.d == localFqlGetAtTags.i));
      a(paramContext, paramSelectAtTagArgType, a(paramContext));
    }
  }

  protected static String a(Context paramContext, SelectAtTagFetcher.SelectAtTagArgType paramSelectAtTagArgType, NetworkRequestCallback<SelectAtTagFetcher.SelectAtTagArgType, FqlGetAtTags> paramNetworkRequestCallback)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    for (String str = null; ; str = localAppSession.a(paramContext.getApplicationContext(), paramSelectAtTagArgType.a, paramSelectAtTagArgType.b, paramSelectAtTagArgType.c, paramSelectAtTagArgType.d, paramNetworkRequestCallback))
      return str;
  }

  public static boolean a(Location paramLocation1, Location paramLocation2)
  {
    int i = 1;
    if ((paramLocation1 == null) && (paramLocation2 == null));
    while (true)
    {
      return i;
      if ((paramLocation1 != null) && (paramLocation2 != null))
      {
        if (paramLocation1.distanceTo(paramLocation2) < 20.0F)
          continue;
        i = 0;
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.places.SelectAtTagFetcher
 * JD-Core Version:    0.6.0
 */