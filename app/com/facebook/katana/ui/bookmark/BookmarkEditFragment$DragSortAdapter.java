package com.facebook.katana.ui.bookmark;

import com.facebook.bookmark.ui.BookmarkAdapter;
import com.facebook.widget.DragSortListView.DragSortListAdapter;

class BookmarkEditFragment$DragSortAdapter extends BookmarkAdapter
  implements DragSortListView.DragSortListAdapter
{
  public BookmarkEditFragment$DragSortAdapter(BookmarkEditFragment paramBookmarkEditFragment, int paramInt)
  {
    super(paramInt);
  }

  public int a()
  {
    return 1 + BookmarkEditFragment.a(this.c);
  }

  public int b()
  {
    return BookmarkEditFragment.b(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkEditFragment.DragSortAdapter
 * JD-Core Version:    0.6.0
 */