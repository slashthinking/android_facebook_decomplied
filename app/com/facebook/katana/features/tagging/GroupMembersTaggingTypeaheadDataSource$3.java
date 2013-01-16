package com.facebook.katana.features.tagging;

import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.widget.tagging.TaggingProfile;
import com.facebook.widget.tagging.TaggingProfile.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class GroupMembersTaggingTypeaheadDataSource$3 extends AppSessionListener
{
  public void d(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, Map<Long, FacebookProfile> paramMap)
  {
    if (paramInt == 200)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.values().iterator();
      while (localIterator.hasNext())
      {
        FacebookProfile localFacebookProfile = (FacebookProfile)localIterator.next();
        localArrayList.add(new TaggingProfile(localFacebookProfile.mDisplayName, localFacebookProfile.mId, localFacebookProfile.mImageUrl, TaggingProfile.Type.USER));
      }
      this.a.a(localArrayList);
    }
    while (true)
    {
      return;
      this.a.a(new ArrayList());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.tagging.GroupMembersTaggingTypeaheadDataSource.3
 * JD-Core Version:    0.6.0
 */