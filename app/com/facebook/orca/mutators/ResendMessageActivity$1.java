package com.facebook.orca.mutators;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ResendMessageActivity$1 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    ResendMessageActivity.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    ResendMessageActivity.a(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.mutators.ResendMessageActivity.1
 * JD-Core Version:    0.6.0
 */