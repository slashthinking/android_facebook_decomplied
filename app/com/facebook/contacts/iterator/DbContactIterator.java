package com.facebook.contacts.iterator;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.contacts.data.ContactSerialization;
import com.facebook.contacts.data.ContactsDatabaseSupplier;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.debug.BLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

public class DbContactIterator
  implements Closeable, Iterator<ContactSummary>
{
  private static final Class<?> a = ContactsUserIterator.class;
  private final ContactsDatabaseSupplier b;
  private final ContactSerialization c;
  private Cursor d;

  public DbContactIterator(ContactsDatabaseSupplier paramContactsDatabaseSupplier, ContactSerialization paramContactSerialization)
  {
    this.b = paramContactsDatabaseSupplier;
    this.c = paramContactSerialization;
  }

  public ContactSummary a()
  {
    Object localObject = null;
    if (this.d == null)
      BLog.b(a, "next: not initialized, skipping");
    while (true)
    {
      return localObject;
      if (!this.d.moveToNext())
      {
        BLog.b(a, "next: cursor empty");
        localObject = null;
        continue;
      }
      try
      {
        ContactSummary localContactSummary = this.c.b(this.d.getString(0));
        BLog.b(a, "next: " + localContactSummary);
        localObject = localContactSummary;
      }
      catch (IOException localIOException)
      {
        BLog.e(a, "next: error deserializing contact: " + localIOException.getMessage());
        localObject = null;
      }
    }
  }

  void a(DbContactIteratorParams paramDbContactIteratorParams)
  {
    this.d = paramDbContactIteratorParams.a().query(this.b.b(), paramDbContactIteratorParams.b(), paramDbContactIteratorParams.c(), paramDbContactIteratorParams.d(), paramDbContactIteratorParams.e(), paramDbContactIteratorParams.f(), paramDbContactIteratorParams.g());
  }

  public void close()
  {
    BLog.b(a, "closing");
    if (this.d != null)
    {
      this.d.close();
      this.d = null;
    }
  }

  public boolean hasNext()
  {
    if ((this.d != null) && (!this.d.isAfterLast()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void remove()
  {
    throw new UnsupportedOperationException("DbContactIterator does not support remove()");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.iterator.DbContactIterator
 * JD-Core Version:    0.6.0
 */