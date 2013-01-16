package com.facebook.katana;

import android.app.LocalActivityManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TabHost;
import java.util.ArrayList;
import java.util.List;

public class MyTabHost extends TabHost
{
  protected int a = -1;
  protected LocalActivityManager b = null;
  private ViewGroup c = null;
  private FrameLayout d;
  private List<MyTabHost.TabSpec> e = new ArrayList(2);
  private View f = null;
  private MyTabHost.OnTabChangeListener g;
  private View.OnKeyListener h;
  private boolean i = true;

  public MyTabHost(Context paramContext)
  {
    super(paramContext);
  }

  public MyTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = -1;
    this.f = null;
  }

  private void a()
  {
    if (this.g != null)
      this.g.a(getCurrentTabTag());
  }

  public MyTabHost.TabSpec a(String paramString, View paramView)
  {
    return new MyTabHost.TabSpec(this, paramString, paramView, null);
  }

  public void a(MyTabHost.TabSpec paramTabSpec)
  {
    if (paramTabSpec.b == null)
      throw new IllegalArgumentException("you must set the tab indicator view.");
    if (MyTabHost.TabSpec.a(paramTabSpec) == null)
      throw new IllegalArgumentException("you must specify a way to create the tab content");
    View localView = paramTabSpec.b;
    localView.setOnKeyListener(this.h);
    this.e.add(paramTabSpec);
    if (this.a == -1)
      setCurrentTab(0);
    this.c.addView(localView);
    localView.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void clearAllTabs()
  {
    this.a = -1;
    this.f = null;
    this.d.removeAllViews();
    this.e.clear();
    requestLayout();
    invalidate();
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = this.d.dispatchKeyEvent(paramKeyEvent);
    if ((!bool) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 19) && (this.f.hasFocus()) && (this.f.findFocus().focusSearch(33) == null))
    {
      ((MyTabHost.TabSpec)this.e.get(this.a)).b.requestFocus();
      playSoundEffect(2);
      bool = true;
    }
    return bool;
  }

  public void dispatchWindowFocusChanged(boolean paramBoolean)
  {
    this.f.dispatchWindowFocusChanged(paramBoolean);
  }

  public int getCurrentTab()
  {
    return this.a;
  }

  public String getCurrentTabTag()
  {
    if ((this.a >= 0) && (this.a < this.e.size()));
    for (String str = ((MyTabHost.TabSpec)this.e.get(this.a)).a; ; str = null)
      return str;
  }

  public View getCurrentTabView()
  {
    if ((this.a >= 0) && (this.a < this.e.size()));
    for (View localView = ((MyTabHost.TabSpec)this.e.get(this.a)).b; ; localView = null)
      return localView;
  }

  public View getCurrentView()
  {
    return this.f;
  }

  public FrameLayout getTabContentView()
  {
    return this.d;
  }

  public List<MyTabHost.TabSpec> getTabSpecs()
  {
    return this.e;
  }

  public void onTouchModeChanged(boolean paramBoolean)
  {
    if ((this.i) && (!paramBoolean) && ((!this.f.hasFocus()) || (this.f.isFocused())))
      ((MyTabHost.TabSpec)this.e.get(this.a)).b.requestFocus();
  }

  public void setCurrentTab(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.e.size()));
    while (true)
    {
      return;
      if (paramInt != this.a)
      {
        ((RadioButton)(RadioButton)((MyTabHost.TabSpec)this.e.get(paramInt)).b).setChecked(true);
        if (this.a != -1)
          MyTabHost.TabSpec.a((MyTabHost.TabSpec)this.e.get(this.a)).b();
        this.a = paramInt;
        MyTabHost.TabSpec localTabSpec = (MyTabHost.TabSpec)this.e.get(paramInt);
        ((MyTabHost.TabSpec)this.e.get(this.a)).b.requestFocus();
        this.f = MyTabHost.TabSpec.a(localTabSpec).a();
        if (this.f.getParent() == null)
          this.d.addView(this.f, new ViewGroup.LayoutParams(-1, -1));
        if (!this.c.hasFocus())
          this.f.requestFocus();
        a();
        continue;
      }
    }
  }

  public void setCurrentTabByTag(String paramString)
  {
    for (int j = 0; ; j++)
    {
      if (j < this.e.size())
      {
        if (!((MyTabHost.TabSpec)this.e.get(j)).a.equals(paramString))
          continue;
        setCurrentTab(j);
      }
      return;
    }
  }

  public void setOnTabChangedListener(MyTabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.g = paramOnTabChangeListener;
  }

  public void setup()
  {
    this.h = new MyTabHost.1(this);
    this.d = ((FrameLayout)findViewById(16908305));
    if (this.d == null)
      throw new RuntimeException("Your TabHost must have a FrameLayout whose id attribute is 'android.R.id.tabcontent'");
    this.c = ((ViewGroup)findViewById(2131297942));
  }

  public void setup(LocalActivityManager paramLocalActivityManager)
  {
    setup();
    this.b = paramLocalActivityManager;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.MyTabHost
 * JD-Core Version:    0.6.0
 */