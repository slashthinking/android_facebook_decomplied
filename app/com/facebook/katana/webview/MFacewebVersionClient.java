package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;

class MFacewebVersionClient
  implements ManagedDataStore.Client<Object, String>
{
  public String a(String paramString)
  {
    return paramString;
  }

  public boolean a(Object paramObject, String paramString)
  {
    return true;
  }

  public int b(Object paramObject, String paramString)
  {
    return 31536000;
  }

  public int c(Object paramObject, String paramString)
  {
    return 31536000;
  }

  public String getDiskKeyPrefix()
  {
    return MFacewebVersion.class.getSimpleName();
  }

  public String getDiskKeySuffix(Object paramObject)
  {
    return "MRootVersion";
  }

  public void initiateNetworkRequest(Context paramContext, Object paramObject, NetworkRequestCallback<Object, String> paramNetworkRequestCallback)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.MFacewebVersionClient
 * JD-Core Version:    0.6.0
 */