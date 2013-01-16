package com.facebook.katana.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.util.Utils;
import java.util.List;

class RefreshableFacewebWebViewContainer$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = ((Integer)this.a.get(paramInt)).intValue();
    if (i == 2131363425);
    while (true)
    {
      try
      {
        Utils.a(this.b, this.c);
        RefreshableFacewebWebViewContainer.a(this.d, null);
        paramDialogInterface.dismiss();
        return;
      }
      catch (Exception localException)
      {
        ErrorReporting.a("RefreshableFacewebWebViewContainer", "copy link failed", localException);
        continue;
      }
      if (i != 2131363426)
        continue;
      this.b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.c)));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.webview.RefreshableFacewebWebViewContainer.2
 * JD-Core Version:    0.6.0
 */