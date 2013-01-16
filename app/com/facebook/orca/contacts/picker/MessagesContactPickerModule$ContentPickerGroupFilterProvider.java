package com.facebook.orca.contacts.picker;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.protocol.methods.FetchThreadListMethod;

class MessagesContactPickerModule$ContentPickerGroupFilterProvider extends AbstractProvider<ContentPickerGroupFilter>
{
  private MessagesContactPickerModule$ContentPickerGroupFilterProvider(MessagesContactPickerModule paramMessagesContactPickerModule)
  {
  }

  public ContentPickerGroupFilter a()
  {
    return new ContentPickerGroupFilter((SingleMethodRunner)b(SingleMethodRunner.class), (FetchThreadListMethod)b(FetchThreadListMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.MessagesContactPickerModule.ContentPickerGroupFilterProvider
 * JD-Core Version:    0.6.0
 */