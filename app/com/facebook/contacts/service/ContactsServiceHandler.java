package com.facebook.contacts.service;

import android.os.Bundle;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.data.ContactsDatabaseSupplier;
import com.facebook.contacts.data.DbContactsProperties;
import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.contacts.data.DbFetchContactHandler;
import com.facebook.contacts.data.DbInsertContactHandler;
import com.facebook.contacts.data.DbInsertContactHandler.InsertionType;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.ContactSummaryBuilder;
import com.facebook.contacts.protocol.BlockContactMethod;
import com.facebook.contacts.protocol.BulkContactsDeleteMethod;
import com.facebook.contacts.protocol.CreateContactClaimMethod;
import com.facebook.contacts.protocol.DeleteContactClaimMethod;
import com.facebook.contacts.protocol.FetchAllContactsMethod;
import com.facebook.contacts.protocol.FetchContactMethod;
import com.facebook.contacts.protocol.FetchDeltaContactsMethod;
import com.facebook.contacts.server.BlockContactParams;
import com.facebook.contacts.server.CreateContactClaimParams;
import com.facebook.contacts.server.DeleteContactClaimParams;
import com.facebook.contacts.server.FetchAllContactsParams;
import com.facebook.contacts.server.FetchAllContactsResult;
import com.facebook.contacts.server.FetchContactParams;
import com.facebook.contacts.server.FetchContactResult;
import com.facebook.contacts.server.FetchDeltaContactsParams;
import com.facebook.contacts.server.FetchDeltaContactsResult;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.AddressBookPeriodicRunner;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.protocol.base.ApiErrorResult;
import com.facebook.orca.protocol.base.ApiErrorResult.ErrorDomain;
import com.facebook.orca.protocol.base.ApiException;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.server.ErrorCode;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

