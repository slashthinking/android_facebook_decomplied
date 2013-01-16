package com.facebook.orca.contacts.upload;

import com.facebook.contacts.data.DbContactsProperties;
import com.facebook.contacts.data.DbContactsPropertyUtil;
import com.facebook.contacts.data.DbInsertContactHandler;
import com.facebook.contacts.data.DbInsertContactHandler.InsertionType;
import com.facebook.contacts.protocol.FetchContactsMethod;
import com.facebook.contacts.protocol.UploadBulkContactsMethod;
import com.facebook.contacts.server.FetchContactsParams;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.server.UploadBulkContactChange;
import com.facebook.contacts.server.UploadBulkContactChange.Type;
import com.facebook.contacts.server.UploadBulkContactChangeResult;
import com.facebook.contacts.server.UploadBulkContactChangeResult.Confidence;
import com.facebook.contacts.server.UploadBulkContactsParams;
import com.facebook.contacts.server.UploadBulkContactsResult;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.prefs.InternalPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceProgressCallback;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.PhoneUserIterator;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserPhoneNumber;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.ImmutableSet<Ljava.lang.String;>;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

public class ContactsUploadServiceHandler
  implements OrcaServiceHandler
{
  private static final String a = ContactsUploadServiceHandler.class.getName();
  private final Provider<PhoneUserIterator> b;
  private final Provider<SingleMethodRunner> c;
  private final UploadBulkContactsMethod d;
  private final FetchContactsMethod e;
  private final DbInsertContactHandler f;
  private final OrcaSharedPreferences g;
  private final DbContactsPropertyUtil h;
  private final PhoneNumberUtil i;

  @Inject
  public ContactsUploadServiceHandler(Provider<PhoneUserIterator> paramProvider, Provider<SingleMethodRunner> paramProvider1, UploadBulkContactsMethod paramUploadBulkContactsMethod, FetchContactsMethod paramFetchContactsMethod, DbInsertContactHandler paramDbInsertContactHandler, OrcaSharedPreferences paramOrcaSharedPreferences, DbContactsPropertyUtil paramDbContactsPropertyUtil, PhoneNumberUtil paramPhoneNumberUtil)
  {
    this.b = paramProvider;
    this.c = paramProvider1;
    this.d = paramUploadBulkContactsMethod;
    this.e = paramFetchContactsMethod;
    this.f = paramDbInsertContactHandler;
    this.g = paramOrcaSharedPreferences;
    this.h = paramDbContactsPropertyUtil;
    this.i = paramPhoneNumberUtil;
  }

  private ImmutableList<UploadBulkContactChangeResult> a(UploadBulkContactsResult paramUploadBulkContactsResult)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    Iterator localIterator = paramUploadBulkContactsResult.b().iterator();
    while (localIterator.hasNext())
    {
      UploadBulkContactChangeResult localUploadBulkContactChangeResult = (UploadBulkContactChangeResult)localIterator.next();
      switch (ContactsUploadServiceHandler.1.a[localUploadBulkContactChangeResult.a().ordinal()])
      {
      default:
        break;
      case 1:
      case 2:
      case 3:
        UploadBulkContactChangeResult.Confidence localConfidence = localUploadBulkContactChangeResult.d();
        if (a(localConfidence))
        {
          localBuilder.b(localUploadBulkContactChangeResult);
          continue;
        }
        BLog.a(a, "Not including contact " + localUploadBulkContactChangeResult + ", confidence " + localConfidence + " too low.");
      }
    }
    return localBuilder.b();
  }

  private ImmutableMultimap<String, Phonenumber.PhoneNumber> a(ImmutableMap<String, UploadBulkContactChange> paramImmutableMap, ImmutableList<UploadBulkContactChangeResult> paramImmutableList)
  {
    ImmutableMultimap.Builder localBuilder = ImmutableMultimap.j();
    Iterator localIterator1 = paramImmutableList.iterator();
    while (localIterator1.hasNext())
    {
      UploadBulkContactChangeResult localUploadBulkContactChangeResult = (UploadBulkContactChangeResult)localIterator1.next();
      String str1 = localUploadBulkContactChangeResult.b();
      String str2 = localUploadBulkContactChangeResult.c();
      UploadBulkContactChange localUploadBulkContactChange = (UploadBulkContactChange)paramImmutableMap.get(str1);
      if (localUploadBulkContactChange == null)
      {
        BLog.e(a, "Got change result that did not match a local contact ID, skipping: " + localUploadBulkContactChangeResult);
        continue;
      }
      Iterator localIterator2 = localUploadBulkContactChange.b().j().iterator();
      while (localIterator2.hasNext())
      {
        String str3 = ((UserPhoneNumber)localIterator2.next()).b();
        try
        {
          localBuilder.a(str2, this.i.parse(str3, null));
        }
        catch (NumberParseException localNumberParseException)
        {
          BLog.e(a, "Error parsing invalid phone number: " + str3 + " Error: " + localNumberParseException);
        }
      }
    }
    return localBuilder.a();
  }

  private ImmutableSet<String> a(UploadBulkContactsResult paramUploadBulkContactsResult, ContactsUploadServiceHandler.ContactIdFilterMode paramContactIdFilterMode)
  {
    ImmutableList localImmutableList = a(paramUploadBulkContactsResult);
    ImmutableSet.Builder localBuilder = ImmutableSet.e();
    Iterator localIterator = localImmutableList.iterator();
    if (localIterator.hasNext())
    {
      UploadBulkContactChangeResult localUploadBulkContactChangeResult = (UploadBulkContactChangeResult)localIterator.next();
      localUploadBulkContactChangeResult.d();
      int j = ContactsUploadServiceHandler.1.b[paramContactIdFilterMode.ordinal()];
      Object localObject = null;
      switch (j)
      {
      default:
        label84: if (localObject == null)
          break;
      case 1:
      case 2:
      }
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        localBuilder.b(localObject);
        break;
        localObject = localUploadBulkContactChangeResult.b();
        break label84;
        localObject = localUploadBulkContactChangeResult.c();
        break label84;
      }
    }
    return (ImmutableSet<String>)localBuilder.b();
  }

  private String a(OperationParams paramOperationParams, PhoneUserIterator paramPhoneUserIterator, ContactsUploadServiceHandler.Progress paramProgress, int paramInt, String paramString)
  {
    ImmutableMap.Builder localBuilder1 = ImmutableMap.k();
    OrcaServiceProgressCallback localOrcaServiceProgressCallback = paramOperationParams.c();
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    Object localObject1 = localBuilder1;
    int j = 0;
    Object localObject2 = paramString;
    while (true)
    {
      String str;
      ImmutableMap.Builder localBuilder2;
      try
      {
        User localUser = paramPhoneUserIterator.e();
        if (localUser == null)
          continue;
        paramProgress.a = (1 + paramProgress.a);
        if (!a(localUser))
          continue;
        ((ImmutableMap.Builder)localObject1).b(localUser.b(), new UploadBulkContactChange(localUser.b(), localUser, UploadBulkContactChange.Type.ADD));
        j++;
        if (j < paramInt)
          continue;
        ImmutableMap localImmutableMap2 = ((ImmutableMap.Builder)localObject1).b();
        UploadBulkContactsResult localUploadBulkContactsResult2 = a((String)localObject2, localImmutableMap2);
        localHashSet2.addAll(localImmutableMap2.b());
        ImmutableSet localImmutableSet2 = a(localUploadBulkContactsResult2, ContactsUploadServiceHandler.ContactIdFilterMode.LOCAL_CONTACT_IDS);
        localHashSet1.addAll(localImmutableSet2);
        str = localUploadBulkContactsResult2.a();
        paramProgress.b += localImmutableSet2.size();
        localBuilder2 = ImmutableMap.k();
        if (localOrcaServiceProgressCallback != null)
        {
          localOrcaServiceProgressCallback.a(OperationResult.a(ContactsUploadState.a(paramProgress.a, paramProgress.b, paramProgress.c)));
          break label357;
          if (j <= 0)
            continue;
          ImmutableMap localImmutableMap1 = ((ImmutableMap.Builder)localObject1).b();
          UploadBulkContactsResult localUploadBulkContactsResult1 = a((String)localObject2, localImmutableMap1);
          localHashSet2.addAll(localImmutableMap1.b());
          ImmutableSet localImmutableSet1 = a(localUploadBulkContactsResult1, ContactsUploadServiceHandler.ContactIdFilterMode.LOCAL_CONTACT_IDS);
          localHashSet1.addAll(localImmutableSet1);
          localObject2 = localUploadBulkContactsResult1.a();
          paramProgress.b += localImmutableSet1.size();
          if (localOrcaServiceProgressCallback == null)
            continue;
          localOrcaServiceProgressCallback.a(OperationResult.a(ContactsUploadState.a(paramProgress.a, paramProgress.b, paramProgress.c)));
          return localObject2;
        }
      }
      finally
      {
        paramPhoneUserIterator.c();
        a(localHashSet2, localHashSet1);
      }
      label357: localObject1 = localBuilder2;
      localObject2 = str;
      j = 0;
    }
  }

  private void a(ImmutableMap<String, UploadBulkContactChange> paramImmutableMap, UploadBulkContactsResult paramUploadBulkContactsResult)
  {
    ImmutableMultimap localImmutableMultimap = a(paramImmutableMap, a(paramUploadBulkContactsResult));
    BLog.b(a, "Inserting phone indexes for contacts: " + localImmutableMultimap);
    this.f.a(localImmutableMultimap);
  }

  private void a(Set<String> paramSet1, Set<String> paramSet2)
  {
    Sets.SetView localSetView = Sets.a(paramSet1, paramSet2);
    String str = new ObjectMapper().writeValueAsString(localSetView);
    this.h.a(DbContactsProperties.e, str);
  }

  private boolean a(UploadBulkContactChangeResult.Confidence paramConfidence)
  {
    switch (ContactsUploadServiceHandler.1.c[paramConfidence.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    for (int j = 0; ; j = 1)
      return j;
  }

  private boolean a(User paramUser)
  {
    int j = 0;
    boolean bool;
    if (paramUser.a() == User.Type.ADDRESS_BOOK)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      Name localName = paramUser.d();
      if ((localName != null) && (localName.f().length() != 0))
        break label79;
      BLog.b(a, "Skipping contact: " + paramUser + " (no name)");
    }
    while (true)
    {
      return j;
      bool = false;
      break;
      label79: ImmutableList localImmutableList1 = paramUser.i();
      ImmutableList localImmutableList2 = paramUser.j();
      if ((localImmutableList1.isEmpty()) && (localImmutableList2.isEmpty()))
      {
        BLog.b(a, "Skipping contact: " + paramUser + " (no emails or phones)");
        j = 0;
        continue;
      }
      j = 1;
    }
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    PhoneUserIterator localPhoneUserIterator1 = (PhoneUserIterator)this.b.b();
    Collection localCollection = localPhoneUserIterator1.b();
    PhoneUserIterator localPhoneUserIterator2 = (PhoneUserIterator)this.b.b();
    localPhoneUserIterator2.a(localCollection);
    int j = localPhoneUserIterator1.d() + localPhoneUserIterator2.d();
    OrcaServiceProgressCallback localOrcaServiceProgressCallback = paramOperationParams.c();
    if (localOrcaServiceProgressCallback != null)
      localOrcaServiceProgressCallback.a(OperationResult.a(ContactsUploadState.a(0, 0, j)));
    ContactsUploadServiceHandler.Progress localProgress = new ContactsUploadServiceHandler.Progress(j);
    int k = Integer.valueOf(this.g.a(InternalPrefKeys.d, "-1")).intValue();
    if (k == -1)
      k = 100;
    BLog.b(a, "Starting upload of " + localProgress.c + " contacts " + "(batch size " + k + ")");
    BLog.b(a, "Starting frequent contacts upload...");
    String str = a(paramOperationParams, localPhoneUserIterator1, localProgress, k, null);
    BLog.b(a, "Starting remaining contacts upload...");
    a(paramOperationParams, localPhoneUserIterator2, localProgress, k, str);
    BLog.b(a, "Done uploading contacts (import ID " + str + ")");
    return OperationResult.b();
  }

  UploadBulkContactsResult a(String paramString, ImmutableMap<String, UploadBulkContactChange> paramImmutableMap)
  {
    Tracer.b(7L);
    Tracer localTracer = Tracer.a("uploadUserBatch (" + paramImmutableMap.size() + " changes)");
    String str;
    if (paramString == null)
      str = "(new import)";
    while (true)
    {
      int j = 0;
      int k = 0;
      Object localObject1 = null;
      label57: if ((k == 0) && (j < 3));
      try
      {
        BLog.b(a, "Uploading user batch " + str + " (" + paramImmutableMap.size() + " changes)");
        UploadBulkContactsParams localUploadBulkContactsParams = new UploadBulkContactsParams(paramString, ImmutableList.a(paramImmutableMap.c()));
        SingleMethodRunner localSingleMethodRunner = (SingleMethodRunner)this.c.b();
        localObject2 = (UploadBulkContactsResult)localSingleMethodRunner.a(this.d, localUploadBulkContactsParams);
        try
        {
          BLog.b(a, "Got upload result: " + localObject2);
          ImmutableSet localImmutableSet = a((UploadBulkContactsResult)localObject2, ContactsUploadServiceHandler.ContactIdFilterMode.REMOTE_CONTACT_IDS);
          if (localImmutableSet.size() > 0)
          {
            FetchContactsParams localFetchContactsParams = new FetchContactsParams(localImmutableSet);
            FetchContactsResult localFetchContactsResult = (FetchContactsResult)localSingleMethodRunner.a(this.e, localFetchContactsParams);
            BLog.b(a, "Got fetch result: " + localFetchContactsResult);
            this.f.a(localFetchContactsResult.a(), DbInsertContactHandler.InsertionType.INSERT);
            a(paramImmutableMap, (UploadBulkContactsResult)localObject2);
          }
          k = 1;
          localObject1 = localObject2;
          break label57;
          str = paramString;
        }
        catch (IOException localIOException1)
        {
        }
        int m = j + 1;
        BLog.e(a, "Failed to upload user batch, (try " + m + " of " + 3 + "), error: " + localIOException1);
        if (m >= 3)
        {
          BLog.e(a, "Giving up uploading user batch.");
          throw localIOException1;
        }
        j = m;
        localObject1 = localObject2;
        break label57;
        localTracer.a(0L);
        Tracer.b(a);
        if (localObject1 != null);
        for (boolean bool = true; ; bool = false)
        {
          Preconditions.checkState(bool);
          return localObject1;
        }
      }
      catch (IOException localIOException2)
      {
        while (true)
          Object localObject2 = localObject1;
      }
    }
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("contacts_upload".equals(str))
      return b(paramOperationParams);
    throw new IllegalArgumentException("Unknown operation type: " + str);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.upload.ContactsUploadServiceHandler
 * JD-Core Version:    0.6.0
 */