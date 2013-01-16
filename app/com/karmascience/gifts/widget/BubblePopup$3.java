package com.karmascience.gifts.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import com.karmascience.gifts.ThreadingService;

class BubblePopup$3
  implements Runnable
{
  public void run()
  {
    int k;
    if ((BubblePopup.a(this.d).getWidth() > 0) && (BubblePopup.a(this.d).getHeight() > 0))
    {
      int i = BubblePopup.b(this.d).getResources().getDimensionPixelSize(2131230886);
      int j = BubblePopup.b(this.d).getResources().getDimensionPixelSize(2131230887);
      BubblePopup.b(this.d).getResources().getDimensionPixelSize(2131230888);
      if (this.a)
      {
        k = BubblePopup.a(this.d).getWidth();
        int m = BubblePopup.a(this.d).getHeight() + BubblePopup.c(this.d).getHeight() + BubblePopup.d(this.d).getHeight();
        BubblePopup.e(this.d).update(k, m);
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)BubblePopup.d(this.d).getLayoutParams();
        localLayoutParams1.bottomMargin = (-i);
        BubblePopup.d(this.d).setLayoutParams(localLayoutParams1);
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)BubblePopup.c(this.d).getLayoutParams();
        localLayoutParams2.topMargin = (-j);
        BubblePopup.c(this.d).setLayoutParams(localLayoutParams2);
      }
    }
    while (true)
    {
      return;
      k = this.b;
      break;
      this.c.a(this);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.widget.BubblePopup.3
 * JD-Core Version:    0.6.0
 */