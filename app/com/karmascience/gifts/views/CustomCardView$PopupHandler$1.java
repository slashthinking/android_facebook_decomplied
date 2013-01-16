package com.karmascience.gifts.views;

import android.widget.TextView;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.Utils;
import com.karmascience.gifts.widget.BubblePopup.OnOptionClickedListener;
import java.util.List;

class CustomCardView$PopupHandler$1
  implements BubblePopup.OnOptionClickedListener
{
  public void a(int paramInt)
  {
    if (!Utils.a(CustomCardView.PopupHandler.a(this.a).getText().toString(), (String)CustomCardView.PopupHandler.b(this.a).get(paramInt)))
      this.a.a.n().c(CustomCardView.PopupHandler.c(this.a)).a("closing_value", (String)CustomCardView.PopupHandler.b(this.a).get(paramInt)).a();
    TextView localTextView = CustomCardView.PopupHandler.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder().append((String)CustomCardView.PopupHandler.b(this.a).get(paramInt));
    if (CustomCardView.PopupHandler.d(this.a));
    for (String str = ","; ; str = "")
    {
      localTextView.setText(str);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CustomCardView.PopupHandler.1
 * JD-Core Version:    0.6.0
 */