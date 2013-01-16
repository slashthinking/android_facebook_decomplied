package com.facebook.katana.ui.bookmark;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.ui.BaseBookmarkMenuFragment;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.ScreenSlider;
import com.facebook.widget.ScreenSlider.ScreenSliderHost;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookmarkMenuController extends ScreenSlider
{
  private static String e = null;
  private final UserInteractionController a;
  private FragmentActivity b;
  private View c;
  private BaseBookmarkMenuFragment d;
  private BookmarkEditFragment f;
  private boolean g;

  public BookmarkMenuController(UserInteractionController paramUserInteractionController)
  {
    super(-1, 55.0F, 360.0F);
    this.a = paramUserInteractionController;
  }

  private void a(BookmarksGroup paramBookmarksGroup, boolean paramBoolean)
  {
    this.d = new BookmarkGroupFragment(paramBookmarksGroup);
    if (!paramBookmarksGroup.id.equals(e))
      this.d.d();
    e = paramBookmarksGroup.id;
    FragmentTransaction localFragmentTransaction = this.b.g().a();
    if (paramBoolean)
      localFragmentTransaction.a(2130968614, 2130968616);
    localFragmentTransaction.b(2131297048, this.d);
    localFragmentTransaction.b();
  }

  private void a(boolean paramBoolean, List<BookmarksGroup> paramList)
  {
    e = null;
    this.d = new BookmarkMenuFragment(paramList);
    if (paramList != null)
      this.d.d();
    FragmentTransaction localFragmentTransaction = this.b.g().a();
    if (paramBoolean)
      localFragmentTransaction.a(2130968618, 2130968620);
    localFragmentTransaction.b(2131297048, this.d);
    localFragmentTransaction.b();
  }

  public void a()
  {
    super.a();
    this.b = null;
    this.c = null;
    this.d = null;
    this.f = null;
  }

  public void a(Activity paramActivity, ScreenSlider.ScreenSliderHost paramScreenSliderHost)
  {
    if (!(paramActivity instanceof FragmentActivity))
      throw new IllegalStateException("BookmarkMenuController must be attached to a FragmentActivity");
    super.a(paramActivity, paramScreenSliderHost);
    this.b = ((FragmentActivity)paramActivity);
    this.g = true;
  }

  public void a(BookmarksGroup paramBookmarksGroup)
  {
    a(paramBookmarksGroup, true);
  }

  public void a(List<BookmarksGroup> paramList)
  {
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((BookmarksGroup)localIterator.next()).d());
    a(0.0F, new BookmarkMenuController.2(this, localArrayList));
  }

  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  protected void b()
  {
    super.b();
    this.a.a(this.c);
  }

  public void b(List<BookmarksGroup> paramList)
  {
    a(55.0F, new BookmarkMenuController.3(this, paramList));
  }

  protected void c()
  {
    super.c();
    if (this.d != null)
      this.c.post(new BookmarkMenuController.1(this));
    this.a.b(this.c);
  }

  protected void d()
  {
    super.d();
    this.a.a(this.c);
  }

  protected void e()
  {
    super.e();
    this.a.b(this.c);
  }

  public View f()
  {
    this.c = LayoutInflater.from(this.b).inflate(2130903264, null);
    if (e == null)
      a(false, null);
    label116: 
    while (true)
    {
      return this.c;
      Iterator localIterator = ((BookmarkManager)FbInjector.a(this.b).a(BookmarkManager.class)).a().iterator();
      while (localIterator.hasNext())
      {
        BookmarksGroup localBookmarksGroup = (BookmarksGroup)localIterator.next();
        if (!e.equals(localBookmarksGroup.id))
          continue;
        a(localBookmarksGroup, false);
      }
      for (int i = 1; ; i = 0)
      {
        if (i != 0)
          break label116;
        a(false, null);
        break;
      }
    }
  }

  public void g()
  {
    if (this.g)
      o();
  }

  public void h()
  {
    if (this.f != null)
      this.f.a(false);
    while (true)
    {
      return;
      if (e != null)
      {
        i();
        continue;
      }
      n();
    }
  }

  public void i()
  {
    a(true, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkMenuController
 * JD-Core Version:    0.6.0
 */