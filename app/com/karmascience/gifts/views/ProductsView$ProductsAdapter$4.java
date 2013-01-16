package com.karmascience.gifts.views;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.karmascience.gifts.content.model.Product;

class ProductsView$ProductsAdapter$4
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
      ProductsView.ProductsAdapter.a(this.b, this.a);
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsView.ProductsAdapter.4
 * JD-Core Version:    0.6.0
 */