package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import com.facebook.widget.listeners.BetterViewOnScrollListener;

public class BetterGridView extends GridView
  implements ScrollableView
{
  private BetterViewOnScrollListener a;

  public BetterGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public BetterGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public BetterGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.a = new BetterViewOnScrollListener();
    super.setOnScrollListener(this.a.a());
  }

  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.b(paramOnScrollListener);
  }

  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.a(paramOnScrollListener);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.BetterGridView
 * JD-Core Version:    0.6.2
 */