package com.facebook.katana.activity.faceweb.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.katana.activity.faceweb.ActionSheetButton;
import com.facebook.katana.webview.FacewebWebView;
import java.util.List;

class ActionSheetDialogFragment$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a();
    FacewebWebView localFacewebWebView = this.a.L();
    if (localFacewebWebView == null);
    while (true)
    {
      return;
      if ((ActionSheetDialogFragment.a(this.a) != null) && (ActionSheetDialogFragment.a(this.a).size() > paramInt))
      {
        String str = ((ActionSheetButton)ActionSheetDialogFragment.a(this.a).get(paramInt)).callback;
        if (str == null)
          continue;
        localFacewebWebView.b(str, null);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.dialog.ActionSheetDialogFragment.2
 * JD-Core Version:    0.6.0
 */