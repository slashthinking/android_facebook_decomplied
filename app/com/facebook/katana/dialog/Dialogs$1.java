package com.facebook.katana.dialog;

import android.content.Context;
import android.widget.TextView;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.service.method.FriendsAddFriend;

final class Dialogs$1
  implements Runnable
{
  public void run()
  {
    String str1 = this.a.getText().toString().trim();
    if (str1.length() == 0)
      str1 = null;
    String str2 = FriendsAddFriend.a(this.b, this.c, Long.valueOf(this.d), str1);
    this.e.a(str2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.dialog.Dialogs.1
 * JD-Core Version:    0.6.0
 */