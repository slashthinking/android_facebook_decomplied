package com.karmascience.gifts.views;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.widget.BubblePopup;
import java.util.List;

class CustomCardView$PopupHandler
  implements View.OnClickListener
{
  private final TextView b;
  private final List<String> c;
  private final String d;
  private final boolean e;

  public CustomCardView$PopupHandler(TextView paramTextView, List<String> paramList, String paramString, boolean paramBoolean)
  {
    boolean bool;
    this.e = bool;
    this.b = paramList;
    this.c = paramString;
    String str = this.b.getText().toString();
    if ((str == null) || (str.trim().equals("")))
      paramList.setText((CharSequence)paramString.get(0));
    this.b.setOnClickListener(this);
    this.d = paramBoolean;
  }

  public void onClick(View paramView)
  {
    this.a.n().c("Clicked Card Closings").a();
    if (this.e)
    {
      str = this.b.getText().toString();
      if (!str.endsWith(","));
    }
    for (String str = str.substring(0, -1 + str.length()); ; str = this.b.getText().toString())
    {
      int i = this.c.indexOf(str);
      BubblePopup localBubblePopup = new BubblePopup(this.a.g());
      localBubblePopup.a((String[])this.c.toArray(new String[0]), i, new CustomCardView.PopupHandler.1(this));
      localBubblePopup.a(1.0F, 1.0F);
      localBubblePopup.a(this.b, true);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CustomCardView.PopupHandler
 * JD-Core Version:    0.6.0
 */