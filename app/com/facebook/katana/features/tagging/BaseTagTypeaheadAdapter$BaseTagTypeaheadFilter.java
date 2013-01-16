package com.facebook.katana.features.tagging;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.widget.tagging.TaggingProfile;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseTagTypeaheadAdapter$BaseTagTypeaheadFilter extends Filter
{
  protected BaseTagTypeaheadAdapter$BaseTagTypeaheadFilter(BaseTagTypeaheadAdapter paramBaseTagTypeaheadAdapter)
  {
  }

  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    this.a.setNotifyOnChange(false);
    this.a.clear();
    if (paramFilterResults != null)
    {
      ArrayList localArrayList = (ArrayList)paramFilterResults.values;
      if (localArrayList != null)
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          TaggingProfile localTaggingProfile = (TaggingProfile)localIterator.next();
          if ((this.a.a != null) && (this.a.a.a(localTaggingProfile.b())))
            continue;
          this.a.add(localTaggingProfile);
        }
      }
    }
    this.a.notifyDataSetChanged();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.BaseTagTypeaheadAdapter.BaseTagTypeaheadFilter
 * JD-Core Version:    0.6.0
 */