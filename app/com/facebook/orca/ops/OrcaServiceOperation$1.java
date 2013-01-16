package com.facebook.orca.ops;

import com.facebook.orca.server.ICompletionHandler.Stub;
import com.facebook.orca.server.OperationResult;

class OrcaServiceOperation$1 extends ICompletionHandler.Stub
{
  public void a(OperationResult paramOperationResult)
  {
    if (!OrcaServiceOperation.c(this.a))
      OrcaServiceOperation.a(this.a, new OrcaServiceOperation.1.1(this, paramOperationResult));
  }

  public void b(OperationResult paramOperationResult)
  {
    OrcaServiceOperation.b(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceOperation.1
 * JD-Core Version:    0.6.0
 */