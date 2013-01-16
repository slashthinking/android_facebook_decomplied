package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.R.styleable;
import com.facebook.widget.DragSortListView;

public class FavoritesDragSortListView extends DragSortListView
{
  private int d = -1;
  private int e = -1;

  public FavoritesDragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FavoritesDragSortListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.FavoritesDragSortListView, 0, 0);
      this.d = localTypedArray.getResourceId(0, -1);
      this.e = localTypedArray.getResourceId(1, -1);
      localTypedArray.recycle();
    }
  }

  protected void a(View paramView)
  {
    if (b(paramView))
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = this.a;
      paramView.setVisibility(0);
      paramView.setLayoutParams(localLayoutParams);
      paramView.setVisibility(0);
      a(paramView, this.d, 4);
      a(paramView, this.e, 0);
    }
  }

  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    FavoritesDragSortListView.DraggableRowView localDraggableRowView;
    if (b(paramView))
    {
      localDraggableRowView = (FavoritesDragSortListView.DraggableRowView)paramView;
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = paramInt1;
      paramView.setLayoutParams(localLayoutParams);
      paramView.setVisibility(paramInt3);
      FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, this.a, paramInt2);
      localDraggableRowView.getInnerRow().setLayoutParams(localLayoutParams1);
      if (paramInt1 != this.b)
        break label137;
      if (paramInt2 == 48)
      {
        a(paramView, this.e, 0);
        a(paramView, this.d, 4);
        a(paramView, this.e, 0);
        a(paramView, this.d, 0);
      }
    }
    while (true)
    {
      if ((paramInt1 != this.a) || (paramInt3 != 0))
        FavoritesDragSortListView.DraggableRowView.a(localDraggableRowView, false);
      return;
      label137: a(paramView, this.d, 4);
    }
  }

  protected boolean b(View paramView)
  {
    if (paramView.findViewById(this.c) != null);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.FavoritesDragSortListView
 * JD-Core Version:    0.6.0
 */