package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.ipc.katana.model.FacebookDeal;
import com.facebook.ipc.katana.model.FacebookDealHistory;
import com.facebook.ipc.katana.model.FacebookDealStatus;
import com.facebook.ipc.katana.model.FacebookPage;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.model.FacebookApp;
import com.facebook.katana.model.FacebookCheckin;
import com.facebook.katana.model.FacebookCheckinDetails;
import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FqlGetFriendCheckins extends FqlMultiQuery
{
  private static final Class<?> b = FqlGetFriendCheckins.class;
  protected List<FacebookCheckin> a;

  public FqlGetFriendCheckins(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, a(paramContext, paramIntent, paramString), paramServiceOperationListener);
  }

  protected static LinkedHashMap<String, FqlQuery> a(Context paramContext, Intent paramIntent, String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("checkins", new FqlGetFriendCheckins.FqlGetCheckins(paramContext, paramIntent, paramString, null));
    localLinkedHashMap.put("details", new FqlGetFriendCheckins.FqlGetCheckinDetails(paramContext, paramIntent, paramString, null, "checkin_id IN (SELECT checkin_id FROM #checkins)"));
    localLinkedHashMap.put("users", new FqlGetUsersProfile(paramContext, paramIntent, paramString, null, "uid IN (SELECT actor_uid FROM #checkins)", FacebookUser.class));
    localLinkedHashMap.put("places", new FqlGetPlaces(paramContext, paramIntent, paramString, null, "page_id IN (SELECT page_id FROM #details)"));
    localLinkedHashMap.put("pages", new FqlGetPages(paramContext, paramIntent, paramString, null, "page_id IN (SELECT page_id FROM #details)", FacebookPage.class));
    localLinkedHashMap.put("apps", new FqlGetAppsProfile(paramContext, paramIntent, paramString, null, "app_id IN (SELECT app_id FROM #details) AND is_facebook_app=0"));
    localLinkedHashMap.put("deals", new FqlGetDeals(paramContext, paramIntent, paramString, null, "creator_id IN (SELECT page_id FROM #places)"));
    localLinkedHashMap.put("deal_status", new FqlGetDealStatus(paramContext, paramIntent, paramString, null, "promotion_id IN (SELECT promotion_id FROM #deals)"));
    localLinkedHashMap.put("deal_history", new FqlGetDealHistory(paramContext, paramIntent, paramString, null, "promotion_id IN (SELECT promotion_id FROM #deals)"));
    return localLinkedHashMap;
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
    List localList = ((FqlGetFriendCheckins.FqlGetCheckins)c("checkins")).a;
    Map localMap1 = ((FqlGetFriendCheckins.FqlGetCheckinDetails)c("details")).a;
    Map localMap2 = ((FqlGetUsersProfile)c("users")).g();
    Map localMap3 = ((FqlGetAppsProfile)c("apps")).g();
    Map localMap4 = ((FqlGetPlaces)c("places")).g();
    Map localMap5 = ((FqlGetPages)c("pages")).g();
    Map localMap6 = ((FqlGetDeals)c("deals")).g();
    Map localMap7 = ((FqlGetDealStatus)c("deal_status")).g();
    Map localMap8 = ((FqlGetDealHistory)c("deal_history")).g();
    this.a = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FacebookCheckin localFacebookCheckin = (FacebookCheckin)localIterator.next();
      FacebookUser localFacebookUser = (FacebookUser)localMap2.get(Long.valueOf(localFacebookCheckin.mActorId));
      if (localFacebookUser == null)
        continue;
      localFacebookCheckin.a(localFacebookUser);
      FacebookCheckinDetails localFacebookCheckinDetails = (FacebookCheckinDetails)localMap1.get(Long.valueOf(localFacebookCheckin.mCheckinId));
      if (localFacebookCheckinDetails == null)
        continue;
      localFacebookCheckin.a(localFacebookCheckinDetails);
      localFacebookCheckinDetails.a((FacebookApp)localMap3.get(Long.valueOf(localFacebookCheckinDetails.mAppId)));
      FacebookPlace localFacebookPlace = (FacebookPlace)localMap4.get(Long.valueOf(localFacebookCheckinDetails.mPageId));
      if (localFacebookPlace == null)
        continue;
      localFacebookCheckinDetails.a(localFacebookPlace);
      localFacebookPlace.a((FacebookPage)localMap5.get(Long.valueOf(localFacebookCheckinDetails.mPageId)));
      FacebookDeal localFacebookDeal = (FacebookDeal)localMap6.get(Long.valueOf(localFacebookCheckinDetails.mPageId));
      if (localFacebookDeal != null)
      {
        FacebookDealStatus localFacebookDealStatus = (FacebookDealStatus)localMap7.get(Long.valueOf(localFacebookDeal.mDealId));
        localFacebookDeal.mDealHistory = ((FacebookDealHistory)localMap8.get(Long.valueOf(localFacebookDeal.mDealId)));
        localFacebookDeal.mDealStatus = localFacebookDealStatus;
      }
      localFacebookPlace.a(localFacebookDeal);
      this.a.add(localFacebookCheckin);
    }
    Collections.sort(this.a, FacebookCheckin.checkinsByTimeComparator);
  }

  public List<FacebookCheckin> g()
  {
    return Collections.unmodifiableList(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetFriendCheckins
 * JD-Core Version:    0.6.0
 */