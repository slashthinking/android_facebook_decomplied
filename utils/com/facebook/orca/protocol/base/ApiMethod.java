package com.facebook.orca.protocol.base;

public abstract interface ApiMethod<PARAMS, RESULT>
{
  public abstract ApiRequest a(PARAMS paramPARAMS);

  public abstract RESULT a(PARAMS paramPARAMS, ApiResponse paramApiResponse);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ApiMethod
 * JD-Core Version:    0.6.2
 */