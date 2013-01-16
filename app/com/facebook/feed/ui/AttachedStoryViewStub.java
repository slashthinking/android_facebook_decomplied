package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewStub;

public class AttachedStoryViewStub extends CustomViewStub
{
  public AttachedStoryViewStub(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AttachedStoryViewStub(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AttachedStoryViewStub(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected View getInflatedLayout()
  {
    return new AttachedStoryView(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.AttachedStoryViewStub
 * JD-Core Version:    0.6.0
 */