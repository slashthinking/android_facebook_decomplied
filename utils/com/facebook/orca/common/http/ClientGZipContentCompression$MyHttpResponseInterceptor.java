package com.facebook.orca.common.http;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class ClientGZipContentCompression$MyHttpResponseInterceptor
  implements HttpResponseInterceptor
{
  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    Header localHeader = paramHttpResponse.getEntity().getContentEncoding();
    HeaderElement[] arrayOfHeaderElement;
    if (localHeader != null)
      arrayOfHeaderElement = localHeader.getElements();
    for (int i = 0; ; i++)
      if (i < arrayOfHeaderElement.length)
      {
        if (arrayOfHeaderElement[i].getName().equalsIgnoreCase("gzip"))
          paramHttpResponse.setEntity(new ClientGZipContentCompression.GzipDecompressingEntity(paramHttpResponse.getEntity()));
      }
      else
        return;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.ClientGZipContentCompression.MyHttpResponseInterceptor
 * JD-Core Version:    0.6.2
 */