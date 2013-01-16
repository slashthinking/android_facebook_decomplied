package com.facebook.katana.features.faceweb;

import android.content.Context;
import com.facebook.katana.IntentUriHandler.UriHandler;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import com.facebook.uri.UriTemplateMap;
import java.util.Map;

public class FacewebUriMap
{
  public static final Map<String, String> a = new FacewebUriMap.1();
  protected static ManagedDataStore<Object, UriTemplateMap<IntentUriHandler.UriHandler>> b;

  public static UriTemplateMap<IntentUriHandler.UriHandler> a(Context paramContext)
  {
    return (UriTemplateMap)b(paramContext).a(null);
  }

  protected static ManagedDataStore<Object, UriTemplateMap<IntentUriHandler.UriHandler>> b(Context paramContext)
  {
    if (b == null)
      b = new ManagedDataStore(new FacewebUriMapClient(), ManagedDataStore.Mode.SINGLE_REQUEST, paramContext);
    return b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.faceweb.FacewebUriMap
 * JD-Core Version:    0.6.0
 */