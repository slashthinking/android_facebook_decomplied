package com.facebook.contacts.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactPhone;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.common.names.NameSplitter;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.SqlUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;

public class DbInsertContactHandler
{
  private static final Class<?> a = DbInsertContactHandler.class;
  private final ContactsDatabaseSupplier b;
  private final ContactSerialization c;
  private final DbInsertContactHandler.ContactNameLookupBuilder d;
  private final NameSplitter e;
  private final DbContactsPropertyUtil f;
  private final PhoneNumberUtil g;
  private final Clock h;

  @Inject
  public DbInsertContactHandler(ContactsDatabaseSupplier paramContactsDatabaseSupplier, ContactSerialization paramContactSerialization, DbInsertContactHandler.ContactNameLookupBuilder paramContactNameLookupBuilder, NameSplitter paramNameSplitter, DbContactsPropertyUtil paramDbContactsPropertyUtil, PhoneNumberUtil paramPhoneNumberUtil, Clock paramClock)
  {
    this.b = paramContactsDatabaseSupplier;
    this.c = paramContactSerialization;
    this.d = paramContactNameLookupBuilder;
    this.e = paramNameSplitter;
    this.f = paramDbContactsPropertyUtil;
    this.g = paramPhoneNumberUtil;
    this.h = paramClock;
  }

  private void a(Name paramName, ImmutableSet.Builder<String> paramBuilder)
  {
    Preconditions.checkNotNull(paramName);
    Preconditions.checkNotNull(paramBuilder);
    String[] arrayOfString = new String[10];
    int i = this.e.a(arrayOfString, paramName.f());
    for (int j = 0; j < i; j++)
      paramBuilder.b(arrayOfString[j]);
    if (paramName.b())
      paramBuilder.b(paramName.getLastName());
    if (paramName.a())
      paramBuilder.b(paramName.getFirstName());
  }

