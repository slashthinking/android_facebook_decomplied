package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookDeal;
import com.facebook.ipc.katana.model.FacebookDealHistory;
import com.facebook.ipc.katana.model.FacebookDealStatus;
import com.facebook.ipc.katana.model.FacebookEvent;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.features.places.SelectAtTagFetcher.SearchType;
import com.facebook.katana.features.places.SelectAtTagFetcher.SelectAtTagArgType;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.GeoRegion;
import com.facebook.katana.model.GeoRegion.Type;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FqlGetAtTags extends FqlMultiQuery
{
  private static final Class<?> r = FqlGetAtTags.class;
  protected List<FacebookPlace> a;
  protected List<GeoRegion> b;
  public Location f;
  public String g;
  public SelectAtTagFetcher.SearchType h;
  public long i;
  public NetworkRequestCallback<SelectAtTagFetcher.SelectAtTagArgType, FqlGetAtTags> j;

  public FqlGetAtTags(Context paramContext, Intent paramIntent, String paramString1, ServiceOperationListener paramServiceOperationListener, Location paramLocation, String paramString2, SelectAtTagFetcher.SearchType paramSearchType, long paramLong, NetworkRequestCallback<SelectAtTagFetcher.SelectAtTagArgType, FqlGetAtTags> paramNetworkRequestCallback)
  {
    super(paramContext, paramIntent, paramString1, a(paramContext, paramIntent, paramString1, paramLocation, paramString2, paramSearchType, paramLong), paramServiceOperationListener);
    this.f = paramLocation;
    this.g = paramString2;
    this.h = paramSearchType;
    this.i = paramLong;
    this.j = paramNetworkRequestCallback;
  }

  private static String a(Location paramLocation)
  {
    Object[] arrayOfObject2;
    if (paramLocation.hasAccuracy())
    {
      arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Double.valueOf(paramLocation.getLatitude());
      arrayOfObject2[1] = Double.valueOf(paramLocation.getLongitude());
      arrayOfObject2[2] = Float.valueOf(paramLocation.getAccuracy());
    }
    Object[] arrayOfObject1;
    for (String str = StringLocaleUtil.a("distance(latitude, longitude, \"%f\", \"%f\", \"%f\")", arrayOfObject2); ; str = StringLocaleUtil.a("distance(latitude, longitude, \"%f\", \"%f\")", arrayOfObject1))
    {
      return str;
      arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Double.valueOf(paramLocation.getLatitude());
      arrayOfObject1[1] = Double.valueOf(paramLocation.getLongitude());
    }
  }

  private static String a(Location paramLocation, String paramString, SelectAtTagFetcher.SearchType paramSearchType, long paramLong)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    long l;
    if ((paramLocation != null) || (!StringUtils.c(paramString)))
    {
      bool = true;
      Assert.b(bool);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("search_type = ");
      StringUtils.a(localStringBuilder, paramSearchType.toString());
      if (paramLong != -1L)
        break label156;
      l = -1L;
    }
    while (true)
    {
      localStringBuilder.append(" AND content_age = \"").append(l).append("\"");
      if (paramLocation != null)
        localStringBuilder.append(" AND ").append(a(paramLocation)).append(" > 0");
      if (!StringUtils.c(paramString))
      {
        localStringBuilder.append(" AND CONTAINS (");
        StringUtils.a(localStringBuilder, paramString);
        localStringBuilder.append(")");
      }
      localStringBuilder.append(" LIMIT ").append(20);
      return localStringBuilder.toString();
      bool = false;
      break;
      label156: if (paramLong == 0L)
      {
        l = 0L;
        continue;
      }
      l = (System.currentTimeMillis() - paramLong) / 1000L;
      if (l >= 0L)
        continue;
      l = -1L;
    }
  }

  protected static LinkedHashMap<String, FqlQuery> a(Context paramContext, Intent paramIntent, String paramString1, Location paramLocation, String paramString2, SelectAtTagFetcher.SearchType paramSearchType, long paramLong)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("places", new FqlGetPlaces(paramContext, paramIntent, paramString1, null, a(paramLocation, paramString2, paramSearchType, paramLong)));
    Boolean localBoolean = Gatekeeper.a(paramContext, "android_event_tagging");
    if ((StringUtils.c(paramString2)) && (Boolean.TRUE.equals(localBoolean)) && (SelectAtTagFetcher.SearchType.EVENT != paramSearchType))
    {
      AppSession localAppSession = AppSession.b(paramContext, false);
      if (localAppSession != null)
        localLinkedHashMap.put("events", FqlGetAtTags.FqlGetEventsCoveringTimeRange.a(paramContext, paramIntent, paramString1, null, localAppSession.b().userId, 5));
    }
    localLinkedHashMap.put("deals", new FqlGetDeals(paramContext, paramIntent, paramString1, null, "creator_id IN (SELECT page_id FROM #places)"));
    localLinkedHashMap.put("deal_status", new FqlGetDealStatus(paramContext, paramIntent, paramString1, null, "promotion_id IN (SELECT promotion_id FROM #deals)"));
    localLinkedHashMap.put("deal_history", new FqlGetDealHistory(paramContext, paramIntent, paramString1, null, "promotion_id IN (SELECT promotion_id FROM #deals)"));
    if (paramLocation != null)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Double.valueOf(paramLocation.getLatitude());
      arrayOfObject[1] = Double.valueOf(paramLocation.getLongitude());
      arrayOfObject[2] = GeoRegion.Type.city;
      arrayOfObject[3] = GeoRegion.Type.state;
      localLinkedHashMap.put("nearby_regions", new FqlGetNearbyRegions(paramContext, paramIntent, paramString1, null, StringLocaleUtil.a("latitude='%f' and longitude='%f' and type in ('%s','%s')", arrayOfObject)));
    }
    return localLinkedHashMap;
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
    this.a = new ArrayList();
    Map localMap1 = ((FqlGetPlaces)c("places")).g();
    if (SelectAtTagFetcher.SearchType.EVENT != this.h)
    {
      FqlGetAtTags.FqlGetEventsCoveringTimeRange localFqlGetEventsCoveringTimeRange = (FqlGetAtTags.FqlGetEventsCoveringTimeRange)c("events");
      if (localFqlGetEventsCoveringTimeRange != null)
      {
        Iterator localIterator2 = localFqlGetEventsCoveringTimeRange.g().values().iterator();
        while (localIterator2.hasNext())
        {
          FacebookEvent localFacebookEvent = (FacebookEvent)localIterator2.next();
          this.a.add(new FacebookPlace(localFacebookEvent));
        }
      }
    }
    Map localMap2 = ((FqlGetDeals)c("deals")).g();
    Map localMap3 = ((FqlGetDealStatus)c("deal_status")).g();
    Map localMap4 = ((FqlGetDealHistory)c("deal_history")).g();
    if (this.f != null)
      this.b = ((FqlGetNearbyRegions)c("nearby_regions")).b;
    Iterator localIterator1 = localMap1.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      FacebookDeal localFacebookDeal = (FacebookDeal)localMap2.get(localEntry.getKey());
      if (localFacebookDeal != null)
      {
        FacebookDealStatus localFacebookDealStatus = (FacebookDealStatus)localMap3.get(Long.valueOf(localFacebookDeal.mDealId));
        localFacebookDeal.mDealHistory = ((FacebookDealHistory)localMap4.get(Long.valueOf(localFacebookDeal.mDealId)));
        localFacebookDeal.mDealStatus = localFacebookDealStatus;
      }
      ((FacebookPlace)localEntry.getValue()).a(localFacebookDeal);
      this.a.add(localEntry.getValue());
    }
  }

  public List<FacebookPlace> g()
  {
    if (this.a != null);
    for (List localList = Collections.unmodifiableList(this.a); ; localList = null)
      return localList;
  }

  public List<GeoRegion> h()
  {
    if (this.b != null);
    for (List localList = Collections.unmodifiableList(this.b); ; localList = null)
      return localList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetAtTags
 * JD-Core Version:    0.6.0
 */