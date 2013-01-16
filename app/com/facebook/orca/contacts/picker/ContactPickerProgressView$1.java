package com.facebook.orca.contacts.picker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.orca.contacts.upload.ContactsUploadState;

class ContactPickerProgressView$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ContactsUploadState localContactsUploadState = (ContactsUploadState)paramIntent.getParcelableExtra("state");
    ContactPickerProgressView.a(this.a, localContactsUploadState);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerProgressView.1
 * JD-Core Version:    0.6.0
 */