package com.facebook.katana.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.widget.DragSortListView;

public class BookmarksDragSortListView extends DragSortListView
{
  private int d = -1;
  private int e = -1;

  public BookmarksDragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BookmarksDragSortListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(View paramView)
  {
    a(paramView, this.d, 8);
    a(paramView, this.e, 8);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = -2;
    paramView.setVisibility(0);
    paramView.setLayoutParams(localLayoutParams);
  }

  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (b(paramView))
    {
      localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = -2;
      paramView.setVisibility(paramInt3);
      if (paramInt1 != this.b)
        break label101;
      if (paramInt2 != 48)
        break label73;
      paramView.findViewById(this.d).setVisibility(8);
      paramView.findViewById(this.e).setVisibility(0);
    }
    while (true)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      label73: paramView.findViewById(this.d).setVisibility(0);
      paramView.findViewById(this.e).setVisibility(8);
      continue;
      label101: paramView.findViewById(this.d).setVisibility(8);
      paramView.findViewById(this.e).setVisibility(8);
      if (paramInt1 == this.a)
        continue;
      localLayoutParams.height = paramInt1;
    }
  }

  protected boolean b(View paramView)
  {
    int i = 0;
    if (paramView == null);
    while (true)
    {
      return i;
      View localView = paramView.findViewById(this.c);
      i = 0;
      if (localView == null)
        continue;
      int j = localView.getVisibility();
      i = 0;
      if (j == 8)
        continue;
      i = 1;
    }
  }

  public void setBottomEmptyId(int paramInt)
  {
    this.e = paramInt;
  }

  public void setTopEmptyId(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.BookmarksDragSortListView
 * JD-Core Version:    0.6.0
 */