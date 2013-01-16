package com.facebook.katana.model;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.service.method.FqlGetPhotoSet;

class PhotoSetDataStoreClient
  implements ManagedDataStore.Client<String, FacebookPhotoSet>
{
  public String a(String paramString)
  {
    return paramString;
  }

  public void a(Context paramContext, String paramString, NetworkRequestCallback<String, FacebookPhotoSet> paramNetworkRequestCallback)
  {
    FqlGetPhotoSet.a(paramContext, paramString, paramNetworkRequestCallback);
  }

  public boolean a(String paramString, FacebookPhotoSet paramFacebookPhotoSet)
  {
    return true;
  }

  public int b(String paramString, FacebookPhotoSet paramFacebookPhotoSet)
  {
    return 3600;
  }

  public FacebookPhotoSet b(String paramString)
  {
    throw new IllegalStateException("operation not supported");
  }

  public int c(String paramString, FacebookPhotoSet paramFacebookPhotoSet)
  {
    return 0;
  }

  public String getDiskKeyPrefix()
  {
    return FacebookPhotoSet.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.PhotoSetDataStoreClient
 * JD-Core Version:    0.6.0
 */