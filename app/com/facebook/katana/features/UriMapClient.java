package com.facebook.katana.features;

import android.content.Context;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.common.json.jsonmirror.JMException;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.types.JMSimpleDict;
import com.facebook.common.util.Log;
import com.facebook.katana.IntentUriHandler.UriHandler;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.service.method.FqlGetUserServerSettings;
import com.facebook.katana.util.TraceLogger;
import com.facebook.uri.UriTemplateMap;
import com.facebook.uri.UriTemplateMap.InvalidUriTemplateException;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class UriMapClient
  implements ManagedDataStore.Client<Object, UriTemplateMap<IntentUriHandler.UriHandler>>
{
  protected abstract IntentUriHandler.UriHandler a(String paramString);

  protected abstract String a();

  public boolean a(Object paramObject, UriTemplateMap<IntentUriHandler.UriHandler> paramUriTemplateMap)
  {
    return true;
  }

  public UriTemplateMap<IntentUriHandler.UriHandler> b(String paramString)
  {
    try
    {
      JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(paramString);
      FbJsonChecker.a(localJsonParser);
      Object localObject = JMParser.a(localJsonParser, new JMSimpleDict());
      if ((localObject != null) && ((localObject instanceof Map)))
      {
        Map localMap = (Map)localObject;
        localUriTemplateMap2 = new UriTemplateMap();
        Iterator localIterator1 = d().entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
          String str2 = (String)localEntry2.getKey();
          try
          {
            localUriTemplateMap2.a(str2, a((String)localEntry2.getValue()));
          }
          catch (UriTemplateMap.InvalidUriTemplateException localInvalidUriTemplateException2)
          {
            Log.a(a(), "Invalid uri template: " + str2, localInvalidUriTemplateException2);
            throw localInvalidUriTemplateException2;
          }
        }
        Iterator localIterator2 = localMap.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
          String str1 = (String)localEntry1.getKey();
          try
          {
            localUriTemplateMap2.a(str1, a((String)localEntry1.getValue()));
          }
          catch (UriTemplateMap.InvalidUriTemplateException localInvalidUriTemplateException1)
          {
            Log.a(a(), "Invalid uri template: " + str1, localInvalidUriTemplateException1);
          }
        }
      }
    }
    catch (JMException localJMException)
    {
      UriTemplateMap localUriTemplateMap2;
      localUriTemplateMap1 = null;
      break label289;
      localUriTemplateMap1 = localUriTemplateMap2;
      break label289;
      localUriTemplateMap1 = null;
      return localUriTemplateMap1;
    }
    catch (IOException localIOException)
    {
      while (true)
        label289: UriTemplateMap localUriTemplateMap1 = null;
    }
  }

  protected abstract String b();

  protected abstract String c();

  protected abstract Map<String, String> d();

  public void initiateNetworkRequest(Context paramContext, Object paramObject, NetworkRequestCallback<Object, UriTemplateMap<IntentUriHandler.UriHandler>> paramNetworkRequestCallback)
  {
    UriMapClient.1 local1 = new UriMapClient.1(this, paramNetworkRequestCallback);
    TraceLogger localTraceLogger = paramNetworkRequestCallback.b();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = b();
    arrayOfObject[1] = c();
    localTraceLogger.a("requesting project name %s/map %s", arrayOfObject);
    AppSession localAppSession = AppSession.a(paramContext, false);
    if (localAppSession == null);
    while (true)
    {
      return;
      FqlGetUserServerSettings.a(localAppSession, paramContext, b(), c(), local1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.UriMapClient
 * JD-Core Version:    0.6.0
 */