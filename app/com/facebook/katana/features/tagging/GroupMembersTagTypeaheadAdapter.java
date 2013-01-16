package com.facebook.katana.features.tagging;

import android.content.Context;
import android.widget.Filter;

public class GroupMembersTagTypeaheadAdapter extends BaseTagTypeaheadAdapter
{
  private Filter b = new GroupMembersTagTypeaheadAdapter.TagTypeaheadFilter(this, null);
  private long c;

  public GroupMembersTagTypeaheadAdapter(Context paramContext, long paramLong)
  {
    super(paramContext);
    this.c = paramLong;
  }

  public Filter getFilter()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.GroupMembersTagTypeaheadAdapter
 * JD-Core Version:    0.6.0
 */