package com.facebook.katana.ui.bookmark;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.event.BookmarkEvent;
import com.facebook.bookmark.ui.event.BookmarkEventBuilder;
import com.facebook.bookmark.ui.event.OnBookmarkSelectedListener;
import com.facebook.feed.model.NewsFeedType;

class FB4AViewItemFactory$NewsFeedViewItem$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    OnBookmarkSelectedListener localOnBookmarkSelectedListener = FB4AViewItemFactory.NewsFeedViewItem.b(this.b);
    BookmarkEventBuilder localBookmarkEventBuilder = BookmarkEvent.newBuilder().a(FB4AViewItemFactory.g(this.b.a)).a(this.a);
    if (paramInt == 0);
    for (NewsFeedType localNewsFeedType = NewsFeedType.TOP_STORIES; ; localNewsFeedType = NewsFeedType.MOST_RECENT)
    {
      localOnBookmarkSelectedListener.a(localBookmarkEventBuilder.a(localNewsFeedType).a());
      paramDialogInterface.dismiss();
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.FB4AViewItemFactory.NewsFeedViewItem.2
 * JD-Core Version:    0.6.0
 */