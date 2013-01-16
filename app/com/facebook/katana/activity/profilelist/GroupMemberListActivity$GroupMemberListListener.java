package com.facebook.katana.activity.profilelist;

import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.binding.AppSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupMemberListActivity$GroupMemberListListener extends ProfileListActivity.ProfileListListener
{
  public GroupMemberListActivity$GroupMemberListListener(GroupMemberListActivity paramGroupMemberListActivity)
  {
    super(paramGroupMemberListActivity);
  }

  public void d(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, Map<Long, FacebookProfile> paramMap)
  {
    if (paramInt == 200)
    {
      GroupMemberListActivity.a(this.a);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.values().iterator();
      while (localIterator.hasNext())
        localArrayList.add((FacebookProfile)localIterator.next());
      ((ProfileListDynamicAdapter)this.a.B).a(localArrayList);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupMemberListActivity.GroupMemberListListener
 * JD-Core Version:    0.6.0
 */