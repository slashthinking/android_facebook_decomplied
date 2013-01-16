package com.facebook.katana.ui.bookmark;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.analytics.InteractionLogger;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.ui.BaseBookmarkMenuFragment;
import com.facebook.bookmark.ui.BaseViewItemFactory.DividerViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.ViewItem;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class BookmarkMenuFragment extends BaseBookmarkMenuFragment
{
  private boolean Y = false;
  private BookmarkAdapter.ViewItem Z;
  private EditText aa;
  private InteractionLogger ab;
  private final Object ac = new Object();
  private boolean e = false;
  private List<BookmarksGroup> f = null;
  private BookmarkMenuController g;
  private FB4AViewItemFactory h;
  private BookmarkAdapter.ViewItem i;

  public BookmarkMenuFragment()
  {
    super(2130903265, 2131296420);
  }

  public BookmarkMenuFragment(List<BookmarksGroup> paramList)
  {
    super(2130903265, 2131296420);
    this.f = paramList;
  }

  private void M()
  {
    CharSequence[] arrayOfCharSequence = new CharSequence[4];
    arrayOfCharSequence[0] = e(2131362807);
    arrayOfCharSequence[1] = e(2131362808);
    arrayOfCharSequence[2] = e(2131363456);
    arrayOfCharSequence[3] = e(2131362961);
    new AlertDialog.Builder(n()).setItems(arrayOfCharSequence, new BookmarkMenuFragment.3(this)).show();
  }

  private void N()
  {
    this.Y = false;
    this.a.notifyDataSetChanged();
  }

  public static List<BookmarksGroup> b(Context paramContext)
  {
    ArrayList localArrayList1 = Lists.a();
    String str = paramContext.getString(2131362844);
    Bookmark[] arrayOfBookmark = new Bookmark[1];
    arrayOfBookmark[0] = c(paramContext);
    localArrayList1.add(new BookmarksGroup("profile", str, 1, Lists.a(arrayOfBookmark)));
    ArrayList localArrayList2 = Lists.a();
    localArrayList2.add(d(paramContext));
    localArrayList2.add(e(paramContext));
    localArrayList2.add(f(paramContext));
    localArrayList2.add(g(paramContext));
    localArrayList2.add(h(paramContext));
    localArrayList1.add(new BookmarksGroup("-1", paramContext.getString(2131362837), localArrayList2.size(), localArrayList2));
    return localArrayList1;
  }

  public static Bookmark c(Context paramContext)
  {
    String str1 = (String)paramContext.getText(2131362844);
    AppSession localAppSession = AppSession.b(paramContext, false);
    FacebookUser localFacebookUser;
    if (localAppSession != null)
    {
      localFacebookUser = localAppSession.b().a();
      if ((localFacebookUser == null) || (localFacebookUser.mDisplayName == null));
    }
    for (String str2 = localFacebookUser.mDisplayName; ; str2 = str1)
      return new Bookmark(-1L, str2, "fb://profile", 0, null, null, "profile");
  }

  public static Bookmark d(Context paramContext)
  {
    return new Bookmark(4748854339L, paramContext.getString(2131362832), "fb://feed", 0, "http://www.facebook.com/images/icons/newsfeed.png", "http://www.facebook.com/images/m/faceweb/ios/feedButton.png", "app");
  }

  public static Bookmark e(Context paramContext)
  {
    return new Bookmark(217974574879787L, paramContext.getString(2131362833), "fb://messaging", 0, "http://www.facebook.com/images/icons/messages.png", "http://www.facebook.com/images/m/faceweb/ios/inboxButton.png", "app");
  }

  public static Bookmark f(Context paramContext)
  {
    return new Bookmark(-1L, paramContext.getString(2131362960), "fb://online", 0, "/images/im_online.gif", "http://www.facebook.com/images/m/faceweb/ios/chatButton.png", "app");
  }

  public static Bookmark g(Context paramContext)
  {
    return new Bookmark(-1L, paramContext.getString(2131362834), "fb://events", 0, "http://www.facebook.com/images/icons/event.gif", "http://www.facebook.com/images/m/faceweb/ios/eventsButton.png", "app");
  }

  public static Bookmark h(Context paramContext)
  {
    return new Bookmark(-1L, paramContext.getString(2131362835), "fb://friends/", 0, "http://www.facebook.com/images/icons/friends.png", "http://www.facebook.com/images/m/faceweb/ios/friendsButton.png", "app");
  }

  public static Bookmark i(Context paramContext)
  {
    return new Bookmark(-1L, paramContext.getString(2131362959), "fb://help", 0, "/images/icons/help.png", null, "app");
  }

  public static Bookmark j(Context paramContext)
  {
    return new Bookmark(-1L, paramContext.getString(2131363051), "fb://faceweb/f?href=%2Fprivacy", 0, "/images/icons/privacy.png", null, "app");
  }

  public static Bookmark k(Context paramContext)
  {
    return new Bookmark(-1L, paramContext.getString(2131363052), "fb://faceweb/f?href=%2Fpolicies", 0, "/images/icons/policies.png", null, "app");
  }

  public void B()
  {
    super.B();
    this.g.a(true);
  }

  protected List<BookmarksGroup> L()
  {
    return b(n());
  }

  protected int a()
  {
    return BookmarkMenuFragment.ViewItemType.values().length;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if ((paramBundle != null) && (this.f == null))
      this.f = paramBundle.getParcelableArrayList("prepared_bookmarks");
    this.g = ((BookmarkMenuController)R().a(BookmarkMenuController.class));
  }

  public void a(FetchBookmarksResult paramFetchBookmarksResult, boolean paramBoolean)
  {
    if (this.Y)
    {
      this.Y = false;
      if (this.g != null)
        this.g.a(paramFetchBookmarksResult.a());
    }
    while (true)
    {
      return;
      if ((paramBoolean) || (this.e))
      {
        this.e = false;
        this.f = null;
        ImmutableList localImmutableList = paramFetchBookmarksResult.a();
        if (localImmutableList.isEmpty())
        {
          b(L());
          continue;
        }
        b(localImmutableList);
        continue;
      }
    }
  }

  public void a(BookmarksGroup paramBookmarksGroup)
  {
    if ((this.c != null) && (!this.Y))
      b(this.c.a());
  }

  public void a(ServiceException paramServiceException)
  {
    if (this.Y)
    {
      N();
      new AlertDialog.Builder(n()).setIcon(17301543).setMessage(q().getString(2131362843)).show();
    }
  }

  protected void b()
  {
    if (this.f != null)
    {
      b(this.f);
      this.f = null;
    }
    while (true)
    {
      return;
      FetchBookmarksResult localFetchBookmarksResult = this.c.c();
      if ((localFetchBookmarksResult.e() == DataFreshnessResult.NO_DATA) || (localFetchBookmarksResult.e() == DataFreshnessResult.FROM_CACHE_STALE))
        this.e = true;
      if (localFetchBookmarksResult.a().isEmpty())
      {
        b(L());
        continue;
      }
      b(localFetchBookmarksResult.a());
    }
  }

  public void b(List<BookmarksGroup> paramList)
  {
    ArrayList localArrayList = Lists.a();
    int j = 0;
    int k;
    label52: BookmarksGroup localBookmarksGroup;
    if (j < paramList.size())
    {
      if ("settings".equals(paramList.get(j)))
        paramList.add((BookmarksGroup)paramList.remove(j));
    }
    else
    {
      k = 0;
      if (k >= paramList.size())
        break label313;
      localBookmarksGroup = (BookmarksGroup)paramList.get(k);
      if (localBookmarksGroup.b() != 0)
        break label96;
    }
    while (true)
    {
      k++;
      break label52;
      j++;
      break;
      label96: boolean bool;
      int m;
      label149: Bookmark localBookmark;
      Object localObject;
      if (k > 0)
      {
        FB4AViewItemFactory localFB4AViewItemFactory = this.h;
        BookmarkMenuFragment.ViewItemType localViewItemType = BookmarkMenuFragment.ViewItemType.Divider;
        if (k > 1)
        {
          bool = true;
          localArrayList.add(localFB4AViewItemFactory.a(localViewItemType, localBookmarksGroup, bool));
        }
      }
      else
      {
        List localList = localBookmarksGroup.a();
        m = 0;
        if (m >= localList.size())
          break label277;
        localBookmark = (Bookmark)localList.get(m);
        if (!"profile".equals(localBookmarksGroup.id))
          break label223;
        localObject = this.h.a(BookmarkMenuFragment.ViewItemType.Profile, localBookmark);
      }
      while (true)
      {
        localArrayList.add(localObject);
        m++;
        break label149;
        bool = false;
        break;
        label223: if (4748854339L == localBookmark.id)
        {
          localObject = this.h.a(BookmarkMenuFragment.ViewItemType.NewsFeed, localBookmark, m, this.b);
          continue;
        }
        localObject = this.h.a(BookmarkMenuFragment.ViewItemType.Bookmark, localBookmark, m);
      }
      label277: if (!localBookmarksGroup.e())
        continue;
      localArrayList.add(this.h.a(BookmarkMenuFragment.ViewItemType.SeeAll, localBookmarksGroup, 2130838908, 2131363406));
    }
    label313: c(localArrayList);
    a(localArrayList);
  }

  protected void c(List<BookmarkAdapter.ViewItem> paramList)
  {
    int j = -1 + paramList.size();
    if (j >= 0)
    {
      BookmarkAdapter.ViewItem localViewItem = (BookmarkAdapter.ViewItem)paramList.get(j);
      if ((localViewItem instanceof BaseViewItemFactory.DividerViewItem))
        if (!"settings".equals(((BookmarksGroup)((BaseViewItemFactory.DividerViewItem)localViewItem).b()).id))
          break label255;
    }
    label255: for (int k = 1; ; k = 0)
    {
      if (k == 0)
        paramList.add(this.h.a(BookmarkMenuFragment.ViewItemType.Divider, new BookmarksGroup("settings", e(2131362805), 0, new ArrayList()), true));
      paramList.add(this.Z);
      paramList.add(this.h.a(BookmarkMenuFragment.ViewItemType.IconLable, this.ac, 2130837504, 2131362806));
      paramList.add(this.h.a(BookmarkMenuFragment.ViewItemType.IconLable, j(n()), 2130838174, 2131363051));
      paramList.add(this.h.a(BookmarkMenuFragment.ViewItemType.IconLable, k(n()), 2130838968, 2131363052));
      paramList.add(this.h.a(BookmarkMenuFragment.ViewItemType.IconLable, i(n()), 2130838168, 2131362959));
      if (this.e)
        paramList.add(this.i);
      return;
      j--;
      break;
    }
  }

  public void d(Bundle paramBundle)
  {
    this.aa = ((EditText)i(2131297050));
    this.aa.setOnClickListener(new BookmarkMenuFragment.1(this));
    this.h = new FB4AViewItemFactory(n(), (LayoutInflater)R().a(LayoutInflater.class));
    this.i = this.h.a(BookmarkMenuFragment.ViewItemType.Loader);
    this.Z = new BookmarkMenuFragment.2(this, BookmarkMenuFragment.ViewItemType.EditFavorites, 2130903068, null, (LayoutInflater)R().a(LayoutInflater.class));
    this.ab = new InteractionLogger(n());
    super.d(paramBundle);
  }

  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.f != null)
      paramBundle.putParcelableArrayList("prepared_bookmarks", Lists.a(this.f));
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.a.getItem(paramInt);
    if (!(localObject instanceof BookmarkAdapter.BaseViewItem));
    while (true)
    {
      return;
      BookmarkAdapter.BaseViewItem localBaseViewItem = (BookmarkAdapter.BaseViewItem)localObject;
      BookmarkMenuFragment.ViewItemType localViewItemType = (BookmarkMenuFragment.ViewItemType)localBaseViewItem.a();
      FB4AViewItemFactory.BookmarkEditViewHolder localBookmarkEditViewHolder;
      if (localViewItemType == BookmarkMenuFragment.ViewItemType.EditFavorites)
      {
        localBookmarkEditViewHolder = (FB4AViewItemFactory.BookmarkEditViewHolder)paramView.getTag();
        if (!this.Y)
          break label147;
        localBookmarkEditViewHolder.b();
        localBookmarkEditViewHolder.e.setText(2131362838);
        label76: if (this.Y)
          break label175;
      }
      label147: label175: for (boolean bool = true; ; bool = false)
      {
        this.Y = bool;
        if ((localViewItemType != BookmarkMenuFragment.ViewItemType.SeeAll) || (this.g == null))
          break label181;
        BookmarksGroup localBookmarksGroup = (BookmarksGroup)localBaseViewItem.b();
        this.ab.a(localBookmarksGroup.id, FB4A_AnalyticEntities.UIElementsTypes.e, FB4A_AnalyticEntities.UIElements.y);
        this.g.a(localBookmarksGroup);
        break;
        localBookmarkEditViewHolder.a();
        localBookmarkEditViewHolder.e.setText(2131362840);
        this.c.d();
        break label76;
      }
      label181: if ((localViewItemType == BookmarkMenuFragment.ViewItemType.IconLable) && (this.ac.equals(localBaseViewItem.b())))
      {
        this.ab.a("account", FB4A_AnalyticEntities.UIElementsTypes.e, FB4A_AnalyticEntities.UIElements.y);
        M();
        continue;
      }
      super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkMenuFragment
 * JD-Core Version:    0.6.0
 */