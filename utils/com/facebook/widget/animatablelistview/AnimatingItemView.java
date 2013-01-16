package com.facebook.widget.animatablelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.ViewTransform;

public class AnimatingItemView extends CustomViewGroup
{
  private AnimatingItemInfo<?> a;
  private float b = 1.0F;
  private float c = 1.0F;
  private float d = 1.0F;
  private int e = 0;
  private final ViewTransform f = new ViewTransform(this);
  private AnimatingItemInfo.AnimationListener g = new AnimatingItemView.1(this);

  public AnimatingItemView(Context paramContext)
  {
    super(paramContext);
  }

  public AnimatingItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AnimatingItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    int i = 1;
    int j;
    if (this.a != null)
    {
      if (this.b != this.a.a())
      {
        j = i;
        if (this.e == this.a.d())
          break label135;
      }
      while (true)
      {
        this.b = this.a.a();
        this.e = this.a.d();
        this.c = this.a.b();
        this.d = this.a.c();
        this.f.setScaleX(this.c);
        this.f.setScaleY(this.d);
        if (i != 0)
          this.f.setVisibility(this.e);
        if (j != 0)
          requestLayout();
        return;
        j = 0;
        break;
        label135: i = 0;
      }
    }
    if (this.b != 1.0F)
    {
      j = i;
      label151: if (this.e == 0)
        break label186;
    }
    while (true)
    {
      this.b = 1.0F;
      this.e = 0;
      this.c = 1.0F;
      this.d = 1.0F;
      break;
      j = 0;
      break label151;
      label186: i = 0;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = getPaddingLeft();
    int k = getRight() - getLeft() - getPaddingRight();
    int m = getPaddingTop();
    int n = getBottom() - getTop() - getPaddingBottom();
    for (int i1 = 0; i1 < i; i1++)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() != 8)
      {
        if (this.b < 0.0F)
        {
          int i2 = localView.getMeasuredHeight() - (n - m);
          m -= i2;
          n -= i2;
        }
        layoutChild(j, k, m, n, localView);
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m = 0;
    View localView;
    int i4;
    if (j < i)
    {
      localView = getChildAt(j);
      if (localView.getVisibility() == 8)
        break label163;
      measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      i4 = Math.max(k, localView.getMeasuredWidth());
    }
    for (int i5 = Math.max(m, localView.getMeasuredHeight()); ; i5 = m)
    {
      j++;
      k = i4;
      m = i5;
      break;
      int n = k + (getPaddingLeft() + getPaddingRight());
      int i1 = Math.max(m + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
      int i2 = Math.max(n, getSuggestedMinimumWidth());
      int i3 = Math.abs((int)(i1 * this.b));
      setMeasuredDimension(resolveSize(i2, paramInt1), resolveSize(i3, paramInt2));
      return;
      label163: i4 = k;
    }
  }

  public void setItemInfo(AnimatingItemInfo<?> paramAnimatingItemInfo)
  {
    if (this.a != null)
      this.a.b(this.g);
    this.a = paramAnimatingItemInfo;
    if (this.a != null)
      this.a.a(this.g);
    a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimatingItemView
 * JD-Core Version:    0.6.2
 */