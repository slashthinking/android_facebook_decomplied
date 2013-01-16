package com.facebook.katana.activity.profilelist;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.model.FacebookGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GroupSelectorAdapter$GroupFilter extends Filter
{
  private GroupSelectorAdapter$GroupFilter(GroupSelectorAdapter paramGroupSelectorAdapter)
  {
  }

  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      localFilterResults.count = GroupSelectorAdapter.a(this.a).size();
      localFilterResults.values = GroupSelectorAdapter.a(this.a);
      GroupSelectorAdapter.a(this.a, null);
    }
    while (true)
    {
      return localFilterResults;
      ArrayList localArrayList = new ArrayList();
      String str = paramCharSequence.toString().trim().toLowerCase();
      Iterator localIterator = GroupSelectorAdapter.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        FacebookGroup localFacebookGroup = (FacebookGroup)(FacebookProfile)localIterator.next();
        if (!localFacebookGroup.mDisplayName.toLowerCase().contains(str))
          continue;
        localArrayList.add(localFacebookGroup);
      }
      localFilterResults.count = localArrayList.size();
      localFilterResults.values = localArrayList;
      GroupSelectorAdapter.a(this.a, paramCharSequence.toString());
    }
  }

  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if (paramFilterResults.values != null)
    {
      this.a.d = ((List)paramFilterResults.values);
      this.a.j();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupSelectorAdapter.GroupFilter
 * JD-Core Version:    0.6.0
 */