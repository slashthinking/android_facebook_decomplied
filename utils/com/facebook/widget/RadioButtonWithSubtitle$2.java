package com.facebook.widget;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class RadioButtonWithSubtitle$2
  implements CompoundButton.OnCheckedChangeListener
{
  RadioButtonWithSubtitle$2(RadioButtonWithSubtitle paramRadioButtonWithSubtitle)
  {
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (RadioButtonWithSubtitle.b(this.a) != null)
      RadioButtonWithSubtitle.b(this.a).a(this.a, paramBoolean);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.RadioButtonWithSubtitle.2
 * JD-Core Version:    0.6.2
 */