package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.ipc.connections.ConnectionsContract;
import com.facebook.ipc.connections.ConnectionsContract.ConnectionType;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookFriendInfo;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.platform.FacebookAuthenticationService;
import com.facebook.katana.platform.PlatformStorage;
import com.facebook.katana.util.PlatformUtils;
import com.facebook.katana.util.Utils;
import com.facebook.orca.inject.FbInjector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ConnectionsSync extends ServiceOperation
  implements ServiceOperationListener
{
  private final String a;
  private final long b;
  private final String c;
  private final Map<Long, String> d;
  private final List<FacebookFriendInfo> e;
  private final List<FacebookFriendInfo> f;
  private final List<Long> g;
  private final String h;
  private ConnectionsSync.FqlGetFriendsAndPages i;
  private boolean j;

  public ConnectionsSync(Context paramContext, Intent paramIntent, String paramString1, long paramLong, String paramString2, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, paramServiceOperationListener);
    this.a = paramString1;
    this.b = paramLong;
    this.c = paramString2;
    this.d = new HashMap();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = paramIntent.getStringExtra("un");
  }

  private void a(List<FacebookFriendInfo> paramList)
  {
    ContentResolver localContentResolver = this.o.getContentResolver();
    boolean bool1 = PlatformUtils.a(this.o);
    boolean bool2 = FacebookAuthenticationService.d(this.o, this.c);
    boolean bool3 = FacebookAuthenticationService.c(this.o, this.c);
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("platform_storage");
    localHoneyClientEvent.a("storage_supported", bool1);
    localHoneyClientEvent.a("is_sync_enabled", bool2);
    localHoneyClientEvent.a("does_show_ungrouped_contacts", bool3);
    ((AnalyticsLogger)FbInjector.a(this.o).a(AnalyticsLogger.class)).a(localHoneyClientEvent);
    if ((bool1) && (FacebookAuthenticationService.d(this.o, this.c)))
      PlatformStorage.a(this.o, this.h, paramList, this.d);
    if (this.j);
    while (true)
    {
      return;
      if ((b(paramList)) && (!this.j))
      {
        if (this.e.size() > 0)
        {
          ContentValues[] arrayOfContentValues = new ContentValues[this.e.size()];
          Iterator localIterator3 = this.e.iterator();
          int m = 0;
          while (localIterator3.hasNext())
          {
            FacebookFriendInfo localFacebookFriendInfo2 = (FacebookFriendInfo)localIterator3.next();
            long l2 = localFacebookFriendInfo2.mUserId;
            ContentValues localContentValues2 = new ContentValues();
            arrayOfContentValues[m] = localContentValues2;
            m++;
            localContentValues2.put("user_id", Long.valueOf(l2));
            localContentValues2.put("cell", localFacebookFriendInfo2.mCellPhone);
            localContentValues2.put("other", localFacebookFriendInfo2.mOtherPhone);
            localContentValues2.put("email", localFacebookFriendInfo2.mContactEmail);
            localContentValues2.put("first_name", localFacebookFriendInfo2.mFirstName);
            localContentValues2.put("last_name", localFacebookFriendInfo2.mLastName);
            localContentValues2.put("display_name", localFacebookFriendInfo2.mDisplayName);
            localContentValues2.put("user_image_url", localFacebookFriendInfo2.mImageUrl);
            localContentValues2.put("birthday_month", Integer.valueOf(localFacebookFriendInfo2.mBirthdayMonth));
            localContentValues2.put("birthday_day", Integer.valueOf(localFacebookFriendInfo2.mBirthdayDay));
            localContentValues2.put("birthday_year", Integer.valueOf(localFacebookFriendInfo2.mBirthdayYear));
            localContentValues2.put("hash", Long.valueOf(localFacebookFriendInfo2.c()));
            localContentValues2.put("search_token", localFacebookFriendInfo2.mSearchToken);
            if (localFacebookFriendInfo2.mImageUrl == null)
              continue;
            this.d.put(Long.valueOf(l2), localFacebookFriendInfo2.mImageUrl);
          }
          localContentResolver.bulkInsert(ConnectionsContract.d, arrayOfContentValues);
        }
        if (this.f.size() > 0)
        {
          ContentValues localContentValues1 = new ContentValues();
          Iterator localIterator1 = this.f.iterator();
          while (localIterator1.hasNext())
          {
            FacebookFriendInfo localFacebookFriendInfo1 = (FacebookFriendInfo)localIterator1.next();
            if (localFacebookFriendInfo1.mDisplayName == null)
              continue;
            long l1 = localFacebookFriendInfo1.mUserId;
            localContentValues1.clear();
            localContentValues1.put("first_name", localFacebookFriendInfo1.mFirstName);
            localContentValues1.put("last_name", localFacebookFriendInfo1.mLastName);
            localContentValues1.put("display_name", localFacebookFriendInfo1.mDisplayName);
            localContentValues1.put("user_image_url", localFacebookFriendInfo1.mImageUrl);
            localContentValues1.put("birthday_month", Integer.valueOf(localFacebookFriendInfo1.mBirthdayMonth));
            localContentValues1.put("birthday_day", Integer.valueOf(localFacebookFriendInfo1.mBirthdayDay));
            localContentValues1.put("birthday_year", Integer.valueOf(localFacebookFriendInfo1.mBirthdayYear));
            localContentValues1.put("hash", Long.valueOf(localFacebookFriendInfo1.c()));
            localContentValues1.put("cell", localFacebookFriendInfo1.mCellPhone);
            localContentValues1.put("other", localFacebookFriendInfo1.mOtherPhone);
            localContentValues1.put("email", localFacebookFriendInfo1.mContactEmail);
            localContentValues1.put("search_token", localFacebookFriendInfo1.mSearchToken);
            localContentResolver.update(Uri.withAppendedPath(ConnectionsContract.e, "" + l1), localContentValues1, null, null);
            if (localFacebookFriendInfo1.mImageUrl == null)
              continue;
            this.d.put(Long.valueOf(localFacebookFriendInfo1.mUserId), localFacebookFriendInfo1.mImageUrl);
          }
        }
        if (this.g.size() <= 0)
          continue;
        StringBuffer localStringBuffer = new StringBuffer(128);
        localStringBuffer.append("user_id").append(" IN(");
        Iterator localIterator2 = this.g.iterator();
        int k = 1;
        if (localIterator2.hasNext())
        {
          Long localLong = (Long)localIterator2.next();
          if (k != 0)
            k = 0;
          while (true)
          {
            localStringBuffer.append(localLong);
            break;
            localStringBuffer.append(",");
          }
        }
        localStringBuffer.append(")");
        localContentResolver.delete(ConnectionsContract.b, localStringBuffer.toString(), null);
        continue;
      }
    }
  }

  private void a(Map<Long, ConnectionsSync.FacebookPageProfile> paramMap1, Map<Long, ConnectionsSync.FacebookPageProfile> paramMap2)
  {
    ContentResolver localContentResolver = this.o.getContentResolver();
    HashMap localHashMap = new HashMap(paramMap2);
    Iterator localIterator1 = paramMap1.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    if (this.j);
    while (true)
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      if ((!a(localHashMap, localArrayList1, localArrayList2, localArrayList3)) || (this.j))
        continue;
      if (localArrayList1.size() > 0)
      {
        ContentValues[] arrayOfContentValues = new ContentValues[localArrayList1.size()];
        Iterator localIterator4 = localArrayList1.iterator();
        int m = 0;
        while (localIterator4.hasNext())
        {
          ConnectionsSync.FacebookPageProfile localFacebookPageProfile2 = (ConnectionsSync.FacebookPageProfile)localIterator4.next();
          long l2 = localFacebookPageProfile2.mId;
          ContentValues localContentValues2 = new ContentValues();
          arrayOfContentValues[m] = localContentValues2;
          m++;
          localContentValues2.put("user_id", Long.valueOf(l2));
          localContentValues2.put("display_name", localFacebookPageProfile2.mDisplayName);
          localContentValues2.put("user_image_url", localFacebookPageProfile2.mImageUrl);
          localContentValues2.put("connection_type", Integer.valueOf(localFacebookPageProfile2.a().ordinal()));
          localContentValues2.put("hash", Long.valueOf(localFacebookPageProfile2.b()));
          if (localFacebookPageProfile2.mImageUrl == null)
            continue;
          this.d.put(Long.valueOf(l2), localFacebookPageProfile2.mImageUrl);
        }
        localContentResolver.bulkInsert(ConnectionsContract.i, arrayOfContentValues);
      }
      if (localArrayList2.size() > 0)
      {
        ContentValues localContentValues1 = new ContentValues();
        Iterator localIterator2 = localArrayList2.iterator();
        while (localIterator2.hasNext())
        {
          ConnectionsSync.FacebookPageProfile localFacebookPageProfile1 = (ConnectionsSync.FacebookPageProfile)localIterator2.next();
          if (localFacebookPageProfile1.mDisplayName == null)
            continue;
          long l1 = localFacebookPageProfile1.mId;
          localContentValues1.clear();
          localContentValues1.put("display_name", localFacebookPageProfile1.mDisplayName);
          localContentValues1.put("user_image_url", localFacebookPageProfile1.mImageUrl);
          localContentValues1.put("connection_type", Integer.valueOf(localFacebookPageProfile1.a().ordinal()));
          localContentValues1.put("hash", Long.valueOf(localFacebookPageProfile1.b()));
          localContentResolver.update(Uri.withAppendedPath(ConnectionsContract.j, String.valueOf(l1)), localContentValues1, null, null);
          if (localFacebookPageProfile1.mImageUrl == null)
            continue;
          this.d.put(Long.valueOf(localFacebookPageProfile1.mId), localFacebookPageProfile1.mImageUrl);
        }
      }
      if (localArrayList3.size() <= 0)
        continue;
      StringBuffer localStringBuffer = new StringBuffer(128);
      localStringBuffer.append("user_id").append(" IN(");
      Iterator localIterator3 = localArrayList3.iterator();
      int k = 1;
      if (localIterator3.hasNext())
      {
        Long localLong = (Long)localIterator3.next();
        if (k != 0)
          k = 0;
        while (true)
        {
          localStringBuffer.append(localLong);
          break;
          localStringBuffer.append(",");
        }
      }
      localStringBuffer.append(")");
      localContentResolver.delete(ConnectionsContract.b, localStringBuffer.toString(), null);
    }
  }

  private boolean a(Map<Long, ConnectionsSync.FacebookPageProfile> paramMap, List<ConnectionsSync.FacebookPageProfile> paramList1, List<ConnectionsSync.FacebookPageProfile> paramList2, List<Long> paramList)
  {
    Cursor localCursor = this.o.getContentResolver().query(ConnectionsContract.i, ConnectionsSync.HashQuery.a, null, null, null);
    int k = localCursor.getColumnIndex("user_id");
    int m = localCursor.getColumnIndex("hash");
    while (localCursor.moveToNext())
    {
      long l = localCursor.getLong(k);
      ConnectionsSync.FacebookPageProfile localFacebookPageProfile2 = (ConnectionsSync.FacebookPageProfile)paramMap.get(Long.valueOf(l));
      if (localFacebookPageProfile2 == null)
      {
        paramList.add(Long.valueOf(l));
        continue;
      }
      if (localFacebookPageProfile2.b() != localCursor.getLong(m))
      {
        paramList2.add(localFacebookPageProfile2);
        paramMap.remove(Long.valueOf(l));
        continue;
      }
      paramMap.remove(Long.valueOf(l));
    }
    localCursor.close();
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      ConnectionsSync.FacebookPageProfile localFacebookPageProfile1 = (ConnectionsSync.FacebookPageProfile)localIterator.next();
      if (localFacebookPageProfile1.mDisplayName == null)
        continue;
      paramList1.add(localFacebookPageProfile1);
    }
    if ((paramList1.size() > 0) || (paramList2.size() > 0) || (paramList.size() > 0));
    for (int n = 1; ; n = 0)
      return n;
  }

  private boolean b(List<FacebookFriendInfo> paramList)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      FacebookFriendInfo localFacebookFriendInfo3 = (FacebookFriendInfo)localIterator1.next();
      localHashMap.put(Long.valueOf(localFacebookFriendInfo3.mUserId), localFacebookFriendInfo3);
    }
    Cursor localCursor = this.o.getContentResolver().query(ConnectionsContract.d, ConnectionsSync.HashQuery.a, null, null, null);
    int k = localCursor.getColumnIndex("user_id");
    int m = localCursor.getColumnIndex("hash");
    while (localCursor.moveToNext())
    {
      Long localLong = Long.valueOf(localCursor.getLong(k));
      FacebookFriendInfo localFacebookFriendInfo2 = (FacebookFriendInfo)localHashMap.get(localLong);
      if (localFacebookFriendInfo2 == null)
      {
        this.g.add(localLong);
        localHashMap.remove(localLong);
        continue;
      }
      if (localFacebookFriendInfo2.c() != localCursor.getLong(m))
      {
        this.f.add(localFacebookFriendInfo2);
        localHashMap.remove(localLong);
        continue;
      }
      localHashMap.remove(localLong);
    }
    localCursor.close();
    Iterator localIterator2 = localHashMap.values().iterator();
    while (localIterator2.hasNext())
    {
      FacebookFriendInfo localFacebookFriendInfo1 = (FacebookFriendInfo)localIterator2.next();
      if (localFacebookFriendInfo1.mDisplayName == null)
        continue;
      this.e.add(localFacebookFriendInfo1);
    }
    if ((this.e.size() > 0) || (this.f.size() > 0) || (this.g.size() > 0));
    for (int n = 1; ; n = 0)
      return n;
  }

  private void c()
  {
    ContentResolver localContentResolver = this.o.getContentResolver();
    long l = AppSession.a(this.o, false).b().userId;
    FacebookUser localFacebookUser = AppSession.a(this.o, false).b().a();
    Cursor localCursor = localContentResolver.query(ConnectionsContract.b, ConnectionsSync.HashQuery.a, "user_id IN(" + l + ")", null, null);
    if (localCursor.moveToNext())
    {
      int k = localCursor.getColumnIndex("hash");
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Long.valueOf(localFacebookUser.mUserId);
      arrayOfObject2[1] = localFacebookUser.mDisplayName;
      arrayOfObject2[2] = localFacebookUser.mImageUrl;
      if (Utils.b(arrayOfObject2) != localCursor.getLong(k))
      {
        ContentValues localContentValues2 = new ContentValues();
        localContentValues2.put("user_id", Long.valueOf(localFacebookUser.mUserId));
        localContentValues2.put("display_name", localFacebookUser.mDisplayName);
        localContentValues2.put("user_image_url", localFacebookUser.mImageUrl);
        Object[] arrayOfObject3 = new Object[3];
        arrayOfObject3[0] = Long.valueOf(localFacebookUser.mUserId);
        arrayOfObject3[1] = localFacebookUser.mDisplayName;
        arrayOfObject3[2] = localFacebookUser.mImageUrl;
        localContentValues2.put("hash", Integer.valueOf(Utils.b(arrayOfObject3)));
        Uri localUri = Uri.withAppendedPath(ConnectionsContract.c, String.valueOf(localFacebookUser.mUserId));
        this.d.put(Long.valueOf(localFacebookUser.mUserId), localFacebookUser.mImageUrl);
        localContentResolver.update(localUri, localContentValues2, null, null);
      }
    }
    while (true)
    {
      localCursor.close();
      return;
      ContentValues localContentValues1 = new ContentValues();
      localContentValues1.put("user_id", Long.valueOf(localFacebookUser.mUserId));
      localContentValues1.put("display_name", localFacebookUser.mDisplayName);
      localContentValues1.put("user_image_url", localFacebookUser.mImageUrl);
      localContentValues1.put("connection_type", Integer.valueOf(ConnectionsContract.ConnectionType.SELF.ordinal()));
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = Long.valueOf(localFacebookUser.mUserId);
      arrayOfObject1[1] = localFacebookUser.mDisplayName;
      arrayOfObject1[2] = localFacebookUser.mImageUrl;
      localContentValues1.put("hash", Integer.valueOf(Utils.b(arrayOfObject1)));
      this.d.put(Long.valueOf(localFacebookUser.mUserId), localFacebookUser.mImageUrl);
      localContentResolver.insert(ConnectionsContract.b, localContentValues1);
    }
  }

  public Map<Long, String> a()
  {
    return this.d;
  }

  public void a(ServiceOperation paramServiceOperation, long paramLong1, long paramLong2)
  {
  }

  public void a(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.i.a(false);
      if (this.i.l != null)
        this.i.l.a();
      this.i = null;
    }
    this.j = true;
  }

  public void a_(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    if (this.j)
      this.q.a_(this, 400, "Canceled", paramException);
    while (true)
    {
      return;
      this.q.a_(this, paramInt, paramString, paramException);
    }
  }

  public void b()
  {
    this.i = new ConnectionsSync.FqlGetFriendsAndPages(this.o, this.p, this.a, this, this.b);
    this.i.b();
  }

  public void b(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    if (this.j);
    while (true)
    {
      return;
      if (paramInt == 200)
      {
        ConnectionsSync.FqlGetFriendsAndPages localFqlGetFriendsAndPages = (ConnectionsSync.FqlGetFriendsAndPages)paramServiceOperation;
        a(localFqlGetFriendsAndPages.g());
        a(localFqlGetFriendsAndPages.h(), localFqlGetFriendsAndPages.i());
        c();
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ConnectionsSync
 * JD-Core Version:    0.6.0
 */