package com.facebook.orca.creation;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class CreateThreadActivity$3 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    CreateThreadActivity.b(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    CreateThreadActivity.b(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.creation.CreateThreadActivity.3
 * JD-Core Version:    0.6.0
 */