package com.facebook.orca.users;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.facebook.contacts.data.DbInsertContactHandler;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.contacts.divebar.DivebarCache;
import com.facebook.orca.contacts.favorites.FavoriteContactsCache;
import com.facebook.orca.contacts.favorites.MobileAppDataCache;
import com.facebook.orca.contacts.favorites.TopLastActiveCache;
import com.facebook.orca.database.DbInsertFriendUsersHandler;
import com.facebook.orca.database.DbProperties;
import com.facebook.orca.database.DbUsersPropertyUtil;
import com.facebook.orca.database.UsersDatabaseSupplier;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.protocol.base.ApiException;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.FetchLastActiveMethod;
import com.facebook.orca.protocol.methods.FetchMessagingFavoritesMethod;
import com.facebook.orca.protocol.methods.FetchMobileAppDataMethod;
import com.facebook.orca.protocol.methods.GetFriendsMethod;
import com.facebook.orca.protocol.methods.UpdateMessagingFavoritesMethod;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.FetchLastActiveParams;
import com.facebook.orca.server.FetchLastActiveResult;
import com.facebook.orca.server.FetchMessagingFavoritesResult;
import com.facebook.orca.server.FetchMobileAppDataResult;
import com.facebook.orca.server.GetFriendsParams;
import com.facebook.orca.server.GetFriendsResult;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.UpdateFavoriteContactsParams;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

