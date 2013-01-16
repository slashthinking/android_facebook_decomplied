package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.ui.mentions.MentionsAutoCompleteTextView;
import com.facebook.katana.ui.mentions.MentionsUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacewebPalCall;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FacewebFragment$ShowCommentPublisherHandler extends FacewebFragment.ShowTextPublisherHandler
{
  protected String a;
  protected String b;

  public FacewebFragment$ShowCommentPublisherHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramFacewebFragment, paramHandler);
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    this.a = this.f.a(paramFacebookWebView.getMobilePage(), "callback");
    this.b = this.f.a(paramFacebookWebView.getMobilePage(), "post_id");
  }

  protected void a(FacebookWebView paramFacebookWebView, TextView paramTextView)
  {
    super.a(paramFacebookWebView, paramTextView);
    String str = MentionsUtils.a(((EditText)paramTextView).getEditableText());
    JSONObject localJSONObject;
    if (str.length() > 0)
      localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("text", str);
      localJSONObject.put("post_id", this.b);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localJSONObject);
      this.c.g(3);
      paramFacebookWebView.a(this.a, localArrayList, this);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        Log.a(this.c.Q(), "inconceivable exception", localJSONException);
    }
  }

  public void a(FacebookWebView paramFacebookWebView, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.c.h(3);
    if (paramBoolean)
      Toaster.a(this.c.n(), 2131363199);
    while (true)
    {
      return;
      super.a(paramFacebookWebView, paramString1, paramBoolean, paramString2);
    }
  }

  public void b(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    View localView = this.c.A();
    if ((localView == null) || (this.f == null));
    while (true)
    {
      return;
      super.b(paramContext, paramFacebookWebView);
      MentionsAutoCompleteTextView localMentionsAutoCompleteTextView = (MentionsAutoCompleteTextView)(EditText)localView.findViewById(2131296563);
      BaseFacebookActivity localBaseFacebookActivity = this.c.P();
      if (localBaseFacebookActivity == null)
        continue;
      localMentionsAutoCompleteTextView.b(localBaseFacebookActivity);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowCommentPublisherHandler
 * JD-Core Version:    0.6.0
 */