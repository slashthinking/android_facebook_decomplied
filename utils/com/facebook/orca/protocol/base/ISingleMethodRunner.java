package com.facebook.orca.protocol.base;

public abstract interface ISingleMethodRunner
{
  public abstract <PARAMS, RESULT> RESULT a(ApiMethod<PARAMS, RESULT> paramApiMethod, PARAMS paramPARAMS);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ISingleMethodRunner
 * JD-Core Version:    0.6.2
 */