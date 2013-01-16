package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacewebPalCall;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FacewebFragment$ShowReplyPublisherHandler extends FacewebFragment.ShowTextPublisherHandler
{
  String a;

  public FacewebFragment$ShowReplyPublisherHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramFacewebFragment, paramHandler);
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    this.a = this.f.a(paramFacebookWebView.getMobilePage(), "callback");
  }

  protected void a(FacebookWebView paramFacebookWebView, TextView paramTextView)
  {
    super.a(paramFacebookWebView, paramTextView);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("text", paramTextView.getText().toString().trim());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localJSONObject);
      this.b.g(4);
      paramFacebookWebView.a(this.a, localArrayList, this);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        Log.a(this.b.Q(), "inconceivable exception " + localJSONException.toString());
    }
  }

  public void a(FacebookWebView paramFacebookWebView, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.b.h(4);
    if (paramBoolean)
      Toaster.a(this.b.n(), 2131363199);
    while (true)
    {
      return;
      super.a(paramFacebookWebView, paramString1, paramBoolean, paramString2);
    }
  }

  public void b(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    View localView = this.b.A();
    if ((this.f == null) || (localView == null));
    while (true)
    {
      return;
      super.b(paramContext, paramFacebookWebView);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowReplyPublisherHandler
 * JD-Core Version:    0.6.0
 */