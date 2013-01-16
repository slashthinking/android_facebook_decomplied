package com.facebook.katana.activity.faceweb;

import android.os.Bundle;
import android.os.Handler;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.composer.model.SharePreview;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.Shareable;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;

public class FacewebFragment$ShowShareComposerHandler extends FacebookWebView.NativeUICallHandler
{
  private final String b = "ShowShareComposerHandler";
  private String d;
  private boolean e;

  public FacewebFragment$ShowShareComposerHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  private Bundle a(Shareable paramShareable, SharePreview paramSharePreview)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("extra_is_share", true);
    localBundle.putBoolean(ComposerConstants.c, true);
    localBundle.putParcelable("extra_shareable", paramShareable);
    localBundle.putParcelable("extra_share_preview", paramSharePreview);
    return localBundle;
  }

  public void a()
  {
    this.e = false;
    this.d = null;
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str1 = paramFacebookWebView.getMobilePage();
    FacewebFragment.b(this.a, paramFacewebPalCall.a(str1, "callback"));
    String str2 = paramFacewebPalCall.a(str1, "fbid");
    String str3 = paramFacewebPalCall.a(str1, "title");
    if (StringUtils.c(str2))
      ErrorReporting.a("ShowShareComposerHandler", "blank fbid", true);
    while (true)
    {
      return;
      if (StringUtils.c(str3))
      {
        ErrorReporting.a("ShowShareComposerHandler", "blank title", true);
        continue;
      }
      if (this.e)
      {
        if (str2.equals(this.d))
        {
          Log.b("ShowShareComposerHandler", "duplicate onclick for share composer");
          continue;
        }
        ErrorReporting.a("ShowShareComposerHandler", "onclick event for two fbids while share composer is launched", true);
      }
      String str4 = paramFacewebPalCall.a(str1, "external_url");
      String str5 = paramFacewebPalCall.a(str1, "caption");
      String str6 = paramFacewebPalCall.a(str1, "preview_image_url");
      Bundle localBundle = a(new Shareable(str2, new GraphQLObjectType(paramFacewebPalCall.a(str1, "object_type"))), new SharePreview(str3, str5, null, str6, str4));
      if (!this.a.a(null, localBundle, Integer.valueOf(11), 536870912, FacewebFragment.i(this.a)))
        continue;
      this.d = str2;
      this.e = true;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowShareComposerHandler
 * JD-Core Version:    0.6.0
 */