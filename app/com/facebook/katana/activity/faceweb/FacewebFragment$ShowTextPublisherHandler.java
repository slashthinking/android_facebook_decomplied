package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacebookWebView.JsReturnHandler;

public abstract class FacewebFragment$ShowTextPublisherHandler extends FacewebFragment.StatefulNativeUICallHandler
  implements FacebookWebView.JsReturnHandler
{
  public FacewebFragment$ShowTextPublisherHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  protected void a(FacebookWebView paramFacebookWebView, TextView paramTextView)
  {
    ((InputMethodManager)this.d.n().getSystemService("input_method")).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
  }

  public void a(FacebookWebView paramFacebookWebView, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.e.post(new FacewebFragment.ShowTextPublisherHandler.6(this));
  }

  public void b(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    View localView1 = this.d.A();
    if ((localView1 == null) || (this.f == null));
    while (true)
    {
      return;
      Button localButton = (Button)localView1.findViewById(2131296835);
      localView1.findViewById(2131296833).setVisibility(0);
      View localView2 = localView1.findViewById(2131296897);
      FacewebFragment.ShowTextPublisherHandler.1 local1 = new FacewebFragment.ShowTextPublisherHandler.1(this, localView2);
      localView2.getViewTreeObserver().addOnGlobalLayoutListener(local1);
      EditText localEditText = (EditText)localView1.findViewById(2131296563);
      localEditText.setOnEditorActionListener(new FacewebFragment.ShowTextPublisherHandler.2(this, paramFacebookWebView));
      localEditText.setOnFocusChangeListener(new FacewebFragment.ShowTextPublisherHandler.3(this));
      int i = localEditText.getText().length();
      boolean bool = false;
      if (i > 0)
        bool = true;
      localButton.setEnabled(bool);
      localEditText.addTextChangedListener(new FacewebFragment.ShowTextPublisherHandler.4(this, localButton, localEditText));
      localButton.setOnClickListener(new FacewebFragment.ShowTextPublisherHandler.5(this, paramFacebookWebView));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowTextPublisherHandler
 * JD-Core Version:    0.6.0
 */