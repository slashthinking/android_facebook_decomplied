package com.facebook.katana.activity.faceweb;

import android.os.Handler;
import com.facebook.common.util.Log;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.katana.webview.FacewebPalCall;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacewebFragment$SetActionMenuHandler extends FacebookWebView.NativeUICallHandler
{
  public FacewebFragment$SetActionMenuHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  int a(String paramString)
  {
    int i;
    if (paramString.equals("mark_unread"))
      i = 2130838314;
    while (true)
    {
      return i;
      if (paramString.equals("mark_spam"))
      {
        i = 2130838312;
        continue;
      }
      if (paramString.equals("archive"))
      {
        i = 2130838308;
        continue;
      }
      if (paramString.equals("unarchive"))
      {
        i = 2130838313;
        continue;
      }
      if (paramString.equals("move"))
      {
        i = 2130838311;
        continue;
      }
      if (paramString.equals("delete"))
      {
        i = 2130838309;
        continue;
      }
      if (paramString.equals("forward"))
      {
        i = 2130838310;
        continue;
      }
      i = -1;
    }
  }

  public void a(FacebookWebView paramFacebookWebView, FacewebPalCall paramFacewebPalCall)
  {
    String str = paramFacewebPalCall.a(paramFacebookWebView.getMobilePage(), "actions");
    try
    {
      JSONArray localJSONArray = new JSONArray(str);
      FacewebFragment.a(this.a, new JSONObject[localJSONArray.length()]);
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        FacewebFragment.e(this.a)[i] = localJSONObject;
        if (!localJSONObject.has("type"))
          continue;
        int j = a(localJSONObject.optString("type"));
        if (j <= 0)
          continue;
        localJSONObject.put("icon", j);
      }
    }
    catch (JSONException localJSONException)
    {
      Log.a(this.a.Q(), "Invalid JSON format", localJSONException);
      FacewebFragment.a(this.a, null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.SetActionMenuHandler
 * JD-Core Version:    0.6.0
 */