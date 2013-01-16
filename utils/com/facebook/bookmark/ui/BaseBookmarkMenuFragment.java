package com.facebook.bookmark.ui;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.bookmark.BookmarkLoaderCallbacks;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.BookmarkManager.BookmarkCallback;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.ui.event.BookmarkEvent;
import com.facebook.bookmark.ui.event.BookmarkEventBuilder;
import com.facebook.bookmark.ui.event.OnBookmarkSelectedListener;
import com.facebook.common.util.Log;
import com.facebook.orca.activity.FbFragment;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.ServiceException;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class BaseBookmarkMenuFragment extends FbFragment
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, BookmarkManager.BookmarkCallback
{
  private static String h = null;
  private static Map<Class<? extends BaseBookmarkMenuFragment>, BaseBookmarkMenuFragment.ScrollState> i = Maps.a();
  protected BookmarkAdapter a;
  protected OnBookmarkSelectedListener b;
  protected BookmarkManager c;
  protected Map<Long, Integer> d = Maps.a();
  private final int e;
  private final int f;
  private ListView g;

  public BaseBookmarkMenuFragment(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }

  private BaseViewItemFactory.BookmarkViewHolder g(int paramInt)
  {
    View localView = f(paramInt);
    if (localView != null);
    for (BaseViewItemFactory.BookmarkViewHolder localBookmarkViewHolder = (BaseViewItemFactory.BookmarkViewHolder)localView.getTag(); ; localBookmarkViewHolder = null)
      return localBookmarkViewHolder;
  }

  public void B()
  {
    BaseBookmarkMenuFragment.ScrollState localScrollState = c();
    super.B();
    this.g.setSelectionFromTop(localScrollState.a, localScrollState.b);
    String str = Locale.getDefault().toString();
    if (h == null)
      h = str;
    if (!Objects.equal(str, h))
    {
      h = str;
      this.c.d();
    }
  }

  public void C()
  {
    super.C();
    int j = this.g.getFirstVisiblePosition();
    View localView = this.g.getChildAt(0);
    int k = 0;
    if (localView == null);
    while (true)
    {
      a(new BaseBookmarkMenuFragment.ScrollState(j, k, null));
      return;
      k = localView.getTop();
    }
  }

  public void K()
  {
    Bundle localBundle = n().getIntent().getBundleExtra("bookmark_identifier");
    if (localBundle == null);
    label170: 
    while (true)
    {
      return;
      String str = localBundle.getString("url");
      int j = this.g.getFirstVisiblePosition();
      int k = this.g.getLastVisiblePosition();
      for (int m = j; ; m++)
      {
        if (m > k)
          break label170;
        Bookmark localBookmark = ((BookmarkAdapter.ViewItem)this.a.getItem(m)).c();
        if ((localBookmark != null) && (localBookmark.url.equals(str)))
        {
          View localView1 = this.g.getChildAt(m - j);
          if (localView1 == null)
            break;
          View localView2 = localView1.findViewById(2131296410);
          if (localView2 == null)
            break;
          TransitionDrawable localTransitionDrawable = (TransitionDrawable)localView2.getBackground();
          localTransitionDrawable.setCrossFadeEnabled(true);
          localTransitionDrawable.startTransition(1);
          this.g.postDelayed(new BaseBookmarkMenuFragment.1(this, localTransitionDrawable), 140L);
          break;
        }
      }
    }
  }

  protected abstract int a();

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(this.e, paramViewGroup, false);
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FbInjector localFbInjector = R();
    this.b = ((OnBookmarkSelectedListener)localFbInjector.a(OnBookmarkSelectedListener.class));
    this.c = ((BookmarkManager)localFbInjector.a(BookmarkManager.class));
  }

  public void a(Bookmark paramBookmark)
  {
    if (!this.d.containsKey(Long.valueOf(paramBookmark.id)));
    Bookmark localBookmark;
    BaseViewItemFactory.BookmarkViewHolder localBookmarkViewHolder;
    do
    {
      int j;
      BookmarkAdapter.BaseViewItem localBaseViewItem;
      while (true)
      {
        return;
        j = ((Integer)this.d.get(Long.valueOf(paramBookmark.id))).intValue();
        localBaseViewItem = (BookmarkAdapter.BaseViewItem)this.a.getItem(j);
        if ((localBaseViewItem.b() instanceof Bookmark))
          break;
        Log.a(BaseBookmarkMenuFragment.class, "could not update unread count in the list view because the position went wrong!");
      }
      localBookmark = (Bookmark)localBaseViewItem.b();
      localBookmark.a(paramBookmark.a());
      localBookmarkViewHolder = g(j);
    }
    while (localBookmarkViewHolder == null);
    if (localBookmark.a() > 0)
    {
      localBookmarkViewHolder.c.setVisibility(0);
      localBookmarkViewHolder.c.setText(String.valueOf(localBookmark.a()));
    }
    while (true)
    {
      localBookmarkViewHolder.c.invalidate();
      break;
      localBookmarkViewHolder.c.setVisibility(8);
    }
  }

  public void a(BookmarksGroup paramBookmarksGroup)
  {
  }

  protected void a(BaseBookmarkMenuFragment.ScrollState paramScrollState)
  {
    i.put(getClass(), paramScrollState);
  }

  public void a(ServiceException paramServiceException)
  {
  }

  public void a(List<BookmarkAdapter.ViewItem> paramList)
  {
    Preconditions.checkNotNull(paramList);
    if (!s());
    while (true)
    {
      return;
      for (int j = 0; j < paramList.size(); j++)
      {
        Bookmark localBookmark = ((BookmarkAdapter.ViewItem)paramList.get(j)).c();
        if (localBookmark != null)
          this.d.put(Long.valueOf(localBookmark.id), Integer.valueOf(j));
      }
      this.a.a(paramList);
    }
  }

  protected abstract void b();

  protected BaseBookmarkMenuFragment.ScrollState c()
  {
    if (i.containsKey(getClass()));
    for (BaseBookmarkMenuFragment.ScrollState localScrollState = (BaseBookmarkMenuFragment.ScrollState)i.get(getClass()); ; localScrollState = new BaseBookmarkMenuFragment.ScrollState(0, 0, null))
      return localScrollState;
  }

  public void d()
  {
    a(new BaseBookmarkMenuFragment.ScrollState(0, 0, null));
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.a = new BookmarkAdapter(a());
    b();
    this.g = ((ListView)i(this.f));
    if (Build.VERSION.SDK_INT <= 10)
      this.g.setScrollingCacheEnabled(false);
    this.g.setEnabled(true);
    this.g.setOnItemClickListener(this);
    this.g.setOnItemLongClickListener(this);
    this.g.setAdapter(this.a);
    z().a(0, null, new BookmarkLoaderCallbacks(n(), this.c, true, this));
  }

  protected View f(int paramInt)
  {
    int j = paramInt - (this.g.getFirstVisiblePosition() - this.g.getHeaderViewsCount());
    if ((j >= 0) && (j < this.g.getChildCount()));
    for (View localView = this.g.getChildAt(j); ; localView = null)
      return localView;
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.a.getItem(paramInt);
    if (!(localObject instanceof BookmarkAdapter.BaseViewItem));
    while (true)
    {
      return;
      BookmarkAdapter.BaseViewItem localBaseViewItem = (BookmarkAdapter.BaseViewItem)localObject;
      if ((localBaseViewItem.b() instanceof Bookmark))
        this.b.a(BookmarkEvent.newBuilder().a(n()).a((Bookmark)localBaseViewItem.b()).a());
    }
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    BookmarkAdapter.BaseViewItem localBaseViewItem = (BookmarkAdapter.BaseViewItem)this.a.getItem(paramInt);
    if ((localBaseViewItem.b() instanceof Bookmark));
    for (boolean bool = this.b.a(BookmarkEvent.newBuilder().a(n()).a((Bookmark)localBaseViewItem.b()).a(true).a()); ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ui.BaseBookmarkMenuFragment
 * JD-Core Version:    0.6.2
 */