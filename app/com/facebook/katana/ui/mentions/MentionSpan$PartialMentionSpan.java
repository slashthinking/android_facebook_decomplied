package com.facebook.katana.ui.mentions;

import android.text.Editable;

public class MentionSpan$PartialMentionSpan
{
  private final String b;

  public MentionSpan$PartialMentionSpan(MentionSpan paramMentionSpan, String paramString)
  {
    this.b = paramString;
  }

  public String a()
  {
    return this.b;
  }

  public boolean a(Editable paramEditable)
  {
    int i = paramEditable.getSpanStart(this);
    int j = paramEditable.getSpanEnd(this);
    if ((i == -1) || (j == -1));
    for (boolean bool = false; ; bool = this.b.equals(paramEditable.subSequence(i, j).toString()))
      return bool;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.mentions.MentionSpan.PartialMentionSpan
 * JD-Core Version:    0.6.0
 */