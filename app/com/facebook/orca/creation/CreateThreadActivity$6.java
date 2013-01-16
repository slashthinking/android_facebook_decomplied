package com.facebook.orca.creation;

import com.facebook.orca.compose.ComposeFragment;
import com.facebook.orca.contacts.picker.ContactPickerFragment.OnPrimaryContactTypeChangedListener;
import com.facebook.orca.users.UserIdentifier.IdentifierType;

class CreateThreadActivity$6
  implements ContactPickerFragment.OnPrimaryContactTypeChangedListener
{
  public void a(UserIdentifier.IdentifierType paramIdentifierType)
  {
    boolean bool1 = true;
    CreateThreadActivity localCreateThreadActivity = this.a;
    boolean bool2;
    ComposeFragment localComposeFragment;
    if (UserIdentifier.IdentifierType.PHONE == paramIdentifierType)
    {
      bool2 = bool1;
      localCreateThreadActivity.o = bool2;
      CreateThreadActivity.c(this.a);
      CreateThreadActivity.d(this.a).a(this.a.o);
      localComposeFragment = CreateThreadActivity.d(this.a);
      if (UserIdentifier.IdentifierType.FBID != paramIdentifierType)
        break label76;
    }
    while (true)
    {
      localComposeFragment.b(bool1);
      return;
      bool2 = false;
      break;
      label76: bool1 = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.creation.CreateThreadActivity.6
 * JD-Core Version:    0.6.0
 */