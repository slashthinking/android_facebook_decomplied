package com.facebook.orca.nux;

import com.facebook.app.Product;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.MessengerPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.orca.threads.MessagingIdUtil;
import javax.inject.Inject;
import javax.inject.Provider;

public class OrcaNuxManager
{
  private static final Class<?> a = OrcaNuxManager.class;
  private final OrcaAppType b;
  private final Provider<Boolean> c;
  private final OrcaSharedPreferences d;
  private final UiCounters e;
  private final Provider<Boolean> f;
  private final Provider<Boolean> g;
  private final ContactsUploadRunner h;

  @Inject
  public OrcaNuxManager(OrcaAppType paramOrcaAppType, Provider<Boolean> paramProvider1, OrcaSharedPreferences paramOrcaSharedPreferences, UiCounters paramUiCounters, Provider<Boolean> paramProvider2, Provider<Boolean> paramProvider3, ContactsUploadRunner paramContactsUploadRunner)
  {
    this.b = paramOrcaAppType;
    this.c = paramProvider1;
    this.d = paramOrcaSharedPreferences;
    this.e = paramUiCounters;
    this.f = paramProvider2;
    this.g = paramProvider3;
    this.h = paramContactsUploadRunner;
    n();
  }

  private void a(PrefKey paramPrefKey)
  {
    this.d.b().a(paramPrefKey, true).a();
  }

  private void n()
  {
    boolean bool = this.d.a(MessengerPrefKeys.d, false);
    int i = this.d.a(MessengerPrefKeys.i, -1);
    int j = this.d.a(MessengerPrefKeys.g, -1);
    if (i != -1)
      this.d.b().a(MessengerPrefKeys.i).a(MessengerPrefKeys.g, i).a();
    while (true)
    {
      if (i != 3)
      {
        OrcaSharedPreferences.Editor localEditor = this.d.b().a(MessengerPrefKeys.g, 3);
        if (i != -1)
          localEditor.a(MessengerPrefKeys.h, true);
        if (i == 2)
          localEditor.a(MessengerPrefKeys.j).a(MessengerPrefKeys.k).a(MessengerPrefKeys.l);
        localEditor.a();
      }
      return;
      if ((j == -1) && (bool))
      {
        this.d.b().a(MessengerPrefKeys.g, 1).a();
        i = 1;
        continue;
      }
      i = j;
    }
  }

  public void a()
  {
    this.d.b().a(MessengerPrefKeys.d).a(MessengerPrefKeys.g).a(MessengerPrefKeys.h).a(MessengerPrefKeys.i).a(MessengerPrefKeys.j).a(MessengerPrefKeys.k).a(MessengerPrefKeys.l).a(MessengerPrefKeys.n).a(MessagesPrefKeys.w).a();
  }

  public boolean a(String paramString)
  {
    boolean bool1 = d();
    int i = 0;
    if (bool1)
    {
      boolean bool2 = MessagingIdUtil.g(paramString);
      i = 0;
      if (bool2)
      {
        boolean bool3 = this.d.a(MessengerPrefKeys.k, false);
        i = 0;
        if (!bool3)
          i = 1;
      }
    }
    return i;
  }

  public boolean b()
  {
    if (this.b.i() == Product.MESSENGER);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean c()
  {
    if ((b()) && (((Boolean)this.f.b()).booleanValue()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean d()
  {
    if ((b()) && ((this.e.a("send_clicked") >= 20) || (e())) && (((Boolean)this.c.b()).booleanValue()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean e()
  {
    return this.d.a(MessengerPrefKeys.h, false);
  }

  public boolean f()
  {
    return this.d.a(MessengerPrefKeys.j, false);
  }

  public boolean g()
  {
    boolean bool1 = d();
    int i = 0;
    if (bool1)
    {
      boolean bool2 = this.d.a(MessengerPrefKeys.j, false);
      i = 0;
      if (!bool2)
        i = 1;
    }
    return i;
  }

  public boolean h()
  {
    boolean bool1 = c();
    int i = 0;
    if (bool1)
    {
      boolean bool2 = this.h.d();
      i = 0;
      if (!bool2)
      {
        boolean bool3 = this.d.a(MessengerPrefKeys.n, false);
        i = 0;
        if (!bool3)
          i = 1;
      }
    }
    return i;
  }

  public boolean i()
  {
    boolean bool = this.d.a(MessengerPrefKeys.o, false);
    int i = 0;
    if (!bool)
      i = 1;
    return i;
  }

  public void j()
  {
    a(MessengerPrefKeys.j);
  }

  public void k()
  {
    a(MessengerPrefKeys.k);
  }

  public void l()
  {
    a(MessengerPrefKeys.n);
  }

  public void m()
  {
    a(MessengerPrefKeys.o);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.OrcaNuxManager
 * JD-Core Version:    0.6.0
 */