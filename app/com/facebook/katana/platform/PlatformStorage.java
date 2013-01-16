package com.facebook.katana.platform;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.StatusUpdates;
import android.text.TextUtils;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookStatus;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.model.FacebookFriendInfo;
import com.facebook.katana.util.PlatformUtils;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PlatformStorage
{
  private static final Class<?> a = PlatformStorage.class;
  private static FbErrorReporter b = null;

  private static long a(ContentResolver paramContentResolver, long paramLong)
  {
    Uri localUri = ContactsContract.RawContacts.CONTENT_URI;
    String[] arrayOfString1 = PlatformStorage.UserIdQuery.a;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramLong);
    Cursor localCursor = paramContentResolver.query(localUri, arrayOfString1, "account_type='com.facebook.auth.login' AND sourceid=?", arrayOfString2, null);
    while (true)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          long l2 = localCursor.getLong(0);
          l1 = l2;
          return l1;
        }
      }
      finally
      {
        if (localCursor == null)
          continue;
        localCursor.close();
      }
      long l1 = 0L;
    }
  }

  static ContentProviderOperation.Builder a(Uri paramUri, boolean paramBoolean)
  {
    return ContentProviderOperation.newInsert(a(paramUri)).withYieldAllowed(paramBoolean);
  }

  private static ContentProviderOperation a(ContentValues paramContentValues, String paramString1, String paramString2, Uri paramUri, boolean paramBoolean)
  {
    ContentProviderOperation localContentProviderOperation;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2.equals(paramString1))
      {
        localContentProviderOperation = null;
        return localContentProviderOperation;
      }
      paramContentValues.clear();
      paramContentValues.put("data1", paramString2);
    }
    for (ContentProviderOperation.Builder localBuilder = b(paramUri, paramBoolean).withValues(paramContentValues); ; localBuilder = c(paramUri, paramBoolean))
    {
      localContentProviderOperation = localBuilder.build();
      break;
    }
  }

  static Uri a(Uri paramUri)
  {
    return paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
  }

  private static Set<Long> a(ContentResolver paramContentResolver)
  {
    HashSet localHashSet = Sets.a();
    Cursor localCursor = paramContentResolver.query(ContactsContract.Data.CONTENT_URI, PlatformStorage.ProfilePicQuery.a, "data15 is not null", null, null);
    if (localCursor != null)
      try
      {
        if (localCursor.moveToNext())
          localHashSet.add(Long.valueOf(localCursor.getLong(0)));
      }
      finally
      {
        localCursor.close();
      }
    return localHashSet;
  }

  private static void a(ContentResolver paramContentResolver, ArrayList<ContentProviderOperation> paramArrayList)
  {
    if (paramArrayList.size() == 0);
    while (true)
    {
      return;
      try
      {
        paramContentResolver.applyBatch("com.android.contacts", paramArrayList);
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        Log.a(a, "storing contact data failed", localOperationApplicationException);
      }
      catch (RemoteException localRemoteException)
      {
        Log.a(a, "storing contact data failed", localRemoteException);
      }
    }
  }

  public static void a(Context paramContext, long paramLong, byte[] paramArrayOfByte)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    long l = a(localContentResolver, paramLong);
    if (l > 0L)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mimetype", "vnd.android.cursor.item/photo");
      localContentValues.put("raw_contact_id", Long.valueOf(l));
      localContentValues.put("data15", paramArrayOfByte);
      Uri localUri = a(ContactsContract.Data.CONTENT_URI);
      if (localContentResolver.update(localUri, localContentValues, "raw_contact_id=" + l + " AND " + "mimetype" + "='" + "vnd.android.cursor.item/photo" + "'", null) == 0)
        localContentResolver.insert(localUri, localContentValues);
    }
  }

  private static void a(Context paramContext, ContentResolver paramContentResolver, ArrayList<ContentProviderOperation> paramArrayList, ContentValues paramContentValues, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Long paramLong1, Long paramLong2, long paramLong)
  {
    Uri localUri1 = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, paramLong2.longValue());
    paramContentValues.clear();
    paramContentValues.put("sync1", Long.valueOf(paramLong));
    paramArrayList.add(b(localUri1, true).withValues(paramContentValues).build());
    Uri localUri2 = ContactsContract.Data.CONTENT_URI;
    String[] arrayOfString1 = PlatformStorage.DataQuery.a;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramLong2);
    Cursor localCursor = paramContentResolver.query(localUri2, arrayOfString1, "raw_contact_id=?", arrayOfString2, null);
    boolean bool1 = true;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    String str1;
    Uri localUri3;
    String str4;
    int i13;
    try
    {
      if (!localCursor.moveToNext())
        break label609;
      long l = localCursor.getLong(0);
      str1 = localCursor.getString(1);
      localUri3 = ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, l);
      if ("vnd.android.cursor.item/name".equals(str1))
      {
        String str3 = localCursor.getString(3);
        str4 = localCursor.getString(4);
        if ((str3 != null) || (paramString2 == null))
          break label1018;
        i13 = 1;
        label185: 
        while (i13 != 0)
        {
          paramContentValues.clear();
          paramContentValues.put("data2", paramString2);
          paramContentValues.put("data3", paramString3);
          paramArrayList.add(b(localUri3, bool1).withValues(paramContentValues).build());
          bool1 = false;
          break;
          label237: if (!str3.equals(paramString2))
          {
            i13 = 1;
            continue;
          }
          boolean bool2 = str4.equals(paramString3);
          i13 = 0;
          if (bool2)
            continue;
          i13 = 1;
        }
      }
      if ("vnd.android.cursor.item/phone_v2".equals(str1))
      {
        int i10 = localCursor.getInt(3);
        String str2 = localCursor.getString(2);
        if (i10 == 2)
        {
          ContentProviderOperation localContentProviderOperation2 = a(paramContentValues, str2, paramString4, localUri3, bool1);
          if (localContentProviderOperation2 == null)
            break label1034;
          paramArrayList.add(localContentProviderOperation2);
          bool1 = false;
          break label1034;
        }
        if (i10 == 7)
        {
          ContentProviderOperation localContentProviderOperation1 = a(paramContentValues, str2, paramString5, localUri3, bool1);
          if (localContentProviderOperation1 == null)
            break label1064;
          paramArrayList.add(localContentProviderOperation1);
          bool1 = false;
          break label1064;
        }
        Log.a(a, "Ignoring unkown row type: " + i10);
      }
    }
    finally
    {
      localCursor.close();
    }
    int i1;
    int i2;
    int i4;
    int i5;
    if ("vnd.android.cursor.item/email_v2".equals(str1))
    {
      if (!TextUtils.isEmpty(paramString6))
      {
        if (!paramString6.equals(localCursor.getString(2)))
        {
          paramContentValues.clear();
          paramContentValues.put("data1", paramString6);
          paramArrayList.add(b(localUri3, bool1).withValues(paramContentValues).build());
          bool1 = false;
        }
      }
      else
      {
        paramArrayList.add(c(localUri3, bool1).build());
        bool1 = false;
      }
    }
    else if ("vnd.android.cursor.item/vnd.facebook.profile".equals(str1))
    {
      Long localLong = Long.valueOf(localCursor.getLong(2));
      if ((localLong != null) && (localLong.equals(paramLong1)))
      {
        paramContentValues.clear();
        paramContentValues.put("data1", paramLong1);
        paramArrayList.add(ContentProviderOperation.newUpdate(localUri3).withValues(paramContentValues).build());
      }
      i1 = k;
      i2 = 1;
      int i8 = j;
      i4 = m;
      i5 = i8;
      break label991;
      label609: localCursor.close();
      if ((m == 0) && (!TextUtils.isEmpty(paramString4)))
      {
        paramContentValues.clear();
        paramContentValues.put("data1", paramString4);
        paramContentValues.put("data2", Integer.valueOf(2));
        paramContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        paramContentValues.put("raw_contact_id", paramLong2);
        ContentProviderOperation.Builder localBuilder3 = a(ContactsContract.Data.CONTENT_URI, bool1).withValues(paramContentValues);
        bool1 = false;
        paramArrayList.add(localBuilder3.build());
      }
      if ((k == 0) && (!TextUtils.isEmpty(paramString5)))
      {
        paramContentValues.clear();
        paramContentValues.put("data1", paramString5);
        paramContentValues.put("data2", Integer.valueOf(7));
        paramContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        paramContentValues.put("raw_contact_id", paramLong2);
        ContentProviderOperation.Builder localBuilder2 = a(ContactsContract.Data.CONTENT_URI, bool1).withValues(paramContentValues);
        bool1 = false;
        paramArrayList.add(localBuilder2.build());
      }
      if ((j == 0) && (!TextUtils.isEmpty(paramString6)))
      {
        paramContentValues.clear();
        paramContentValues.put("data1", paramString6);
        paramContentValues.put("data2", Integer.valueOf(3));
        paramContentValues.put("mimetype", "vnd.android.cursor.item/email_v2");
        paramContentValues.put("raw_contact_id", paramLong2);
        ContentProviderOperation.Builder localBuilder1 = a(ContactsContract.Data.CONTENT_URI, bool1).withValues(paramContentValues);
        bool1 = false;
        paramArrayList.add(localBuilder1.build());
      }
      if (i == 0)
      {
        paramContentValues.clear();
        paramContentValues.put("data1", paramLong1);
        paramContentValues.put("data2", paramContext.getString(2131362851));
        paramContentValues.put("data3", paramContext.getString(2131363112));
        paramContentValues.put("mimetype", "vnd.android.cursor.item/vnd.facebook.profile");
        paramContentValues.put("raw_contact_id", paramLong2);
        paramArrayList.add(a(ContactsContract.Data.CONTENT_URI, bool1).withValues(paramContentValues).build());
      }
      return;
    }
    else
    {
      int n = i;
      i1 = k;
      i2 = n;
      int i3 = j;
      i4 = m;
      i5 = i3;
      break label991;
      int i14 = i;
      i1 = k;
      i2 = i14;
      int i15 = j;
      i4 = m;
      i5 = i15;
    }
    while (true)
    {
      label991: int i6 = i2;
      k = i1;
      i = i6;
      int i7 = i5;
      m = i4;
      j = i7;
      break;
      label1018: if ((str4 != null) || (paramString3 == null))
        break label237;
      i13 = 1;
      break label185;
      label1034: m = 1;
      while (true)
      {
        int i11 = i;
        i1 = k;
        i2 = i11;
        int i12 = j;
        i4 = m;
        i5 = i12;
        break;
        label1064: k = 1;
      }
      int i9 = i;
      i1 = k;
      i2 = i9;
      i4 = m;
      i5 = 1;
    }
  }

  public static void a(Context paramContext, String paramString, List<FacebookStatus> paramList)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FacebookStatus localFacebookStatus = (FacebookStatus)localIterator.next();
      long l = b(localContentResolver, localFacebookStatus.a().mUserId);
      localContentValues.clear();
      if (l <= 0L)
        continue;
      localContentValues.put("presence_data_id", Long.valueOf(l));
      localContentValues.put("status", localFacebookStatus.b());
      localContentValues.put("status_ts", Long.valueOf(1000L * localFacebookStatus.c()));
      localContentValues.put("protocol", Integer.valueOf(-1));
      localContentValues.put("custom_protocol", "Facebook");
      localContentValues.put("im_account", paramString);
      localContentValues.put("im_handle", Long.valueOf(localFacebookStatus.a().mUserId));
      localContentValues.put("status_res_package", paramContext.getPackageName());
      localContentValues.put("status_icon", Integer.valueOf(2130838304));
      localContentValues.put("status_label", Integer.valueOf(2131362037));
      localArrayList.add(a(ContactsContract.StatusUpdates.CONTENT_URI, true).withValues(localContentValues).build());
      if (localArrayList.size() < 50)
        continue;
      a(localContentResolver, localArrayList);
      localArrayList.clear();
    }
    a(localContentResolver, localArrayList);
  }

  public static void a(Context paramContext, String paramString, List<FacebookFriendInfo> paramList, Map<Long, String> paramMap)
  {
    monitorenter;
    while (true)
    {
      ContentResolver localContentResolver;
      HashSet localHashSet;
      HashMap localHashMap1;
      Cursor localCursor;
      try
      {
        localContentResolver = paramContext.getContentResolver();
        localHashSet = Sets.a();
        localHashMap1 = new HashMap();
        localCursor = localContentResolver.query(ContactsContract.RawContacts.CONTENT_URI, PlatformStorage.SyncHashQuery.a, "account_type='com.facebook.auth.login' AND account_name=?", new String[] { paramString }, null);
        if (localCursor != null)
          continue;
        monitorexit;
        return;
      }
      finally
      {
        try
        {
          if (!localCursor.moveToNext())
            break label149;
          localHashMap1.put(Long.valueOf(localCursor.getLong(1)), new PlatformStorage.ExistingContact(localCursor.getLong(0), localCursor.getLong(2)));
          localHashSet.add(Long.valueOf(localCursor.getLong(0)));
        }
        finally
        {
          localCursor.close();
        }
        monitorexit;
      }
      label149: localCursor.close();
      if ((localHashSet != null) && (!localHashSet.isEmpty()))
        localHashSet.removeAll(a(localContentResolver));
      ArrayList localArrayList1 = new ArrayList();
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator1 = paramList.iterator();
      while (localIterator1.hasNext())
      {
        FacebookFriendInfo localFacebookFriendInfo3 = (FacebookFriendInfo)localIterator1.next();
        long l1 = localFacebookFriendInfo3.mUserId;
        PlatformStorage.ExistingContact localExistingContact2 = (PlatformStorage.ExistingContact)localHashMap1.get(Long.valueOf(l1));
        if (localExistingContact2 != null)
        {
          long l2 = localFacebookFriendInfo3.c();
          if (Long.valueOf(localExistingContact2.b).longValue() != l2)
          {
            localHashMap2.put(Long.valueOf(localExistingContact2.a), localFacebookFriendInfo3);
            if (localFacebookFriendInfo3.mImageUrl != null)
              paramMap.put(Long.valueOf(l1), localFacebookFriendInfo3.mImageUrl);
          }
          while (true)
          {
            localHashMap1.remove(Long.valueOf(l1));
            break;
            if ((localFacebookFriendInfo3.mImageUrl == null) || (!localHashSet.contains(Long.valueOf(localExistingContact2.a))))
              continue;
            paramMap.put(Long.valueOf(l1), localFacebookFriendInfo3.mImageUrl);
          }
        }
        localArrayList1.add(localFacebookFriendInfo3);
        if (localFacebookFriendInfo3.mImageUrl == null)
          continue;
        paramMap.put(Long.valueOf(l1), localFacebookFriendInfo3.mImageUrl);
      }
      if (localHashMap1.size() > 0)
      {
        ArrayList localArrayList2 = new ArrayList();
        Iterator localIterator2 = localHashMap1.values().iterator();
        while (localIterator2.hasNext())
        {
          PlatformStorage.ExistingContact localExistingContact1 = (PlatformStorage.ExistingContact)localIterator2.next();
          localArrayList2.add(c(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, localExistingContact1.a), true).build());
          if (localArrayList2.size() < 50)
            continue;
          a(paramContext.getContentResolver(), localArrayList2);
          localArrayList2.clear();
        }
        a(paramContext.getContentResolver(), localArrayList2);
      }
      if (localArrayList1.size() > 0)
      {
        ArrayList localArrayList3 = new ArrayList();
        ContentValues localContentValues1 = new ContentValues();
        Iterator localIterator3 = localArrayList1.iterator();
        while (localIterator3.hasNext())
        {
          FacebookFriendInfo localFacebookFriendInfo2 = (FacebookFriendInfo)localIterator3.next();
          a(paramContext, localArrayList3, localContentValues1, paramString, localFacebookFriendInfo2.mFirstName, localFacebookFriendInfo2.mLastName, localFacebookFriendInfo2.mCellPhone, localFacebookFriendInfo2.mOtherPhone, localFacebookFriendInfo2.mContactEmail, localFacebookFriendInfo2.mUserId, localFacebookFriendInfo2.c());
          if (localArrayList3.size() < 50)
            continue;
          a(paramContext.getContentResolver(), localArrayList3);
          localArrayList3.clear();
        }
        a(paramContext.getContentResolver(), localArrayList3);
      }
      if (localHashMap2.size() <= 0)
        continue;
      ArrayList localArrayList4 = new ArrayList();
      ContentValues localContentValues2 = new ContentValues();
      Iterator localIterator4 = localHashMap2.keySet().iterator();
      while (localIterator4.hasNext())
      {
        Long localLong = (Long)localIterator4.next();
        FacebookFriendInfo localFacebookFriendInfo1 = (FacebookFriendInfo)localHashMap2.get(localLong);
        a(paramContext, localContentResolver, localArrayList4, localContentValues2, paramString, localFacebookFriendInfo1.mFirstName, localFacebookFriendInfo1.mLastName, localFacebookFriendInfo1.mCellPhone, localFacebookFriendInfo1.mOtherPhone, localFacebookFriendInfo1.mContactEmail, Long.valueOf(localFacebookFriendInfo1.mUserId), localLong, localFacebookFriendInfo1.c());
        if (localArrayList4.size() < 50)
          continue;
        a(paramContext.getContentResolver(), localArrayList4);
        localArrayList4.clear();
      }
      a(localContentResolver, localArrayList4);
    }
  }

  private static void a(Context paramContext, ArrayList<ContentProviderOperation> paramArrayList, ContentValues paramContentValues, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong1, long paramLong2)
  {
    int i = paramArrayList.size();
    paramContentValues.clear();
    paramContentValues.put("is_restricted", Integer.valueOf(1));
    paramContentValues.put("sourceid", Long.valueOf(paramLong1));
    paramContentValues.put("sync1", Long.valueOf(paramLong2));
    paramContentValues.put("account_type", "com.facebook.auth.login");
    paramContentValues.put("account_name", paramString1);
    paramArrayList.add(a(ContactsContract.RawContacts.CONTENT_URI, true).withValues(paramContentValues).build());
    paramContentValues.clear();
    paramContentValues.put("data2", paramString2);
    paramContentValues.put("data3", paramString3);
    paramContentValues.put("mimetype", "vnd.android.cursor.item/name");
    ContentProviderOperation.Builder localBuilder1 = a(ContactsContract.Data.CONTENT_URI, false).withValues(paramContentValues);
    localBuilder1.withValueBackReference("raw_contact_id", i);
    paramArrayList.add(localBuilder1.build());
    if (!TextUtils.isEmpty(paramString4))
    {
      paramContentValues.clear();
      paramContentValues.put("data1", paramString4);
      paramContentValues.put("data2", Integer.valueOf(2));
      paramContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
      ContentProviderOperation.Builder localBuilder5 = a(ContactsContract.Data.CONTENT_URI, false).withValues(paramContentValues);
      localBuilder5.withValueBackReference("raw_contact_id", i);
      paramArrayList.add(localBuilder5.build());
    }
    if (!TextUtils.isEmpty(paramString5))
    {
      paramContentValues.clear();
      paramContentValues.put("data1", paramString5);
      paramContentValues.put("data2", Integer.valueOf(7));
      paramContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
      ContentProviderOperation.Builder localBuilder4 = a(ContactsContract.Data.CONTENT_URI, false).withValues(paramContentValues);
      localBuilder4.withValueBackReference("raw_contact_id", i);
      paramArrayList.add(localBuilder4.build());
    }
    if (!TextUtils.isEmpty(paramString6))
    {
      paramContentValues.clear();
      paramContentValues.put("data1", paramString6);
      paramContentValues.put("data2", Integer.valueOf(3));
      paramContentValues.put("mimetype", "vnd.android.cursor.item/email_v2");
      ContentProviderOperation.Builder localBuilder3 = a(ContactsContract.Data.CONTENT_URI, false).withValues(paramContentValues);
      localBuilder3.withValueBackReference("raw_contact_id", i);
      paramArrayList.add(localBuilder3.build());
    }
    paramContentValues.clear();
    paramContentValues.put("data1", Long.valueOf(paramLong1));
    paramContentValues.put("data2", paramContext.getString(2131362851));
    paramContentValues.put("data3", paramContext.getString(2131363112));
    paramContentValues.put("mimetype", "vnd.android.cursor.item/vnd.facebook.profile");
    ContentProviderOperation.Builder localBuilder2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValues(paramContentValues);
    localBuilder2.withValueBackReference("raw_contact_id", i);
    paramArrayList.add(localBuilder2.build());
  }

  public static boolean a(Context paramContext)
  {
    ProviderInfo localProviderInfo = paramContext.getPackageManager().resolveContentProvider("com.android.contacts", 0);
    int i = 0;
    if (localProviderInfo == null);
    String[] arrayOfString;
    do
    {
      Resources localResources;
      int j;
      do
      {
        do
        {
          return i;
          localResources = paramContext.createPackageContext(localProviderInfo.packageName, 0).getResources();
          i = 0;
        }
        while (localResources == null);
        j = localResources.getIdentifier("unrestricted_packages", "array", localProviderInfo.packageName);
        i = 0;
      }
      while (j == 0);
      arrayOfString = localResources.getStringArray(j);
      i = 0;
    }
    while (arrayOfString == null);
    String str = paramContext.getPackageName();
    for (int k = 0; ; k++)
    {
      int m = arrayOfString.length;
      i = 0;
      if (k >= m)
        break;
      if (!arrayOfString[k].equals(str))
        continue;
      i = 1;
      break;
    }
  }

  private static long b(ContentResolver paramContentResolver, long paramLong)
  {
    Uri localUri = ContactsContract.Data.CONTENT_URI;
    String[] arrayOfString1 = PlatformStorage.ProfileQuery.a;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramLong);
    Cursor localCursor = paramContentResolver.query(localUri, arrayOfString1, "mimetype='vnd.android.cursor.item/vnd.facebook.profile' AND data1=?", arrayOfString2, null);
    if (localCursor != null);
    while (true)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          long l2 = localCursor.getLong(0);
          l1 = l2;
          return l1;
        }
      }
      finally
      {
        if (localCursor == null)
          continue;
        localCursor.close();
      }
      long l1 = 0L;
    }
  }

  static ContentProviderOperation.Builder b(Uri paramUri, boolean paramBoolean)
  {
    return ContentProviderOperation.newUpdate(a(paramUri)).withYieldAllowed(paramBoolean);
  }

  public static void b(Context paramContext)
  {
    if (!PlatformUtils.a(paramContext));
    for (boolean bool = true; ; bool = false)
    {
      Assert.b(bool);
      Uri localUri = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("account_type");
      localStringBuilder.append("='");
      localStringBuilder.append("com.facebook.auth.login");
      localStringBuilder.append("'");
      paramContext.getContentResolver().delete(localUri, localStringBuilder.toString(), null);
      return;
    }
  }

  static ContentProviderOperation.Builder c(Uri paramUri, boolean paramBoolean)
  {
    return ContentProviderOperation.newDelete(a(paramUri)).withYieldAllowed(paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.PlatformStorage
 * JD-Core Version:    0.6.0
 */