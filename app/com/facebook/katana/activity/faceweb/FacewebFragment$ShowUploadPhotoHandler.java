package com.facebook.katana.activity.faceweb;

import android.content.Intent;
import android.os.Handler;
import com.facebook.katana.activity.media.MediaPickerActivity;
import com.facebook.katana.activity.media.MediaPickerEnvironment.Builder;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.katana.webview.FacewebWebView;

public class FacewebFragment$ShowUploadPhotoHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$ShowUploadPhotoHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    boolean bool1 = true;
    FacewebFragment.b(this.a, paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "callback"));
    String str;
    Intent localIntent;
    boolean bool3;
    label129: MediaPickerEnvironment.Builder localBuilder2;
    if (FacewebFragment.b(this.a) != null)
    {
      str = FacewebFragment.b(this.a).getMobilePage();
      FacewebFragment.a(this.a, FacewebFragment.a(paramFacewebPalCall.a(str, "target")));
      boolean bool2 = StringUtils.a("true", paramFacewebPalCall.a(str, "photosOnly"));
      localIntent = new Intent(this.a.n(), MediaPickerActivity.class);
      MediaPickerEnvironment.Builder localBuilder1 = new MediaPickerEnvironment.Builder(FacewebFragment.h(this.a));
      if (FacewebFragment.g(this.a))
        break label196;
      bool3 = bool1;
      localBuilder2 = localBuilder1.b(bool3);
      if (bool2)
        break label202;
    }
    while (true)
    {
      localIntent.putExtra("extra_environment", localBuilder2.a(bool1).a());
      localIntent.putExtra("extra_source_activity", this.a.getClass().getSimpleName());
      this.a.a(localIntent, 50);
      return;
      str = null;
      break;
      label196: bool3 = false;
      break label129;
      label202: bool1 = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowUploadPhotoHandler
 * JD-Core Version:    0.6.0
 */