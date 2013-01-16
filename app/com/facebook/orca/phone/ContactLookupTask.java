package com.facebook.orca.phone;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import com.facebook.contacts.iterator.DbContactIterator;
import com.facebook.contacts.iterator.DbContactIteratorFactory;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.users.Name;
import com.google.i18n.phonenumbers.NumberParseException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.inject.Provider;

public class ContactLookupTask
  implements Runnable
{
  private static final Class<?> a = ContactLookupTask.class;
  private Context b;
  private ContactLookupTask.ContactLookupTaskListener c;
  private String d;
  private String e;
  private URL f;
  private Uri g;

  public ContactLookupTask(Context paramContext, String paramString, ContactLookupTask.ContactLookupTaskListener paramContactLookupTaskListener)
  {
    this.b = paramContext;
    this.c = paramContactLookupTaskListener;
    this.d = paramString;
    this.e = null;
    this.f = null;
    this.g = null;
  }

  private void a()
  {
    DbContactIteratorFactory localDbContactIteratorFactory = (DbContactIteratorFactory)FbInjector.a(this.b).b(DbContactIteratorFactory.class).b();
    while (true)
    {
      DbContactIterator localDbContactIterator1;
      ContactSummary localContactSummary;
      try
      {
        DbContactIterator localDbContactIterator2 = localDbContactIteratorFactory.b(this.d);
        localDbContactIterator1 = localDbContactIterator2;
        if (localDbContactIterator1 == null)
          return;
      }
      catch (NumberParseException localNumberParseException)
      {
        BLog.e(a, "Failed to parse contact number: " + this.d);
        localDbContactIterator1 = null;
        continue;
        if (localDbContactIterator1.hasNext())
        {
          localContactSummary = localDbContactIterator1.a();
          this.e = localContactSummary.getName().f();
        }
      }
      try
      {
        String str = localContactSummary.getBigPictureUrl();
        if (str != null)
          this.f = new URL(str);
        while (true)
        {
          localDbContactIterator1.close();
          break;
          BLog.c(a, "Could not find photo URL for FB contact " + this.e);
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        while (true)
          BLog.e(a, "Could not load contact's photo from Rolodex", localMalformedURLException);
      }
    }
  }

  private void b()
  {
    Uri localUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.d));
    Cursor localCursor = this.b.getContentResolver().query(localUri, new String[] { "_id", "display_name" }, null, null, null);
    if (localCursor.moveToFirst())
    {
      if (this.e == null)
        this.e = localCursor.getString(localCursor.getColumnIndex("display_name"));
      long l = localCursor.getLong(localCursor.getColumnIndex("_id"));
      this.g = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, l);
    }
  }

  public void run()
  {
    if (this.c == null);
    while (true)
    {
      return;
      a();
      if (this.e == null)
        b();
      this.c.a(this.d, this.e);
      if (this.f != null)
      {
        Uri localUri = Uri.parse(this.f.toString());
        this.c.a(this.d, localUri);
      }
      if (this.g == null)
        continue;
      Bitmap localBitmap = BitmapFactory.decodeStream(ContactsContract.Contacts.openContactPhotoInputStream(this.b.getContentResolver(), this.g));
      this.c.a(this.d, localBitmap);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.ContactLookupTask
 * JD-Core Version:    0.6.0
 */