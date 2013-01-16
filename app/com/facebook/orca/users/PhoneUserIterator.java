package com.facebook.orca.users;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.ContactsContract.RawContactsEntity;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil.SmsAddress;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.AndExpression;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class PhoneUserIterator
{
  private static final String a = PhoneUserIterator.class.getName();
  private static final String[] f = { "_id" };
  private static final String[] g = { "_id", "contact_id", "deleted", "data_version", "mimetype", "is_primary", "is_super_primary", "data_version", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9" };
  private static final String[] h = { "_id" };
  private final ContentResolver b;
  private final OrcaPhoneNumberUtil c;
  private Cursor d;
  private UserBuilder e;

  @Inject
  public PhoneUserIterator(ContentResolver paramContentResolver, OrcaPhoneNumberUtil paramOrcaPhoneNumberUtil)
  {
    this.b = paramContentResolver;
    this.c = paramOrcaPhoneNumberUtil;
  }

  private void a(String paramString)
  {
    SqlQueryBuilder.AndExpression localAndExpression = SqlQueryBuilder.a();
    if (paramString != null)
      localAndExpression.a(SqlQueryBuilder.a(paramString));
    localAndExpression.a(SqlQueryBuilder.a("mimetype IN " + SqlUtil.a(new String[] { "vnd.android.cursor.item/name", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2" })));
    this.d = this.b.query(ContactsContract.RawContactsEntity.CONTENT_URI, g, localAndExpression.a(), localAndExpression.b(), "contact_id");
  }

  private void a(String paramString, int paramInt, List<Integer> paramList)
  {
    Uri localUri = ContactsContract.Contacts.CONTENT_FILTER_URI.buildUpon().appendPath(paramString).build();
    Cursor localCursor = this.b.query(localUri, f, null, null, null);
    label85: 
    try
    {
      if (localCursor.moveToNext())
      {
        if (paramList.size() >= paramInt)
          break label85;
        paramList.add(Integer.valueOf(localCursor.getInt(0)));
      }
    }
    finally
    {
      localCursor.close();
    }
  }

  private void a(Collection<UserKey> paramCollection, PhoneUserIterator.Exclusion paramExclusion)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      UserKey localUserKey = (UserKey)localIterator.next();
      if ((localUserKey.a() == User.Type.ADDRESS_BOOK) || (localUserKey.a() == User.Type.PHONE_NUMBER))
        continue;
      throw new IllegalArgumentException("Cannot look up phone for user key " + localUserKey);
    }
    Collection localCollection = UserKey.b(paramCollection);
    if (paramExclusion == PhoneUserIterator.Exclusion.EXCLUDE);
    for (String str1 = " NOT IN "; ; str1 = " IN ")
    {
      String str2 = "contact_id" + str1 + SqlUtil.b(localCollection);
      BLog.b(a, "Searching for contact IDs where: " + str2);
      a(str2);
      if (paramCollection.size() != this.d.getCount())
        BLog.d(a, "Looked for " + paramCollection.size() + " contacts, but only found " + this.d.getCount());
      return;
    }
  }

  private void a(List<Integer> paramList)
  {
    String str = "contact_id IN " + SqlUtil.b(paramList);
    this.d = this.b.query(ContactsContract.RawContactsEntity.CONTENT_URI, g, str, null, "contact_id");
  }

  private UserPhoneNumber b(String paramString, int paramInt)
  {
    Tracer localTracer = Tracer.a("parseSmsAddress", "parseSmsAddress");
    boolean bool = this.c.a(paramString).a();
    UserPhoneNumber localUserPhoneNumber = null;
    if (bool)
      localUserPhoneNumber = this.c.a(paramString, paramInt);
    localTracer.a();
    return localUserPhoneNumber;
  }

  private void b(String paramString, int paramInt, List<Integer> paramList)
  {
    Uri localUri = ContactsContract.PhoneLookup.CONTENT_FILTER_URI.buildUpon().appendPath(paramString).build();
    Cursor localCursor = this.b.query(localUri, f, null, null, null);
    label85: 
    try
    {
      if (localCursor.moveToNext())
      {
        if (paramList.size() >= paramInt)
          break label85;
        paramList.add(Integer.valueOf(localCursor.getInt(0)));
      }
    }
    finally
    {
      localCursor.close();
    }
  }

  public void a()
  {
    a(null);
    this.d = this.b.query(ContactsContract.RawContactsEntity.CONTENT_URI, g, null, null, "contact_id");
  }

  public void a(String paramString, int paramInt)
  {
    ArrayList localArrayList = Lists.a();
    a(paramString, paramInt, localArrayList);
    b(paramString, paramInt, localArrayList);
    a(localArrayList);
  }

  public void a(Collection<UserKey> paramCollection)
  {
    Tracer localTracer = Tracer.a("initWithExcludedUserKeys");
    a(paramCollection, PhoneUserIterator.Exclusion.EXCLUDE);
    localTracer.a();
  }

  // ERROR //
  public Collection<UserKey> b()
  {
    // Byte code:
    //   0: invokestatic 296	com/google/common/collect/Lists:a	()Ljava/util/ArrayList;
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 75	com/facebook/orca/users/PhoneUserIterator:b	Landroid/content/ContentResolver;
    //   8: getstatic 316	android/provider/ContactsContract$Contacts:CONTENT_STREQUENT_URI	Landroid/net/Uri;
    //   11: getstatic 68	com/facebook/orca/users/PhoneUserIterator:h	[Ljava/lang/String;
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 131	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore 5
    //   22: aload 5
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +32 -> 58
    //   29: getstatic 28	com/facebook/orca/users/PhoneUserIterator:a	Ljava/lang/String;
    //   32: ldc_w 318
    //   35: invokestatic 320	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: ifnull +9 -> 48
    //   42: aload_3
    //   43: invokeinterface 184 1 0
    //   48: aload_0
    //   49: aload_1
    //   50: getstatic 323	com/facebook/orca/users/PhoneUserIterator$Exclusion:INCLUDE	Lcom/facebook/orca/users/PhoneUserIterator$Exclusion;
    //   53: invokespecial 310	com/facebook/orca/users/PhoneUserIterator:a	(Ljava/util/Collection;Lcom/facebook/orca/users/PhoneUserIterator$Exclusion;)V
    //   56: aload_1
    //   57: areturn
    //   58: aload_3
    //   59: invokeinterface 251 1 0
    //   64: iconst_1
    //   65: if_icmpge +55 -> 120
    //   68: getstatic 28	com/facebook/orca/users/PhoneUserIterator:a	Ljava/lang/String;
    //   71: ldc_w 325
    //   74: invokestatic 327	com/facebook/orca/debug/BLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: goto -39 -> 38
    //   80: astore_2
    //   81: getstatic 28	com/facebook/orca/users/PhoneUserIterator:a	Ljava/lang/String;
    //   84: new 93	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 329
    //   94: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 320	com/facebook/orca/debug/BLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_3
    //   108: ifnull -60 -> 48
    //   111: aload_3
    //   112: invokeinterface 184 1 0
    //   117: goto -69 -> 48
    //   120: getstatic 28	com/facebook/orca/users/PhoneUserIterator:a	Ljava/lang/String;
    //   123: new 93	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 331
    //   133: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_3
    //   137: invokeinterface 251 1 0
    //   142: invokevirtual 256	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc_w 333
    //   148: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 245	com/facebook/orca/debug/BLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_3
    //   158: invokeinterface 161 1 0
    //   163: ifeq -125 -> 38
    //   166: aload_1
    //   167: new 202	com/facebook/orca/users/UserKey
    //   170: dup
    //   171: getstatic 211	com/facebook/orca/users/User$Type:ADDRESS_BOOK	Lcom/facebook/orca/users/User$Type;
    //   174: aload_3
    //   175: iconst_0
    //   176: invokeinterface 337 2 0
    //   181: invokespecial 340	com/facebook/orca/users/UserKey:<init>	(Lcom/facebook/orca/users/User$Type;Ljava/lang/String;)V
    //   184: invokeinterface 181 2 0
    //   189: pop
    //   190: goto -33 -> 157
    //   193: astore 4
    //   195: aload_3
    //   196: ifnull +9 -> 205
    //   199: aload_3
    //   200: invokeinterface 184 1 0
    //   205: aload 4
    //   207: athrow
    //   208: astore 4
    //   210: aconst_null
    //   211: astore_3
    //   212: goto -17 -> 195
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_3
    //   218: goto -137 -> 81
    //
    // Exception table:
    //   from	to	target	type
    //   29	38	80	java/lang/Exception
    //   58	77	80	java/lang/Exception
    //   120	190	80	java/lang/Exception
    //   29	38	193	finally
    //   58	77	193	finally
    //   81	107	193	finally
    //   120	190	193	finally
    //   4	22	208	finally
    //   4	22	215	java/lang/Exception
  }

  public void c()
  {
    if (this.d != null)
    {
      this.d.close();
      this.d = null;
    }
  }

  public int d()
  {
    Cursor localCursor = this.d;
    int i = 0;
    if (localCursor != null)
    {
      long l1 = -1L;
      this.d.moveToPosition(-1);
      while (this.d.moveToNext())
      {
        if (this.d.getInt(2) != 0)
          continue;
        long l2 = this.d.getLong(1);
        if (l2 == l1)
          continue;
        i++;
        l1 = l2;
      }
      this.d.moveToPosition(-1);
    }
    return i;
  }

  public User e()
  {
    String str1;
    int j;
    String str2;
    User localUser;
    while (true)
      if (this.d.moveToNext())
      {
        long l1 = this.d.getLong(0);
        long l2 = this.d.getLong(1);
        int i = this.d.getInt(2);
        this.d.getInt(3);
        str1 = this.d.getString(4);
        this.d.getInt(5);
        j = this.d.getInt(6);
        if (i != 0)
        {
          BLog.a(a, "Skipping deleted raw contact row: " + l1);
          continue;
        }
        str2 = Long.toString(l2);
        if (this.e != null)
          break;
        this.e = new UserBuilder();
        this.e.a(User.Type.ADDRESS_BOOK, str2);
        localUser = null;
      }
    while (true)
    {
      if (this.e.k() == null)
      {
        PicCropInfo localPicCropInfo = PicCropInfo.a(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, this.e.b()).toString());
        BLog.b(a, "Using pic crop info for contact " + this.e.b() + " " + localPicCropInfo);
        this.e.a(localPicCropInfo);
      }
      Name localName2;
      int i1;
      if ("vnd.android.cursor.item/name".equals(str1))
      {
        String str5 = this.d.getString(8);
        Name localName1 = new Name(this.d.getString(9), this.d.getString(10), str5);
        int n = localName1.f().length();
        localName2 = this.e.h();
        if (localName2 == null)
        {
          i1 = 0;
          label335: if ((n > i1) || ((j != 0) && (n > 0)))
            this.e.a(localName1);
          label362: if (localUser == null)
            break;
        }
      }
      while (true)
      {
        return localUser;
        if (Objects.equal(str2, this.e.b()))
          break label671;
        localUser = this.e.w();
        this.e = new UserBuilder();
        this.e.a(User.Type.ADDRESS_BOOK, str2);
        break;
        i1 = localName2.f().length();
        break label335;
        if ("vnd.android.cursor.item/email_v2".equals(str1))
        {
          String str4 = this.d.getString(8);
          int m = this.d.getInt(9);
          this.d.getString(10);
          if (StringUtil.a(str4))
            break label362;
          Object localObject2 = this.e.c();
          if (localObject2 == null)
          {
            localObject2 = Lists.a();
            this.e.a((List)localObject2);
          }
          ((List)localObject2).add(new UserEmailAddress(str4, m));
          break label362;
        }
        if (!"vnd.android.cursor.item/phone_v2".equals(str1))
          break label362;
        String str3 = this.d.getString(8);
        int k = this.d.getInt(9);
        this.d.getString(10);
        UserPhoneNumber localUserPhoneNumber = b(str3, k);
        if (localUserPhoneNumber == null)
          break label362;
        Object localObject1 = this.e.d();
        if (localObject1 == null)
        {
          localObject1 = Lists.a();
          this.e.b((List)localObject1);
        }
        ((List)localObject1).add(localUserPhoneNumber);
        break label362;
        if (this.e != null)
        {
          localUser = this.e.w();
          this.e = null;
          continue;
        }
        localUser = null;
      }
      label671: localUser = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.PhoneUserIterator
 * JD-Core Version:    0.6.0
 */