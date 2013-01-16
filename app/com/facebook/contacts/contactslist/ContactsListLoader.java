package com.facebook.contacts.contactslist;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import com.facebook.contacts.iterator.DbContactIterator;
import com.facebook.contacts.iterator.DbContactIteratorFactory;
import com.facebook.contacts.models.ContactSummary;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class ContactsListLoader extends AsyncTaskLoader<ContactsListLoader.Result>
{
  private static final Class<?> f = ContactsListLoader.class;
  private final DbContactIteratorFactory g;
  private ContactsListLoader.Result h;

  public ContactsListLoader(Context paramContext, DbContactIteratorFactory paramDbContactIteratorFactory)
  {
    super(paramContext);
    this.g = paramDbContactIteratorFactory;
  }

  private ContactsListLoader.Result v()
  {
    return new ContactsListLoader.Result(w());
  }

  private ImmutableList<ContactSummary> w()
  {
    DbContactIterator localDbContactIterator = this.g.a();
    ImmutableList.Builder localBuilder = ImmutableList.e();
    while (true)
    {
      ContactSummary localContactSummary = localDbContactIterator.a();
      if (localContactSummary == null)
        break;
      localBuilder.b(localContactSummary);
    }
    localDbContactIterator.close();
    return localBuilder.b();
  }

  public ContactsListLoader.Result f()
  {
    return v();
  }

  protected void g()
  {
    super.g();
    if (this.h != null)
      b(this.h);
    if (this.h == null)
      o();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactslist.ContactsListLoader
 * JD-Core Version:    0.6.0
 */