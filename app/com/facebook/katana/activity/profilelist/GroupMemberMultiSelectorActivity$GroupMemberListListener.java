package com.facebook.katana.activity.profilelist;

import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupMemberMultiSelectorActivity$GroupMemberListListener extends ProfileListActivity.ProfileListListener
{
  public GroupMemberMultiSelectorActivity$GroupMemberListListener(GroupMemberMultiSelectorActivity paramGroupMemberMultiSelectorActivity)
  {
    super(paramGroupMemberMultiSelectorActivity);
  }

  public void d(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, Map<Long, FacebookProfile> paramMap)
  {
    if (paramInt == 200)
    {
      GroupMemberMultiSelectorActivity.b(this.a);
      long l = GroupMemberMultiSelectorActivity.c(this.a).b().userId;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = paramMap.values().iterator();
      while (localIterator1.hasNext())
      {
        FacebookProfile localFacebookProfile2 = (FacebookProfile)localIterator1.next();
        if (localFacebookProfile2.mId == l)
          continue;
        localArrayList.add(localFacebookProfile2);
      }
      Iterator localIterator2 = this.a.t.iterator();
      while (localIterator2.hasNext())
      {
        FacebookProfile localFacebookProfile1 = (FacebookProfile)localIterator2.next();
        if (localArrayList.contains(localFacebookProfile1))
          continue;
        localArrayList.add(localFacebookProfile1);
      }
      if (localArrayList.size() == 0)
        GroupMemberMultiSelectorActivity.a(this.a, false);
      ((SelectableProfileListDynamicAdapter)this.a.B).a(localArrayList);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupMemberMultiSelectorActivity.GroupMemberListListener
 * JD-Core Version:    0.6.0
 */