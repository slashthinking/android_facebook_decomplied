package com.facebook.contacts.iterator;

import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.orca.common.names.NameNormalizer;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import java.util.Locale;
import javax.inject.Provider;

public class DbContactIteratorFactory
{
  Provider<DbContactIterator> a;

  public DbContactIteratorFactory(Provider<DbContactIterator> paramProvider)
  {
    this.a = paramProvider;
  }

  public DbContactIterator a()
  {
    return a(DbContactIteratorParams.a);
  }

  public DbContactIterator a(DbContactIteratorParams paramDbContactIteratorParams)
  {
    DbContactIterator localDbContactIterator = (DbContactIterator)this.a.b();
    localDbContactIterator.a(paramDbContactIteratorParams);
    return localDbContactIterator;
  }

  public DbContactIterator a(String paramString)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("contact_summaries");
    String[] arrayOfString1 = { "data" };
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = "name";
    arrayOfString2[1] = NameNormalizer.a(paramString);
    return a(new DbContactIteratorParams(localSQLiteQueryBuilder, arrayOfString1, "contact_id IN (SELECT contact_id FROM contacts_indexed_data WHERE type = ? AND indexed_data GLOB ?)", arrayOfString2, null, null, null));
  }

  public DbContactIterator b(String paramString)
  {
    PhoneNumberUtil localPhoneNumberUtil = PhoneNumberUtil.getInstance();
    String str1 = Locale.getDefault().getCountry();
    if (str1.equals(""))
      str1 = "US";
    String str2 = localPhoneNumberUtil.format(localPhoneNumberUtil.parse(paramString, str1), PhoneNumberUtil.PhoneNumberFormat.E164);
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("contact_summaries");
    return a(new DbContactIteratorParams(localSQLiteQueryBuilder, new String[] { "data" }, "contact_id IN (SELECT contact_id FROM contacts_indexed_data WHERE type = ? AND indexed_data = ?)", new String[] { "phone_e164", str2 }, null, null, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.iterator.DbContactIteratorFactory
 * JD-Core Version:    0.6.0
 */