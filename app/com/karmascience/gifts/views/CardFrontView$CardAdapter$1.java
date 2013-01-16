package com.karmascience.gifts.views;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.karmascience.gifts.ThreadingService;

class CardFrontView$CardAdapter$1
  implements Runnable
{
  public void run()
  {
    if (this.a.getWidth() == 0)
      this.c.a.o().a(this);
    while (true)
    {
      return;
      CardFrontView.CardAdapter.a(this.c, this.a.getWidth(), this.a.getHeight());
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(CardFrontView.CardAdapter.a(this.c), CardFrontView.CardAdapter.b(this.c));
      this.b.setLayoutParams(localLayoutParams);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CardFrontView.CardAdapter.1
 * JD-Core Version:    0.6.0
 */