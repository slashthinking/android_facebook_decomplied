package com.facebook.katana.ui.bookmark;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import java.util.List;

class BookmarkMenuController$2
  implements Runnable
{
  public void run()
  {
    BookmarkMenuController.a(this.b, null);
    BookmarkMenuController.a(this.b, new BookmarkEditFragment(this.a));
    FragmentTransaction localFragmentTransaction = BookmarkMenuController.b(this.b).g().a();
    localFragmentTransaction.b(2131297048, BookmarkMenuController.c(this.b));
    localFragmentTransaction.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkMenuController.2
 * JD-Core Version:    0.6.0
 */