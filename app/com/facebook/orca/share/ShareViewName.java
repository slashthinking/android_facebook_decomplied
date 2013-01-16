package com.facebook.orca.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewParent;
import com.facebook.orca.common.ui.widgets.text.MultilineEllipsizeTextView;

public class ShareViewName extends MultilineEllipsizeTextView
{
  public ShareViewName(Context paramContext)
  {
    super(paramContext);
  }

  public ShareViewName(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ShareViewName(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void drawableStateChanged()
  {
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent())
    {
      if (!(localViewParent instanceof ShareView))
        continue;
      ((ShareView)localViewParent).a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareViewName
 * JD-Core Version:    0.6.0
 */