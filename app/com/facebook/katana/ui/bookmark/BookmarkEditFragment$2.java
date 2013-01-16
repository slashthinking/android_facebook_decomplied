package com.facebook.katana.ui.bookmark;

import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.widget.DragSortListView.DropListener;
import java.util.List;

class BookmarkEditFragment$2
  implements DragSortListView.DropListener
{
  public void a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - BookmarkEditFragment.a(this.a);
    int j = paramInt2 - BookmarkEditFragment.a(this.a);
    Bookmark localBookmark = (Bookmark)BookmarkEditFragment.c(this.a).remove(i);
    BookmarkEditFragment.c(this.a).add(j, localBookmark);
    BookmarkEditFragment.d(this.a).a(BookmarkEditFragment.c(this.a), BookmarkEditFragment.c(this.a).size());
    BookmarkEditFragment.a(this.a, true);
    this.a.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkEditFragment.2
 * JD-Core Version:    0.6.0
 */