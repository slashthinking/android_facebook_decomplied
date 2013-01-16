package com.facebook.analytics;

import com.google.common.io.CountingInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

final class AnalyticsOrcaHttpClientObserver$BytesCountingEntity$MyCountingInputStream extends FilterInputStream
{
  AnalyticsOrcaHttpClientObserver$BytesCountingEntity$MyCountingInputStream(AnalyticsOrcaHttpClientObserver.BytesCountingEntity paramBytesCountingEntity, InputStream paramInputStream)
  {
    super(new CountingInputStream(paramInputStream));
  }

  private void a()
  {
    try
    {
      long l = ((CountingInputStream)this.in).a();
      if (l > AnalyticsOrcaHttpClientObserver.BytesCountingEntity.a(this.a))
      {
        AnalyticsOrcaHttpClientObserver.c(this.a.a).a(AnalyticsOrcaHttpClientObserver.BytesCountingEntity.b(this.a), AnalyticsOrcaHttpClientObserver.BytesCountingEntity.c(this.a), l - AnalyticsOrcaHttpClientObserver.BytesCountingEntity.a(this.a));
        AnalyticsOrcaHttpClientObserver.BytesCountingEntity.a(this.a, l);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int read()
  {
    int i = this.in.read();
    a();
    return i;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    a();
    return i;
  }

  public long skip(long paramLong)
  {
    long l = this.in.skip(paramLong);
    a();
    return l;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsOrcaHttpClientObserver.BytesCountingEntity.MyCountingInputStream
 * JD-Core Version:    0.6.2
 */