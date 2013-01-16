package com.facebook.katana.ui.bookmark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.analytics.InteractionLogger;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.ui.event.BaseBookmarkSelectedListener;
import com.facebook.bookmark.ui.event.BookmarkEvent;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.annotations.IsNativeNewsFeedEnabled;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.NativeThirdPartyUriHelper;
import com.facebook.katana.activity.FacebookActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.FbFragmentChromeActivity;
import com.facebook.katana.activity.photos.PhotosTabActivity;
import com.facebook.katana.model.FacebookAffiliation;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.threadlist.ThreadListActivity;
import com.facebook.widget.ScreenSlider;

public class FB4ABookmarkSelectedListener extends BaseBookmarkSelectedListener
{
  private final ScreenSlider a;
  private final BookmarkManager b;
  private final FacebookActivityDelegate c;

  public FB4ABookmarkSelectedListener(ScreenSlider paramScreenSlider, BookmarkManager paramBookmarkManager, FacebookActivityDelegate paramFacebookActivityDelegate)
  {
    this.c = paramFacebookActivityDelegate;
    this.a = paramScreenSlider;
    this.b = paramBookmarkManager;
  }

  private static Intent a(Context paramContext, NewsFeedType paramNewsFeedType)
  {
    return a(paramContext, paramNewsFeedType, null);
  }

  private static Intent a(Context paramContext, NewsFeedType paramNewsFeedType, String paramString)
  {
    Intent localIntent = new Intent(paramContext, FbFragmentChromeActivity.class);
    if (!a(paramContext))
      localIntent.putExtra("target_fragment", 0);
    while (true)
    {
      return localIntent;
      localIntent.putExtra("target_fragment", 1);
      localIntent.putExtra("feed_type", paramNewsFeedType.value);
      if (paramString == null)
        continue;
      localIntent.putExtra("friend_list_feed_id", paramString);
    }
  }

