package com.facebook.orca.cache;

import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import java.util.Map;

class SaveDraftManager$1 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    SaveDraftManager.a(this.b).remove(this.a);
  }

  public void a(OperationResult paramOperationResult)
  {
    SaveDraftManager.a(this.b).remove(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.SaveDraftManager.1
 * JD-Core Version:    0.6.0
 */