package com.facebook.analytics.util;

import com.facebook.common.util.Log;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;

public class NetworkDataLogUtils
{
  private static final Class<?> a = NetworkDataLogUtils.class;

  public long a(HttpMessage paramHttpMessage)
  {
    long l = 0L;
    HeaderIterator localHeaderIterator = paramHttpMessage.headerIterator();
    while (localHeaderIterator.hasNext())
      l += localHeaderIterator.nextHeader().toString().length();
    return l;
  }

  public long a(HttpUriRequest paramHttpUriRequest)
  {
    long l1 = a(paramHttpUriRequest);
    long l3;
    if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequest))
    {
      HttpEntity localHttpEntity = ((HttpEntityEnclosingRequest)paramHttpUriRequest).getEntity();
      if (localHttpEntity != null)
      {
        l3 = localHttpEntity.getContentLength();
        if (l3 <= 0L);
      }
    }
    for (long l2 = l1 + l3; ; l2 = l1)
    {
      RequestLine localRequestLine = paramHttpUriRequest.getRequestLine();
      if (localRequestLine != null)
        l2 += localRequestLine.toString().length();
      return l2;
    }
  }

  public String a(HttpResponse paramHttpResponse)
  {
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    String str = null;
    if (localHttpEntity != null)
    {
      Header localHeader2 = localHttpEntity.getContentType();
      str = null;
      if (localHeader2 != null)
        str = localHttpEntity.getContentType().getValue();
    }
    if (str == null)
    {
      Header localHeader1 = paramHttpResponse.getFirstHeader("Content-Type");
      if (localHeader1 != null)
        str = localHeader1.getValue();
    }
    return str;
  }

  public long b(HttpMessage paramHttpMessage)
  {
    int i = 1;
    int j = 0;
    Header[] arrayOfHeader = paramHttpMessage.getHeaders("Content-Length");
    int k;
    if (arrayOfHeader != null)
      k = i;
    while (true)
    {
      label43: String str;
      if (arrayOfHeader.length > 0)
      {
        if ((k & i) == 0)
          break label118;
        int m = arrayOfHeader.length;
        l1 = 0L;
        if (j >= m)
          break label123;
        str = arrayOfHeader[j].getValue();
        if (str == null);
      }
      try
      {
        long l2 = Long.parseLong(str);
        if (l2 > 0L)
          l1 += l2;
        j++;
        break label43;
        k = 0;
        continue;
        i = 0;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          Log.a(a, "Failure in getting content length from the header", localNumberFormatException);
      }
    }
    label118: long l1 = -1L;
    label123: return l1;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.util.NetworkDataLogUtils
 * JD-Core Version:    0.6.2
 */