  private static String a(String paramString)
  {
    String str;
    if (paramString != null)
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri != null)
      {
        str = new Uri.Builder().scheme(localUri.getScheme()).authority(localUri.getAuthority()).path(localUri.getPath()).toString();
        if (str.endsWith("/"));
      }
    }
    while (true)
    {
      return str;
      str = str.substring(0, -1 + str.length());
      continue;
      str = null;
    }
  }

  private void a(BookmarkEvent paramBookmarkEvent, NewsFeedType paramNewsFeedType)
  {
    OrcaSharedPreferences.Editor localEditor = ((OrcaSharedPreferences)FbInjector.a(paramBookmarkEvent.a).a(OrcaSharedPreferences.class)).b();
    localEditor.a(FbandroidPrefKeys.m, paramNewsFeedType.ordinal());
    localEditor.a();
  }

  private static boolean a(Context paramContext)
  {
    return ((Boolean)FbInjector.a(paramContext).a(Boolean.class, IsNativeNewsFeedEnabled.class)).booleanValue();
  }

  private Intent d(BookmarkEvent paramBookmarkEvent)
  {
    Bookmark localBookmark = paramBookmarkEvent.b;
    Intent localIntent;
    if ((localBookmark != null) && (4748854339L == localBookmark.id))
    {
      a(paramBookmarkEvent, NewsFeedType.TOP_STORIES);
      localIntent = a(paramBookmarkEvent.a, NewsFeedType.TOP_STORIES);
    }
    while (true)
    {
      return localIntent;
      if ((localBookmark != null) && ("friend_list".equals(localBookmark.type)))
      {
        localIntent = a(paramBookmarkEvent.a, NewsFeedType.MOST_RECENT, String.valueOf(localBookmark.id));
        continue;
      }
      if ((localBookmark != null) && ("fb://messaging".compareTo(a(localBookmark.url)) == 0))
      {
        localIntent = new Intent(paramBookmarkEvent.a, ThreadListActivity.class);
        continue;
      }
      if ((localBookmark != null) && ("fb://albums".compareTo(a(localBookmark.url)) == 0) && (FacebookAffiliation.b()))
      {
        localIntent = new Intent(paramBookmarkEvent.a, PhotosTabActivity.class);
        localIntent.putExtra("tab_to_show", "sync");
        continue;
      }
      localIntent = null;
    }
  }

  protected void a(Activity paramActivity)
  {
    this.a.n();
  }

  protected void a(BookmarkEvent paramBookmarkEvent, Intent paramIntent)
  {
    super.a(paramBookmarkEvent, paramIntent);
    if ((paramIntent != null) && (paramBookmarkEvent.b != null) && (paramBookmarkEvent.b.a() > 0) && (("group".equals(paramBookmarkEvent.b.type)) || ("friend_list".equals(paramBookmarkEvent.b.type))))
      this.b.a(paramBookmarkEvent.b.id, 0);
  }

  protected Intent b(BookmarkEvent paramBookmarkEvent)
  {
    Object localObject2;
    if (paramBookmarkEvent.d)
      localObject2 = d(paramBookmarkEvent);
    Bookmark localBookmark;
    Object localObject1;
    while (true)
    {
      return localObject2;
      localBookmark = paramBookmarkEvent.b;
      localObject1 = paramBookmarkEvent.b();
      if ((localBookmark == null) || (4748854339L != localBookmark.id))
        break;
      NewsFeedType localNewsFeedType = (NewsFeedType)paramBookmarkEvent.a();
      if (localNewsFeedType == null)
        break;
      a(paramBookmarkEvent, localNewsFeedType);
      if (a(paramBookmarkEvent.a))
      {
        localObject2 = a(paramBookmarkEvent.a, localNewsFeedType);
        continue;
      }
      if (localNewsFeedType != NewsFeedType.TOP_STORIES)
        break label150;
    }
    label150: for (String str = "fb://feed/top_stories"; ; str = "fb://feed/most_recent_stories")
    {
      localObject1 = str;
      if ((localBookmark == null) || (!"friend_list".equals(localBookmark.type)) || (!a(paramBookmarkEvent.a)))
        break label157;
      localObject2 = a(paramBookmarkEvent.a, NewsFeedType.MOST_RECENT, String.valueOf(localBookmark.id));
      break;
    }
    label157: if (localObject1 == null)
    {
      FbErrorReporter localFbErrorReporter = (FbErrorReporter)FbInjector.a(paramBookmarkEvent.a).a(FbErrorReporter.class);
      StringBuilder localStringBuilder = new StringBuilder().append("The bookmark with id: ");
      if (paramBookmarkEvent.b == null);
      for (Object localObject3 = null; ; localObject3 = Long.valueOf(paramBookmarkEvent.b.id))
      {
        localFbErrorReporter.a("bookmarks", localObject3 + " does not have url");
        localObject2 = null;
        break;
      }
    }
    Intent localIntent1 = IntentUriHandler.a(paramBookmarkEvent.a, (String)localObject1);
    if (localIntent1 == null);
    for (Intent localIntent2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1)); ; localIntent2 = localIntent1)
    {
      NativeThirdPartyUriHelper.a(paramBookmarkEvent.a, localIntent2);
      if ((paramBookmarkEvent.a != null) && ((paramBookmarkEvent.a instanceof FacebookActivity)))
        ((FacebookActivity)paramBookmarkEvent.a).t().p();
      localObject2 = localIntent2;
      break;
    }
  }

  protected boolean c(BookmarkEvent paramBookmarkEvent)
  {
    InteractionLogger localInteractionLogger = new InteractionLogger(paramBookmarkEvent.a);
    String str;
    if (paramBookmarkEvent.d)
    {
      str = "long_click";
      localInteractionLogger.a(str, paramBookmarkEvent.b(), FB4A_AnalyticEntities.UIElementsTypes.e, FB4A_AnalyticEntities.UIElements.y);
      if (!paramBookmarkEvent.b().startsWith("fb://online"))
        break label71;
      this.c.r();
    }
    label71: for (boolean bool = true; ; bool = super.c(paramBookmarkEvent))
    {
      return bool;
      str = "click";
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.FB4ABookmarkSelectedListener
 * JD-Core Version:    0.6.0
 */