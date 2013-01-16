package com.facebook.contacts.contactcard;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.widget.CustomViewGroup;

public class SectionView extends CustomViewGroup
{
  private final FrameLayout a;
  private final ViewGroup b;

  public SectionView(Context paramContext)
  {
    this(paramContext, null);
  }

  public SectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903122);
    this.b = ((ViewGroup)getView(2131296615));
    this.a = ((FrameLayout)getView(2131296614));
    b();
  }

  protected void a(View paramView)
  {
    int i = this.b.indexOfChild(paramView);
    if (i == -1);
    while (true)
    {
      return;
      this.b.removeViewAt(i);
      if (this.b.getChildCount() == 0)
        continue;
      this.b.removeViewAt(i - 1);
    }
  }

  protected void a(View paramView, boolean paramBoolean)
  {
    if ((this.b.getChildCount() != 0) && (paramBoolean))
    {
      View localView = new View(getContext());
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131230820)));
      localView.setBackgroundDrawable(getResources().getDrawable(2130839053));
      this.b.addView(localView);
    }
    this.b.addView(paramView);
    this.a.setVisibility(0);
  }

  protected void b()
  {
    this.a.setVisibility(8);
    this.b.removeAllViews();
  }

  protected void b(View paramView)
  {
    a(paramView, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.SectionView
 * JD-Core Version:    0.6.0
 */