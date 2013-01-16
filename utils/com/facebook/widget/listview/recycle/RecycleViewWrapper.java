package com.facebook.widget.listview.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Preconditions;

public class RecycleViewWrapper extends CustomViewGroup
{
  private Integer a = Integer.valueOf(-1);
  private int b = -1;

  public RecycleViewWrapper(Context paramContext)
  {
    super(paramContext);
  }

  public RecycleViewWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public RecycleViewWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public View getEligibleContentView()
  {
    View localView;
    if ((this.a == null) || (this.a.intValue() < 0))
      localView = null;
    while (true)
    {
      return localView;
      int i = getChildCount();
      if (i <= 1);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool, "There can only be 1 wrapped child view at most!");
        if (i != 1)
          break label58;
        localView = getChildAt(0);
        break;
      }
      label58: localView = null;
    }
  }

  public int getPositionInListView()
  {
    return this.b;
  }

  public Integer getRecyleViewType()
  {
    return this.a;
  }

  public void setPositionInListView(int paramInt)
  {
    this.b = paramInt;
  }

  public void setRecycleViewType(Integer paramInteger)
  {
    this.a = paramInteger;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.listview.recycle.RecycleViewWrapper
 * JD-Core Version:    0.6.2
 */