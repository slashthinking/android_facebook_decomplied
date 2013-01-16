package com.facebook.orca.threadview.upsell;

import com.facebook.orca.common.dialogs.ErrorDialogBuilder;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;

class MergedThreadsUpsellController$4 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    MergedThreadsUpsellController.b(this.a, null);
    ErrorDialogBuilder.a(MergedThreadsUpsellController.a(this.a)).a(2131362339).b(2131362714).a();
  }

  public void a(OperationResult paramOperationResult)
  {
    MergedThreadsUpsellController.b(this.a, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.upsell.MergedThreadsUpsellController.4
 * JD-Core Version:    0.6.0
 */