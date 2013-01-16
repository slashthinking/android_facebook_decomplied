package com.facebook.katana.features.tagging;

import android.widget.Filter.FilterResults;
import com.facebook.orca.inject.FbInjector;
import java.util.List;

class GroupMembersTagTypeaheadAdapter$TagTypeaheadFilter extends BaseTagTypeaheadAdapter.BaseTagTypeaheadFilter
{
  private GroupMembersTagTypeaheadAdapter$TagTypeaheadFilter(GroupMembersTagTypeaheadAdapter paramGroupMembersTagTypeaheadAdapter)
  {
    super(paramGroupMembersTagTypeaheadAdapter);
  }

  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    List localList = ((GroupMembersTaggingTypeaheadDataSource)FbInjector.a(this.b.getContext()).a(GroupMembersTaggingTypeaheadDataSource.class)).a(paramCharSequence, Long.valueOf(GroupMembersTagTypeaheadAdapter.a(this.b)));
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    localFilterResults.values = localList;
    localFilterResults.count = localList.size();
    return localFilterResults;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.GroupMembersTagTypeaheadAdapter.TagTypeaheadFilter
 * JD-Core Version:    0.6.0
 */