package com.facebook.orca.common.names;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

@SuppressLint({"UseSparseArrays"})
public class ContactLocaleUtils
{
  private static final String a = Locale.CHINESE.getLanguage().toLowerCase();
  private static final String b = Locale.JAPANESE.getLanguage().toLowerCase();
  private static final String c = Locale.KOREAN.getLanguage().toLowerCase();
  private static ContactLocaleUtils d;
  private HashMap<Integer, ContactLocaleUtils.ContactLocaleUtilsBase> e = new HashMap();
  private ContactLocaleUtils.ContactLocaleUtilsBase f = new ContactLocaleUtils.ContactLocaleUtilsBase(this);
  private String g;

  private ContactLocaleUtils()
  {
    a(null);
  }

  private int a(int paramInt)
  {
    if ((paramInt == 2) && (!b.equals(this.g)) && (!c.equals(this.g)))
      paramInt = 3;
    return paramInt;
  }

  private ContactLocaleUtils.ContactLocaleUtilsBase a(Integer paramInteger)
  {
    int i = paramInteger.intValue();
    Integer localInteger = Integer.valueOf(a(i));
    if ((a.equals(this.g)) && (i == 1))
      localInteger = Integer.valueOf(3);
    return b(localInteger);
  }

  public static ContactLocaleUtils a()
  {
    monitorenter;
    try
    {
      if (d == null)
        d = new ContactLocaleUtils();
      ContactLocaleUtils localContactLocaleUtils = d;
      monitorexit;
      return localContactLocaleUtils;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private ContactLocaleUtils.ContactLocaleUtilsBase b(Integer paramInteger)
  {
    monitorenter;
    try
    {
      Object localObject2 = (ContactLocaleUtils.ContactLocaleUtilsBase)this.e.get(paramInteger);
      if ((localObject2 == null) && (paramInteger.intValue() == 3))
      {
        localObject2 = new ContactLocaleUtils.ChineseContactUtils(this, null);
        this.e.put(paramInteger, localObject2);
      }
      if (localObject2 == null)
        localObject2 = this.f;
      monitorexit;
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      monitorexit;
    }
    throw localObject1;
  }

  public Iterator<String> a(String paramString, int paramInt)
  {
    return a(Integer.valueOf(paramInt)).a(paramString);
  }

  public void a(Locale paramLocale)
  {
    if (paramLocale == null);
    for (this.g = Locale.getDefault().getLanguage().toLowerCase(); ; this.g = paramLocale.getLanguage().toLowerCase())
      return;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.names.ContactLocaleUtils
 * JD-Core Version:    0.6.0
 */