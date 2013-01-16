package com.facebook.katana.activity.findfriends;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class FindFriendsActivity$3 extends ClickableSpan
{
  public void onClick(View paramView)
  {
    if (FindFriendsActivity.d(this.a) == 1)
    {
      FindFriendsActivity.a(this.a, false);
      FindFriendsActivity.a(this.a).a(true);
    }
    while (true)
    {
      ((TextView)this.a.findViewById(2131296852)).setText(FindFriendsActivity.e(this.a));
      ((Button)this.a.findViewById(2131296853)).setVisibility(0);
      return;
      FindFriendsActivity.b(this.a, false);
      FindFriendsActivity.c(this.a).a(true);
    }
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.a.getResources().getColor(2131165440));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.FindFriendsActivity.3
 * JD-Core Version:    0.6.0
 */