package com.facebook.widget.animatablelistview;

import android.widget.AbsListView.OnScrollListener;
import com.facebook.orca.common.ui.widgets.listview.ListViewScrollStateHelper;
import com.facebook.orca.common.ui.widgets.listview.ScrollState.ScrollPosition;
import com.facebook.widget.BetterListView;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

public class AnimatingListViewScrollStateController<T>
{
  private final BetterListView a;
  private final AnimatingListAdapter<T> b;
  private final ListViewScrollStateHelper c;
  private int d = 0;
  private final ValueAnimator.AnimatorUpdateListener e = new AnimatingListViewScrollStateController.1(this);
  private final AbsListView.OnScrollListener f = new AnimatingListViewScrollStateController.2(this);

  public AnimatingListViewScrollStateController(BetterListView paramBetterListView, AnimatingListAdapter<T> paramAnimatingListAdapter)
  {
    this.a = paramBetterListView;
    this.b = paramAnimatingListAdapter;
    this.b.a(this.e);
    paramBetterListView.a(this.f);
    this.c = new ListViewScrollStateHelper();
  }

  private void a(int paramInt)
  {
    this.d = paramInt;
  }

  private void a(ValueAnimator paramValueAnimator)
  {
    if ((this.d == 0) && (this.c.a(this.a) == ScrollState.ScrollPosition.BOTTOM))
      this.a.setSelection(-1 + this.a.getCount());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.animatablelistview.AnimatingListViewScrollStateController
 * JD-Core Version:    0.6.2
 */