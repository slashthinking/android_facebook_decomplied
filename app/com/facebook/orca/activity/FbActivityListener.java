package com.facebook.orca.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public abstract interface FbActivityListener
{
  public abstract Dialog a(Activity paramActivity, int paramInt);

  public abstract Boolean a(Activity paramActivity, int paramInt, KeyEvent paramKeyEvent);

  public abstract void a(Activity paramActivity);

  public abstract void a(Activity paramActivity, Intent paramIntent);

  public abstract void a(Activity paramActivity, Configuration paramConfiguration);

  public abstract void a(Activity paramActivity, Bundle paramBundle);

  public abstract void a(Activity paramActivity, MotionEvent paramMotionEvent);

  public abstract void a(Menu paramMenu);

  public abstract boolean a(Activity paramActivity, int paramInt, Dialog paramDialog);

  public abstract boolean a(Activity paramActivity, Exception paramException);

  public abstract boolean a(MenuItem paramMenuItem);

  public abstract Boolean b(Activity paramActivity, int paramInt, KeyEvent paramKeyEvent);

  public abstract void b(Activity paramActivity);

  public abstract void b(Menu paramMenu);

  public abstract void c(Activity paramActivity);

  public abstract void d(Activity paramActivity);

  public abstract void e(Activity paramActivity);

  public abstract void f(Activity paramActivity);

  public abstract void g(Activity paramActivity);

  public abstract void h(Activity paramActivity);

  public abstract void j(Activity paramActivity);

  public abstract void k(Activity paramActivity);

  public abstract Boolean l(Activity paramActivity);

  public abstract boolean m(Activity paramActivity);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.FbActivityListener
 * JD-Core Version:    0.6.0
 */