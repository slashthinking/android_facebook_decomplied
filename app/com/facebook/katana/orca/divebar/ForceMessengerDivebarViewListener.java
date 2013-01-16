package com.facebook.katana.orca.divebar;

import android.content.Context;
import com.facebook.katana.IntentUriHandler;
import com.facebook.orca.contacts.divebar.DivebarViewListener;
import com.facebook.orca.contacts.picker.ContactPickerRow;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserWithIdentifier;

public class ForceMessengerDivebarViewListener
  implements DivebarViewListener
{
  private Context a;

  public ForceMessengerDivebarViewListener(Context paramContext)
  {
    this.a = paramContext;
  }

  public boolean a(UserWithIdentifier paramUserWithIdentifier, boolean paramBoolean, ContactPickerRow paramContactPickerRow)
  {
    return IntentUriHandler.b(this.a, "fb://messaging/compose/" + paramUserWithIdentifier.a().b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.divebar.ForceMessengerDivebarViewListener
 * JD-Core Version:    0.6.0
 */