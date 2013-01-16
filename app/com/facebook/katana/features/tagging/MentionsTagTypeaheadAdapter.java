package com.facebook.katana.features.tagging;

import android.content.Context;
import android.widget.Filter;

public final class MentionsTagTypeaheadAdapter extends TagTypeaheadAdapter
{
  private final MentionsTagTypeaheadAdapter.MentionsTagTypeaheadFilter b = new MentionsTagTypeaheadAdapter.MentionsTagTypeaheadFilter(this, null);

  public MentionsTagTypeaheadAdapter(Context paramContext)
  {
    super(paramContext, 2130903558);
    this.b.a(false).b(false).c(false).d(false);
  }

  public MentionsTagTypeaheadAdapter a(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
    return this;
  }

  public MentionsTagTypeaheadAdapter b(boolean paramBoolean)
  {
    this.b.d(paramBoolean);
    return this;
  }

  public Filter getFilter()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.MentionsTagTypeaheadAdapter
 * JD-Core Version:    0.6.0
 */