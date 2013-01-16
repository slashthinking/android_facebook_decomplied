package com.facebook.orca.protocol.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public abstract class BatchRunner
{
  private List<BatchOperation> a = Lists.a();
  private List b = Lists.a();
  private Map<String, Object> c = Maps.a();

  public <RESULT> RESULT a(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public <RESULT> RESULT a(String paramString)
  {
    return this.c.get(paramString);
  }

  public List<BatchOperation> a()
  {
    return this.a;
  }

  public <PARAMS, RESULT> void a(BatchOperation<PARAMS, RESULT> paramBatchOperation)
  {
    this.a.add(paramBatchOperation);
  }

  protected void a(String paramString, Object paramObject)
  {
    this.b.add(paramObject);
    if (paramString != null)
      this.c.put(paramString, paramObject);
  }

  public abstract void b(String paramString);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.BatchRunner
 * JD-Core Version:    0.6.2
 */