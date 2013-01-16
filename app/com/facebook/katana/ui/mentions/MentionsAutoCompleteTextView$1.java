package com.facebook.katana.ui.mentions;

import com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter;
import java.util.List;

class MentionsAutoCompleteTextView$1
  implements BaseTagTypeaheadAdapter.TaggingProfileExclusionFilter
{
  public boolean a(long paramLong)
  {
    List localList = ((MentionsSpannableStringBuilder)this.a.getEditableText()).b();
    if ((localList != null) && (localList.contains(Long.valueOf(paramLong))));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.mentions.MentionsAutoCompleteTextView.1
 * JD-Core Version:    0.6.0
 */