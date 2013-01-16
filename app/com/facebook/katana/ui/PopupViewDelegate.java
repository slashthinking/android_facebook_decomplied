package com.facebook.katana.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.facebook.katana.webview.FacewebWebView;
import java.util.Map;

public abstract interface PopupViewDelegate
{
  public abstract void a(Activity paramActivity);

  public abstract void a(Activity paramActivity, PopupViewDelegate.PopupState paramPopupState, String paramString, boolean paramBoolean);

  public abstract void a(Context paramContext, boolean paramBoolean);

  public abstract void a(PopupViewDelegate.OnStateChangedListener paramOnStateChangedListener);

  public abstract void a(PopupViewDelegate.PopupState paramPopupState1, PopupViewDelegate.PopupState paramPopupState2);

  public abstract void a(Map<PopupViewDelegate.PopupState, Point> paramMap);

  public abstract void b();

  public abstract boolean d();

  public abstract void e();

  public abstract void f();

  public abstract FacewebWebView g();

  public abstract View h();

  public abstract PopupViewDelegate.PopupState i();

  public abstract boolean l();

  public abstract int m();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.PopupViewDelegate
 * JD-Core Version:    0.6.0
 */