package com.facebook.orca.threadview.upsell;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import com.facebook.contacts.iterator.DbContactIterator;
import com.facebook.contacts.iterator.DbContactIteratorFactory;
import com.facebook.contacts.models.ContactSummary;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.google.i18n.phonenumbers.NumberParseException;

public class MergedThreadsUpsellLoader extends AsyncTaskLoader<ContactSummary>
{
  private static final Class<?> f = MergedThreadsUpsellLoader.class;
  private final DbContactIteratorFactory g;
  private final String h;
  private final String i;

  public MergedThreadsUpsellLoader(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    this.g = ((DbContactIteratorFactory)FbInjector.a(paramContext).a(DbContactIteratorFactory.class));
    this.h = paramString1;
    this.i = paramString2;
  }

  private ContactSummary a(DbContactIterator paramDbContactIterator)
  {
    ContactSummary localContactSummary1 = ContactSummary.a;
    ContactSummary localContactSummary2;
    do
    {
      if (!paramDbContactIterator.hasNext())
        break;
      localContactSummary2 = paramDbContactIterator.a();
    }
    while (StringUtil.a(localContactSummary2.getProfileFbid()));
    while (true)
    {
      paramDbContactIterator.close();
      return localContactSummary2;
      localContactSummary2 = localContactSummary1;
    }
  }

  private ContactSummary v()
  {
    try
    {
      DbContactIterator localDbContactIterator2 = this.g.b(this.h);
      localDbContactIterator1 = localDbContactIterator2;
      if (localDbContactIterator1 == null)
      {
        localContactSummary = ContactSummary.a;
        return localContactSummary;
      }
    }
    catch (NumberParseException localNumberParseException)
    {
      while (true)
      {
        BLog.b(f, "Could not parse number: " + this.h);
        DbContactIterator localDbContactIterator1 = null;
        continue;
        ContactSummary localContactSummary = a(localDbContactIterator1);
      }
    }
  }

  private ContactSummary w()
  {
    return a(this.g.a(this.i));
  }

  public ContactSummary f()
  {
    ContactSummary localContactSummary = v();
    if (localContactSummary != ContactSummary.a);
    while (true)
    {
      return localContactSummary;
      localContactSummary = w();
    }
  }

  protected void g()
  {
    super.g();
    o();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.upsell.MergedThreadsUpsellLoader
 * JD-Core Version:    0.6.0
 */