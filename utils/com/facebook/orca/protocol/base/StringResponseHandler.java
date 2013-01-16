package com.facebook.orca.protocol.base;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class StringResponseHandler
  implements ResponseHandler<String>
{
  private final ApiResponseChecker a;
  private HttpResponse b;

  public StringResponseHandler(ApiResponseChecker paramApiResponseChecker)
  {
    this.a = paramApiResponseChecker;
  }

  public String a(HttpResponse paramHttpResponse)
  {
    this.b = paramHttpResponse;
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    String str1;
    int i;
    String str2;
    if (localHttpEntity == null)
    {
      str1 = null;
      i = localStatusLine.getStatusCode();
      if (i < 300)
        break label127;
      if (i == 400)
        this.a.a(str1);
      str2 = localStatusLine.getReasonPhrase();
      if (str1 == null)
        break label120;
    }
    label120: for (String str3 = str2 + "\n" + str1; ; str3 = str2)
    {
      throw new HttpResponseException(i, str3);
      str1 = EntityUtils.toString(localHttpEntity);
      break;
    }
    label127: return str1;
  }

  public HttpResponse a()
  {
    return this.b;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.StringResponseHandler
 * JD-Core Version:    0.6.2
 */