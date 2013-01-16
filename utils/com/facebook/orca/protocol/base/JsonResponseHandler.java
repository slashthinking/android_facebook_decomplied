package com.facebook.orca.protocol.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class JsonResponseHandler
  implements ResponseHandler<JsonNode>
{
  private final ObjectMapper a;
  private final ApiResponseChecker b;
  private HttpResponse c;

  public JsonResponseHandler(ObjectMapper paramObjectMapper, ApiResponseChecker paramApiResponseChecker)
  {
    this.a = paramObjectMapper;
    this.b = paramApiResponseChecker;
  }

  public JsonNode a(HttpResponse paramHttpResponse)
  {
    this.c = paramHttpResponse;
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    int i = localStatusLine.getStatusCode();
    if (i >= 300)
    {
      if (localHttpEntity == null);
      for (String str1 = null; ; str1 = EntityUtils.toString(localHttpEntity))
      {
        if (i == 400)
          this.b.a(str1);
        String str2 = localStatusLine.getReasonPhrase();
        if (str1 != null)
          str2 = str2 + "\n" + str1;
        throw new HttpResponseException(i, str2);
      }
    }
    return this.a.readTree(localHttpEntity.getContent());
  }

  public HttpResponse a()
  {
    return this.c;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.JsonResponseHandler
 * JD-Core Version:    0.6.2
 */