package com.facebook.widget.flyout;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.common.util.AnimatorEndFuture;
import com.facebook.orca.activity.FbFragment;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.nineoldandroids.animation.AnimatorSet;

public abstract class FlyoutFragment extends FbFragment
  implements IFlyoutInterface
{
  protected RelativeLayout a;
  private Point b;

  private Point a(float paramFloat1, float paramFloat2)
  {
    DisplayMetrics localDisplayMetrics = q().getDisplayMetrics();
    return new Point((int)(paramFloat1 * localDisplayMetrics.widthPixels), (int)(paramFloat2 * localDisplayMetrics.heightPixels));
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903210, paramViewGroup, false);
    localView.setOnClickListener(new FlyoutFragment.1(this));
    this.a = ((RelativeLayout)localView.findViewById(2131296900));
    a(paramLayoutInflater, this.a);
    return localView;
  }

  public ListenableFuture<Void> a()
  {
    Object localObject;
    if (!s())
      localObject = Futures.a(null);
    while (true)
    {
      return localObject;
      if (n() == null)
      {
        localObject = Futures.a(null);
      }
      else
      {
        AnimatorSet localAnimatorSet = FlyoutAnimation.b(new FlyoutAnimationBuilder().a(this.a).a(1.0F, 0.0F).b(1.0F, 0.0F).a(this.b.x).b(this.b.y).a(150L));
        localAnimatorSet.a(new FlyoutFragment.2(this));
        localAnimatorSet.c();
        localObject = new AnimatorEndFuture(localAnimatorSet);
      }
    }
  }

  public ListenableFuture<Void> a(FragmentActivity paramFragmentActivity)
  {
    return a(paramFragmentActivity.g());
  }

  public ListenableFuture<Void> a(FragmentManager paramFragmentManager)
  {
    FragmentTransaction localFragmentTransaction = paramFragmentManager.a();
    localFragmentTransaction.b(16908290, this, "chromeless:content:fragment:tag");
    localFragmentTransaction.a(null);
    localFragmentTransaction.a();
    paramFragmentManager.b();
    AnimatorSet localAnimatorSet = FlyoutAnimation.a(new FlyoutAnimationBuilder().a(this.a).a(0.0F, 1.0F).b(0.0F, 1.0F).a(this.b.x).b(this.b.y).a(150L));
    localAnimatorSet.c();
    return new AnimatorEndFuture(localAnimatorSet);
  }

  public void a(Point paramPoint)
  {
    this.b = paramPoint;
  }

  protected abstract void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);

  protected void c()
  {
    if (!s());
    while (true)
    {
      return;
      FragmentActivity localFragmentActivity = n();
      if ((localFragmentActivity != null) && ((localFragmentActivity == null) || (!localFragmentActivity.isFinishing())))
        localFragmentActivity.g().e();
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    Point localPoint;
    if (this.b == null)
    {
      localPoint = a(0.5F, 0.5F);
      if (paramBundle == null)
        break label57;
    }
    label57: for (this.b = new Point(paramBundle.getInt("AnimationOriginX", localPoint.x), paramBundle.getInt("AnimationOriginY", localPoint.y)); ; this.b = localPoint)
      return;
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.b != null)
    {
      paramBundle.putInt("AnimationOriginX", this.b.x);
      paramBundle.putInt("AnimationOriginY", this.b.y);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.flyout.FlyoutFragment
 * JD-Core Version:    0.6.2
 */