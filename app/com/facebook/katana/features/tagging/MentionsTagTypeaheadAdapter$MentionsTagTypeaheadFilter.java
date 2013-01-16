package com.facebook.katana.features.tagging;

import android.widget.Filter.FilterResults;
import com.facebook.widget.tagging.TaggingProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MentionsTagTypeaheadAdapter$MentionsTagTypeaheadFilter extends TagTypeaheadAdapter.TagTypeaheadFilter
{
  private MentionsTagTypeaheadAdapter$MentionsTagTypeaheadFilter(MentionsTagTypeaheadAdapter paramMentionsTagTypeaheadAdapter)
  {
    super(paramMentionsTagTypeaheadAdapter);
  }

  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults = super.performFiltering(paramCharSequence);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0));
    while (true)
    {
      return localFilterResults;
      ArrayList localArrayList = new ArrayList();
      String str = paramCharSequence.toString().toLowerCase();
      Iterator localIterator = ((List)localFilterResults.values).iterator();
      label152: 
      while (localIterator.hasNext())
      {
        TaggingProfile localTaggingProfile = (TaggingProfile)localIterator.next();
        if ((localTaggingProfile.a() == null) || (localTaggingProfile.a().length() == 0))
          continue;
        String[] arrayOfString = localTaggingProfile.a().toLowerCase().split(" ");
        int i = arrayOfString.length;
        for (int j = 0; ; j++)
        {
          if (j >= i)
            break label152;
          if (!arrayOfString[j].startsWith(str))
            continue;
          localArrayList.add(localTaggingProfile);
          break;
        }
      }
      localFilterResults = new Filter.FilterResults();
      localFilterResults.values = localArrayList;
      localFilterResults.count = localArrayList.size();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.MentionsTagTypeaheadAdapter.MentionsTagTypeaheadFilter
 * JD-Core Version:    0.6.0
 */