package com.facebook.orca.prefs;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.collect.Sets;
import java.util.Set;

class OrcaSharedPreferencesContentProvider$PreferenceDbTransaction
{
  private int b;
  private Set<String> c = Sets.a();

  public OrcaSharedPreferencesContentProvider$PreferenceDbTransaction(OrcaSharedPreferencesContentProvider paramOrcaSharedPreferencesContentProvider)
  {
  }

  public Set<String> a()
  {
    return this.c;
  }

  public void a(String paramString)
  {
    this.c.add(paramString);
  }

  public int b()
  {
    return this.b;
  }

  public void c()
  {
    OrcaSharedPreferencesContentProvider.a(this.a).beginTransaction();
    this.b = (1 + this.b);
  }

  public void d()
  {
    OrcaSharedPreferencesContentProvider.a(this.a).setTransactionSuccessful();
  }

  public void e()
  {
    OrcaSharedPreferencesContentProvider.a(this.a).endTransaction();
    this.b = (-1 + this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesContentProvider.PreferenceDbTransaction
 * JD-Core Version:    0.6.0
 */