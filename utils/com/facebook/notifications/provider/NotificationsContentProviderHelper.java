package com.facebook.notifications.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.notifications.model.FacebookNotification;
import com.facebook.notifications.model.FacebookNotificationBuilder;
import com.facebook.notifications.protocol.FetchNotificationsResult;
import com.facebook.notifications.server.FetchNotificationsParams;
import com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NotificationsContentProviderHelper
{
  private static final String a = NotificationsContentProviderHelper.class.getClass().getSimpleName();
  private final NotificationsContract b;
  private final ContentResolver c;
  private final NotificationsLastUpdatedTimeUtil d;

  public NotificationsContentProviderHelper(NotificationsContract paramNotificationsContract, @FromApplication ContentResolver paramContentResolver, NotificationsLastUpdatedTimeUtil paramNotificationsLastUpdatedTimeUtil)
  {
    this.b = ((NotificationsContract)Preconditions.checkNotNull(paramNotificationsContract));
    this.c = ((ContentResolver)Preconditions.checkNotNull(paramContentResolver));
    this.d = ((NotificationsLastUpdatedTimeUtil)Preconditions.checkNotNull(paramNotificationsLastUpdatedTimeUtil));
  }

  private void a(ImmutableList<Long> paramImmutableList)
  {
    if (paramImmutableList.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Joiner localJoiner = Joiner.on(",");
      localStringBuilder.append("notif_id").append(" IN (").append(localJoiner.join(paramImmutableList)).append(")");
      this.c.delete(this.b.c, localStringBuilder.toString(), null);
    }
  }

  private void b(FetchNotificationsParams paramFetchNotificationsParams, ImmutableList<FacebookNotification> paramImmutableList, ImmutableMap<Long, FacebookProfile> paramImmutableMap)
  {
    if (paramImmutableList.size() > 0)
    {
      ContentValues[] arrayOfContentValues = new ContentValues[paramImmutableList.size()];
      Iterator localIterator = paramImmutableList.iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        FacebookNotification localFacebookNotification = (FacebookNotification)localIterator.next();
        j = i + 1;
        ContentValues localContentValues = new ContentValues();
        arrayOfContentValues[i] = localContentValues;
        localContentValues.put("recipient_id", Long.valueOf(paramFetchNotificationsParams.c()));
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
        FacebookProfile localFacebookProfile = (FacebookProfile)paramImmutableMap.get(Long.valueOf(localFacebookNotification.senderId));
        if (localFacebookProfile != null)
        {
          localContentValues.put("sender_name", localFacebookProfile.mDisplayName);
          localContentValues.put("sender_url", localFacebookProfile.mImageUrl);
        }
      }
      this.c.bulkInsert(this.b.c, arrayOfContentValues);
    }
  }

  public FetchNotificationsResult a(FetchNotificationsParams paramFetchNotificationsParams)
  {
    ArrayList localArrayList = Lists.a();
    HashMap localHashMap = Maps.a();
    ContentResolver localContentResolver = this.c;
    Uri localUri = this.b.c;
    String[] arrayOfString = NotificationsContentProviderHelper.NotificationsQuery.a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "recipient_id";
    arrayOfObject[1] = Long.valueOf(paramFetchNotificationsParams.c());
    Cursor localCursor = localContentResolver.query(localUri, arrayOfString, StringUtil.a("%s=%d", arrayOfObject), null, null);
    if (localCursor != null);
    DataFreshnessResult localDataFreshnessResult;
    try
    {
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getColumnIndex("notif_id");
        int j = localCursor.getColumnIndex("updated");
        int k = localCursor.getColumnIndex("title");
        int m = localCursor.getColumnIndex("href");
        int n = localCursor.getColumnIndex("is_unread");
        int i1 = localCursor.getColumnIndex("object_id");
        int i2 = localCursor.getColumnIndex("object_type");
        int i3 = localCursor.getColumnIndex("object_photo_url");
        int i4 = localCursor.getColumnIndex("icon_url");
        int i5 = localCursor.getColumnIndex("join_data_string");
        int i6 = localCursor.getColumnIndex("sender_id");
        int i7 = localCursor.getColumnIndex("sender_name");
        int i8 = localCursor.getColumnIndex("sender_url");
        boolean bool2;
        do
        {
          FacebookNotificationBuilder localFacebookNotificationBuilder = new FacebookNotificationBuilder().a(localCursor.getLong(i)).b(localCursor.getLong(i6)).c(localCursor.getLong(j)).a(localCursor.getString(k)).b(localCursor.getString(m));
          if (localCursor.getInt(n) != 1)
            break;
          bool1 = true;
          localArrayList.add(localFacebookNotificationBuilder.a(bool1).c(localCursor.getString(i1)).d(localCursor.getString(i2)).e(localCursor.getString(i3)).f(localCursor.getString(i4)).g(localCursor.getString(i5)).k());
          long l = localCursor.getLong(i6);
          String str1 = localCursor.getString(i7);
          String str2 = localCursor.getString(i8);
          localHashMap.put(Long.valueOf(l), new FacebookProfile(l, str1, str2, 0));
          bool2 = localCursor.moveToNext();
        }
        while (bool2);
      }
      if (localCursor != null)
        localCursor.close();
      return new FetchNotificationsResult(localDataFreshnessResult, ImmutableList.a(localArrayList), ImmutableMap.a(localHashMap), this.d.a());
      boolean bool1 = false;
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }

  public void a(FetchNotificationsParams paramFetchNotificationsParams, ImmutableList<FacebookNotification> paramImmutableList, ImmutableMap<Long, FacebookProfile> paramImmutableMap)
  {
    HashMap localHashMap = Maps.a();
    Iterator localIterator1 = paramImmutableList.iterator();
    while (localIterator1.hasNext())
    {
      FacebookNotification localFacebookNotification3 = (FacebookNotification)localIterator1.next();
      localHashMap.put(Long.valueOf(localFacebookNotification3.notificationId), localFacebookNotification3);
    }
    ImmutableList.Builder localBuilder1 = ImmutableList.e();
    ImmutableList.Builder localBuilder2 = ImmutableList.e();
    Iterator localIterator2 = a(paramFetchNotificationsParams).a.iterator();
    while (localIterator2.hasNext())
    {
      FacebookNotification localFacebookNotification1 = (FacebookNotification)localIterator2.next();
      long l = localFacebookNotification1.notificationId;
      FacebookNotification localFacebookNotification2 = (FacebookNotification)localHashMap.get(Long.valueOf(l));
      if (localFacebookNotification2 == null)
        localBuilder1.b(Long.valueOf(l));
      else if (localFacebookNotification2.equals(localFacebookNotification1))
        localHashMap.remove(Long.valueOf(l));
      else
        localBuilder1.b(Long.valueOf(l));
    }
    Iterator localIterator3 = localHashMap.values().iterator();
    while (localIterator3.hasNext())
      localBuilder2.b((FacebookNotification)localIterator3.next());
    a(localBuilder1.b());
    b(paramFetchNotificationsParams, localBuilder2.b(), paramImmutableMap);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.provider.NotificationsContentProviderHelper
 * JD-Core Version:    0.6.2
 */