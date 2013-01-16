package com.facebook.katana.activity.composer;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;

class ComposerActivity$18
  implements TextWatcher
{
  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.a.findViewById(2131296528);
    if ((localLinearLayout.getVisibility() != 8) && (localLinearLayout.getAnimation() == null))
      ComposerActivity.a(this.a, localLinearLayout);
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity.18
 * JD-Core Version:    0.6.0
 */