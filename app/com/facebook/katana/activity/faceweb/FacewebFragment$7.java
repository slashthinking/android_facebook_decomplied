package com.facebook.katana.activity.faceweb;

import android.app.Dialog;
import android.os.Handler;
import com.facebook.common.util.Log;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.dialog.Dialogs;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import java.util.List;

class FacewebFragment$7 extends FacebookWebView.NativeUICallHandler
{
  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    long l = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "userId", -1L);
    if (l == -1L)
      Log.b(this.b.k(), "addFriend RPC failed");
    while (true)
    {
      return;
      FacewebFragment.7.1 local1 = new FacewebFragment.7.1(this);
      FacewebFragment.c(this.b).add(local1);
      FacewebFragment.d(this.b).a(local1);
      Dialog localDialog = Dialogs.a(this.a, l, new FacewebFragment.7.2(this));
      localDialog.setOwnerActivity(this.a);
      localDialog.show();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.7
 * JD-Core Version:    0.6.0
 */