package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.model.PageTopic;
import java.util.ArrayList;
import java.util.List;

class PageTopicsGet$PageTopicsManagedStoreClient
  implements ManagedDataStore.Client<String, List<PageTopic>>
{
  public String a(String paramString)
  {
    return paramString;
  }

  public void a(Context paramContext, String paramString, NetworkRequestCallback<String, List<PageTopic>> paramNetworkRequestCallback)
  {
    PageTopicsGet.b(paramContext);
  }

  public boolean a(String paramString, List<PageTopic> paramList)
  {
    return true;
  }

  public int b(String paramString, List<PageTopic> paramList)
  {
    return 31536000;
  }

  public List<PageTopic> b(String paramString)
  {
    try
    {
      localObject = PageTopicsGet.e(paramString).data;
      if (localObject == null)
        localObject = new ArrayList();
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.a(PageTopicsGet.i(), localException.getMessage(), localException);
        Object localObject = null;
      }
    }
  }

  public int c(String paramString, List<PageTopic> paramList)
  {
    return b(paramString, paramList);
  }

  public String getDiskKeyPrefix()
  {
    return PageTopicsGet.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PageTopicsGet.PageTopicsManagedStoreClient
 * JD-Core Version:    0.6.0
 */