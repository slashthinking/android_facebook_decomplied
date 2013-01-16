package com.facebook.katana.ui.bookmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.ui.BaseBookmarkMenuFragment;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookmarkGroupFragment extends BaseBookmarkMenuFragment
{
  private BookmarksGroup e;
  private Button f;
  private BookmarkMenuController g;
  private FB4AViewItemFactory h;

  public BookmarkGroupFragment()
  {
    super(2130903075, 2131296420);
  }

  public BookmarkGroupFragment(BookmarksGroup paramBookmarksGroup)
  {
    super(2130903075, 2131296420);
    this.e = ((BookmarksGroup)Preconditions.checkNotNull(paramBookmarksGroup));
  }

  protected int a()
  {
    return BookmarkGroupFragment.ViewItemType.values().length;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.g = ((BookmarkMenuController)R().a(BookmarkMenuController.class));
    if ((paramBundle != null) && (this.e == null))
      this.e = ((BookmarksGroup)paramBundle.getParcelable("bookmarks_group"));
  }

  public void a(FetchBookmarksResult paramFetchBookmarksResult, boolean paramBoolean)
  {
    if (!paramBoolean)
      return;
    while (true)
    {
      Iterator localIterator = paramFetchBookmarksResult.a().iterator();
      if (!localIterator.hasNext())
        continue;
      BookmarksGroup localBookmarksGroup = (BookmarksGroup)localIterator.next();
      if ((!localBookmarksGroup.id.equals(this.e.id)) || (!localBookmarksGroup.name.equals(this.e.name)))
        break;
      this.e = localBookmarksGroup;
      b();
    }
  }

  protected void b()
  {
    ArrayList localArrayList = Lists.a();
    List localList = this.e.c();
    for (int i = 0; i < localList.size(); i++)
      localArrayList.add(this.h.a(BookmarkGroupFragment.ViewItemType.Bookmark, (Bookmark)localList.get(i), i));
    a(localArrayList);
  }

  public void d(Bundle paramBundle)
  {
    this.h = new FB4AViewItemFactory(n(), (LayoutInflater)R().a(LayoutInflater.class));
    super.d(paramBundle);
    if (this.f == null)
    {
      this.f = ((Button)i(2131296423));
      this.f.setOnClickListener(new BookmarkGroupFragment.1(this));
    }
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelable("bookmarks_group", this.e);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkGroupFragment
 * JD-Core Version:    0.6.0
 */