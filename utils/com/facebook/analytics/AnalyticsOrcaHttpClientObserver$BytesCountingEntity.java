package com.facebook.analytics;

import java.io.InputStream;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

final class AnalyticsOrcaHttpClientObserver$BytesCountingEntity extends HttpEntityWrapper
{
  private final URI b;
  private final String c;
  private long d = 0L;
  private InputStream e = null;
  private AnalyticsOrcaHttpClientObserver.BytesCountingEntity.MyCountingInputStream f;

  public AnalyticsOrcaHttpClientObserver$BytesCountingEntity(AnalyticsOrcaHttpClientObserver paramAnalyticsOrcaHttpClientObserver, HttpEntity paramHttpEntity, URI paramURI, String paramString)
  {
    super(paramHttpEntity);
    this.b = paramURI;
    this.c = paramString;
  }

  public InputStream getContent()
  {
    InputStream localInputStream = this.wrappedEntity.getContent();
    if (localInputStream != this.e)
    {
      this.e = localInputStream;
      this.f = new AnalyticsOrcaHttpClientObserver.BytesCountingEntity.MyCountingInputStream(this, localInputStream);
    }
    return this.f;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsOrcaHttpClientObserver.BytesCountingEntity
 * JD-Core Version:    0.6.2
 */