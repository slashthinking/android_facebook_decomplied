package com.karmascience.gifts.content;

import com.karmascience.gifts.ThreadingService;
import com.karmascience.gifts.views.AlcoholInfoEntryView.AddressHolder;

public abstract class SaveNewAddressApiMethod<T> extends GraphPOJOApiMethod<T>
{
  public SaveNewAddressApiMethod(String paramString1, ThreadingService paramThreadingService, int paramInt, Class<T> paramClass, String paramString2, String paramString3, AlcoholInfoEntryView.AddressHolder paramAddressHolder)
  {
    super(paramString1, paramThreadingService, paramInt, paramClass, paramString2, paramString3);
    a("addressee", paramAddressHolder.a);
    a("street", paramAddressHolder.b);
    a("building", paramAddressHolder.c);
    a("city", paramAddressHolder.d);
    a("state", paramAddressHolder.e);
    a("postal_code", paramAddressHolder.f);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.SaveNewAddressApiMethod
 * JD-Core Version:    0.6.0
 */