package com.facebook.katana.view;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.webview.BaseWebView;
import com.facebook.orca.annotations.AuthNotRequired;
import com.facebook.orca.inject.FbInjector;

@AuthNotRequired
public class LoggedOutWebViewActivity extends BaseFacebookActivity
{
  private static final String s = LoggedOutWebViewActivity.class.getSimpleName();
  private WebView n;
  private LoggedOutWebViewActivity.ProgressSpinner o;
  private View p;
  private View q;
  private NetAccessLogger r;

  private void j()
  {
    try
    {
      this.o.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        ErrorReporting.a(s, "failed to hide spinner, bad state", localIllegalArgumentException);
    }
  }

  private void k()
  {
    if (this.n.getVisibility() == 0)
      this.n.requestFocus();
    while (true)
    {
      return;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      this.n.startAnimation(localTranslateAnimation);
      this.n.setVisibility(0);
      this.n.requestFocus();
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FrameLayout localFrameLayout = new FrameLayout(this);
    this.r = ((NetAccessLogger)C().a(NetAccessLogger.class));
    this.o = new LoggedOutWebViewActivity.ProgressSpinner(this);
    this.n = new BaseWebView(this);
    this.n.getSettings().setGeolocationEnabled(true);
    this.n.addJavascriptInterface(new LoggedOutWebViewActivity.LoggedOutCallbackImplementation(this), "fbLoggedOutWebViewIsErrorPage");
    this.p = new View(this);
    this.p.setBackgroundResource(2130838357);
    localFrameLayout.addView(this.p);
    this.n.setWebViewClient(new LoggedOutWebViewActivity.LoggedOutWebViewClient(this, null));
    if (Build.VERSION.SDK_INT >= 11)
      this.n.setLayerType(1, null);
    if (paramBundle == null)
      this.n.loadUrl(getIntent().getDataString());
    while (true)
    {
      localFrameLayout.addView(this.n);
      this.n.setVisibility(8);
      this.q = getLayoutInflater().inflate(2130903135, null);
      this.q.setVisibility(8);
      this.q.setOnTouchListener(new LoggedOutWebViewActivity.1(this));
      localFrameLayout.addView(this.q);
      setContentView(localFrameLayout);
      this.o.show();
      return;
      this.n.restoreState(paramBundle);
    }
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.n.restoreState(paramBundle);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.n.saveState(paramBundle);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.LoggedOutWebViewActivity
 * JD-Core Version:    0.6.0
 */