  private void a(ImmutableMultimap<String, Phonenumber.PhoneNumber> paramImmutableMultimap, ImmutableList.Builder<ContentValues> paramBuilder)
  {
    Iterator localIterator = paramImmutableMultimap.n().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      Phonenumber.PhoneNumber localPhoneNumber = (Phonenumber.PhoneNumber)localEntry.getValue();
      ContentValues localContentValues1 = new ContentValues();
      localContentValues1.put("type", "phone_e164");
      localContentValues1.put("contact_id", str1);
      localContentValues1.put("indexed_data", this.g.format(localPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164));
      paramBuilder.b(localContentValues1);
      String str2 = this.g.getNationalSignificantNumber(localPhoneNumber);
      ContentValues localContentValues2 = new ContentValues();
      localContentValues2.put("type", "phone_national");
      localContentValues2.put("contact_id", str1);
      localContentValues2.put("indexed_data", str2);
      paramBuilder.b(localContentValues2);
      int i = this.g.getLengthOfGeographicalAreaCode(localPhoneNumber);
      if (i <= 0)
        continue;
      String str3 = str2.substring(i);
      ContentValues localContentValues3 = new ContentValues();
      localContentValues3.put("type", "phone_local");
      localContentValues3.put("contact_id", str1);
      localContentValues3.put("indexed_data", str3);
      paramBuilder.b(localContentValues3);
    }
  }

  private void a(String paramString, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fbid", paramString);
    localContentValues.put("display_order", Integer.valueOf(paramInt));
    localSQLiteDatabase.replaceOrThrow("favorite_contacts", "", localContentValues);
  }

  private void a(String paramString, Name paramName)
  {
    if (paramName == null);
    while (true)
    {
      return;
      ImmutableSet.Builder localBuilder = ImmutableSet.e();
      a(paramName, localBuilder);
      String[] arrayOfString = (String[])localBuilder.b().toArray(new String[0]);
      this.d.a(paramString, paramName.getDisplayName(), arrayOfString, arrayOfString.length, this.e.a(0));
    }
  }

  public void a(ContactSummary paramContactSummary)
  {
    a(paramContactSummary, null);
  }

  public void a(ContactSummary paramContactSummary, ContactDetails paramContactDetails)
  {
    Preconditions.checkNotNull(paramContactSummary);
    Tracer localTracer = Tracer.a("insertContactIntoDatabase (" + paramContactSummary.getContactId() + ")");
    ContentValues localContentValues1 = new ContentValues();
    localContentValues1.put("contact_id", paramContactSummary.getContactId());
    localContentValues1.put("data", this.c.a(paramContactSummary));
    ContentValues localContentValues2;
    if (paramContactDetails != null)
    {
      localContentValues2 = new ContentValues();
      localContentValues2.put("contact_id", paramContactDetails.getContactId());
      localContentValues2.put("data", this.c.a(paramContactDetails));
    }
    for (ContentValues localContentValues3 = localContentValues2; ; localContentValues3 = null)
    {
      ImmutableList.Builder localBuilder = ImmutableList.e();
      int i;
      ContentValues localContentValues4;
      Object localObject1;
      ImmutableMultimap.Builder localBuilder1;
      Iterator localIterator2;
      if ((paramContactSummary.getCanMessage()) && (!paramContactSummary.getIsMemorialized()))
      {
        i = 1;
        if (i == 0)
          break label790;
        if (paramContactSummary.getProfileFbid() != null)
        {
          ContentValues localContentValues8 = new ContentValues();
          localContentValues8.put("type", "profile_fbid");
          localContentValues8.put("contact_id", paramContactSummary.getContactId());
          localContentValues8.put("indexed_data", paramContactSummary.getProfileFbid());
          localContentValues4 = localContentValues8;
          float f1 = paramContactSummary.getCommunicationRank();
          boolean bool = f1 < 0.0F;
          localObject1 = null;
          if (bool)
          {
            ContentValues localContentValues9 = new ContentValues();
            localContentValues9.put("type", "communication_rank");
            localContentValues9.put("contact_id", paramContactSummary.getContactId());
            localContentValues9.put("indexed_data", Float.valueOf(f1));
            localObject1 = localContentValues9;
          }
          localBuilder1 = ImmutableMultimap.j();
          localIterator2 = paramContactSummary.getPhones().iterator();
        }
      }
      else
      {
        while (true)
          while (true)
          {
            if (!localIterator2.hasNext())
              break label436;
            ContactPhone localContactPhone = (ContactPhone)localIterator2.next();
            try
            {
              Phonenumber.PhoneNumber localPhoneNumber = this.g.parse(localContactPhone.getUniversalNumber(), null);
              localBuilder1.a(paramContactSummary.getContactId(), localPhoneNumber);
              if (!localContactPhone.getIsVerified())
                continue;
              ContentValues localContentValues10 = new ContentValues();
              localContentValues10.put("type", "phone_verified");
              localContentValues10.put("contact_id", paramContactSummary.getContactId());
              localContentValues10.put("indexed_data", localContactPhone.getUniversalNumber());
              localBuilder.b(localContentValues10);
              continue;
              i = 0;
            }
            catch (NumberParseException localNumberParseException)
            {
              BLog.e(a, "Error parsing invalid E.164 number: " + localContactPhone.getUniversalNumber() + " Error: " + localNumberParseException);
            }
          }
        label436: a(localBuilder1.a(), localBuilder);
      }
      while (true)
      {
        ContentValues localContentValues5;
        if (paramContactSummary.getCanMessage())
        {
          localContentValues5 = new ContentValues();
          localContentValues5.put("type", "can_message");
          localContentValues5.put("contact_id", paramContactSummary.getContactId());
          localContentValues5.put("indexed_data", Boolean.valueOf(true));
        }
        SQLiteDatabase localSQLiteDatabase;
        for (ContentValues localContentValues6 = localContentValues5; ; localContentValues6 = null)
        {
          localSQLiteDatabase = this.b.b();
          localSQLiteDatabase.beginTransaction();
          try
          {
            localSQLiteDatabase.replaceOrThrow("contact_summaries", null, localContentValues1);
            if (localContentValues3 != null)
              localSQLiteDatabase.replaceOrThrow("contact_details", null, localContentValues3);
            String[] arrayOfString = new String[1];
            arrayOfString[0] = paramContactSummary.getContactId();
            localSQLiteDatabase.delete("contacts_indexed_data", "contact_id=?", arrayOfString);
            if (i != 0)
            {
              a(paramContactSummary.getContactId(), paramContactSummary.getName());
              a(paramContactSummary.getContactId(), paramContactSummary.getPhoneticName());
            }
            if (localContentValues4 != null)
              localSQLiteDatabase.insertOrThrow("contacts_indexed_data", null, localContentValues4);
            if (localObject1 != null)
              localSQLiteDatabase.insertOrThrow("contacts_indexed_data", null, localObject1);
            Iterator localIterator1 = localBuilder.b().iterator();
            while (localIterator1.hasNext())
            {
              ContentValues localContentValues7 = (ContentValues)localIterator1.next();
              BLog.b(a, "Inserting phone lookup: " + localContentValues7);
              localSQLiteDatabase.insertOrThrow("contacts_indexed_data", null, localContentValues7);
            }
          }
          finally
          {
            localSQLiteDatabase.endTransaction();
          }
        }
        if (localContentValues6 != null)
        {
          BLog.b(a, "Inserting can-message lookup: " + localContentValues6);
          localSQLiteDatabase.insertOrThrow("contacts_indexed_data", null, localContentValues6);
        }
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
        localTracer.a();
        return;
        localContentValues4 = null;
        break;
        label790: localContentValues4 = null;
        localObject1 = null;
      }
    }
  }

  public void a(ImmutableCollection<String> paramImmutableCollection)
  {
    if (paramImmutableCollection.isEmpty());
    while (true)
    {
      return;
      SQLiteDatabase localSQLiteDatabase = this.b.b();
      String str = "contact_id IN " + SqlUtil.b(paramImmutableCollection);
      localSQLiteDatabase.beginTransaction();
      try
      {
        localSQLiteDatabase.delete("contact_summaries", str, null);
        localSQLiteDatabase.delete("contact_details", str, null);
        localSQLiteDatabase.delete("contacts_indexed_data", str, null);
        localSQLiteDatabase.setTransactionSuccessful();
        localSQLiteDatabase.endTransaction();
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
    }
  }

  public void a(ImmutableCollection<ContactSummary> paramImmutableCollection, DbInsertContactHandler.InsertionType paramInsertionType)
  {
    if (paramImmutableCollection.isEmpty());
    while (true)
    {
      return;
      Tracer localTracer = Tracer.a("insertContactSummariesIntoDatabase (" + paramImmutableCollection.size() + " contacts)");
      SQLiteDatabase localSQLiteDatabase = this.b.b();
      localSQLiteDatabase.beginTransaction();
      try
      {
        if (paramInsertionType == DbInsertContactHandler.InsertionType.REPLACE_ALL)
        {
          localSQLiteDatabase.delete("contact_summaries", null, null);
          localSQLiteDatabase.delete("contact_details", null, null);
          localSQLiteDatabase.delete("contacts_indexed_data", null, null);
        }
        Iterator localIterator = paramImmutableCollection.iterator();
        while (localIterator.hasNext())
          a((ContactSummary)localIterator.next());
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      localTracer.a();
    }
  }

  public void a(ImmutableMultimap<String, Phonenumber.PhoneNumber> paramImmutableMultimap)
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    a(paramImmutableMultimap, localBuilder);
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      Iterator localIterator = localBuilder.b().iterator();
      while (localIterator.hasNext())
      {
        ContentValues localContentValues = (ContentValues)localIterator.next();
        BLog.b(a, "Inserting phone lookup: " + localContentValues);
        localSQLiteDatabase.insertOrThrow("contacts_indexed_data", null, localContentValues);
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }

  public void a(Collection<User> paramCollection)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.delete("favorite_contacts", null, null);
      Iterator localIterator = paramCollection.iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        String str = ((User)localIterator.next()).b();
        j = i + 1;
        a(str, i);
      }
      this.f.b(DbContactsProperties.c, paramCollection.size());
      this.f.b(DbContactsProperties.d, this.h.a());
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (SQLException localSQLException)
    {
      BLog.d(a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.DbInsertContactHandler
 * JD-Core Version:    0.6.0
 */