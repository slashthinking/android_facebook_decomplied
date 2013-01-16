package com.facebook.katana.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import com.facebook.katana.model.FacebookPhonebookContact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhonebookUtils
{
  private final ContentResolver a;

  public PhonebookUtils(ContentResolver paramContentResolver)
  {
    this.a = paramContentResolver;
  }

  public List<FacebookPhonebookContact> a()
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashSet localHashSet = new HashSet();
    String[] arrayOfString1 = { "_id", "display_name" };
    String[] arrayOfString2 = { "contact_id", "data1" };
    String[] arrayOfString3 = { "contact_id", "data1" };
    String[] arrayOfString4 = { "number", "type", "duration" };
    Cursor localCursor1 = this.a.query(ContactsContract.Contacts.CONTENT_URI, arrayOfString1, null, null, null);
    Cursor localCursor2 = this.a.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, arrayOfString2, null, null, null);
    Cursor localCursor3 = this.a.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, arrayOfString3, null, null, null);
    Cursor localCursor4 = this.a.query(CallLog.Calls.CONTENT_URI, arrayOfString4, null, null, null);
    while (localCursor1.moveToNext())
    {
      Long localLong3 = Long.valueOf(localCursor1.getLong(localCursor1.getColumnIndex("_id")));
      localHashMap1.put(localLong3, new FacebookPhonebookContact(localCursor1.getString(localCursor1.getColumnIndex("display_name")), localLong3.longValue(), new ArrayList(), new ArrayList()));
    }
    localCursor1.close();
    while (localCursor3.moveToNext())
    {
      Long localLong2 = Long.valueOf(localCursor3.getLong(localCursor3.getColumnIndex("contact_id")));
      if (localHashMap1.get(localLong2) == null)
        continue;
      String str3 = localCursor3.getString(localCursor3.getColumnIndex("data1"));
      if (localHashSet.contains(str3))
        continue;
      localHashSet.add(str3);
      ((FacebookPhonebookContact)localHashMap1.get(localLong2)).emails.add(str3);
    }
    localCursor3.close();
    while (localCursor2.moveToNext())
    {
      Long localLong1 = Long.valueOf(localCursor2.getLong(localCursor2.getColumnIndex("contact_id")));
      if (localHashMap1.get(localLong1) == null)
        continue;
      String str2 = localCursor2.getString(localCursor2.getColumnIndex("data1"));
      if (localHashSet.contains(str2))
        continue;
      localHashSet.add(str2);
      ((FacebookPhonebookContact)localHashMap1.get(localLong1)).phones.add(str2);
      localHashMap2.put(PhoneNumberUtils.stripSeparators(str2), localHashMap1.get(localLong1));
    }
    localCursor2.close();
    while (localCursor4.moveToNext())
    {
      String str1 = PhoneNumberUtils.stripSeparators(localCursor4.getString(localCursor4.getColumnIndex("number")));
      if (localHashMap2.get(str1) == null)
        continue;
      int i = localCursor4.getInt(localCursor4.getColumnIndex("type"));
      int j = localCursor4.getInt(localCursor4.getColumnIndex("duration"));
      if (i == 1)
      {
        FacebookPhonebookContact localFacebookPhonebookContact3 = (FacebookPhonebookContact)localHashMap2.get(str1);
        localFacebookPhonebookContact3.incomingCallCount = (1L + localFacebookPhonebookContact3.incomingCallCount);
        FacebookPhonebookContact localFacebookPhonebookContact4 = (FacebookPhonebookContact)localHashMap2.get(str1);
        localFacebookPhonebookContact4.incomingCallDuration += j;
        continue;
      }
      FacebookPhonebookContact localFacebookPhonebookContact1 = (FacebookPhonebookContact)localHashMap2.get(str1);
      localFacebookPhonebookContact1.outgoingCallCount = (1L + localFacebookPhonebookContact1.outgoingCallCount);
      FacebookPhonebookContact localFacebookPhonebookContact2 = (FacebookPhonebookContact)localHashMap2.get(str1);
      localFacebookPhonebookContact2.outgoingCallDuration += j;
    }
    localCursor4.close();
    return new ArrayList(localHashMap1.values());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.PhonebookUtils
 * JD-Core Version:    0.6.0
 */