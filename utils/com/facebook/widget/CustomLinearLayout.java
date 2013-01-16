package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.util.event.FbEventBus;
import com.facebook.common.util.event.FbEventSubscriber;
import com.facebook.common.util.event.FbEventSubscriberListManager;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.listview.recycle.IViewAttachAware;
import com.facebook.widget.listview.recycle.RecyclableViewHelper;

public class CustomLinearLayout extends LinearLayout
  implements FbCustomViewGroup
{
  private FbEventSubscriberListManager a;

  public CustomLinearLayout(Context paramContext)
  {
    super(paramContext);
  }

  public CustomLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private CustomLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
  }

  protected boolean a(FbEventSubscriber paramFbEventSubscriber)
  {
    if (this.a == null)
      this.a = new FbEventSubscriberListManager();
    return this.a.a(paramFbEventSubscriber);
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

  protected <T extends View> T b(int paramInt)
  {
    return findViewById(paramInt);
  }

  public void detachRecyclableViewFromParent(View paramView)
  {
    paramView.onStartTemporaryDetach();
    super.detachViewFromParent(paramView);
    requestLayout();
  }

  protected <T extends FbEventBus> T getEventBus()
  {
    return null;
  }

  protected FbInjector getInjector()
  {
    return FbInjector.a(getContext());
  }

  protected void k()
  {
    if (this.a != null)
      this.a.a(getEventBus());
  }

  protected void l()
  {
    if (this.a != null)
      this.a.b(getEventBus());
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    k();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    l();
  }

  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    k();
  }

  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    l();
  }

  public void removeRecyclableViewFromParent(View paramView, boolean paramBoolean)
  {
    super.removeDetachedView(paramView, paramBoolean);
  }

  protected void setContentView(int paramInt)
  {
    Tracer localTracer = Tracer.a("CustomLinearLayout.setContentView");
    LayoutInflater.from(getContext()).inflate(paramInt, this);
    localTracer.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CustomLinearLayout
 * JD-Core Version:    0.6.2
 */