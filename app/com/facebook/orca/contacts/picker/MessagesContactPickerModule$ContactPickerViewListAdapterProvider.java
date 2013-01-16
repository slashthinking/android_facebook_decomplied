package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.orca.common.util.OrcaPhoneNumberUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.google.inject.Key;

class MessagesContactPickerModule$ContactPickerViewListAdapterProvider extends AbstractProvider<IContactPickerViewListAdapter>
{
  private final Key<? extends ContactPickerListFilter> b;

  private MessagesContactPickerModule$ContactPickerViewListAdapterProvider(Key<? extends ContactPickerListFilter> paramKey)
  {
    Object localObject;
    this.b = localObject;
  }

  public ContactPickerViewListAdapter a()
  {
    return new ContactPickerViewListAdapter((Context)b(Context.class), a(this.b), (LayoutInflater)b(LayoutInflater.class), (OrcaPhoneNumberUtil)b(OrcaPhoneNumberUtil.class), (SecureContextHelper)b(SecureContextHelper.class), (AnalyticsLogger)b(AnalyticsLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.ContactPickerViewListAdapterProvider
 * JD-Core Version:    0.6.0
 */