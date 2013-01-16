package com.facebook.orca.images;

import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.ops.OrcaServiceOperation.OnCompletedListener;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class ThreadIconPickerActivity$2 extends OrcaServiceOperation.OnCompletedListener
{
  public void a(ServiceException paramServiceException)
  {
    ErrorDialogBuilder.a(this.a).a(2131362339).a(paramServiceException).a(this.a).a();
  }

  public void a(OperationResult paramOperationResult)
  {
    this.a.finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ThreadIconPickerActivity.2
 * JD-Core Version:    0.6.0
 */