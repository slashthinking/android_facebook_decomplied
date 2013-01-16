package com.facebook.orca.contacts.picker;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;
import javax.inject.Provider;

class ContactPickerInviteFriendsView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (((Boolean)ContactPickerInviteFriendsView.a(this.a).b()).booleanValue())
    {
      Intent localIntent2 = ContactPickerInviteFriendsView.b(this.a);
      ContactPickerInviteFriendsView.c(this.a).a(localIntent2, this.a.getContext());
    }
    while (true)
    {
      return;
      Intent localIntent1 = ContactPickerInviteFriendsView.d(this.a);
      ContactPickerInviteFriendsView.c(this.a).b(localIntent1, this.a.getContext());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.picker.ContactPickerInviteFriendsView.1
 * JD-Core Version:    0.6.0
 */