package com.facebook.orca.cache;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ArchiveThreadManager$1 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    ArchiveThreadManager.a(this.b, paramServiceException, this.a);
  }

  public void a(OperationResult paramOperationResult)
  {
    ArchiveThreadManager.a(this.b, paramOperationResult, this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.ArchiveThreadManager.1
 * JD-Core Version:    0.6.0
 */