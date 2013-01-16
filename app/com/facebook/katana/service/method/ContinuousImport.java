package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.facebook.common.util.Log;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import com.facebook.katana.provider.ObservedContactsProvider;
import com.facebook.katana.util.PhonebookUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContinuousImport extends ApiMethod
{
  private static Class<?> a = ContinuousImport.class;
  private Context b;
  private Map<Long, FacebookPhonebookContact> f;
  private Map<Long, FacebookPhonebookContact> g;
  private Map<Long, FacebookPhonebookContact> h = null;
  private List<FacebookPhonebookContactUser> i = null;
  private final PhonebookUtils j;

  public ContinuousImport(Context paramContext, Intent paramIntent, String paramString, ServiceOperationListener paramServiceOperationListener, PhonebookUtils paramPhonebookUtils)
  {
    super(paramContext, paramIntent, "POST", "continuous.import", Constants.URL.b(paramContext), paramServiceOperationListener);
    this.e.put("call_id", String.valueOf(System.currentTimeMillis()));
    this.e.put("session_key", paramString);
    this.j = paramPhonebookUtils;
    this.b = paramContext;
    this.f = new HashMap();
    this.g = new HashMap();
    this.h = new HashMap();
    this.i = new ArrayList();
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putBoolean("continuous_import", paramBoolean);
    localEditor.commit();
  }

  public static boolean a(Context paramContext)
  {
    boolean bool1 = Boolean.TRUE.equals(Gatekeeper.a(paramContext, "android_continuous_import"));
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      bool2 = PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("continuous_import", false);
    }
  }

  protected void a(Collection<FacebookPhonebookContact> paramCollection)
  {
    long l = System.currentTimeMillis() / 1000L;
    ContentValues[] arrayOfContentValues = new ContentValues[paramCollection.size()];
    Iterator localIterator = paramCollection.iterator();
    int n;
    for (int k = 0; localIterator.hasNext(); k = n)
    {
      FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)localIterator.next();
      ContentValues localContentValues = new ContentValues();
      int m = FacebookPhonebookContact.a(localFacebookPhonebookContact);
      localContentValues.put("contact_id", Long.valueOf(localFacebookPhonebookContact.recordId));
      localContentValues.put("signature", Integer.valueOf(m));
      localContentValues.put("timestamp", Long.valueOf(l));
      n = k + 1;
      arrayOfContentValues[k] = localContentValues;
    }
    this.b.getContentResolver().bulkInsert(ObservedContactsProvider.a, arrayOfContentValues);
  }

  public void b()
  {
    if (a(this.b))
    {
      ContinuousImport.ContinuousImportTask localContinuousImportTask = new ContinuousImport.ContinuousImportTask(this, null);
      Void[] arrayOfVoid = new Void[1];
      arrayOfVoid[0] = ((Void)null);
      localContinuousImportTask.execute(arrayOfVoid);
    }
    while (true)
    {
      return;
      this.q.a_(this, 200, null, null);
    }
  }

  protected void b(Collection<FacebookPhonebookContact> paramCollection)
  {
    long l = System.currentTimeMillis() / 1000L;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)localIterator.next();
      ContentValues localContentValues = new ContentValues();
      int k = FacebookPhonebookContact.a(localFacebookPhonebookContact);
      localContentValues.put("contact_id", Long.valueOf(localFacebookPhonebookContact.recordId));
      localContentValues.put("signature", Integer.valueOf(k));
      localContentValues.put("timestamp", Long.valueOf(l));
      Uri localUri = Uri.withAppendedPath(ObservedContactsProvider.b, String.valueOf(localFacebookPhonebookContact.recordId));
      this.b.getContentResolver().update(localUri, localContentValues, null, null);
    }
  }

  protected void g()
  {
    List localList = k();
    Map localMap = l();
    if (localMap.size() == 0)
    {
      a(localList);
      this.f = new HashMap();
      this.g = new HashMap();
    }
    while (true)
    {
      return;
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      HashSet localHashSet = new HashSet();
      Iterator localIterator1 = localList.iterator();
      label206: 
      while (localIterator1.hasNext())
      {
        FacebookPhonebookContact localFacebookPhonebookContact = (FacebookPhonebookContact)localIterator1.next();
        int k = FacebookPhonebookContact.a(localFacebookPhonebookContact);
        ContinuousImport.ContactCached localContactCached2 = (ContinuousImport.ContactCached)localMap.get(Long.valueOf(localFacebookPhonebookContact.recordId));
        if (localContactCached2 == null)
          localHashMap1.put(Long.valueOf(localFacebookPhonebookContact.recordId), localFacebookPhonebookContact);
        while (true)
        {
          if (localContactCached2 == null)
            break label206;
          localHashSet.add(Long.valueOf(localContactCached2.a()));
          break;
          if (localContactCached2.b() == k)
            continue;
          localHashMap2.put(Long.valueOf(localFacebookPhonebookContact.recordId), localFacebookPhonebookContact);
        }
      }
      Iterator localIterator2 = localMap.values().iterator();
      while (localIterator2.hasNext())
      {
        ContinuousImport.ContactCached localContactCached1 = (ContinuousImport.ContactCached)localIterator2.next();
        if (localHashSet.contains(Long.valueOf(localContactCached1.a())))
          continue;
        Uri localUri = Uri.withAppendedPath(ObservedContactsProvider.b, String.valueOf(localContactCached1.a()));
        this.b.getContentResolver().delete(localUri, null, null);
      }
      if (localHashMap1.size() > 0)
        this.f = localHashMap1;
      if (localHashMap2.size() <= 0)
        continue;
      this.g = localHashMap2;
    }
  }

  protected Map<Long, FacebookPhonebookContact> getRecentlyAdded()
  {
    return this.f;
  }

  protected Map<Long, FacebookPhonebookContact> getRecentlyUpdated()
  {
    return this.g;
  }

  protected void h()
  {
    Log.e(a, "initiating ContactInfoFetcher call");
    if ((this.f.size() == 0) && (this.g.size() == 0))
      a(this, 200, null, null);
    while (true)
    {
      return;
      i();
      ContactRemoteInfoFetcher localContactRemoteInfoFetcher = new ContactRemoteInfoFetcher(this.b);
      HashMap localHashMap = new HashMap();
      localHashMap.putAll(this.f);
      localHashMap.putAll(this.g);
      localContactRemoteInfoFetcher.b(localHashMap);
    }
  }

  protected void i()
  {
    AppSession localAppSession = AppSession.a(this.b, true);
    Iterator localIterator = localAppSession.d().iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((AppSessionListener)localIterator.next() instanceof ContinuousImport.ContactRemoteInfoFetcherListener));
    while (true)
    {
      return;
      localAppSession.a(new ContinuousImport.ContactRemoteInfoFetcherListener(this));
    }
  }

  protected void j()
  {
    AppSession localAppSession = AppSession.a(this.b, true);
    Iterator localIterator = localAppSession.d().iterator();
    AppSessionListener localAppSessionListener;
    do
    {
      if (!localIterator.hasNext())
        break;
      localAppSessionListener = (AppSessionListener)localIterator.next();
    }
    while (!(localAppSessionListener instanceof ContinuousImport.ContactRemoteInfoFetcherListener));
    while (true)
    {
      if (localAppSessionListener != null)
        localAppSession.b(localAppSessionListener);
      return;
      localAppSessionListener = null;
    }
  }

  protected List<FacebookPhonebookContact> k()
  {
    return this.j.a();
  }

  // ERROR //
  protected Map<Long, ContinuousImport.ContactCached> l()
  {
    // Byte code:
    //   0: new 72	java/util/HashMap
    //   3: dup
    //   4: invokespecial 74	java/util/HashMap:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 70	com/facebook/katana/service/method/ContinuousImport:b	Landroid/content/Context;
    //   12: invokevirtual 197	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   15: getstatic 202	com/facebook/katana/provider/ObservedContactsProvider:a	Landroid/net/Uri;
    //   18: getstatic 342	com/facebook/katana/service/method/ContinuousImport$ObservedContactQuery:a	[Ljava/lang/String;
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 346	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +102 -> 133
    //   34: aload 4
    //   36: invokeinterface 351 1 0
    //   41: ifeq +92 -> 133
    //   44: new 266	com/facebook/katana/service/method/ContinuousImport$ContactCached
    //   47: dup
    //   48: aload_0
    //   49: aload 4
    //   51: aload 4
    //   53: ldc 167
    //   55: invokeinterface 355 2 0
    //   60: invokeinterface 359 2 0
    //   65: aload 4
    //   67: aload 4
    //   69: ldc 181
    //   71: invokeinterface 355 2 0
    //   76: invokeinterface 359 2 0
    //   81: aload 4
    //   83: aload 4
    //   85: ldc 191
    //   87: invokeinterface 355 2 0
    //   92: invokeinterface 359 2 0
    //   97: invokespecial 362	com/facebook/katana/service/method/ContinuousImport$ContactCached:<init>	(Lcom/facebook/katana/service/method/ContinuousImport;JJJ)V
    //   100: astore 5
    //   102: aload_1
    //   103: aload 5
    //   105: invokevirtual 268	com/facebook/katana/service/method/ContinuousImport$ContactCached:a	()J
    //   108: invokestatic 176	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: aload 5
    //   113: invokeinterface 64 3 0
    //   118: pop
    //   119: aload 4
    //   121: invokeinterface 365 1 0
    //   126: istore 7
    //   128: iload 7
    //   130: ifne -86 -> 44
    //   133: aload 4
    //   135: ifnull +10 -> 145
    //   138: aload 4
    //   140: invokeinterface 368 1 0
    //   145: aload_1
    //   146: areturn
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +9 -> 160
    //   154: aload_3
    //   155: invokeinterface 368 1 0
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: aload 4
    //   165: astore_3
    //   166: goto -16 -> 150
    //
    // Exception table:
    //   from	to	target	type
    //   8	29	147	finally
    //   34	128	162	finally
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ContinuousImport
 * JD-Core Version:    0.6.0
 */