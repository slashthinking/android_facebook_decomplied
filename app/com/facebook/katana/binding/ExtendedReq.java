package com.facebook.katana.binding;

import android.content.Context;
import android.content.Intent;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.features.places.PlacesUtils;
import com.facebook.katana.features.places.SelectAtTagFetcher.SelectAtTagArgType;
import com.facebook.katana.model.FacebookCheckin;
import com.facebook.katana.model.FacebookCheckinDetails;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.service.method.FqlGetAtTags;
import com.facebook.katana.service.method.FqlGetFriendCheckins;
import com.facebook.katana.service.method.PlacesCheckin;
import com.facebook.katana.service.method.ServiceOperation;
import com.facebook.katana.util.ReentrantCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class ExtendedReq
{
  static void a(AppSession paramAppSession, Context paramContext, Intent paramIntent, int paramInt, String paramString, Exception paramException, ServiceOperation paramServiceOperation)
  {
    int i = paramIntent.getIntExtra("extended_type", 0);
    String str = paramIntent.getStringExtra("rid");
    switch (i)
    {
    default:
      return;
    case 500:
      FqlGetFriendCheckins localFqlGetFriendCheckins = (FqlGetFriendCheckins)paramServiceOperation;
      List localList3 = null;
      if (paramInt == 200)
        localList3 = localFqlGetFriendCheckins.g();
      Iterator localIterator4 = paramAppSession.b.a().iterator();
      while (localIterator4.hasNext())
        ((AppSessionListener)localIterator4.next()).d(paramAppSession, str, paramInt, paramString, paramException, localList3);
    case 501:
      FqlGetAtTags localFqlGetAtTags = (FqlGetAtTags)paramServiceOperation;
      boolean bool2 = false;
      List localList1 = null;
      List localList2 = null;
      if (paramInt == 200)
      {
        localList1 = localFqlGetAtTags.g();
        localList2 = localFqlGetAtTags.h();
        bool2 = true;
      }
      if (localFqlGetAtTags.j != null)
      {
        SelectAtTagFetcher.SelectAtTagArgType localSelectAtTagArgType = new SelectAtTagFetcher.SelectAtTagArgType(localFqlGetAtTags.f, localFqlGetAtTags.g, localFqlGetAtTags.h, localFqlGetAtTags.i);
        localFqlGetAtTags.j.a(paramContext, bool2, localSelectAtTagArgType, null, localFqlGetAtTags);
      }
      Iterator localIterator3 = paramAppSession.b.a().iterator();
      while (localIterator3.hasNext())
        ((AppSessionListener)localIterator3.next()).a(paramAppSession, str, paramInt, paramString, paramException, localList1, localList2, localFqlGetAtTags.f, localFqlGetAtTags.g, localFqlGetAtTags.h, localFqlGetAtTags.i);
    case 700:
      Iterator localIterator2 = paramAppSession.b.a().iterator();
      while (localIterator2.hasNext())
        ((AppSessionListener)localIterator2.next()).a(paramAppSession, str, paramInt, paramString, paramException, paramServiceOperation);
    case 503:
    }
    PlacesCheckin localPlacesCheckin = (PlacesCheckin)paramServiceOperation;
    FacebookPlace localFacebookPlace = localPlacesCheckin.a;
    if (localFacebookPlace.mPageId > 0L);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Assert.b(bool1);
      long l = localPlacesCheckin.g();
      if ((paramInt == 200) && (l != -1L))
      {
        FacebookUser localFacebookUser = paramAppSession.b().a();
        ArrayList localArrayList = new ArrayList(localPlacesCheckin.g);
        FacebookCheckinDetails localFacebookCheckinDetails = new FacebookCheckinDetails(l, localFacebookUser.mUserId, localFacebookPlace.mPageId, System.currentTimeMillis() / 1000L, localArrayList, "checkin", 350685531728L);
        localFacebookCheckinDetails.a(localFacebookPlace);
        FacebookCheckin localFacebookCheckin = new FacebookCheckin(localFacebookUser.mUserId, l);
        localFacebookCheckin.a(localFacebookCheckinDetails);
        localFacebookCheckin.a(localFacebookUser);
        PlacesUtils.a(paramContext, localFacebookCheckin, System.currentTimeMillis());
      }
      Iterator localIterator1 = paramAppSession.b.a().iterator();
      while (localIterator1.hasNext())
        ((AppSessionListener)localIterator1.next()).d(paramAppSession, str, paramInt, paramString, paramException);
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ExtendedReq
 * JD-Core Version:    0.6.0
 */