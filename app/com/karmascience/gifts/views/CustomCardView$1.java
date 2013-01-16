package com.karmascience.gifts.views;

import android.text.Editable;
import android.text.TextWatcher;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;

class CustomCardView$1
  implements TextWatcher
{
  public void afterTextChanged(Editable paramEditable)
  {
    if (!CustomCardView.a(this.a))
      this.a.n().c("Edited Card Message").a();
    CustomCardView.a(this.a, true);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CustomCardView.1
 * JD-Core Version:    0.6.0
 */