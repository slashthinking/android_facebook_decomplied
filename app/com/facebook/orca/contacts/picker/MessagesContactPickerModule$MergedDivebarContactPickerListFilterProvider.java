package com.facebook.orca.contacts.picker;

import android.content.res.Resources;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.annotations.IsDisplayGroupsInDivebarEnabled;
import com.facebook.orca.inject.AbstractProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

class MessagesContactPickerModule$MergedDivebarContactPickerListFilterProvider extends AbstractProvider<ContactPickerListFilter>
{
  private ImmutableList<ContactPickerMergedFilter.ContactPickerSubFilterConfig> c()
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    localBuilder.b(new ContactPickerMergedFilter.ContactPickerSubFilterConfig((ContactPickerListFilter)b(ContactPickerFriendFilter.class), null, true));
    if (((Boolean)b(Boolean.class, IsClientSmsEnabled.class)).booleanValue())
      localBuilder.b(new ContactPickerMergedFilter.ContactPickerSubFilterConfig((ContactPickerListFilter)b(ContactPickerAddressBookFilter.class), ((Resources)b(Resources.class)).getString(2131362514), false));
    if (((Boolean)b(Boolean.class, IsDisplayGroupsInDivebarEnabled.class)).booleanValue())
      localBuilder.b(new ContactPickerMergedFilter.ContactPickerSubFilterConfig((ContactPickerListFilter)b(ContentPickerGroupFilter.class), ((Resources)b(Resources.class)).getString(2131362515), false));
    localBuilder.b(new ContactPickerMergedFilter.ContactPickerSubFilterConfig((ContactPickerListFilter)b(ContactPickerFriendsOfFriendsFilter.class), ((Resources)b(Resources.class)).getString(2131362513), false));
    return localBuilder.b();
  }

  public ContactPickerListFilter a()
  {
    return new ContactPickerMergedFilter(c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.MergedDivebarContactPickerListFilterProvider
 * JD-Core Version:    0.6.0
 */