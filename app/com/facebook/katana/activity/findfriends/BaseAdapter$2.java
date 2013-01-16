package com.facebook.katana.activity.findfriends;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class BaseAdapter$2 extends ClickableSpan
{
  public void onClick(View paramView)
  {
    this.c.b(this.a, this.b);
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.c.b.getResources().getColor(2131165440));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.BaseAdapter.2
 * JD-Core Version:    0.6.0
 */