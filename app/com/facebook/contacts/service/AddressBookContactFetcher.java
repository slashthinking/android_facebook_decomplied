package com.facebook.contacts.service;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import com.facebook.contacts.data.ContactSerialization;
import com.facebook.contacts.models.ContactDetails;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.contacts.models.ContactSummaryBuilder;
import com.facebook.contacts.models.entry.Entry;
import com.facebook.contacts.models.entry.PhoneEntry;
import com.facebook.contacts.server.FetchContactResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.orca.users.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

public class AddressBookContactFetcher
{
  private final ContentResolver a;
  private final ContactSerialization b;

  public AddressBookContactFetcher(ContentResolver paramContentResolver, ContactSerialization paramContactSerialization)
  {
    this.a = paramContentResolver;
    this.b = paramContactSerialization;
  }

  private String a(String paramString, ContactSummaryBuilder paramContactSummaryBuilder)
  {
    Cursor localCursor = this.a.query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(paramString)), new String[] { "_id", "display_name", "lookup" }, null, null, null);
    try
    {
      boolean bool = localCursor.moveToNext();
      String str1 = null;
      if (bool)
      {
        str1 = localCursor.getString(0);
        String str2 = localCursor.getString(1);
        String str3 = localCursor.getString(2);
        paramContactSummaryBuilder.d(str2).g(str3);
      }
      return str1;
    }
    finally
    {
      localCursor.close();
    }
    throw localObject;
  }

  private void a(String paramString, ImmutableSet.Builder<Entry> paramBuilder)
  {
    Cursor localCursor = this.a.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "data1", "data2" }, "contact_id = " + paramString, null, null);
    try
    {
      if (localCursor.moveToNext())
        paramBuilder.b(new PhoneEntry(null, true, null, -1L, localCursor.getString(0), Integer.valueOf(localCursor.getInt(1)).intValue()));
    }
    finally
    {
      localCursor.close();
    }
  }

  public FetchContactResult a(UserKey paramUserKey)
  {
    ContactSummaryBuilder localContactSummaryBuilder = new ContactSummaryBuilder();
    ImmutableSet.Builder localBuilder = ImmutableSet.e();
    String str1 = a(paramUserKey.b(), localContactSummaryBuilder);
    if (str1 == null);
    ContactDetails localContactDetails;
    for (FetchContactResult localFetchContactResult = new FetchContactResult(DataFreshnessResult.FROM_SERVER, System.currentTimeMillis(), ContactSummary.a, null); ; localFetchContactResult = new FetchContactResult(DataFreshnessResult.FROM_SERVER, System.currentTimeMillis(), localContactSummaryBuilder.q(), localContactDetails))
    {
      return localFetchContactResult;
      String str2 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, str1).toString();
      localContactSummaryBuilder.e(str2);
      localContactSummaryBuilder.f(str2);
      a(str1, localBuilder);
      localContactDetails = new ContactDetails(str1, this.b.a(ImmutableList.a(localBuilder.b())), false);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.service.AddressBookContactFetcher
 * JD-Core Version:    0.6.0
 */