package com.facebook.orca.protocol.base;

public class BatchOperation$Builder<PARAMS, RESULT>
{
  private final ApiMethod<PARAMS, RESULT> a;
  private final PARAMS b;
  private String c;
  private String d;

  public BatchOperation$Builder(ApiMethod<PARAMS, RESULT> paramApiMethod, PARAMS paramPARAMS)
  {
    this.a = paramApiMethod;
    this.b = paramPARAMS;
  }

  public Builder<PARAMS, RESULT> a(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public BatchOperation<PARAMS, RESULT> a()
  {
    return new BatchOperation(this);
  }

  public Builder<PARAMS, RESULT> b(String paramString)
  {
    this.d = paramString;
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.BatchOperation.Builder
 * JD-Core Version:    0.6.2
 */