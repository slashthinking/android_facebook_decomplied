package com.facebook.katana.provider;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.google.common.base.Preconditions;

public class KeyValueStore
{
  private final OrcaSharedPreferences a;
  private final FbErrorReporter b;
  private final PrefKey c;
  private final LegacyKeyValueStore d;

  public KeyValueStore(OrcaSharedPreferences paramOrcaSharedPreferences, PrefKey paramPrefKey, LegacyKeyValueStore paramLegacyKeyValueStore, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = paramFbErrorReporter;
    this.c = paramPrefKey;
    this.d = paramLegacyKeyValueStore;
  }

  private PrefKey b(String paramString)
  {
    return (PrefKey)this.c.c(paramString);
  }

  public String a(String paramString1, String paramString2)
  {
    Object localObject = this.a.a(b(paramString1), null);
    String str1;
    String str2;
    if (localObject == null)
    {
      str1 = this.d.a(paramString1);
      if (str1 == null)
      {
        str2 = "kvm_null_flag";
        a(paramString1, str2, false);
        this.d.b(paramString1);
        localObject = str1;
      }
    }
    else
    {
      if ((localObject != null) && (!"kvm_null_flag".equals(localObject)))
        break label80;
    }
    while (true)
    {
      return paramString2;
      str2 = str1;
      break;
      label80: paramString2 = (String)localObject;
    }
  }

  public void a()
  {
    this.d.a();
    this.a.b().b(this.c).a();
  }

  public void a(String paramString)
  {
    this.d.b(paramString);
    this.a.b().a(b(paramString)).a();
  }

  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    if (paramBoolean)
      if ("kvm_null_flag".equals(paramString2))
        break label68;
    label68: for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "%s can't be stored as a value in KVM, as it is a reserved keyword.", new Object[] { "kvm_null_flag" });
      this.a.b().a(b(paramString1), paramString2).a();
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.KeyValueStore
 * JD-Core Version:    0.6.0
 */