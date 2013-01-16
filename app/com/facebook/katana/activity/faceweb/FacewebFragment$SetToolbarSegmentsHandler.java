package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.facebook.common.util.Log;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.katana.webview.FacewebWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacewebFragment$SetToolbarSegmentsHandler extends FacewebFragment.StatefulNativeUICallHandler
{
  private String[] b;
  private int c = -1;
  private int d = -1;

  public FacewebFragment$SetToolbarSegmentsHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  private RadioButton a(int paramInt, String paramString)
  {
    RadioButton localRadioButton = (RadioButton)this.a.n().getLayoutInflater().inflate(2130903568, null);
    localRadioButton.setButtonDrawable(2130838155);
    localRadioButton.setId(paramInt);
    localRadioButton.setText(paramString);
    return localRadioButton;
  }

  private void a(int paramInt)
  {
    if (this.c == paramInt);
    while (true)
    {
      return;
      this.c = paramInt;
      if ((paramInt < 0) || (paramInt >= this.b.length))
        continue;
      this.d = paramInt;
      if (FacewebFragment.b(this.a) == null)
        continue;
      FacewebFragment.b(this.a).b(this.b[paramInt], null);
    }
  }

  public void b(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    int i = 0;
    View localView = this.a.A();
    if ((localView == null) || (this.f == null))
      return;
    while (true)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.f.a(paramFacebookWebView.getMobilePage(), "segments"));
        RadioGroup localRadioGroup = (RadioGroup)localView.findViewById(2131296898);
        this.b = new String[localJSONArray.length()];
        localRadioGroup.removeAllViews();
        localRadioGroup.clearCheck();
        if (i >= localJSONArray.length())
          continue;
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        String str2 = localJSONObject.optString("title");
        String str3 = localJSONObject.optString("callback");
        this.b[i] = str3;
        RadioButton localRadioButton = a(i, str2);
        localRadioButton.setTag(str3);
        localRadioGroup.addView(localRadioButton);
        localRadioButton.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
        i++;
        continue;
        this.c = 0;
        if (this.d != -1)
          break label263;
        String str1 = this.f.a(paramFacebookWebView.getMobilePage(), "current_tab");
        if (str1 == null)
          continue;
        this.c = Integer.parseInt(str1);
        localRadioGroup.check(this.c);
        localRadioGroup.setOnCheckedChangeListener(new FacewebFragment.SetToolbarSegmentsHandler.1(this));
        localRadioGroup.setVisibility(0);
      }
      catch (JSONException localJSONException)
      {
        Log.a(this.a.Q(), "Data format error", localJSONException);
      }
      break;
      label263: this.c = this.d;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.SetToolbarSegmentsHandler
 * JD-Core Version:    0.6.0
 */