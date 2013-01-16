package com.facebook.katana.ui.bookmark;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.facebook.bookmark.ui.event.BookmarkEvent;
import com.facebook.bookmark.ui.event.BookmarkEventBuilder;
import com.facebook.bookmark.ui.event.OnBookmarkSelectedListener;
import com.facebook.katana.LogoutActivity;
import com.facebook.katana.SettingsActivity;
import com.facebook.katana.activity.codegenerator.CodeGeneratorActivity;

class BookmarkMenuFragment$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      paramDialogInterface.dismiss();
      return;
      BookmarkMenuFragment.c(this.a).a(BookmarkEvent.newBuilder().a(this.a.n()).a("fb://account_settings").a());
      continue;
      this.a.a(new Intent(this.a.p(), SettingsActivity.class));
      continue;
      this.a.a(new Intent(this.a.p(), CodeGeneratorActivity.class));
      continue;
      LogoutActivity.a(this.a.n());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkMenuFragment.3
 * JD-Core Version:    0.6.0
 */