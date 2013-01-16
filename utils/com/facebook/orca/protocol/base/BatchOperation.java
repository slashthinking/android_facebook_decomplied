package com.facebook.orca.protocol.base;

public class BatchOperation<PARAMS, RESULT>
{
  private final ApiMethod<PARAMS, RESULT> a;
  private final PARAMS b;
  private final String c;
  private final String d;

  BatchOperation(BatchOperation.Builder<PARAMS, RESULT> paramBuilder)
  {
    this.a = BatchOperation.Builder.a(paramBuilder);
    this.b = BatchOperation.Builder.b(paramBuilder);
    this.c = BatchOperation.Builder.c(paramBuilder);
    this.d = BatchOperation.Builder.d(paramBuilder);
  }

  public static <PARAMS, RESULT> BatchOperation.Builder<PARAMS, RESULT> a(ApiMethod<PARAMS, RESULT> paramApiMethod, PARAMS paramPARAMS)
  {
    return new BatchOperation.Builder(paramApiMethod, paramPARAMS);
  }

  public ApiMethod<PARAMS, RESULT> a()
  {
    return this.a;
  }

  public PARAMS b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.BatchOperation
 * JD-Core Version:    0.6.2
 */