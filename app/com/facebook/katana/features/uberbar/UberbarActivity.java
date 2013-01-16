package com.facebook.katana.features.uberbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.webview.FacewebWebView;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;

public class UberbarActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private EditText n;
  private UberbarDelegate o;
  private InputMethodManager p;
  private InteractionLogger q;

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903610);
    this.n = ((EditText)f(2131297050));
    this.n.setFocusableInTouchMode(true);
    this.n.requestFocus();
    this.p = ((InputMethodManager)C().a(InputMethodManager.class));
    this.p.showSoftInput(this.n, 0);
    findViewById(2131297919).setOnClickListener(new UberbarActivity.1(this));
    ViewGroup localViewGroup = (ViewGroup)f(2131297920);
    View localView = f(2131296659);
    this.o = UberbarDelegate.a((OrcaSharedPreferences)C().a(OrcaSharedPreferences.class), this, this.n, localViewGroup, localView);
    this.o.c();
    this.q = new InteractionLogger(this);
  }

  public String i()
  {
    return null;
  }

  public FacewebWebView j()
  {
    return this.o.c();
  }

  protected void onPause()
  {
    super.onPause();
    this.o.b();
  }

  protected void onResume()
  {
    super.onResume();
    this.o.a();
  }

  protected void onStart()
  {
    super.onStart();
    this.q.a(FB4A_AnalyticEntities.Modules.h, true);
  }

  protected void onStop()
  {
    super.onStop();
    this.q.a(FB4A_AnalyticEntities.Modules.h);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarActivity
 * JD-Core Version:    0.6.0
 */