package com.facebook.orca.common.http;

import com.facebook.common.util.NetAccessLogger;
import com.facebook.orca.debug.BLog;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.RequestWrapper;

public class OrcaHttpDebugProcessorHook
{
  private static final Class<?> a = OrcaHttpDebugProcessorHook.class;
  private final NetAccessLogger b;

  public OrcaHttpDebugProcessorHook(NetAccessLogger paramNetAccessLogger)
  {
    this.b = paramNetAccessLogger;
  }

  private String a(HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity != null);
    String str;
    try
    {
      if (paramHttpEntity.isRepeatable())
      {
        if (paramHttpEntity.getContentLength() >= 4096L)
          break label89;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramHttpEntity.writeTo(localByteArrayOutputStream);
        str = localByteArrayOutputStream.toString();
      }
      else
      {
        str = "[NULL OR NON-REPEATABLE ENTITY]";
      }
    }
    catch (IOException localIOException)
    {
      str = "[" + localIOException.getMessage() + "]";
    }
    while (true)
    {
      return str;
      label89: str = "[TOO MUCH DATA TO INCLUDE]";
    }
  }

  private URI a(HttpUriRequest paramHttpUriRequest)
  {
    URI localURI1 = paramHttpUriRequest.getURI();
    HttpRequest localHttpRequest;
    if ((paramHttpUriRequest instanceof RequestWrapper))
    {
      localHttpRequest = ((RequestWrapper)paramHttpUriRequest).getOriginal();
      if (!(localHttpRequest instanceof HttpUriRequest));
    }
    for (URI localURI2 = ((HttpUriRequest)localHttpRequest).getURI(); ; localURI2 = localURI1)
      return localURI2;
  }

  public void a(HttpRequest paramHttpRequest)
  {
    if (!(paramHttpRequest instanceof HttpUriRequest));
    while (true)
    {
      return;
      HttpUriRequest localHttpUriRequest = (HttpUriRequest)paramHttpRequest;
      this.b.a(localHttpUriRequest.getURI().toString());
      if (BLog.b(2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Http request:");
        localStringBuilder.append(a(localHttpUriRequest));
        localStringBuilder.append("\n");
        for (Header localHeader : localHttpUriRequest.getAllHeaders())
        {
          localStringBuilder.append(localHeader.getName());
          localStringBuilder.append(": ");
          localStringBuilder.append(localHeader.getValue());
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("\n");
        if ((paramHttpRequest instanceof HttpEntityEnclosingRequest))
        {
          localStringBuilder.append(a(((HttpEntityEnclosingRequest)paramHttpRequest).getEntity()));
          localStringBuilder.append("\n");
        }
        BLog.a(a, localStringBuilder.toString());
      }
    }
  }

  public void a(HttpResponse paramHttpResponse, Object paramObject)
  {
    if (!BLog.b(2))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Http Response:\n");
    for (Header localHeader : paramHttpResponse.getAllHeaders())
    {
      localStringBuilder.append(localHeader.getName());
      localStringBuilder.append(": ");
      localStringBuilder.append(localHeader.getValue());
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("\n");
    if (paramObject != null)
    {
      if (!(paramObject instanceof String))
        break label144;
      localStringBuilder.append("Body:\n");
      localStringBuilder.append((String)paramObject);
    }
    while (true)
    {
      BLog.a(a, localStringBuilder.toString());
      break;
      label144: if ((paramObject instanceof JsonNode))
      {
        localStringBuilder.append("Body:\n");
        localStringBuilder.append(paramObject.toString());
      }
      else
      {
        localStringBuilder.append("Body: ");
        localStringBuilder.append("[").append(paramObject.getClass().getName()).append("]");
        localStringBuilder.append("\n");
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpDebugProcessorHook
 * JD-Core Version:    0.6.2
 */