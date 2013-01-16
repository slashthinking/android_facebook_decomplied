package com.facebook.katana.activity.findfriends;

import com.facebook.katana.activity.profilelist.ProfileListActivity.ProfileListAdapter;
import com.facebook.katana.activity.profilelist.ProfileListActivity.ProfileListListener;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import com.facebook.katana.service.method.ContactRemoteInfoFetcher.Listener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindFriendsActivity$ContactRemoteInfoFetcherListener extends ProfileListActivity.ProfileListListener
  implements ContactRemoteInfoFetcher.Listener
{
  protected FindFriendsActivity$ContactRemoteInfoFetcherListener(FindFriendsActivity paramFindFriendsActivity)
  {
    super(paramFindFriendsActivity);
  }

  public void a(List<FacebookPhonebookContactUser> paramList, int paramInt, String paramString, Exception paramException)
  {
    FindFriendsActivity.a(this.a, paramList);
    if (FindFriendsActivity.g(this.a).size() == 0)
      this.a.q();
    while (true)
    {
      return;
      FindFriendsActivity.a(this.a).a(FindFriendsActivity.g(this.a));
      this.a.p();
      FindFriendsActivity.h(this.a).j();
    }
  }

  public void a(Map<Long, FacebookPhonebookContact> paramMap)
  {
    FindFriendsActivity.a(this.a, paramMap);
    FindFriendsActivity.c(this.a).a(new ArrayList(FindFriendsActivity.f(this.a).values()));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.FindFriendsActivity.ContactRemoteInfoFetcherListener
 * JD-Core Version:    0.6.0
 */