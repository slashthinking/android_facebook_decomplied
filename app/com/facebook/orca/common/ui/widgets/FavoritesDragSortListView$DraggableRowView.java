package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewGroup;

public abstract class FavoritesDragSortListView$DraggableRowView extends CustomViewGroup
{
  boolean a = true;

  public FavoritesDragSortListView$DraggableRowView(Context paramContext)
  {
    super(paramContext);
  }

  public FavoritesDragSortListView$DraggableRowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public FavoritesDragSortListView$DraggableRowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void setCanConvert(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public boolean a()
  {
    return this.a;
  }

  public abstract View getInnerRow();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.FavoritesDragSortListView.DraggableRowView
 * JD-Core Version:    0.6.0
 */