package com.facebook.katana.activity.profilelist;

import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookGroup;
import com.facebook.katana.util.StringUtils;
import java.util.List;

public class GroupSelectorActivity$GroupSelectorListener extends ProfileListActivity.ProfileListListener
{
  public GroupSelectorActivity$GroupSelectorListener(GroupSelectorActivity paramGroupSelectorActivity)
  {
    super(paramGroupSelectorActivity);
  }

  public void e(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, List<FacebookGroup> paramList)
  {
    if (paramInt == 200)
      ((GroupSelectorAdapter)this.a.B).a(paramList);
    while (true)
    {
      GroupSelectorActivity.a(this.a, false);
      return;
      String str = StringUtils.a(this.a, this.a.getString(2131362958), paramInt, paramString2, paramException);
      Toaster.a(this.a, str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.profilelist.GroupSelectorActivity.GroupSelectorListener
 * JD-Core Version:    0.6.0
 */