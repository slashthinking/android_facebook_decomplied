package com.facebook.katana.activity.faceweb;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.katana.ui.mentions.MentionsUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.JsReturnHandler;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FacewebFragment$ShareHandler
  implements View.OnClickListener, FacebookWebView.JsReturnHandler
{
  protected FacebookWebView a;

  public FacewebFragment$ShareHandler(FacewebFragment paramFacewebFragment)
  {
  }

  public void a(FacebookWebView paramFacebookWebView, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.b.h(2);
    if (paramBoolean)
      Toaster.a(this.b.n(), 2131363206);
  }

  public void onClick(View paramView)
  {
    String str = MentionsUtils.a(((EditText)this.b.A().findViewById(2131297842)).getText());
    JSONObject localJSONObject;
    if (str.length() > 0)
      localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", "didPostStatus");
      localJSONObject.put("text", str);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localJSONObject);
      this.b.g(2);
      this.a.a(FacewebFragment.m(this.b), localArrayList, this);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        Log.a(this.b.Q(), "inconceivable exception " + localJSONException.toString());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShareHandler
 * JD-Core Version:    0.6.0
 */