package com.facebook.katana.features.places;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.service.method.FqlGetAtTags;

class SelectAtTagManagedStoreClient
  implements ManagedDataStore.Client<SelectAtTagFetcher.SelectAtTagArgType, FqlGetAtTags>
{
  public static final String a = SelectAtTagFetcher.class.getSimpleName();

  public int a(SelectAtTagFetcher.SelectAtTagArgType paramSelectAtTagArgType, FqlGetAtTags paramFqlGetAtTags)
  {
    return 1800;
  }

  public FqlGetAtTags a(String paramString)
  {
    throw new IllegalStateException("Attempting to deserialize FqlGetAtTags, currently unsupported");
  }

  public String a(SelectAtTagFetcher.SelectAtTagArgType paramSelectAtTagArgType)
  {
    return "places_nearby";
  }

  public void a(Context paramContext, SelectAtTagFetcher.SelectAtTagArgType paramSelectAtTagArgType, NetworkRequestCallback<SelectAtTagFetcher.SelectAtTagArgType, FqlGetAtTags> paramNetworkRequestCallback)
  {
    SelectAtTagFetcher.a(paramContext, paramSelectAtTagArgType, paramNetworkRequestCallback);
  }

  public int b(SelectAtTagFetcher.SelectAtTagArgType paramSelectAtTagArgType, FqlGetAtTags paramFqlGetAtTags)
  {
    return 0;
  }

  public boolean c(SelectAtTagFetcher.SelectAtTagArgType paramSelectAtTagArgType, FqlGetAtTags paramFqlGetAtTags)
  {
    return false;
  }

  public String getDiskKeyPrefix()
  {
    return SelectAtTagFetcher.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.places.SelectAtTagManagedStoreClient
 * JD-Core Version:    0.6.0
 */