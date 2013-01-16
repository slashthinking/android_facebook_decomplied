package com.facebook.katana.ui.bookmark;

import android.app.AlertDialog.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.ui.BookmarkAdapter;
import com.facebook.katana.ui.BookmarksDragSortListView;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookmarkEditFragment extends FbFragment
{
  private boolean Y = false;
  private BookmarkManager Z;
  private BookmarksDragSortListView a;
  private FB4AViewItemFactory aa;
  private boolean ab = false;
  private BookmarkAdapter b;
  private Button c;
  private BookmarkMenuController d;
  private List<BookmarksGroup> e;
  private BookmarksGroup f;
  private List<Bookmark> g = null;
  private int h;
  private int i;

  public BookmarkEditFragment()
  {
  }

  public BookmarkEditFragment(List<BookmarksGroup> paramList)
  {
    a(paramList);
  }

  private void a(Bookmark paramBookmark)
  {
    boolean bool = this.f.a(paramBookmark);
    Object[] arrayOfObject2;
    if (bool)
    {
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramBookmark.name;
    }
    Object[] arrayOfObject1;
    for (String str = a(2131362841, arrayOfObject2); ; str = a(2131362842, arrayOfObject1))
    {
      new AlertDialog.Builder(n()).setIcon(17301543).setMessage(str).setPositiveButton(2131363280, new BookmarkEditFragment.5(this, bool, paramBookmark)).setNegativeButton(2131363016, null).show();
      return;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramBookmark.name;
    }
  }

  private void a(List<BookmarksGroup> paramList)
  {
    this.e = ((List)Preconditions.checkNotNull(paramList));
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      BookmarksGroup localBookmarksGroup = (BookmarksGroup)localIterator.next();
      if (!"pinned".equals(localBookmarksGroup.id))
        continue;
      this.g = Lists.a(localBookmarksGroup.c());
      this.f = localBookmarksGroup;
    }
    Preconditions.checkNotNull(this.g, "There is no favorites bookmark group!");
  }

  private void b(Bookmark paramBookmark)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      Bookmark localBookmark = (Bookmark)localIterator.next();
      if (localBookmark.id != paramBookmark.id)
        continue;
      this.g.remove(localBookmark);
    }
    this.f.a(this.g, this.g.size());
  }

  private void c(Bookmark paramBookmark)
  {
    this.g.add(paramBookmark);
    this.f.a(this.g, this.g.size());
  }

  public void C()
  {
    a(false);
    super.C();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903074, paramViewGroup, false);
  }

  public void a()
  {
    if (!s());
    while (true)
    {
      return;
      ArrayList localArrayList = Lists.a();
      label292: for (int j = 0; j < this.e.size(); j++)
      {
        BookmarksGroup localBookmarksGroup = (BookmarksGroup)this.e.get(j);
        boolean bool3;
        if (j > 0)
        {
          FB4AViewItemFactory localFB4AViewItemFactory2 = this.aa;
          BookmarkEditFragment.ViewItemType localViewItemType2 = BookmarkEditFragment.ViewItemType.Divider;
          if (j > 1)
          {
            bool3 = true;
            localArrayList.add(localFB4AViewItemFactory2.a(localViewItemType2, localBookmarksGroup, bool3));
          }
        }
        else
        {
          if (this.f != localBookmarksGroup)
            break label221;
        }
        Bookmark localBookmark;
        Object localObject;
        label221: for (boolean bool1 = true; ; bool1 = false)
        {
          List localList = localBookmarksGroup.c();
          if (bool1)
          {
            this.h = localArrayList.size();
            this.i = (-1 + (localArrayList.size() + localList.size()));
          }
          for (int k = 0; ; k++)
          {
            if (k >= localList.size())
              break label292;
            localBookmark = (Bookmark)localList.get(k);
            if ((!"profile".equals(localBookmarksGroup.id)) && (4748854339L != localBookmark.id))
              break;
            localObject = this.aa.b(BookmarkEditFragment.ViewItemType.Pinned, localBookmark);
            localArrayList.add(localObject);
          }
          bool3 = false;
          break;
        }
        FB4AViewItemFactory localFB4AViewItemFactory1 = this.aa;
        BookmarkEditFragment.ViewItemType localViewItemType1 = BookmarkEditFragment.ViewItemType.Editable;
        if ((bool1) || (this.f.a(localBookmark)));
        for (boolean bool2 = true; ; bool2 = false)
        {
          localObject = localFB4AViewItemFactory1.a(localViewItemType1, localBookmark, bool2, bool1, new BookmarkEditFragment.1(this, localBookmark));
          break;
        }
      }
      this.b.a(localArrayList);
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.d = ((BookmarkMenuController)R().a(BookmarkMenuController.class));
    if ((paramBundle != null) && (this.e == null))
      a(paramBundle.getParcelableArrayList("saved_bookmarks"));
  }

  public void a(boolean paramBoolean)
  {
    if (this.ab)
      return;
    if ((paramBoolean) && (this.Y))
    {
      List localList = Lists.a(this.g, new BookmarkEditFragment.4(this));
      this.Z.a(localList);
      this.d.b(this.e);
    }
    while (true)
    {
      this.ab = true;
      break;
      this.d.b(null);
    }
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.aa = new FB4AViewItemFactory(n(), (LayoutInflater)R().a(LayoutInflater.class));
    this.ab = false;
    this.b = new BookmarkEditFragment.DragSortAdapter(this, BookmarkEditFragment.ViewItemType.values().length);
    this.a = ((BookmarksDragSortListView)i(2131296420));
    if (Build.VERSION.SDK_INT <= 10)
      this.a.setScrollingCacheEnabled(false);
    this.a.setAdapter(this.b);
    this.a.setTopEmptyId(2131296639);
    this.a.setBottomEmptyId(2131296642);
    this.a.setDropListener(new BookmarkEditFragment.2(this));
    this.c = ((Button)i(2131296419));
    this.c.setOnClickListener(new BookmarkEditFragment.3(this));
    this.Z = ((BookmarkManager)FbInjector.a(n()).a(BookmarkManager.class));
    a();
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putParcelableArrayList("saved_bookmarks", Lists.a(this.e));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkEditFragment
 * JD-Core Version:    0.6.0
 */