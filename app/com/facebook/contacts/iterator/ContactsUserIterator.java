package com.facebook.contacts.iterator;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.contacts.data.ContactSerialization;
import com.facebook.contacts.data.ContactsDatabaseSupplier;
import com.facebook.contacts.data.ContactsDbSchemaPart;
import com.facebook.contacts.models.ContactPicCropInfoGenerator;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.common.names.NameNormalizer;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserBuilder;
import com.facebook.orca.users.UserKey;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ContactsUserIterator
  implements FacebookUserIterator
{
  private static final Class<?> a = ContactsUserIterator.class;
  private static final String[] f = { "c.data" };
  private static final CharMatcher g = CharMatcher.anyOf("0123456789+");
  private final ContactsDatabaseSupplier b;
  private final ContactSerialization c;
  private final ContactPicCropInfoGenerator d;
  private Cursor e;

  public ContactsUserIterator(ContactsDatabaseSupplier paramContactsDatabaseSupplier, ContactSerialization paramContactSerialization, ContactPicCropInfoGenerator paramContactPicCropInfoGenerator)
  {
    this.b = paramContactsDatabaseSupplier;
    this.c = paramContactSerialization;
    this.d = paramContactPicCropInfoGenerator;
  }

  public void a()
  {
    BLog.b(a, "init");
    this.e = null;
  }

  public void a(int paramInt)
  {
    BLog.b(a, "initTopFriends: " + paramInt);
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("contacts_indexed_data AS idx INNER JOIN contact_summaries AS c ON idx.contact_id = c.contact_id");
    this.e = localSQLiteQueryBuilder.query(this.b.b(), f, "idx.type = ?", new String[] { "communication_rank" }, null, null, "CAST(idx.indexed_data AS NUMERIC) DESC", Integer.toString(paramInt));
  }

  public void a(ImmutableCollection<UserKey> paramImmutableCollection)
  {
    BLog.b(a, "initWithUserKeyExclusion: " + paramImmutableCollection);
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("contacts_indexed_data AS idx INNER JOIN contact_summaries AS c ON idx.contact_id = c.contact_id");
    this.e = localSQLiteQueryBuilder.query(this.b.b(), f, "idx.type = ? AND idx.indexed_data NOT IN " + SqlUtil.b(UserKey.b(paramImmutableCollection)), new String[] { "profile_fbid" }, null, null, null);
  }

  public void a(String paramString, int paramInt)
  {
    BLog.b(a, "initWithSearchRestrict: " + paramString + " max: " + paramInt);
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("contacts_indexed_data AS idx INNER JOIN contact_summaries AS c ON idx.contact_id = c.contact_id");
    localSQLiteQueryBuilder.setDistinct(true);
    localSQLiteQueryBuilder.appendWhere("(idx.type = ? AND idx.indexed_data GLOB '");
    localSQLiteQueryBuilder.appendWhere(NameNormalizer.a(paramString));
    localSQLiteQueryBuilder.appendWhere("*')");
    String str = g.retainFrom(paramString);
    if (str.length() > 0)
    {
      localSQLiteQueryBuilder.appendWhere("OR (idx.type IN ");
      localSQLiteQueryBuilder.appendWhere(SqlUtil.b(ContactsDbSchemaPart.a));
      localSQLiteQueryBuilder.appendWhere(" AND idx.indexed_data GLOB '");
      localSQLiteQueryBuilder.appendWhere(str);
      localSQLiteQueryBuilder.appendWhere("*')");
    }
    this.e = localSQLiteQueryBuilder.query(this.b.b(), f, null, new String[] { "name" }, null, null, null);
  }

  public void a(Collection<UserKey> paramCollection)
  {
    BLog.b(a, "initWithUserKeyRestrict: " + paramCollection);
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("contacts_indexed_data AS idx INNER JOIN contact_summaries AS c ON idx.contact_id = c.contact_id");
    Collection localCollection = UserKey.b(paramCollection);
    if (localCollection.isEmpty());
    StringBuilder localStringBuilder;
    for (String str1 = null; ; str1 = localStringBuilder.toString())
    {
      this.e = localSQLiteQueryBuilder.query(this.b.b(), f, "idx.type = ? AND idx.indexed_data IN " + SqlUtil.b(localCollection), new String[] { "profile_fbid" }, null, null, str1);
      return;
      localStringBuilder = new StringBuilder("CASE idx.indexed_data ");
      Iterator localIterator = localCollection.iterator();
      for (int i = 0; localIterator.hasNext(); i++)
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append("WHEN ");
        DatabaseUtils.appendEscapedSQLString(localStringBuilder, str2);
        localStringBuilder.append(" THEN ");
        localStringBuilder.append(i);
        localStringBuilder.append(" ");
      }
      localStringBuilder.append("END");
    }
  }

  public void b()
  {
    BLog.b(a, "initMobileAppDataFriends");
    this.e = null;
  }

  public void c()
  {
    BLog.b(a, "initFavoriteFriends");
    Cursor localCursor = this.b.b().query("favorite_contacts", new String[] { "fbid" }, null, null, null, null, "display_order ASC");
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(0);
      localArrayList.add(new UserKey(User.Type.FACEBOOK, str));
    }
    BLog.b(a, "Looking up favorites by user ID: " + localArrayList);
    a(localArrayList);
  }

  public User d()
  {
    User localUser = null;
    if (this.e == null)
      BLog.b(a, "next: not initialized, skipping");
    while (true)
    {
      return localUser;
      if (this.e.moveToNext())
        break;
      BLog.b(a, "next: cursor empty");
      localUser = null;
    }
    ContactSummary localContactSummary = this.c.b(this.e.getString(0));
    UserBuilder localUserBuilder = new UserBuilder();
    if (localContactSummary.getProfileFbid() != null)
      localUserBuilder.a(User.Type.FACEBOOK, localContactSummary.getProfileFbid());
    while (true)
    {
      localUserBuilder.a(localContactSummary.getName()).e(localContactSummary.getBigPictureUrl()).d(localContactSummary.getSmallPictureUrl()).a(this.d.a(localContactSummary)).b(this.d.b(localContactSummary)).a(localContactSummary.getCommunicationRank()).a(localContactSummary.getIsMobilePushable());
      localUser = localUserBuilder.w();
      BLog.b(a, "next: " + localUser);
      break;
      localUserBuilder.a(User.Type.FACEBOOK_CONTACT, localContactSummary.getContactId());
    }
  }

  public void e()
  {
    BLog.b(a, "closing");
    if (this.e != null)
    {
      this.e.close();
      this.e = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.iterator.ContactsUserIterator
 * JD-Core Version:    0.6.0
 */