package com.facebook.contacts.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.server.FetchContactResult;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DbFetchContactHandler
{
  private static final String[] c = { "data" };
  private static final String[] d = { "fb.indexed_data", "phone.indexed_data" };
  private final ContactsDatabaseSupplier a;
  private final ObjectMapper b;

  public DbFetchContactHandler(ContactsDatabaseSupplier paramContactsDatabaseSupplier, ObjectMapper paramObjectMapper)
  {
    this.a = paramContactsDatabaseSupplier;
    this.b = paramObjectMapper;
  }

  private String a(UserKey paramUserKey, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.b();
    Cursor localCursor;
    if (paramUserKey.a() == User.Type.FACEBOOK)
    {
      String[] arrayOfString3 = c;
      String[] arrayOfString4 = new String[2];
      arrayOfString4[0] = "profile_fbid";
      arrayOfString4[1] = paramUserKey.b();
      localCursor = localSQLiteDatabase.query(paramString, arrayOfString3, "contact_id IN (SELECT contact_id FROM contacts_indexed_data WHERE type = ? AND indexed_data = ?)", arrayOfString4, null, null, null);
    }
    try
    {
      boolean bool = localCursor.moveToNext();
      Object localObject2 = null;
      if (bool)
      {
        String str = localCursor.getString(0);
        localObject2 = str;
      }
      return localObject2;
      String[] arrayOfString1 = c;
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = paramUserKey.b();
      localCursor = localSQLiteDatabase.query(paramString, arrayOfString1, "contact_id = ?", arrayOfString2, null, null, null);
    }
    finally
    {
      localCursor.close();
    }
  }

  private ContactSummary c(UserKey paramUserKey)
  {
    String str = a(paramUserKey, "contact_summaries");
    if (str == null);
    for (ContactSummary localContactSummary = null; ; localContactSummary = (ContactSummary)this.b.readValue(str, ContactSummary.class))
      return localContactSummary;
  }

  private ContactDetails d(UserKey paramUserKey)
  {
    String str = a(paramUserKey, "contact_details");
    if (str == null);
    for (ContactDetails localContactDetails = null; ; localContactDetails = (ContactDetails)this.b.readValue(str, ContactDetails.class))
      return localContactDetails;
  }

  public FetchContactResult a(UserKey paramUserKey)
  {
    boolean bool;
    ContactSummary localContactSummary;
    ContactDetails localContactDetails;
    if ((paramUserKey.a() == User.Type.FACEBOOK) || (paramUserKey.a() == User.Type.FACEBOOK_CONTACT))
    {
      bool = true;
      Preconditions.checkArgument(bool);
      localContactSummary = c(paramUserKey);
      localContactDetails = d(paramUserKey);
      if ((localContactSummary == null) || (localContactDetails == null))
        break label74;
    }
    label74: for (FetchContactResult localFetchContactResult = new FetchContactResult(DataFreshnessResult.FROM_CACHE_STALE, System.currentTimeMillis(), localContactSummary, localContactDetails); ; localFetchContactResult = FetchContactResult.a)
    {
      return localFetchContactResult;
      bool = false;
      break;
    }
  }

  public ImmutableMultimap<UserKey, UserKey> a(Collection<UserKey> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0));
    ImmutableMultimap.Builder localBuilder;
    for (ImmutableMultimap localImmutableMultimap = ImmutableMultimap.c(); ; localImmutableMultimap = localBuilder.a())
    {
      return localImmutableMultimap;
      localBuilder = ImmutableMultimap.j();
      ArrayList localArrayList1 = Lists.a();
      ArrayList localArrayList2 = Lists.a();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        UserKey localUserKey = (UserKey)localIterator.next();
        if (localUserKey.a() == User.Type.FACEBOOK)
        {
          localArrayList1.add(localUserKey.b());
          continue;
        }
        localArrayList2.add(localUserKey.b());
      }
      SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
      localSQLiteQueryBuilder.setTables("(SELECT type, contact_id, indexed_data FROM contacts_indexed_data WHERE type = 'profile_fbid') AS fb INNER JOIN (SELECT type, contact_id, indexed_data FROM contacts_indexed_data WHERE type = 'phone_verified') AS phone ON fb.contact_id = phone.contact_id");
      String str = "fb.contact_id IN (SELECT contact_id FROM contacts_indexed_data WHERE (indexed_data IN " + SqlUtil.b(localArrayList2) + " AND " + "type = '" + "phone_verified" + "')" + " OR " + "(indexed_data IN " + SqlUtil.b(localArrayList1) + " AND " + "type = '" + "profile_fbid" + "')" + ")";
      Cursor localCursor = localSQLiteQueryBuilder.query(this.a.b(), d, str, null, null, null, null, null);
      try
      {
        if (localCursor.moveToNext())
          localBuilder.a(new UserKey(User.Type.FACEBOOK, localCursor.getString(0)), new UserKey(User.Type.PHONE_NUMBER, localCursor.getString(1)));
      }
      finally
      {
        localCursor.close();
      }
    }
  }

  public ImmutableMultimap<UserKey, UserKey> b(UserKey paramUserKey)
  {
    return a(ImmutableList.a(paramUserKey));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.DbFetchContactHandler
 * JD-Core Version:    0.6.0
 */