public class AddressBookServiceHandler
  implements OrcaServiceHandler
{
  private static final Class<?> a = AddressBookServiceHandler.class;
  private static int b = 15;
  private final Provider<SingleMethodRunner> c;
  private final GetFriendsMethod d;
  private final UpdateMessagingFavoritesMethod e;
  private final FetchMessagingFavoritesMethod f;
  private final FetchLastActiveMethod g;
  private final FetchMobileAppDataMethod h;
  private final DbInsertFriendUsersHandler i;
  private final DbInsertContactHandler j;
  private final FavoriteContactsCache k;
  private final DivebarCache l;
  private final TopLastActiveCache m;
  private final MobileAppDataCache n;
  private final UsersDatabaseSupplier o;
  private final DbUsersPropertyUtil p;
  private final OrcaActivityBroadcaster q;
  private final OrcaSharedPreferences r;
  private final Provider<Boolean> s;
  private final Provider<Boolean> t;
  private final Provider<Boolean> u;
  private final Clock v;

  public AddressBookServiceHandler(Provider<SingleMethodRunner> paramProvider, GetFriendsMethod paramGetFriendsMethod, UpdateMessagingFavoritesMethod paramUpdateMessagingFavoritesMethod, FetchMessagingFavoritesMethod paramFetchMessagingFavoritesMethod, FetchLastActiveMethod paramFetchLastActiveMethod, FetchMobileAppDataMethod paramFetchMobileAppDataMethod, DbInsertFriendUsersHandler paramDbInsertFriendUsersHandler, DbInsertContactHandler paramDbInsertContactHandler, FavoriteContactsCache paramFavoriteContactsCache, DivebarCache paramDivebarCache, TopLastActiveCache paramTopLastActiveCache, MobileAppDataCache paramMobileAppDataCache, UsersDatabaseSupplier paramUsersDatabaseSupplier, DbUsersPropertyUtil paramDbUsersPropertyUtil, OrcaSharedPreferences paramOrcaSharedPreferences, OrcaActivityBroadcaster paramOrcaActivityBroadcaster, Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2, Provider<Boolean> paramProvider3, Clock paramClock)
  {
    this.c = paramProvider;
    this.d = paramGetFriendsMethod;
    this.e = paramUpdateMessagingFavoritesMethod;
    this.f = paramFetchMessagingFavoritesMethod;
    this.g = paramFetchLastActiveMethod;
    this.h = paramFetchMobileAppDataMethod;
    this.i = paramDbInsertFriendUsersHandler;
    this.j = paramDbInsertContactHandler;
    this.r = paramOrcaSharedPreferences;
    this.k = paramFavoriteContactsCache;
    this.l = paramDivebarCache;
    this.m = paramTopLastActiveCache;
    this.n = paramMobileAppDataCache;
    this.o = paramUsersDatabaseSupplier;
    this.p = paramDbUsersPropertyUtil;
    this.q = paramOrcaActivityBroadcaster;
    this.s = paramProvider1;
    this.t = paramProvider2;
    this.u = paramProvider3;
    this.v = paramClock;
  }

  private void a(ImmutableList<User> paramImmutableList)
  {
    SQLiteDatabase localSQLiteDatabase = this.o.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      this.i.a(paramImmutableList);
      localSQLiteDatabase.setTransactionSuccessful();
      this.k.a();
      localSQLiteDatabase.endTransaction();
      this.j.a(paramImmutableList);
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }

  private boolean a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = this.o.b();
    localSQLiteDatabase.beginTransaction();
    while (true)
    {
      try
      {
        GetFriendsParams localGetFriendsParams = GetFriendsParams.a(paramLong);
        GetFriendsResult localGetFriendsResult = (GetFriendsResult)((SingleMethodRunner)this.c.b()).a(this.d, localGetFriendsParams);
        this.i.b();
        this.i.a(localGetFriendsResult);
        int i1 = localGetFriendsResult.a().size() + localGetFriendsResult.c().size();
        BLog.c(a, "Got " + i1 + " incremental sync results.");
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        if (i1 > 0)
        {
          i2 = 1;
          return i2;
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      int i2 = 0;
    }
  }

  private FetchMobileAppDataResult b()
  {
    ImmutableList localImmutableList1 = ImmutableList.d();
    FetchMobileAppDataResult localFetchMobileAppDataResult;
    if (!((Boolean)this.u.b()).booleanValue())
      localFetchMobileAppDataResult = new FetchMobileAppDataResult(DataFreshnessResult.NO_DATA, localImmutableList1, System.currentTimeMillis());
    while (true)
    {
      return localFetchMobileAppDataResult;
      long l1 = this.p.a(DbProperties.i, -1L);
      long l2 = System.currentTimeMillis();
      if ((l1 != -1L) && (l2 - l1 < 86400000L))
      {
        ImmutableList localImmutableList2 = this.n.a();
        DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
        if (localImmutableList2 != null);
        while (true)
        {
          localFetchMobileAppDataResult = new FetchMobileAppDataResult(localDataFreshnessResult, localImmutableList2, l1);
          break;
          localImmutableList2 = localImmutableList1;
        }
      }
      localFetchMobileAppDataResult = (FetchMobileAppDataResult)((SingleMethodRunner)this.c.b()).a(this.h, Integer.valueOf(50));
      this.n.a(localFetchMobileAppDataResult.a());
      SQLiteDatabase localSQLiteDatabase = this.o.b();
      localSQLiteDatabase.beginTransaction();
      try
      {
        this.i.c(localFetchMobileAppDataResult.a());
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        this.p.b(DbProperties.i, System.currentTimeMillis());
        BLog.b(a, "mobile app data loaded");
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
    }
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    UpdateFavoriteContactsParams localUpdateFavoriteContactsParams = (UpdateFavoriteContactsParams)paramOperationParams.b().getParcelable("favorites");
    ((SingleMethodRunner)this.c.b()).a(this.e, localUpdateFavoriteContactsParams);
    a(localUpdateFavoriteContactsParams.a());
    return OperationResult.b();
  }

  private void b(long paramLong)
  {
    this.p.b(DbProperties.c, paramLong);
  }

  private FetchLastActiveResult c()
  {
    ImmutableList localImmutableList1 = ImmutableList.d();
    FetchLastActiveResult localFetchLastActiveResult;
    if (!((Boolean)this.s.b()).booleanValue())
      localFetchLastActiveResult = new FetchLastActiveResult(DataFreshnessResult.NO_DATA, localImmutableList1, System.currentTimeMillis());
    while (true)
    {
      return localFetchLastActiveResult;
      long l1 = this.p.a(DbProperties.h, -1L);
      long l2 = System.currentTimeMillis();
      if ((l1 != -1L) && (l2 - l1 < 120000L))
      {
        ImmutableList localImmutableList2 = this.m.a();
        DataFreshnessResult localDataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
        if (localImmutableList2 != null);
        while (true)
        {
          localFetchLastActiveResult = new FetchLastActiveResult(localDataFreshnessResult, localImmutableList2, l1);
          break;
          localImmutableList2 = localImmutableList1;
        }
      }
      FetchLastActiveParams localFetchLastActiveParams;
      SQLiteDatabase localSQLiteDatabase;
      if (((Boolean)this.t.b()).booleanValue())
      {
        localFetchLastActiveParams = FetchLastActiveParams.a();
        localFetchLastActiveResult = (FetchLastActiveResult)((SingleMethodRunner)this.c.b()).a(this.g, localFetchLastActiveParams);
        this.m.a(localFetchLastActiveResult.a());
        localSQLiteDatabase = this.o.b();
        localSQLiteDatabase.beginTransaction();
      }
      try
      {
        this.i.b(localFetchLastActiveResult.a());
        localSQLiteDatabase.setTransactionSuccessful();
        this.k.a();
        this.l.e();
        localSQLiteDatabase.endTransaction();
        this.p.b(DbProperties.h, System.currentTimeMillis());
        BLog.b(a, "last active data loaded");
        continue;
        localFetchLastActiveParams = FetchLastActiveParams.a(b);
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
    }
  }

  private boolean d()
  {
    long l1 = this.p.a(DbProperties.d, -1L);
    long l2 = System.currentTimeMillis();
    boolean bool1;
    if ((l1 != -1L) && (l2 - l1 < 10800000L))
    {
      bool1 = false;
      return bool1;
    }
    if (l1 != -1L);
    while (true)
    {
      try
      {
        boolean bool2 = a(l1);
        bool1 = bool2;
        this.p.b(DbProperties.d, System.currentTimeMillis());
      }
      catch (ApiException localApiException)
      {
        if (localApiException.b().a() != 193)
          continue;
        bool1 = e();
        continue;
        throw localApiException;
      }
      bool1 = e();
    }
  }

  private boolean e()
  {
    int i1 = 0;
    String str = null;
    int i2 = 1;
    while (true)
    {
      int i3;
      GetFriendsResult localGetFriendsResult;
      SQLiteDatabase localSQLiteDatabase;
      if (i1 == 0)
      {
        i3 = 20;
        GetFriendsParams localGetFriendsParams = GetFriendsParams.a(i3, str);
        localGetFriendsResult = (GetFriendsResult)((SingleMethodRunner)this.c.b()).a(this.d, localGetFriendsParams);
        localSQLiteDatabase = this.o.b();
        localSQLiteDatabase.beginTransaction();
        if (i2 == 0);
      }
      int i4;
      while (true)
      {
        int i5;
        try
        {
          this.i.a();
          this.i.b();
          i2 = 0;
          this.i.a(localGetFriendsResult);
          str = localGetFriendsResult.d();
          BLog.c(a, "Got " + localGetFriendsResult.a().size() + " friends in batch");
          i4 = i1 + localGetFriendsResult.a().size();
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          this.q.a("com.facebook.orca.ACTION_FRIEND_SYNC_PROGRESS");
          if (str != null)
            break label237;
          BLog.c(a, "Got " + i4 + " friends.");
          if (i4 > 0)
          {
            return i5;
            i3 = 50;
          }
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
      }
      label237: i1 = i4;
    }
  }

  private void f()
  {
    long l1 = this.p.a(DbProperties.g, -1L);
    if ((l1 != -1L) && (System.currentTimeMillis() - l1 < 10800000L));
    while (true)
    {
      return;
      a(a().a());
      this.q.a("com.facebook.orca.FAVORITE_CONTACT_SYNC_PROGRESS");
    }
  }

  protected FetchMessagingFavoritesResult a()
  {
    return (FetchMessagingFavoritesResult)((SingleMethodRunner)this.c.b()).a(this.f, null);
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult;
    if ("sync_address_book".equals(str))
    {
      long l1 = this.v.a();
      f();
      d();
      c();
      b(l1);
      localOperationResult = OperationResult.b();
    }
    while (true)
    {
      return localOperationResult;
      if ("fetch_favorite_contacts".equals(str))
      {
        localOperationResult = OperationResult.a(a());
        continue;
      }
      if ("sync_top_last_active".equals(str))
      {
        localOperationResult = OperationResult.a(c());
        continue;
      }
      if ("update_favorite_contacts".equals(str))
      {
        localOperationResult = b(paramOperationParams);
        continue;
      }
      if (!"sync_mobile_app_data".equals(str))
        break;
      localOperationResult = OperationResult.a(b());
    }
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.AddressBookServiceHandler
 * JD-Core Version:    0.6.0
 */