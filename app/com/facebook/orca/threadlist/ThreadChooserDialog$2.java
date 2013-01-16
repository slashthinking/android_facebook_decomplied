package com.facebook.orca.threadlist;

import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ThreadChooserDialog$2 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    ThreadChooserDialog.a(this.a).d();
    ThreadChooserDialog.a(this.a, paramServiceException);
  }

  public void a(OperationResult paramOperationResult)
  {
    ThreadChooserDialog.a(this.a).d();
    ThreadChooserDialog.a(this.a, paramOperationResult);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadChooserDialog.2
 * JD-Core Version:    0.6.0
 */