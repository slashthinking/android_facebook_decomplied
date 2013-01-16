package com.facebook.katana.activity.faceweb.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.katana.model.NewsFeedToggleOption;
import com.facebook.katana.webview.FacewebWebView;
import java.util.List;

class FeedFilterPickerDialogFragment$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.c.a();
    FacewebWebView localFacewebWebView = this.c.L();
    if (localFacewebWebView == null);
    while (true)
    {
      return;
      if ((FeedFilterPickerDialogFragment.a(this.c) != null) && (FeedFilterPickerDialogFragment.a(this.c).size() > paramInt) && (this.a != paramInt))
      {
        String str = ((NewsFeedToggleOption)FeedFilterPickerDialogFragment.a(this.c).get(paramInt)).script;
        if (str != null)
          localFacewebWebView.b(str, null);
      }
      localFacewebWebView.b(this.b, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.dialog.FeedFilterPickerDialogFragment.2
 * JD-Core Version:    0.6.0
 */