package com.facebook.katana.features.faceweb;

import com.facebook.debug.LogPrefixer;
import com.facebook.katana.IntentUriHandler.UriHandler;
import com.facebook.katana.features.UriMapClient;
import com.facebook.uri.UriTemplateMap;
import java.util.Map;

class FacewebUriMapClient extends UriMapClient
{
  public static Class<?> a = FacewebUriMapClient.class;

  protected IntentUriHandler.UriHandler a(String paramString)
  {
    return new FacewebUriMap.FacewebUriHandler(paramString);
  }

  protected String a()
  {
    return LogPrefixer.a(a);
  }

  public int b(Object paramObject, UriTemplateMap<IntentUriHandler.UriHandler> paramUriTemplateMap)
  {
    return 3600;
  }

  protected String b()
  {
    return "android_faceweb";
  }

  public int c(Object paramObject, UriTemplateMap<IntentUriHandler.UriHandler> paramUriTemplateMap)
  {
    return 3600;
  }

  protected String c()
  {
    return "urimap";
  }

  protected Map<String, String> d()
  {
    return FacewebUriMap.a;
  }

  public String getDiskKeyPrefix()
  {
    return FacewebUriMap.class.getSimpleName();
  }

  public String getDiskKeySuffix(Object paramObject)
  {
    return "urimap";
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.faceweb.FacewebUriMapClient
 * JD-Core Version:    0.6.0
 */