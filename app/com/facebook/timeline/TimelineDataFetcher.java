package com.facebook.timeline;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.Log;
import com.facebook.feed.protocol.DeleteStoryMethod.Params;
import com.facebook.feed.protocol.FetchTimelineHeaderParams;
import com.facebook.feed.protocol.FetchTimelineSectionListParams;
import com.facebook.feed.protocol.HideTimelineStoryMethod.Params;
import com.facebook.friends.protocol.AddFriendListMemberMethod.Params;
import com.facebook.friends.protocol.FetchFriendListsWithMemberParams;
import com.facebook.friends.protocol.RemoveFriendListMemberMethod.Params;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.timeline.cache.TimelineClearCacheParams;
import com.facebook.timeline.cache.TimelineUserDataCleaner;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;

public class TimelineDataFetcher
{
  public final Integer a = Integer.valueOf(1);
  public final Integer b = Integer.valueOf(2);
  private final Context c;
  private final TimelineAllSectionsData d;
  private final TimelineHeaderData e;
  private final TimelineDataFetcher.ViewCallback f;
  private final long g;
  private final FetchTimelineHeaderParams h;
  private final TimelineDataFetcher.BackendFetch i;
  private final TimelineUserDataCleaner j;
  private final Clock k;
  private final String l;
  private final String m;
  private TimelineDataFetcher.State n;
  private HashSet<ListenableFuture<OperationResult>> o;

