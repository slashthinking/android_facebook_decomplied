package com.facebook.orca.sms;

import com.facebook.orca.threads.ParticipantInfo;

class FetchMmsSmsThreadSummaryResult
{
  private final long a;
  private final long b;
  private final long c;
  private final boolean d;
  private final String e;
  private final String f;
  private final ParticipantInfo g;

  FetchMmsSmsThreadSummaryResult(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, String paramString)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramBoolean;
    this.e = paramString;
    this.f = null;
    this.g = null;
  }

  FetchMmsSmsThreadSummaryResult(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, String paramString1, String paramString2, ParticipantInfo paramParticipantInfo)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramBoolean;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramParticipantInfo;
  }

  static FetchMmsSmsThreadSummaryResult a(FetchMmsSmsThreadSummaryResult paramFetchMmsSmsThreadSummaryResult, String paramString, ParticipantInfo paramParticipantInfo)
  {
    return new FetchMmsSmsThreadSummaryResult(paramFetchMmsSmsThreadSummaryResult.a, paramFetchMmsSmsThreadSummaryResult.b, paramFetchMmsSmsThreadSummaryResult.c, paramFetchMmsSmsThreadSummaryResult.d, paramFetchMmsSmsThreadSummaryResult.e, paramString, paramParticipantInfo);
  }

  long a()
  {
    return this.a;
  }

  long b()
  {
    return this.b;
  }

  long c()
  {
    return this.c;
  }

  boolean d()
  {
    return this.d;
  }

  String e()
  {
    return this.e;
  }

  String f()
  {
    return this.f;
  }

  ParticipantInfo g()
  {
    return this.g;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.FetchMmsSmsThreadSummaryResult
 * JD-Core Version:    0.6.0
 */