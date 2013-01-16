package com.facebook.katana.ui.bookmark;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.bookmark.model.Bookmark;

class BookmarkEditFragment$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a)
      BookmarkEditFragment.b(this.c, this.b);
    while (true)
    {
      BookmarkEditFragment.a(this.c, true);
      this.c.a();
      return;
      BookmarkEditFragment.c(this.c, this.b);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkEditFragment.5
 * JD-Core Version:    0.6.0
 */