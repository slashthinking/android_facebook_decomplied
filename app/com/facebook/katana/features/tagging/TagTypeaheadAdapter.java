package com.facebook.katana.features.tagging;

import android.content.Context;
import android.widget.Filter;

public class TagTypeaheadAdapter extends BaseTagTypeaheadAdapter
{
  private Filter b = new TagTypeaheadAdapter.TagTypeaheadFilter(this);

  public TagTypeaheadAdapter(Context paramContext)
  {
    super(paramContext);
  }

  public TagTypeaheadAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  public Filter getFilter()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.TagTypeaheadAdapter
 * JD-Core Version:    0.6.0
 */