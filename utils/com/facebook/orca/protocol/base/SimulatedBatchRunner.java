package com.facebook.orca.protocol.base;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jayway.jsonpath.JsonPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SimulatedBatchRunner extends BatchRunner
{
  private static final Pattern a = Pattern.compile("\\{result=([^}:]*):([^}]*)\\}");
  private SingleMethodRunner b;
  private Map<String, Object> c = Maps.a();

  public SimulatedBatchRunner(SingleMethodRunner paramSingleMethodRunner)
  {
    this.b = paramSingleMethodRunner;
  }

  private ApiRequest a(ApiRequest paramApiRequest)
  {
    if (!b(paramApiRequest));
    while (true)
    {
      return paramApiRequest;
      String str = c(paramApiRequest.c());
      ArrayList localArrayList = Lists.a();
      Iterator localIterator = paramApiRequest.d().iterator();
      while (localIterator.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
        localArrayList.add(new BasicNameValuePair(localNameValuePair.getName(), c(localNameValuePair.getValue())));
      }
      paramApiRequest = new ApiRequest(paramApiRequest.a(), paramApiRequest.b(), str, localArrayList, paramApiRequest.f(), paramApiRequest.e());
    }
  }

  private boolean b(ApiRequest paramApiRequest)
  {
    boolean bool;
    if (d(paramApiRequest.c()))
      bool = true;
    while (true)
    {
      return bool;
      Iterator localIterator = paramApiRequest.d().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          String str = ((NameValuePair)localIterator.next()).getValue();
          if (a.matcher(str).find())
          {
            bool = true;
            break;
          }
        }
      bool = false;
    }
  }

  private String c(String paramString)
  {
    if (!d(paramString));
    while (true)
    {
      return paramString;
      Matcher localMatcher = a.matcher(paramString);
      StringBuffer localStringBuffer = new StringBuffer();
      while (localMatcher.find())
      {
        String str1 = localMatcher.group(1);
        String str2 = localMatcher.group(2);
        Object localObject = this.c.get(str1);
        if (localObject == null)
          throw new Exception("No json result named " + str1);
        localMatcher.appendReplacement(localStringBuffer, (String)JsonPath.a(localObject.toString(), str2));
      }
      localMatcher.appendTail(localStringBuffer);
      paramString = localStringBuffer.toString();
    }
  }

  private boolean d(String paramString)
  {
    return a.matcher(paramString).find();
  }

  public void b(String paramString)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      BatchOperation localBatchOperation = (BatchOperation)localIterator.next();
      String str = localBatchOperation.c();
      ApiMethod localApiMethod = localBatchOperation.a();
      ApiRequest localApiRequest = a(localApiMethod.a(localBatchOperation.b()));
      ApiResponse localApiResponse = this.b.a(localApiRequest);
      if (str != null)
        this.c.put(str, localApiResponse.e());
      Object localObject = localApiMethod.a(localBatchOperation.b(), localApiResponse);
      a(localBatchOperation.c(), localObject);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.SimulatedBatchRunner
 * JD-Core Version:    0.6.2
 */