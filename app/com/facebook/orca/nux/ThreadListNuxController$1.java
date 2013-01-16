package com.facebook.orca.nux;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.orca.common.ui.titlebar.DivebarController.DivebarState;
import com.facebook.orca.contacts.upload.ContactsUploadState;
import com.facebook.orca.debug.BLog;

class ThreadListNuxController$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    BLog.b(ThreadListNuxController.e(), "Updating state for action: " + str);
    if (str.equals("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED"))
    {
      ContactsUploadState localContactsUploadState = (ContactsUploadState)paramIntent.getParcelableExtra("state");
      ThreadListNuxController.a(this.a, localContactsUploadState);
    }
    while (true)
    {
      return;
      if (str.equals("com.facebook.orca.common.ui.titlebar.DIVEBAR_STATE_CHANGED"))
      {
        DivebarController.DivebarState localDivebarState = (DivebarController.DivebarState)paramIntent.getSerializableExtra("state");
        ThreadListNuxController.a(this.a, localDivebarState);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.ThreadListNuxController.1
 * JD-Core Version:    0.6.0
 */