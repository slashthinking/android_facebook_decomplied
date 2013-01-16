package com.facebook.feed.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.model.FeedRowType;
import com.facebook.feed.model.NewsFeedType;
import com.facebook.feed.protocol.FetchNewsFeedParams;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.CelebrationsFeedUnit;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedOptimisticPublishState;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedbackableGraphQLNode;
import com.facebook.graphql.model.FindFriendsFeedUnit;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.OptimisticEntity;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnit;
import com.facebook.graphql.model.UnknownFeedUnit;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FeedUtils
{
  private static int a = -1;
  private static int b = -1;

  public static float a(FeedEventBus paramFeedEventBus, OptimisticEntity paramOptimisticEntity, float paramFloat, View[] paramArrayOfView)
  {
    float f1 = 1.0F;
    float f2 = 0.3F;
    AnimatorSet localAnimatorSet;
    switch (FeedUtils.1.a[paramOptimisticEntity.c().ordinal()])
    {
    default:
      f2 = f1;
      if ((paramFloat == f2) && (paramFloat == f1))
        break;
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.a(a(f1, f2, paramArrayOfView));
      if (f1 != f2)
        localAnimatorSet.a(500L);
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      localAnimatorSet.c();
      return f2;
      f1 = f2;
      break;
      paramOptimisticEntity.a(FeedOptimisticPublishState.NONE);
      float f3 = f1;
      f1 = f2;
      f2 = f3;
      break;
      localAnimatorSet.a(0L);
    }
  }

  public static float a(OptimisticEntity paramOptimisticEntity, float paramFloat, View[] paramArrayOfView)
  {
    return a(null, paramOptimisticEntity, paramFloat, paramArrayOfView);
  }

  public static int a(Context paramContext)
  {
    int i;
    int j;
    int k;
    if (b < 0)
    {
      b(paramContext);
      Display localDisplay = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
      i = localDisplay.getWidth();
      j = localDisplay.getHeight();
      if (i >= j)
        break label109;
      Resources localResources = paramContext.getResources();
      k = (i - 2 * a - 2 * localResources.getDimensionPixelSize(2131230770) - 2 * localResources.getDimensionPixelSize(2131230771)) / (localResources.getDimensionPixelSize(2131230769) + 2 * localResources.getDimensionPixelSize(2131230772));
      if (k >= 2)
        break label114;
      k = 2;
    }
    while (true)
    {
      b = k;
      return b;
      label109: i = j;
      break;
      label114: if (k <= 4)
        continue;
      k = 4;
    }
  }

  public static int a(Context paramContext, int paramInt)
  {
    b(paramContext);
    return (paramInt + 1) * a;
  }

  // ERROR //
  public static android.widget.EditText a(Activity paramActivity, android.widget.EditText paramEditText, int paramInt)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 113	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: pop
    //   6: aload_1
    //   7: invokevirtual 119	android/widget/EditText:getParent	()Landroid/view/ViewParent;
    //   10: checkcast 121	android/view/ViewGroup
    //   13: astore 6
    //   15: aload_0
    //   16: invokestatic 127	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   19: iload_2
    //   20: aload 6
    //   22: iconst_0
    //   23: invokevirtual 131	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   26: astore 7
    //   28: aload 6
    //   30: aload_1
    //   31: invokevirtual 135	android/view/ViewGroup:indexOfChild	(Landroid/view/View;)I
    //   34: istore 8
    //   36: aload 6
    //   38: aload_1
    //   39: invokevirtual 139	android/view/ViewGroup:removeViewInLayout	(Landroid/view/View;)V
    //   42: aload 6
    //   44: aload 7
    //   46: iload 8
    //   48: invokevirtual 143	android/view/ViewGroup:addView	(Landroid/view/View;I)V
    //   51: aload 7
    //   53: checkcast 115	android/widget/EditText
    //   56: astore 4
    //   58: aload 4
    //   60: checkcast 145	com/facebook/composer/mentions/MentionsAutoCompleteTextViewInterface
    //   63: aload_0
    //   64: invokeinterface 148 2 0
    //   69: aload 4
    //   71: areturn
    //   72: astore_3
    //   73: aload_1
    //   74: astore 4
    //   76: ldc 150
    //   78: ldc 152
    //   80: invokestatic 158	com/facebook/orca/debug/BLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: goto -14 -> 69
    //   86: astore 9
    //   88: goto -12 -> 76
    //
    // Exception table:
    //   from	to	target	type
    //   0	58	72	java/lang/Exception
    //   58	69	86	java/lang/Exception
  }

  public static FeedRowType a(FeedUnit paramFeedUnit)
  {
    FeedRowType localFeedRowType;
    if ((paramFeedUnit instanceof PeopleYouMayKnowFeedUnit))
      localFeedRowType = FeedRowType.PYMK;
    while (true)
    {
      return localFeedRowType;
      if ((paramFeedUnit instanceof PagesYouMayLikeFeedUnit))
      {
        localFeedRowType = FeedRowType.PYML;
        continue;
      }
      if ((paramFeedUnit instanceof CelebrationsFeedUnit))
      {
        localFeedRowType = FeedRowType.CELEBRATIONS;
        continue;
      }
      if ((paramFeedUnit instanceof RecommendedApplicationsFeedUnit))
      {
        localFeedRowType = FeedRowType.APP_AD;
        continue;
      }
      if ((paramFeedUnit instanceof FindFriendsFeedUnit))
      {
        localFeedRowType = FeedRowType.FIND_FRIENDS;
        continue;
      }
      if ((paramFeedUnit instanceof FeedStory))
      {
        FeedStory localFeedStory = (FeedStory)paramFeedUnit;
        if (localFeedStory.F())
        {
          localFeedRowType = FeedRowType.STORY_EDGE_NARROW_OR_AGG;
          continue;
        }
        if (localFeedStory.attachedStory != null)
        {
          if (localFeedStory.n())
          {
            localFeedRowType = FeedRowType.STORY_EDGE_NARROW_OR_AGG;
            continue;
          }
          localFeedRowType = FeedRowType.STORY_EDGE_WIDE;
          continue;
        }
        localFeedRowType = FeedRowType.STORY_BASE;
        continue;
      }
      if (((paramFeedUnit instanceof UnknownFeedUnit)) && (BuildConstants.a()))
      {
        localFeedRowType = FeedRowType.NEW_FEED_UNIT;
        continue;
      }
      localFeedRowType = FeedRowType.UNKNOWN;
    }
  }

  private static Collection<Animator> a(float paramFloat1, float paramFloat2, View[] paramArrayOfView)
  {
    ArrayList localArrayList = Lists.a(paramArrayOfView);
    HashSet localHashSet = Sets.a();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
      localHashSet.add(ObjectAnimator.a((View)localIterator.next(), "alpha", new float[] { paramFloat1, paramFloat2 }));
    return localHashSet;
  }

  public static List<GraphQLProfile> a(boolean paramBoolean, GraphQLProfile paramGraphQLProfile, List<GraphQLProfile> paramList)
  {
    if (paramGraphQLProfile == null);
    while (true)
    {
      return paramList;
      paramList = Lists.a(paramList);
      for (int i = 0; ; i++)
      {
        if (i >= paramList.size())
          break label67;
        if (!Objects.equal(paramGraphQLProfile.id, ((GraphQLProfile)paramList.get(i)).id))
          continue;
        if (paramBoolean)
          break;
        paramList.remove(i);
        break;
      }
      label67: if (!paramBoolean)
        continue;
      paramList.add(paramGraphQLProfile);
    }
  }

  public static void a(Activity paramActivity)
  {
    if (paramActivity == null);
    while (true)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (localInputMethodManager == null)
        continue;
      localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
  }

  public static void a(Context paramContext, View paramView)
  {
    if (paramContext == null);
    while (true)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager == null)
        continue;
      localInputMethodManager.showSoftInput(paramView, 1);
    }
  }

  public static void a(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    int i = a(paramContext, paramInt1) - paramInt2;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    localMarginLayoutParams.leftMargin = i;
    localMarginLayoutParams.rightMargin = i;
    paramView.setLayoutParams(localMarginLayoutParams);
  }

  public static void a(FbErrorReporter paramFbErrorReporter, String paramString, FetchNewsFeedParams paramFetchNewsFeedParams, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramFbErrorReporter.a(paramString, paramString + " feedType: " + paramFetchNewsFeedParams.f().toString() + " before cusor: " + paramFetchNewsFeedParams.c() + " after cursor: " + paramFetchNewsFeedParams.d() + " size of results: " + paramInt + " from db cache: " + paramBoolean1 + " from prefetch cache: " + paramBoolean2, true);
    throw new Exception("Response contained null stories or page info");
  }

  public static boolean a(FeedEdge paramFeedEdge1, FeedEdge paramFeedEdge2)
  {
    int i;
    if ((paramFeedEdge1 == null) || (paramFeedEdge2 == null) || (!(paramFeedEdge1.b() instanceof FeedbackableGraphQLNode)) || (!(paramFeedEdge2.b() instanceof FeedbackableGraphQLNode)))
      i = 0;
    while (true)
    {
      return i;
      long l1 = ((FeedbackableGraphQLNode)paramFeedEdge1.b()).Q();
      long l2 = ((FeedbackableGraphQLNode)paramFeedEdge2.b()).Q();
      if ((l1 >= 0L) && (l2 >= 0L) && (l1 == l2))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public static boolean a(String paramString)
  {
    if (("fetch_news_feed_after".equals(paramString)) || ("fetch_news_feed_before".equals(paramString)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private static void b(Context paramContext)
  {
    if (a == -1)
      a = paramContext.getResources().getDimensionPixelSize(2131230783);
  }

  public static boolean b(String paramString)
  {
    if (("fetch_friend_list_feed_after".equals(paramString)) || ("fetch_friend_list_feed_before".equals(paramString)));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FeedUtils
 * JD-Core Version:    0.6.0
 */