package com.facebook.katana.activity.findfriends;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.widget.GridView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import com.facebook.katana.service.method.ContactRemoteInfoFetcher.Listener;
import com.facebook.katana.util.MemoryInfo;
import com.facebook.katana.view.findfriends.FriendCandidate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StepAddFriendsActivity$StepAddFriendsListener extends AppSessionListener
  implements ContactRemoteInfoFetcher.Listener
{
  private boolean b = false;

  public StepAddFriendsActivity$StepAddFriendsListener(StepAddFriendsActivity paramStepAddFriendsActivity)
  {
  }

  public void a()
  {
    this.b = true;
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException, Bitmap paramBitmap)
  {
    if (paramInt == 200)
    {
      FriendCandidate localFriendCandidate = (FriendCandidate)StepAddFriendsActivity.k(this.a).remove(paramString1);
      if ((localFriendCandidate != null) && (paramBitmap != null))
      {
        StepAddFriendsActivity.c(this.a).a(paramBitmap, localFriendCandidate);
        int i = StepAddFriendsActivity.c(this.a).getPosition(localFriendCandidate);
        GridView localGridView = (GridView)this.a.findViewById(2131296856);
        if ((i >= localGridView.getFirstVisiblePosition()) && (i <= localGridView.getLastVisiblePosition()))
          StepAddFriendsActivity.c(this.a).notifyDataSetChanged();
      }
      if (localFriendCandidate != null)
        localFriendCandidate.a(null);
    }
  }

  public void a(List<FacebookPhonebookContactUser> paramList, int paramInt, String paramString, Exception paramException)
  {
    int i = 10;
    if (this.b)
      return;
    MemoryInfo localMemoryInfo = new MemoryInfo();
    int j = Math.min(300, (int)(localMemoryInfo.e / 120000L));
    if (j < i)
      ErrorReporting.a("friend_finder_low_memory", "low phone heap space:" + localMemoryInfo.e);
    while (true)
    {
      int k = Math.min(i, paramList.size());
      StepAddFriendsActivity.a(this.a, new ArrayList(k));
      Iterator localIterator = paramList.subList(0, k).iterator();
      while (localIterator.hasNext())
      {
        FriendCandidate localFriendCandidate = new FriendCandidate((FacebookPhonebookContactUser)localIterator.next());
        StepAddFriendsActivity.m(this.a).add(localFriendCandidate);
      }
      Collections.sort(StepAddFriendsActivity.m(this.a), new StepAddFriendsActivity.StepAddFriendsListener.1(this));
      StepAddFriendsActivity.a(this.a, 100);
      StepAddFriendsActivity.n(this.a);
      StepAddFriendsActivity.j(this.a).a(new FindFriendsAnalyticsEvent("add_friends").i("friend_info_fetched").c(StepAddFriendsActivity.i(this.a)).b(SystemClock.elapsedRealtime() - StepAddFriendsActivity.h(this.a)).a(StepAddFriendsActivity.g(this.a).size()).c(StepAddFriendsActivity.m(this.a).size()));
      break;
      i = j;
    }
  }

  public void a(Map<Long, FacebookPhonebookContact> paramMap)
  {
    if (this.b);
    while (true)
    {
      return;
      StepAddFriendsActivity.a(this.a, 66);
      StepAddFriendsActivity.b(this.a, paramMap);
      StepAddFriendsActivity.j(this.a).a(new FindFriendsAnalyticsEvent("add_friends").i("invite_info_fetched").c(StepAddFriendsActivity.i(this.a)).b(SystemClock.elapsedRealtime() - StepAddFriendsActivity.h(this.a)).a(StepAddFriendsActivity.g(this.a).size()).d(StepAddFriendsActivity.l(this.a).size()));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepAddFriendsActivity.StepAddFriendsListener
 * JD-Core Version:    0.6.0
 */