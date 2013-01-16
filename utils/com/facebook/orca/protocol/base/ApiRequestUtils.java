package com.facebook.orca.protocol.base;

import android.net.Uri.Builder;
import com.facebook.orca.locale.FBLocaleMapper;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Provider;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class ApiRequestUtils
{
  private final Provider<Locale> a;
  private final Provider<String> b;

  public ApiRequestUtils(Provider<Locale> paramProvider, Provider<String> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  private List<NameValuePair> a()
  {
    ArrayList localArrayList = Lists.a();
    localArrayList.add(new BasicNameValuePair("locale", FBLocaleMapper.a((Locale)this.a.b())));
    String str = (String)this.b.b();
    if (str != null)
      localArrayList.add(new BasicNameValuePair("client_country_code", str));
    return localArrayList;
  }

  public List<NameValuePair> a(ApiRequest paramApiRequest)
  {
    ArrayList localArrayList = Lists.a(paramApiRequest.d());
    localArrayList.addAll(a());
    return localArrayList;
  }

  public void a(Uri.Builder paramBuilder)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
      paramBuilder.appendQueryParameter(localNameValuePair.getName(), localNameValuePair.getValue());
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiRequestUtils
 * JD-Core Version:    0.6.2
 */