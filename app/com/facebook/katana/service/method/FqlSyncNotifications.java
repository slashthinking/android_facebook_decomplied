package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.katana.util.StringUtils;
import com.facebook.notifications.model.FacebookNotification;
import com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil;
import com.facebook.orca.inject.FbInjector;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class FqlSyncNotifications extends FqlMultiQuery
{
  private String a;
  private final List<FacebookNotification> b = new ArrayList();
  private final NotificationsContract f;
  private final List<Long> g = new ArrayList();
  private Map<Long, FacebookProfile> h;
  private List<FacebookNotification> i;

  public FqlSyncNotifications(Context paramContext, Intent paramIntent, String paramString, long paramLong, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramString, a(paramContext, paramIntent, paramString, paramLong), paramServiceOperationListener);
    this.f = ((NotificationsContract)FbInjector.a(paramContext).a(NotificationsContract.class));
    this.a = paramString;
  }

  private String a(FacebookNotification paramFacebookNotification)
  {
    JSONObject localJSONObject = paramFacebookNotification.a();
    if (localJSONObject == null);
    for (String str = null; ; str = localJSONObject.optString("target_ent_id"))
      return str;
  }

  public static LinkedHashMap<String, FqlQuery> a(Context paramContext, Intent paramIntent, String paramString, long paramLong)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("notifications", new FqlGetNotifications(paramContext, paramIntent, paramString, paramLong, (ServiceOperationListener)null));
    localLinkedHashMap.put("profiles", new FqlGetProfile(paramContext, paramIntent, paramString, null, "id IN (select sender_id FROM #notifications)"));
    return localLinkedHashMap;
  }

  private static boolean a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.equals(paramString1)));
    for (int j = 1; ; j = 0)
      return j;
  }

  private boolean g()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.i.iterator();
    while (localIterator1.hasNext())
    {
      FacebookNotification localFacebookNotification3 = (FacebookNotification)localIterator1.next();
      localHashMap.put(Long.valueOf(localFacebookNotification3.notificationId), localFacebookNotification3);
    }
    Cursor localCursor = this.o.getContentResolver().query(this.f.c, FqlSyncNotifications.NotificationsQuery.a, null, null, null);
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    if (localCursor.moveToFirst())
    {
      k = localCursor.getColumnIndex("notif_id");
      m = localCursor.getColumnIndex("object_type");
      n = localCursor.getColumnIndex("object_id");
      i1 = localCursor.getColumnIndex("object_photo_url");
      i2 = localCursor.getColumnIndex("title");
      i3 = localCursor.getColumnIndex("updated");
      i4 = localCursor.getColumnIndex("join_data_string");
      i5 = localCursor.getColumnIndex("is_unread");
    }
    label516: label522: label532: 
    while (true)
    {
      Long localLong1 = Long.valueOf(localCursor.getLong(k));
      String str1 = localCursor.getString(m);
      String str2 = localCursor.getString(n);
      localCursor.getString(i1);
      String str3 = localCursor.getString(i2);
      Long localLong2 = Long.valueOf(localCursor.getLong(i3));
      String str4 = localCursor.getString(i4);
      int i6;
      FacebookNotification localFacebookNotification2;
      if (localCursor.getInt(i5) == 1)
      {
        i6 = 1;
        localFacebookNotification2 = (FacebookNotification)localHashMap.get(localLong1);
        if (localFacebookNotification2 != null)
          break label362;
        this.g.add(localLong1);
      }
      while (true)
      {
        if (localCursor.moveToNext())
          break label532;
        localCursor.close();
        Iterator localIterator2 = localHashMap.values().iterator();
        while (localIterator2.hasNext())
        {
          FacebookNotification localFacebookNotification1 = (FacebookNotification)localIterator2.next();
          this.b.add(localFacebookNotification1);
        }
        i6 = 0;
        break;
        label362: int i7;
        label404: boolean bool1;
        boolean bool2;
        boolean bool3;
        boolean bool4;
        if (((localLong2 == null) && (localFacebookNotification2.updatedTime > 0L)) || ((localFacebookNotification2.updatedTime > 0L) && (localFacebookNotification2.updatedTime > localLong2.longValue())))
        {
          i7 = 1;
          bool1 = a(str1, localFacebookNotification2.objectType);
          bool2 = a(str2, localFacebookNotification2.objectId);
          bool3 = a(str3, localFacebookNotification2.title);
          bool4 = a(str4, localFacebookNotification2.joinDataString);
          if (i6 == localFacebookNotification2.isUnread)
            break label516;
        }
        for (int i8 = 1; ; i8 = 0)
        {
          if ((!bool1) && (!bool2) && (!bool3) && (i7 == 0) && (!bool4) && (i8 == 0))
            break label522;
          this.g.add(localLong1);
          break;
          i7 = 0;
          break label404;
        }
        localHashMap.remove(localLong1);
      }
    }
    if ((this.b.size() > 0) || (this.g.size() > 0));
    for (int j = 1; ; j = 0)
      return j;
  }

  private void h()
  {
    ContentResolver localContentResolver = this.o.getContentResolver();
    if (this.g.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("notif_id").append(" IN(");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.g;
      StringUtils.a(localStringBuilder, ",", null, arrayOfObject);
      localStringBuilder.append(')');
      localContentResolver.delete(this.f.c, localStringBuilder.toString(), null);
    }
    if (this.b.size() > 0)
    {
      ContentValues[] arrayOfContentValues = new ContentValues[this.b.size()];
      HashSet localHashSet = Sets.a();
      Iterator localIterator = this.b.iterator();
      int k;
      for (int j = 0; localIterator.hasNext(); j = k)
      {
        FacebookNotification localFacebookNotification = (FacebookNotification)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        arrayOfContentValues[j] = localContentValues;
        k = j + 1;
        localContentValues.put("title", localFacebookNotification.title);
        localContentValues.put("updated", Long.valueOf(localFacebookNotification.updatedTime));
        localContentValues.put("href", localFacebookNotification.href);
        localContentValues.put("is_unread", Boolean.valueOf(localFacebookNotification.isUnread));
        localContentValues.put("notif_id", Long.valueOf(localFacebookNotification.notificationId));
        localContentValues.put("sender_id", Long.valueOf(localFacebookNotification.senderId));
        localContentValues.put("object_id", localFacebookNotification.objectId);
        localContentValues.put("object_type", localFacebookNotification.objectType);
        localContentValues.put("join_data_string", localFacebookNotification.joinDataString);
        localContentValues.put("icon_url", localFacebookNotification.iconUrl);
        FacebookProfile localFacebookProfile = (FacebookProfile)this.h.get(Long.valueOf(localFacebookNotification.senderId));
        if (localFacebookProfile != null)
        {
          localContentValues.put("sender_name", localFacebookProfile.mDisplayName);
          localContentValues.put("sender_url", localFacebookProfile.mImageUrl);
        }
        if (!localFacebookNotification.objectType.equals("photo"))
          continue;
        String str = a(localFacebookNotification);
        if (str == null)
          continue;
        localHashSet.add(str);
      }
      localContentResolver.bulkInsert(this.f.c, arrayOfContentValues);
      if (localHashSet.size() > 0)
        new FqlGetPhotos(this.o, this.p, this.a, localHashSet).b();
    }
  }

  protected void a(JsonParser paramJsonParser)
  {
    super.a(paramJsonParser);
    FqlGetNotifications localFqlGetNotifications = (FqlGetNotifications)c("notifications");
    FqlGetProfile localFqlGetProfile = (FqlGetProfile)c("profiles");
    this.i = localFqlGetNotifications.g();
    this.h = localFqlGetProfile.g();
    ((NotificationsLastUpdatedTimeUtil)FbInjector.a(this.o).a(NotificationsLastUpdatedTimeUtil.class)).a(System.currentTimeMillis());
    if (g())
      h();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlSyncNotifications
 * JD-Core Version:    0.6.0
 */