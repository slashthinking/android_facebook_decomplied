package com.facebook.orca.users;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil.SmsAddress;
import com.facebook.orca.debug.Tracer;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.List;

public class BuiltInContactsUserIterator
{
  protected Cursor a;
  private final ContentResolver b;
  private final OrcaPhoneNumberUtil c;
  private UserBuilder d;

  public BuiltInContactsUserIterator(ContentResolver paramContentResolver, OrcaPhoneNumberUtil paramOrcaPhoneNumberUtil)
  {
    this.b = paramContentResolver;
    this.c = paramOrcaPhoneNumberUtil;
  }

  private UserPhoneNumber a(String paramString, int paramInt)
  {
    Tracer localTracer = Tracer.a("parseSmsAddress", "parseSmsAddress");
    OrcaPhoneNumberUtil.SmsAddress localSmsAddress = this.c.a(paramString);
    boolean bool = localSmsAddress.a();
    UserPhoneNumber localUserPhoneNumber = null;
    if (bool)
      localUserPhoneNumber = localSmsAddress.a(paramInt);
    localTracer.a();
    return localUserPhoneNumber;
  }

  private void b(String paramString)
  {
    this.a = this.b.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "contact_id", "display_name", "data1", "data2" }, "contact_id = ?", new String[] { paramString }, "contact_id");
  }

  private String c(String paramString)
  {
    Uri localUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(paramString));
    Cursor localCursor = this.b.query(localUri, new String[] { "_id" }, null, null, null);
    boolean bool = localCursor.moveToNext();
    String str = null;
    if (bool)
      str = localCursor.getString(0);
    localCursor.close();
    return str;
  }

  public void a()
  {
    if (this.a != null)
    {
      this.a.close();
      this.a = null;
    }
  }

  public void a(String paramString)
  {
    String str = c(paramString);
    if (str != null)
      b(str);
    while (true)
    {
      return;
      this.a = null;
    }
  }

  public User b()
  {
    Cursor localCursor = this.a;
    Object localObject1 = null;
    if (localCursor == null)
      return localObject1;
    label13: String str1;
    String str2;
    int i;
    String str3;
    User localUser2;
    if (this.a.moveToNext())
    {
      long l = this.a.getLong(0);
      str1 = this.a.getString(1);
      str2 = this.a.getString(2);
      i = this.a.getInt(3);
      str3 = Long.toString(l);
      if (this.d == null)
      {
        this.d = new UserBuilder();
        this.d.a(User.Type.ADDRESS_BOOK, str3);
        localUser2 = null;
      }
    }
    while (true)
    {
      if (this.d.h() == null)
        this.d.a(new Name(null, null, str1));
      if (this.d.i() == null)
      {
        String str4 = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, str3).toString();
        this.d.d(str4);
        this.d.e(str4);
      }
      UserPhoneNumber localUserPhoneNumber = a(str2, i);
      if (localUserPhoneNumber != null)
      {
        Object localObject2 = this.d.d();
        if (localObject2 == null)
        {
          localObject2 = Lists.a();
          this.d.b((List)localObject2);
        }
        if (!((List)localObject2).contains(localUserPhoneNumber))
          ((List)localObject2).add(localUserPhoneNumber);
      }
      if (localUser2 == null)
        break label13;
      localObject1 = localUser2;
      break;
      if (!Objects.equal(str3, this.d.b()))
      {
        localUser2 = this.d.w();
        this.d = new UserBuilder();
        this.d.a(User.Type.ADDRESS_BOOK, str3);
        continue;
        UserBuilder localUserBuilder = this.d;
        localObject1 = null;
        if (localUserBuilder == null)
          break;
        User localUser1 = this.d.w();
        this.d = null;
        localObject1 = localUser1;
        break;
      }
      localUser2 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.BuiltInContactsUserIterator
 * JD-Core Version:    0.6.0
 */