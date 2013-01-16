package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookPhonebookContact;
import com.facebook.katana.model.FacebookPhonebookContactUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class ContactRemoteInfoFetcher
{
  private static Class<?> a = ContactRemoteInfoFetcher.class;
  private Context b;
  private AppSession c;
  private String d;
  private String e;
  private ContactRemoteInfoFetcher.ContactObserverSessionListener f;
  private Map<Long, FacebookPhonebookContact> g;
  private Map<Long, FacebookPhonebookContact> h;
  private Map<Long, FacebookPhonebookContact> i;
  private List<FacebookPhonebookContactUser> j;

  public ContactRemoteInfoFetcher(Context paramContext)
  {
    this.b = paramContext;
    this.c = AppSession.b(this.b, true);
    if (this.c == null);
    while (true)
    {
      return;
      this.h = new HashMap();
      this.i = new HashMap();
      this.j = new ArrayList();
    }
  }

  private void c(Map<Long, FacebookPhonebookContact> paramMap)
  {
    this.f = new ContactRemoteInfoFetcher.ContactObserverSessionListener(this, null);
    this.c.a(this.f);
    this.g = paramMap;
  }

  protected ContactRemoteInfoFetcher.Listener a()
  {
    Object localObject1 = null;
    Iterator localIterator = this.c.d().iterator();
    AppSessionListener localAppSessionListener;
    if (localIterator.hasNext())
    {
      localAppSessionListener = (AppSessionListener)localIterator.next();
      if (!(localAppSessionListener instanceof ContactRemoteInfoFetcher.Listener))
        break label55;
    }
    label55: for (Object localObject2 = (ContactRemoteInfoFetcher.Listener)localAppSessionListener; ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }

  public String a(Map<Long, FacebookPhonebookContact> paramMap)
  {
    Log.e(a, "fetch() is called");
    c(paramMap);
    this.d = PhonebookLookup.a(this.c, this.b, new ArrayList(paramMap.values()), true, Locale.getDefault().getCountry(), false);
    Log.e(a, "Initiated an API call - regular fetch");
    return this.d;
  }

  protected void a(int paramInt, String paramString, Exception paramException)
  {
    Log.e(a, "API call completed");
    ContactRemoteInfoFetcher.Listener localListener = a();
    if (localListener != null)
      localListener.a(this.i);
    if (this.h.size() > 0)
    {
      Long[] arrayOfLong = (Long[])this.h.keySet().toArray(new Long[this.h.size()]);
      this.e = FqlUsersGetBriefInfoAndProfilePics.a(this.c, this.b, arrayOfLong);
    }
    while (true)
    {
      return;
      this.j = new ArrayList();
      b(paramInt, paramString, paramException);
    }
  }

  public String b(Map<Long, FacebookPhonebookContact> paramMap)
  {
    Log.e(a, "continuousImport() is called");
    c(paramMap);
    this.d = PhonebookLookup.a(this.c, this.b, new ArrayList(paramMap.values()), true, Locale.getDefault().getCountry(), true);
    Log.e(a, "Initiated an API call - continous import");
    return this.d;
  }

  protected void b(int paramInt, String paramString, Exception paramException)
  {
    ContactRemoteInfoFetcher.Listener localListener = a();
    if (localListener != null)
      localListener.a(this.j, paramInt, paramString, paramException);
    if (this.c != null)
      this.c.b(this.f);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ContactRemoteInfoFetcher
 * JD-Core Version:    0.6.0
 */