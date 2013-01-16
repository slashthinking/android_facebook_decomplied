package com.facebook.katana.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.common.util.SpringAnimator;
import com.facebook.katana.orca.InstallMessengerPromoFragment;
import com.facebook.orca.threadlist.ThreadListFragment;
import com.nineoldandroids.view.ViewHelper;
import java.util.Map;

public class FullscreenPopupViewDelegate extends AbstractPopupViewDelegate
{
  private final String d = FullscreenPopupViewDelegate.class.getSimpleName();
  private ViewPager e = (ViewPager)this.a.findViewById(2131297709);
  private FullscreenPopupViewDelegate.JewelPageAdapter f;
  private SpringAnimator g;
  private final ViewGroup h;

  public FullscreenPopupViewDelegate(Activity paramActivity, ViewGroup paramViewGroup, Handler paramHandler, Map<PopupViewDelegate.PopupState, Point> paramMap)
  {
    super(paramActivity, paramViewGroup, paramHandler, paramMap);
    FragmentActivity localFragmentActivity = (FragmentActivity)paramActivity;
    this.f = new FullscreenPopupViewDelegate.JewelPageAdapter(this, localFragmentActivity.g(), localFragmentActivity);
    this.e.setOnPageChangeListener(new FullscreenPopupViewDelegate.1(this, paramActivity));
    this.e.setOffscreenPageLimit(-1 + this.f.b());
    this.h = ((ViewGroup)this.a.findViewById(2131297703));
    ViewHelper.setTranslationY(this.h, paramActivity.getResources().getDimension(2131230934));
    this.a.findViewById(2131297694).setOnClickListener(new FullscreenPopupViewDelegate.2(this));
  }

  private void a(boolean paramBoolean)
  {
    if (!InstallMessengerPromoFragment.b(this.a.getContext()))
      return;
    if ((this.g != null) && (this.g.g()))
      this.g.d();
    View localView = this.h.findViewById(2131297017);
    if (paramBoolean)
    {
      if (localView != null)
        localView.setClickable(true);
      this.g = SpringAnimator.a(this.h, "translationY", 0.0F);
      this.g.a(500L);
    }
    while (true)
    {
      this.g.c();
      break;
      this.g = SpringAnimator.a(this.h, "translationY", this.h.getHeight());
      this.g.a(0L);
      this.g.a(new FullscreenPopupViewDelegate.3(this, localView));
    }
  }

  protected ListenableRelativeLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return (ListenableRelativeLayout)paramLayoutInflater.inflate(2130903500, paramViewGroup, false);
  }

  protected void a()
  {
    if (this.a == null);
    while (true)
    {
      return;
      int i = this.a.getResources().getDimensionPixelSize(2131230970);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(0, i, 0, 0);
      localLayoutParams.addRule(10, -1);
      View localView = this.a.findViewById(2131297694);
      localView.setLayoutParams(localLayoutParams);
      localView.requestLayout();
      localView.invalidate();
    }
  }

  protected void a(FragmentActivity paramFragmentActivity, Fragment paramFragment)
  {
    this.f.a(paramFragmentActivity, paramFragment);
    this.f.c();
  }

  public void a(ThreadListFragment paramThreadListFragment)
  {
    super.a(paramThreadListFragment);
    paramThreadListFragment.a(new FullscreenPopupViewDelegate.JewelThreadItemViewSupplier(this, null));
  }

  protected boolean a(Context paramContext)
  {
    return true;
  }

  public void b()
  {
    this.f.e();
  }

  protected void b(PopupViewDelegate.PopupState paramPopupState)
  {
    if (!PopupViewDelegate.PopupState.CLOSED.equals(paramPopupState))
      this.e.setCurrentItem(paramPopupState.ordinal());
    super.b(paramPopupState);
    if (paramPopupState == PopupViewDelegate.PopupState.MESSAGES);
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  protected void c()
  {
    if (this.e.getAdapter() == null)
    {
      this.e.setAdapter(this.f);
      this.e.setCurrentItem(this.c.ordinal());
    }
  }

  public boolean l()
  {
    return true;
  }

  public int m()
  {
    return 2130903250;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.FullscreenPopupViewDelegate
 * JD-Core Version:    0.6.0
 */