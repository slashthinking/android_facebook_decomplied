package com.facebook.katana.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import com.facebook.R.styleable;
import com.facebook.common.util.HeightAnimation;

public class ExpandableHeaderListView extends ListView
{
  private HeightAnimation a;
  private int b;
  private View c;
  private View d;
  private ViewGroup.MarginLayoutParams e;
  private float f = -1.0F;
  private int g;
  private int h;

  public ExpandableHeaderListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ExpandableHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ExpandableHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a()
  {
    this.c = findViewById(this.b);
    this.d = ((View)this.c.getParent());
    if ((this.c == null) || (this.d == null));
    while (true)
    {
      return;
      this.e = ((ViewGroup.MarginLayoutParams)this.c.getLayoutParams());
      this.g = this.d.getLayoutParams().height;
      this.h = this.c.getLayoutParams().height;
      this.a = new HeightAnimation(this.d, this.g);
      this.a.setInterpolator(new DecelerateInterpolator());
      this.a.setDuration(250L);
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ExpandableHeaderListView);
    this.b = localTypedArray.getResourceId(0, 0);
    localTypedArray.recycle();
    b();
  }

  private void b()
  {
    setOnTouchListener(new ExpandableHeaderListView.1(this));
  }

  private boolean c()
  {
    if ((this.c != null) && (this.d != null) && (this.c.getVisibility() == 0) && (this.d.getVisibility() == 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void addHeaderView(View paramView)
  {
    super.addHeaderView(paramView);
    a();
  }

  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addHeaderView(paramView, paramObject, paramBoolean);
    a();
  }

  public int getExpandable()
  {
    return this.b;
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (!c());
    while (true)
    {
      return;
      this.e.topMargin = (-this.d.getTop());
      this.c.setLayoutParams(this.e);
      requestLayout();
    }
  }

  public boolean removeHeaderView(View paramView)
  {
    boolean bool = super.removeHeaderView(paramView);
    a();
    return bool;
  }

  public void setExpandable(int paramInt)
  {
    this.b = paramInt;
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.ExpandableHeaderListView
 * JD-Core Version:    0.6.0
 */