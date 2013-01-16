package com.facebook.contacts.contactcard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ConversationSettingsView$NotificationsSettingsDialogFragment$1
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ConversationSettingsView.NotificationsSettingsDialogFragment.a(this.a) != null)
      ConversationSettingsView.NotificationsSettingsDialogFragment.a(this.a).a(paramInt);
    paramDialogInterface.dismiss();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.ConversationSettingsView.NotificationsSettingsDialogFragment.1
 * JD-Core Version:    0.6.0
 */