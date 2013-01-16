package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.util.event.FbEventBus;
import com.facebook.common.util.event.FbEventSubscriber;
import com.facebook.common.util.event.FbEventSubscriberListManager;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.listview.recycle.IViewAttachAware;
import com.facebook.widget.listview.recycle.RecyclableViewHelper;

public class CustomViewGroup extends ViewGroup
  implements FbCustomViewGroup
{
  private FbEventSubscriberListManager mSubscriberListManager;

  public CustomViewGroup(Context paramContext)
  {
    super(paramContext);
  }

  public CustomViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CustomViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected boolean addFbEventSubscriber(FbEventSubscriber paramFbEventSubscriber)
  {
    if (this.mSubscriberListManager == null)
      this.mSubscriberListManager = new FbEventSubscriberListManager();
    return this.mSubscriberListManager.a(paramFbEventSubscriber);
  }

  public void attachRecyclableViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramView instanceof IViewAttachAware)) && (RecyclableViewHelper.a(this, paramView, paramInt)));
    while (true)
    {
      return;
      paramView.onFinishTemporaryDetach();
      super.attachViewToParent(paramView, paramInt, paramLayoutParams);
      requestLayout();
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof FrameLayout.LayoutParams;
  }

  public void detachRecyclableViewFromParent(View paramView)
  {
    paramView.onStartTemporaryDetach();
    super.detachViewFromParent(paramView);
    requestLayout();
  }

  public void detachRecyclableViewsFromParent(int paramInt1, int paramInt2)
  {
    for (int i = 0; i < paramInt2; i++)
    {
      View localView = getChildAt(paramInt1 + i);
      if (localView != null)
        localView.onStartTemporaryDetach();
    }
    super.detachViewsFromParent(paramInt1, paramInt2);
    requestLayout();
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new FrameLayout.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new FrameLayout.LayoutParams(paramLayoutParams);
  }

  protected <T extends FbEventBus> T getEventBus()
  {
    return null;
  }

  public FbInjector getInjector()
  {
    return FbInjector.a(getContext());
  }

  protected <T extends View> T getView(int paramInt)
  {
    return findViewById(paramInt);
  }

  protected void layoutChild(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    int k = localLayoutParams.gravity;
    if (k != -1)
    {
      int m = k & 0x7;
      int n = k & 0x70;
      switch (m)
      {
      case 2:
      case 4:
      default:
        paramInt1 += localLayoutParams.leftMargin;
        switch (n)
        {
        default:
          paramInt3 += localLayoutParams.topMargin;
        case 48:
        case 16:
        case 80:
        }
        break;
      case 3:
      case 1:
      case 5:
      }
    }
    while (true)
    {
      paramView.layout(paramInt1, paramInt3, paramInt1 + i, paramInt3 + j);
      return;
      paramInt1 += localLayoutParams.leftMargin;
      break;
      paramInt1 = paramInt1 + (paramInt2 - paramInt1 - i) / 2 + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
      break;
      paramInt1 = paramInt2 - i - localLayoutParams.rightMargin;
      break;
      paramInt3 += localLayoutParams.topMargin;
      continue;
      paramInt3 = paramInt3 + (paramInt4 - paramInt3 - j) / 2 + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
      continue;
      paramInt3 = paramInt4 - j - localLayoutParams.bottomMargin;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    registerAllSubscribers();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    unregisterAllSubscribers();
  }

  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    registerAllSubscribers();
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
        layoutChild(j, k, m, n, localView);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m = 0;
    View localView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i2;
    if (j < i)
    {
      localView = getChildAt(j);
      if (localView.getVisibility() == 8)
        break label179;
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      i2 = Math.max(k, localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
    }
    for (int i3 = Math.max(m, localView.getMeasuredHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin); ; i3 = m)
    {
      j++;
      k = i2;
      m = i3;
      break;
      int n = k + (getPaddingLeft() + getPaddingRight());
      int i1 = Math.max(m + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(Math.max(n, getSuggestedMinimumWidth()), paramInt1), resolveSize(i1, paramInt2));
      return;
      label179: i2 = k;
    }
  }

  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    unregisterAllSubscribers();
  }

  protected void registerAllSubscribers()
  {
    if (this.mSubscriberListManager != null)
      this.mSubscriberListManager.a(getEventBus());
  }

  protected boolean removeFbEventSubscriber(FbEventSubscriber paramFbEventSubscriber)
  {
    if (this.mSubscriberListManager == null);
    for (boolean bool = false; ; bool = this.mSubscriberListManager.b(paramFbEventSubscriber))
      return bool;
  }

  public void removeRecyclableViewFromParent(View paramView, boolean paramBoolean)
  {
    super.removeDetachedView(paramView, paramBoolean);
  }

  protected void setContentView(int paramInt)
  {
    Tracer localTracer = Tracer.a("CustomViewGroup.setContentView");
    LayoutInflater.from(getContext()).inflate(paramInt, this);
    localTracer.a();
  }

  protected void unregisterAllSubscribers()
  {
    if (this.mSubscriberListManager != null)
      this.mSubscriberListManager.b(getEventBus());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CustomViewGroup
 * JD-Core Version:    0.6.2
 */