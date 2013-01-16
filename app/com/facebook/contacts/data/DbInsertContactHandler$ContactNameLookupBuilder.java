package com.facebook.contacts.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.names.NameLookupBuilder;
import com.facebook.orca.common.names.NameSplitter;
import com.facebook.orca.debug.BLog;
import javax.inject.Inject;

public class DbInsertContactHandler$ContactNameLookupBuilder extends NameLookupBuilder
{
  private static final Class<?> a = ContactNameLookupBuilder.class;
  private final ContactsDatabaseSupplier b;

  @Inject
  public DbInsertContactHandler$ContactNameLookupBuilder(ContactsDatabaseSupplier paramContactsDatabaseSupplier, NameSplitter paramNameSplitter)
  {
    super(paramNameSplitter);
    this.b = paramContactsDatabaseSupplier;
  }

  protected void a(String paramString1, int paramInt, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", "name");
    localContentValues.put("contact_id", paramString1);
    localContentValues.put("indexed_data", paramString2);
    BLog.b(a, "Inserting name lookup: " + localContentValues);
    this.b.b().insert("contacts_indexed_data", null, localContentValues);
  }

  protected String[] a(String paramString)
  {
    return new String[0];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.data.DbInsertContactHandler.ContactNameLookupBuilder
 * JD-Core Version:    0.6.0
 */