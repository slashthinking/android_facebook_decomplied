package com.facebook.katana.platform;

import android.os.Bundle;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class ShareDialogActionExecutor$1
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    if (ShareDialogActionExecutor.a(this.b) != null)
      ShareDialogActionExecutor.a(this.b).b(new Bundle());
    this.a.b();
  }

  public void a(Throwable paramThrowable)
  {
    if (ShareDialogActionExecutor.a(this.b) != null)
      ShareDialogActionExecutor.a(this.b).c(AuthorizeAppResults.a(paramThrowable));
    this.a.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.ShareDialogActionExecutor.1
 * JD-Core Version:    0.6.0
 */