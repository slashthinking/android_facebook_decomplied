package com.facebook.katana.activity.faceweb;

import android.content.Intent;
import android.os.Handler;
import com.facebook.katana.activity.profilelist.FriendMultiSelectorActivity;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import java.util.HashSet;

public class FacewebFragment$ShowFriendPickerHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowFriendPickerHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    Intent localIntent = new Intent(this.a.n(), FriendMultiSelectorActivity.class);
    FacewebFragment.b(this.a, paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "callback"));
    localIntent.putExtra("profiles", IntentUtils.a(new HashSet()));
    this.a.a(localIntent, 40);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowFriendPickerHandler
 * JD-Core Version:    0.6.0
 */