  public TimelineDataFetcher(Context paramContext, TimelineDataFetcher.ViewCallback paramViewCallback, long paramLong, FetchTimelineHeaderParams paramFetchTimelineHeaderParams, TimelineAllSectionsData paramTimelineAllSectionsData, TimelineHeaderData paramTimelineHeaderData, TimelineDataFetcher.BackendFetch paramBackendFetch, TimelineUserDataCleaner paramTimelineUserDataCleaner, Clock paramClock, String paramString1, String paramString2)
  {
    this.c = paramContext;
    this.d = paramTimelineAllSectionsData;
    this.e = paramTimelineHeaderData;
    this.g = paramLong;
    this.h = paramFetchTimelineHeaderParams;
    this.f = paramViewCallback;
    this.i = paramBackendFetch;
    this.j = paramTimelineUserDataCleaner;
    this.o = new HashSet();
    this.k = paramClock;
    this.l = paramString1;
    this.m = paramString2;
    this.n = TimelineDataFetcher.State.VISIBLE;
  }

  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.n != TimelineDataFetcher.State.VISIBLE);
    while (true)
    {
      return;
      if (BuildConstants.a())
      {
        String str = this.c.getString(paramInt) + " : " + paramString2;
        if (paramInt == 2131361835)
          str = str + " in " + paramString1;
        Toast.makeText(this.c, str, 1).show();
        Log.a("TimelineDataFetcher", str);
        continue;
      }
      if (paramInt == 2131361835)
        continue;
      Toast.makeText(this.c, paramInt, 1).show();
    }
  }

  private void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (BuildConstants.a())
    {
      if (!(paramThrowable instanceof ServiceException))
        break label77;
      Bundle localBundle = ((ServiceException)paramThrowable).b().j();
      if (localBundle == null)
        break label77;
      String str = (String)localBundle.get("originalExceptionStack");
      if (str == null)
        break label77;
      String[] arrayOfString = str.split("\\n", 2);
      if (arrayOfString.length <= 0)
        break label77;
      a(paramInt, paramString, arrayOfString[0].trim());
    }
    while (true)
    {
      return;
      label77: a(paramInt, paramString, paramThrowable.getMessage());
    }
  }

  private void a(Parcelable paramParcelable, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt, FutureCallback<OperationResult> paramFutureCallback)
  {
    Bundle localBundle1 = new Bundle();
    if (paramParcelable != null)
      localBundle1.putParcelable(paramString1, paramParcelable);
    if ((paramBoolean2) && (this.e.g()))
      localBundle1.putString("override_auth_token", (String)Preconditions.checkNotNull(this.m));
    localBundle1.putBoolean("skipCache", paramBoolean1);
    localBundle1.putLong("profileId", this.g);
    ListenableFuture localListenableFuture = this.i.a(paramString2, localBundle1);
    if (paramFutureCallback != null)
      Futures.a(localListenableFuture, paramFutureCallback);
    this.o.add(localListenableFuture);
    Bundle localBundle2 = (Bundle)(Bundle)localBundle1.clone();
    localBundle2.putBoolean("skipCache", true);
    if ((paramFutureCallback instanceof TimelineReplayableFetcher))
      ((TimelineReplayableFetcher)paramFutureCallback).a(new TimelineDataFetcher.1(this, paramString2, localBundle2, paramFutureCallback));
    Futures.a(localListenableFuture, new TimelineDataFetcher.2(this, localListenableFuture, paramInt, paramString2));
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/facebook/timeline/TimelineDataFetcher:o	Ljava/util/HashSet;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 69	com/facebook/timeline/TimelineDataFetcher:o	Ljava/util/HashSet;
    //   11: invokevirtual 245	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 250 1 0
    //   21: ifeq +37 -> 58
    //   24: aload_3
    //   25: invokeinterface 253 1 0
    //   30: checkcast 255	com/google/common/util/concurrent/ListenableFuture
    //   33: astore 4
    //   35: aload_3
    //   36: invokeinterface 258 1 0
    //   41: aload 4
    //   43: iconst_1
    //   44: invokeinterface 262 2 0
    //   49: pop
    //   50: goto -35 -> 15
    //   53: astore_2
    //   54: aload_1
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    //   58: aload_1
    //   59: monitorexit
    //   60: return
    //
    // Exception table:
    //   from	to	target	type
    //   7	56	53	finally
    //   58	60	53	finally
  }

  public void a(long paramLong)
  {
    a(new AddFriendListMemberMethod.Params(paramLong, this.g), "addFriendListMemberParams", "add_friend_list_member", false, false, 2131361823, new TimelineDataFetcher.6(this));
  }

  public void a(TimelineReplayableFetcher paramTimelineReplayableFetcher)
  {
    a(paramTimelineReplayableFetcher.a(), paramTimelineReplayableFetcher.b(), paramTimelineReplayableFetcher.c(), paramTimelineReplayableFetcher.d(), false, paramTimelineReplayableFetcher.e(), paramTimelineReplayableFetcher);
  }

  public void a(TimelineSectionFetcher.Params paramParams)
  {
    this.d.a(paramParams.a, true, paramParams.b);
    this.f.i();
    a(new TimelineSectionFetcher(this.g, this.d, this.e, this, this.f, this.k, this.l, paramParams));
  }

  public void a(String paramString)
  {
    a(new DeleteStoryMethod.Params(paramString), "deleteStoryParams", "delete_story", true, false, 2131361825, new TimelineDataFetcher.8(this));
  }

  public void a(boolean paramBoolean)
  {
    a(new FetchTimelineSectionListParams(String.valueOf(this.g), this.l), "fetchTimelineSectionListParams", "fetch_section_list", paramBoolean, false, 2131361835, new TimelineDataFetcher.3(this));
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(new TimelineHeaderFetcher(paramBoolean1, paramBoolean2, this.h, this.d, this.f, this.e, this, this.k));
  }

  public void b()
  {
    if (this.n == TimelineDataFetcher.State.VISIBLE)
      if (this.o.size() != 0)
        break label28;
    for (this.n = TimelineDataFetcher.State.PAUSED; ; this.n = TimelineDataFetcher.State.CANCELLED)
    {
      return;
      label28: a();
    }
  }

  public void b(long paramLong)
  {
    a(new RemoveFriendListMemberMethod.Params(paramLong, this.g), "removeFriendListMemberParams", "remove_friend_list_member", false, false, 2131361824, new TimelineDataFetcher.7(this));
  }

  public void b(String paramString)
  {
    a(new HideTimelineStoryMethod.Params(paramString), "hideStoryParams", "hide_story", true, true, 2131361826, new TimelineDataFetcher.9(this));
  }

  public void b(boolean paramBoolean)
  {
    a(null, null, "fetch_friendlists", paramBoolean, false, 2131361835, new TimelineDataFetcher.4(this));
  }

  public void c()
  {
    if (this.n == TimelineDataFetcher.State.CANCELLED)
    {
      a(true, false);
      this.n = TimelineDataFetcher.State.VISIBLE;
    }
    while (true)
    {
      this.n = TimelineDataFetcher.State.VISIBLE;
      return;
      if (this.n != TimelineDataFetcher.State.REFRESH_UNITS)
        continue;
      f();
      this.n = TimelineDataFetcher.State.VISIBLE;
    }
  }

  public void c(String paramString)
  {
    a(new TimelineClearCacheParams(this.g, paramString), "clearCacheParams", "clear_cache", false, false, 2131361835, null);
  }

  public void c(boolean paramBoolean)
  {
    a(new FetchFriendListsWithMemberParams(this.g), "fetchFriendListsWithMemberParams", "fetch_friendlists_with_member", paramBoolean, false, 2131361835, new TimelineDataFetcher.5(this));
  }

  public void d()
  {
    this.n = TimelineDataFetcher.State.REFRESH_UNITS;
  }

  public void d(boolean paramBoolean)
  {
    c("fetch_timeline_header");
    c("fetch_friendlists_with_member");
    if (paramBoolean)
    {
      c("fetch_first_units");
      c("fetch_section");
    }
    a(paramBoolean, true);
  }

  public void e()
  {
    a();
    a(true, true);
  }

  public void f()
  {
    TimelineSectionFetcher.Params localParams = new TimelineSectionFetcher.Params();
    localParams.c = true;
    localParams.b = true;
    a(localParams);
  }

  public void g()
  {
    this.j.f();
  }

  public void h()
  {
    d(false);
  }

  public void i()
  {
    c("fetch_first_units");
    c("fetch_section");
    this.f.i();
  }

  public void j()
  {
    c("fetch_friendlists_with_member");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineDataFetcher
 * JD-Core Version:    0.6.0
 */