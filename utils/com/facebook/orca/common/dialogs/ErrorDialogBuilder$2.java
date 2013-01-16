package com.facebook.orca.common.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.orca.debug.ErrorReportSender;
import com.facebook.orca.ops.ServiceException;

class ErrorDialogBuilder$2
  implements DialogInterface.OnClickListener
{
  ErrorDialogBuilder$2(ErrorDialogBuilder paramErrorDialogBuilder)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (ErrorDialogBuilder.a(this.a) != null)
      ErrorDialogBuilder.a(this.a).finish();
    new ErrorReportSender(ErrorDialogBuilder.b(this.a)).a(ErrorDialogBuilder.c(this.a).b());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.dialogs.ErrorDialogBuilder.2
 * JD-Core Version:    0.6.2
 */