public class ContactsServiceHandler
  implements OrcaServiceHandler
{
  private static final Class<?> a = ContactsServiceHandler.class;
  private final Provider<SingleMethodRunner> b;
  private final FetchAllContactsMethod c;
  private final FetchDeltaContactsMethod d;
  private final FetchContactMethod e;
  private final BulkContactsDeleteMethod f;
  private final BlockContactMethod g;
  private final CreateContactClaimMethod h;
  private final DeleteContactClaimMethod i;
  private final AddressBookContactFetcher j;
  private final AddressBookPeriodicRunner k;
  private final DataCache l;
  private final ContactsCache m;
  private final DbFetchContactHandler n;
  private final DbInsertContactHandler o;
  private final ContactsDatabaseSupplier p;
  private final OrcaActivityBroadcaster q;
  private final DbContactsPropertyUtil r;
  private final Clock s;

  public ContactsServiceHandler(Provider<SingleMethodRunner> paramProvider, FetchAllContactsMethod paramFetchAllContactsMethod, FetchDeltaContactsMethod paramFetchDeltaContactsMethod, FetchContactMethod paramFetchContactMethod, BulkContactsDeleteMethod paramBulkContactsDeleteMethod, BlockContactMethod paramBlockContactMethod, CreateContactClaimMethod paramCreateContactClaimMethod, DeleteContactClaimMethod paramDeleteContactClaimMethod, AddressBookPeriodicRunner paramAddressBookPeriodicRunner, AddressBookContactFetcher paramAddressBookContactFetcher, DataCache paramDataCache, ContactsCache paramContactsCache, DbFetchContactHandler paramDbFetchContactHandler, DbInsertContactHandler paramDbInsertContactHandler, ContactsDatabaseSupplier paramContactsDatabaseSupplier, OrcaActivityBroadcaster paramOrcaActivityBroadcaster, DbContactsPropertyUtil paramDbContactsPropertyUtil, Clock paramClock)
  {
    this.b = paramProvider;
    this.c = paramFetchAllContactsMethod;
    this.d = paramFetchDeltaContactsMethod;
    this.e = paramFetchContactMethod;
    this.f = paramBulkContactsDeleteMethod;
    this.g = paramBlockContactMethod;
    this.h = paramCreateContactClaimMethod;
    this.i = paramDeleteContactClaimMethod;
    this.k = paramAddressBookPeriodicRunner;
    this.j = paramAddressBookContactFetcher;
    this.l = paramDataCache;
    this.m = paramContactsCache;
    this.n = paramDbFetchContactHandler;
    this.o = paramDbInsertContactHandler;
    this.p = paramContactsDatabaseSupplier;
    this.q = paramOrcaActivityBroadcaster;
    this.r = paramDbContactsPropertyUtil;
    this.s = paramClock;
  }

  private OperationResult a(UserKey paramUserKey)
  {
    FetchContactResult localFetchContactResult = this.j.a(paramUserKey);
    if (localFetchContactResult == FetchContactResult.a);
    for (OperationResult localOperationResult = OperationResult.a(ErrorCode.OTHER, "Contact not found in android db."); ; localOperationResult = OperationResult.a(localFetchContactResult))
      return localOperationResult;
  }

  private OperationResult a(boolean paramBoolean)
  {
    String str1 = a();
    long l1 = this.s.a();
    Object localObject;
    if (str1 == null)
    {
      localObject = b(paramBoolean);
      if (localObject == null)
        break label158;
    }
    label158: for (boolean bool = true; ; bool = false)
      while (true)
      {
        Preconditions.checkState(bool);
        this.r.b(DbContactsProperties.a, l1);
        this.r.a(DbContactsProperties.b, (String)localObject);
        return OperationResult.b();
        try
        {
          String str2 = a(str1);
          localObject = str2;
        }
        catch (ApiException localApiException)
        {
          ApiErrorResult localApiErrorResult = localApiException.b();
          if ((localApiErrorResult.d() == ApiErrorResult.ErrorDomain.GRAPHQL_KERROR_DOMAIN) && (localApiErrorResult.a() == 1702001))
          {
            BLog.d(a, "Delta sync cursor " + str1 + " no longer valid, falling " + "back to full sync.");
            localObject = b(paramBoolean);
            break;
          }
          throw localApiException;
        }
      }
  }

  private String a()
  {
    String str = null;
    long l1 = this.r.a(DbContactsProperties.a, -1L);
    if (l1 == -1L)
      BLog.b(a, "No last sync timestamp; forcing full sync.");
    while (true)
    {
      return str;
      long l2 = this.s.a() - l1;
      if (l2 > 1209600000L)
      {
        BLog.b(a, "Last sync was " + l2 / 86400000L + " days ago; forcing full sync.");
        str = null;
        continue;
      }
      str = this.r.a(DbContactsProperties.b);
      if (str != null)
      {
        BLog.b(a, "Doing delta sync, cursor: " + str);
        continue;
      }
      BLog.b(a, "No delta sync cursor; forcing full sync.");
    }
  }

  private String a(String paramString)
  {
    FetchDeltaContactsResult localFetchDeltaContactsResult;
    do
    {
      Tracer.b(5L);
      Tracer localTracer = Tracer.a("syncContactsDelta (" + 50 + " contacts)");
      FetchDeltaContactsParams localFetchDeltaContactsParams = new FetchDeltaContactsParams(50, paramString);
      localFetchDeltaContactsResult = (FetchDeltaContactsResult)((SingleMethodRunner)this.b.b()).a(this.d, localFetchDeltaContactsParams);
      ImmutableList localImmutableList1 = localFetchDeltaContactsResult.a();
      BLog.b(a, "Inserting contacts: " + localImmutableList1);
      this.o.a(localImmutableList1, DbInsertContactHandler.InsertionType.INSERT);
      ImmutableList localImmutableList2 = localFetchDeltaContactsResult.b();
      BLog.b(a, "Deleting contacts: " + localImmutableList2);
      this.o.a(localImmutableList2);
      paramString = localFetchDeltaContactsResult.c();
      this.q.a("com.facebook.orca.ACTION_FRIEND_SYNC_PROGRESS");
      localTracer.a();
      Tracer.a(a);
    }
    while (localFetchDeltaContactsResult.d());
    return paramString;
  }

  private OperationResult b()
  {
    ((SingleMethodRunner)this.b.b()).a(this.f, null);
    this.p.a();
    this.k.f();
    return OperationResult.b();
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    UserKey localUserKey = ((FetchContactParams)paramOperationParams.b().getParcelable("fetchContactParams")).a();
    if (localUserKey.a() == User.Type.PHONE_NUMBER);
    for (OperationResult localOperationResult = a(localUserKey); ; localOperationResult = c(paramOperationParams))
    {
      return localOperationResult;
      if ((localUserKey.a() != User.Type.FACEBOOK) && (localUserKey.a() != User.Type.FACEBOOK_CONTACT))
        break;
    }
    throw new Exception("Unsupported UserKey type");
  }

  private OperationResult b(UserKey paramUserKey)
  {
    SingleMethodRunner localSingleMethodRunner = (SingleMethodRunner)this.b.b();
    FetchContactParams localFetchContactParams = new FetchContactParams(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, paramUserKey);
    FetchContactResult localFetchContactResult = (FetchContactResult)localSingleMethodRunner.a(this.e, localFetchContactParams);
    this.o.a(localFetchContactResult.a(), localFetchContactResult.b());
    this.m.a(localFetchContactResult.a(), localFetchContactResult.b());
    return OperationResult.b();
  }

  private String b(boolean paramBoolean)
  {
    int i1 = 1;
    int i2 = 0;
    label65: String str;
    for (Object localObject = null; ; localObject = str)
    {
      int i3;
      Tracer localTracer;
      FetchAllContactsParams localFetchAllContactsParams;
      FetchAllContactsResult localFetchAllContactsResult;
      DbInsertContactHandler.InsertionType localInsertionType;
      if (i2 == 0)
      {
        i3 = 20;
        Tracer.b(5L);
        localTracer = Tracer.a("syncContactsFull (" + i3 + " contacts)");
        if (!paramBoolean)
          break label275;
        localFetchAllContactsParams = FetchAllContactsParams.b(i3, (String)localObject);
        localFetchAllContactsResult = (FetchAllContactsResult)((SingleMethodRunner)this.b.b()).a(this.c, localFetchAllContactsParams);
        if (i1 == 0)
          break label287;
        localInsertionType = DbInsertContactHandler.InsertionType.REPLACE_ALL;
        i1 = 0;
      }
      int i4;
      while (true)
      {
        ImmutableList localImmutableList = localFetchAllContactsResult.a();
        BLog.b(a, "Inserting contacts: " + localImmutableList);
        this.o.a(localImmutableList, localInsertionType);
        str = localFetchAllContactsResult.b();
        BLog.c(a, "Got " + localImmutableList.size() + " contacts in batch");
        i4 = i2 + localImmutableList.size();
        this.q.a("com.facebook.orca.ACTION_FRIEND_SYNC_PROGRESS");
        localTracer.a();
        Tracer.a(a);
        if (localFetchAllContactsResult.c())
          break label295;
        BLog.c(a, "Got " + i4 + " contacts.");
        return localFetchAllContactsResult.d();
        i3 = 50;
        break;
        label275: localFetchAllContactsParams = FetchAllContactsParams.a(i3, (String)localObject);
        break label65;
        label287: localInsertionType = DbInsertContactHandler.InsertionType.INSERT;
      }
      label295: i2 = i4;
    }
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    FetchContactParams localFetchContactParams = (FetchContactParams)paramOperationParams.b().getParcelable("fetchContactParams");
    UserKey localUserKey = localFetchContactParams.a();
    DataFreshnessParam localDataFreshnessParam = localFetchContactParams.b();
    OperationResult localOperationResult;
    if (localDataFreshnessParam != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
    {
      BLog.c(a, "Checking contacts cache: " + localUserKey);
      ContactSummary localContactSummary = this.m.a(localUserKey);
      ContactDetails localContactDetails = this.m.b(localUserKey);
      if ((localContactSummary != null) && (localContactDetails != null))
      {
        BLog.c(a, "Got cached contact: " + localContactSummary);
        localOperationResult = OperationResult.a(new FetchContactResult(DataFreshnessResult.FROM_CACHE_STALE, System.currentTimeMillis(), localContactSummary, localContactDetails));
      }
    }
    while (true)
    {
      return localOperationResult;
      if (localDataFreshnessParam != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
      {
        BLog.c(a, "Checking contacts DB: " + localUserKey);
        FetchContactResult localFetchContactResult2 = this.n.a(localUserKey);
        if ((localFetchContactResult2 != FetchContactResult.a) && (localFetchContactResult2.b() != null))
        {
          BLog.c(a, "Got DB contact: " + localFetchContactResult2.a());
          localOperationResult = OperationResult.a(localFetchContactResult2);
          continue;
        }
      }
      if (localUserKey.a() == User.Type.FACEBOOK)
      {
        BLog.c(a, "Checking FB user cache: " + localUserKey);
        User localUser = this.l.a(localUserKey);
        if (localUser != null)
        {
          BLog.c(a, "Got FB user: " + localUser);
          ContactSummaryBuilder localContactSummaryBuilder = new ContactSummaryBuilder().b(localUserKey.b()).d(localUser.f());
          if (localDataFreshnessParam == DataFreshnessParam.DO_NOT_CHECK_SERVER)
          {
            BLog.c(a, "Not checking server, made contact from cached user: " + localContactSummaryBuilder.q());
            localOperationResult = OperationResult.a(new FetchContactResult(DataFreshnessResult.FROM_CACHE_INCOMPLETE, System.currentTimeMillis(), localContactSummaryBuilder.q(), null));
            continue;
          }
        }
      }
      BLog.c(a, "Fetching contact from server");
      FetchContactResult localFetchContactResult1 = (FetchContactResult)((SingleMethodRunner)this.b.b()).a(this.e, localFetchContactParams);
      BLog.c(a, "Got contact from server: " + localFetchContactResult1.a());
      this.o.a(localFetchContactResult1.a(), localFetchContactResult1.b());
      this.m.a(localFetchContactResult1.a(), localFetchContactResult1.b());
      localOperationResult = OperationResult.a(localFetchContactResult1);
    }
  }

  private OperationResult d(OperationParams paramOperationParams)
  {
    CreateContactClaimParams localCreateContactClaimParams = (CreateContactClaimParams)paramOperationParams.b().getParcelable("createContactClaimParams");
    String str = (String)((SingleMethodRunner)this.b.b()).a(this.h, localCreateContactClaimParams);
    b(new UserKey(User.Type.FACEBOOK_CONTACT, localCreateContactClaimParams.a()));
    return OperationResult.a(str);
  }

  private OperationResult e(OperationParams paramOperationParams)
  {
    DeleteContactClaimParams localDeleteContactClaimParams = (DeleteContactClaimParams)paramOperationParams.b().getParcelable("deleteContactClaimParams");
    ((SingleMethodRunner)this.b.b()).a(this.i, localDeleteContactClaimParams);
    return b(new UserKey(User.Type.FACEBOOK_CONTACT, localDeleteContactClaimParams.c()));
  }

  private OperationResult f(OperationParams paramOperationParams)
  {
    BlockContactParams localBlockContactParams = (BlockContactParams)paramOperationParams.b().getParcelable("blockContactParams");
    ((SingleMethodRunner)this.b.b()).a(this.g, localBlockContactParams);
    return OperationResult.b();
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    OperationResult localOperationResult;
    if ("fetch_contact".equals(str))
      localOperationResult = b(paramOperationParams);
    while (true)
    {
      return localOperationResult;
      if ("sync_contacts_partial".equals(str))
      {
        localOperationResult = a(true);
        continue;
      }
      if ("sync_contacts_complete".equals(str))
      {
        localOperationResult = a(false);
        continue;
      }
      if ("create_contact_claim".equals(str))
      {
        localOperationResult = d(paramOperationParams);
        continue;
      }
      if ("delete_contact_claim".equals(str))
      {
        localOperationResult = e(paramOperationParams);
        continue;
      }
      if ("block_contact".equals(str))
      {
        localOperationResult = f(paramOperationParams);
        continue;
      }
      if (!"bulk_contacts_delete".equals(str))
        break;
      localOperationResult = b();
    }
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.service.ContactsServiceHandler
 * JD-Core Version:    0.6.0
 */