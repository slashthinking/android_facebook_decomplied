package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.common.util.event.FbEventBus;
import com.facebook.common.util.event.FbEventSubscriber;
import com.facebook.common.util.event.FbEventSubscriberListManager;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.listview.recycle.IViewAttachAware;
import com.facebook.widget.listview.recycle.RecyclableViewHelper;

public class CustomRelativeLayout extends RelativeLayout
  implements FbCustomViewGroup
{
  private FbEventSubscriberListManager a;

  public CustomRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }

  public CustomRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public CustomRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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

  protected void d()
  {
    if (this.a != null)
      this.a.a(getEventBus());
  }

  public void detachRecyclableViewFromParent(View paramView)
  {
    paramView.onStartTemporaryDetach();
    super.detachViewFromParent(paramView);
    requestLayout();
  }

  protected void e()
  {
    if (this.a != null)
      this.a.b(getEventBus());
  }

  protected <T extends FbEventBus> T getEventBus()
  {
    return null;
  }

  protected FbInjector getInjector()
  {
    return FbInjector.a(getContext());
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
  }

  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    d();
  }

  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    e();
  }

  public void removeRecyclableViewFromParent(View paramView, boolean paramBoolean)
  {
    super.removeDetachedView(paramView, paramBoolean);
  }

  protected void setContentView(int paramInt)
  {
    Tracer localTracer = Tracer.a("CustomRelativeLayout.setContentView");
    LayoutInflater.from(getContext()).inflate(paramInt, this);
    localTracer.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CustomRelativeLayout
 * JD-Core Version:    0.6.2
 */