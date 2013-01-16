package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.orca.common.async.CancellableRunnable;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.debug.BLog;

public class AnchorableToast
{
  private static final Class<?> a = AnchorableToast.class;
  private final Context b;
  private final LayoutInflater c;
  private View d;
  private ViewTreeObserver.OnGlobalLayoutListener e;
  private PopupWindow f;
  private CancellableRunnable g;
  private int h;
  private int i;
  private boolean j;
  private int k = 48;
  private long l = 3000L;

  public AnchorableToast(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    this.b = paramContext;
    this.c = paramLayoutInflater;
    this.i = SizeUtil.a(paramContext, 33.0F);
  }

  private void b()
  {
    if (this.f == null);
    while (true)
    {
      return;
      int[] arrayOfInt = new int[2];
      this.d.getLocationInWindow(arrayOfInt);
      if (this.k == 48)
      {
        this.f.update(arrayOfInt[0], arrayOfInt[1] - this.i, this.h, this.i);
        continue;
      }
      this.f.update(arrayOfInt[0], arrayOfInt[1] + this.d.getHeight(), this.h, this.i);
    }
  }

  public void a()
  {
    if (this.f != null)
    {
      this.f.dismiss();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.a();
      this.g = null;
    }
    if (this.e != null)
    {
      this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this.e);
      this.e = null;
    }
  }

  public void a(int paramInt)
  {
    this.k = paramInt;
  }

  public void a(long paramLong)
  {
    this.l = paramLong;
  }

  public void a(View paramView1, View paramView2)
  {
    a();
    if (paramView1.getWindowToken() == null)
    {
      BLog.d(a, "show called with null window token -- ignoring");
      return;
    }
    this.d = paramView1;
    int[] arrayOfInt = new int[2];
    paramView1.getLocationInWindow(arrayOfInt);
    Drawable localDrawable = this.b.getResources().getDrawable(2130838462);
    this.f = new PopupWindow(this.b);
    FrameLayout localFrameLayout = new FrameLayout(this.b);
    localFrameLayout.setBackgroundDrawable(localDrawable);
    localFrameLayout.addView(paramView2);
    this.h = paramView1.getWidth();
    if (this.j)
    {
      localFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(this.h, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.i = localFrameLayout.getMeasuredHeight();
    }
    this.f.setContentView(localFrameLayout);
    this.f.setWidth(this.h);
    this.f.setHeight(this.i);
    this.f.setBackgroundDrawable(null);
    this.f.setAnimationStyle(16973828);
    if (this.k == 48)
      this.f.showAtLocation(paramView1, 51, arrayOfInt[0], arrayOfInt[1] - this.i);
    while (true)
    {
      if (this.l > 0L)
      {
        this.g = new CancellableRunnable(new AnchorableToast.1(this));
        paramView1.postDelayed(this.g, this.l);
      }
      this.e = new AnchorableToast.2(this);
      paramView1.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
      break;
      if (this.k != 80)
        continue;
      this.f.showAtLocation(paramView1, 51, arrayOfInt[0], arrayOfInt[1] + paramView1.getHeight());
    }
  }

  public void a(View paramView, CharSequence paramCharSequence, AnchorableToast.ToastType paramToastType)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.b);
    View localView;
    if (paramToastType == AnchorableToast.ToastType.WARNING)
    {
      localView = this.c.inflate(2130903429, localFrameLayout, false);
      if (this.k != 80)
        break label93;
      localView.findViewById(2131297525).setVisibility(0);
    }
    while (true)
    {
      ((TextView)localView.findViewById(2131297524)).setText(paramCharSequence);
      a(paramView, localView);
      return;
      localView = this.c.inflate(2130903428, localFrameLayout, false);
      break;
      label93: localView.findViewById(2131297523).setVisibility(0);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.AnchorableToast
 * JD-Core Version:    0.6.0
 */