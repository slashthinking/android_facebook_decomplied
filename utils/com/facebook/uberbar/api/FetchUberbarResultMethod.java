package com.facebook.uberbar.api;

import com.facebook.ipc.data.uberbar.UberbarResult;
import com.facebook.ipc.data.uberbar.UberbarResult.Type;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.protocol.base.ApiResponseType;
import com.facebook.uberbar.UberbarResults;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public class FetchUberbarResultMethod
  implements ApiMethod<FetchUberbarResultParams, List<UberbarResult>>
{
  public ApiRequest a(FetchUberbarResultParams paramFetchUberbarResultParams)
  {
    String str1 = paramFetchUberbarResultParams.a;
    int i = paramFetchUberbarResultParams.b;
    ArrayList localArrayList1 = Lists.a();
    Iterator localIterator = paramFetchUberbarResultParams.c.iterator();
    while (localIterator.hasNext())
    {
      UberbarResult.Type localType = (UberbarResult.Type)localIterator.next();
      localArrayList1.add("'" + localType.name().toLowerCase() + "'");
    }
    String str2 = "[" + Joiner.on(", ").join(localArrayList1) + "]";
    ArrayList localArrayList2 = Lists.a();
    localArrayList2.add(new BasicNameValuePair("query", str1));
    localArrayList2.add(new BasicNameValuePair("context", "mobile_search_android"));
    localArrayList2.add(new BasicNameValuePair("photo_size", Integer.toString(i)));
    localArrayList2.add(new BasicNameValuePair("filter", str2));
    localArrayList2.add(new BasicNameValuePair("include_native_android_url", "true"));
    localArrayList2.add(new BasicNameValuePair("format", "json"));
    return new ApiRequest("fetch_uberbar_result", "GET", "method/ubersearch.get", localArrayList2, ApiResponseType.STRING);
  }

  public List<UberbarResult> a(FetchUberbarResultParams paramFetchUberbarResultParams, ApiResponse paramApiResponse)
  {
    Tracer localTracer = Tracer.a("FetchUberbarResultMethod.getResponse");
    try
    {
      List localList = UberbarResults.a(paramApiResponse.b());
      return localList;
    }
    finally
    {
      localTracer.a();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.api.FetchUberbarResultMethod
 * JD-Core Version:    0.6.2
 */