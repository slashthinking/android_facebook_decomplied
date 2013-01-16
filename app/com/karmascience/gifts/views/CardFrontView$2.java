package com.karmascience.gifts.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.karmascience.gifts.content.model.CardCategories;

class CardFrontView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (CardFrontView.c(this.a) != null)
      CardFrontView.c(this.a).setSelected(false);
    CardFrontView.a(this.a, paramView);
    paramView.setSelected(true);
    String str = (String)paramView.getTag();
    CardFrontView.a(this.a, CardFrontView.b(this.a).a(str));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CardFrontView.2
 * JD-Core Version:    0.6.0
 */