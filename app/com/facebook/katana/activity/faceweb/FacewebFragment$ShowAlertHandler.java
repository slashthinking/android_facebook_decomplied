package com.facebook.katana.activity.faceweb;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.facebook.common.util.Log;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import java.util.HashSet;

public class FacewebFragment$ShowAlertHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowAlertHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  @TargetApi(11)
  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    if (!this.a.u());
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    do
    {
      while (true)
      {
        return;
        String str1 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "alertID");
        if (StringUtils.c(str1))
          break;
        if (FacewebFragment.O().contains(str1))
        {
          Log.e(this.a.Q(), "ignored previously-seen alert " + str1);
          continue;
        }
        FacewebFragment.O().add(str1);
      }
      str2 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "button0Url");
      str3 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "button1Url");
      str4 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "message");
      str5 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "title");
      str6 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "button0Title");
      str7 = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "button1Title");
    }
    while (StringUtils.c(str4));
    AlertDialog.Builder localBuilder;
    label198: FacewebFragment.ShowAlertHandler.1 local1;
    label259: FacewebFragment.ShowAlertHandler.2 local2;
    if (Build.VERSION.SDK_INT >= 14)
    {
      localBuilder = new AlertDialog.Builder(this.a.n(), 4);
      localBuilder.setCancelable(false);
      localBuilder.setMessage(str4);
      if (!StringUtils.c(str5))
        localBuilder.setTitle(str5);
      local1 = new FacewebFragment.ShowAlertHandler.1(this, str2);
      if (StringUtils.c(str6))
        break label319;
      localBuilder.setPositiveButton(str6, local1);
      local2 = new FacewebFragment.ShowAlertHandler.2(this, str3);
      if (StringUtils.c(str7))
        break label342;
      localBuilder.setNegativeButton(str7, local2);
    }
    while (true)
    {
      localBuilder.create().show();
      break;
      localBuilder = new AlertDialog.Builder(this.a.n());
      break label198;
      label319: localBuilder.setPositiveButton(this.a.n().getString(2131361888), local1);
      break label259;
      label342: if (StringUtils.c(str3))
        continue;
      localBuilder.setNegativeButton(this.a.n().getString(2131362848), local2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowAlertHandler
 * JD-Core Version:    0.6.0
 */