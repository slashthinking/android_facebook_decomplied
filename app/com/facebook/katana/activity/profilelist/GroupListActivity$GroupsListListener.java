package com.facebook.katana.activity.profilelist;

import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookGroup;
import java.util.List;

public class GroupListActivity$GroupsListListener extends ProfileListActivity.ProfileListListener
{
  public GroupListActivity$GroupsListListener(GroupListActivity paramGroupListActivity)
  {
    super(paramGroupListActivity);
  }

  public void e(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookGroup> paramList)
  {
    if (paramInt == 200)
      ((GroupListAdapter)this.a.B).a(paramList);
    GroupListActivity.a(this.a, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupListActivity.GroupsListListener
 * JD-Core Version:    0.6.0
 */