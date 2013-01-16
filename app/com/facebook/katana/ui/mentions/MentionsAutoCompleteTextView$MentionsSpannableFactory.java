package com.facebook.katana.ui.mentions;

import android.text.Editable;
import android.text.Editable.Factory;

class MentionsAutoCompleteTextView$MentionsSpannableFactory extends Editable.Factory
{
  private MentionsAutoCompleteTextView$MentionsSpannableFactory(MentionsAutoCompleteTextView paramMentionsAutoCompleteTextView)
  {
  }

  public Editable newEditable(CharSequence paramCharSequence)
  {
    return MentionsSpannableStringBuilder.a(paramCharSequence, this.a.getResources());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.mentions.MentionsAutoCompleteTextView.MentionsSpannableFactory
 * JD-Core Version:    0.6.0
 */