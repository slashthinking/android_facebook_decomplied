package com.facebook.feed.util;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.feed.flyout.FlyoutClickSource;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLAggregatedRange;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.LifeEventFeedUnit;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnitItem;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FeedLinkifyUtil
{
  private final int a = 350;
  private final int b = 150;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final Context h;
  private final NewsFeedAnalyticsEventBuilder i;
  private final AnalyticsLogger j;
  private final FlyoutAnimationHandler k;
  private final SecureContextHelper l;

  public FeedLinkifyUtil(Context paramContext, NewsFeedAnalyticsEventBuilder paramNewsFeedAnalyticsEventBuilder, AnalyticsLogger paramAnalyticsLogger, FlyoutAnimationHandler paramFlyoutAnimationHandler, SecureContextHelper paramSecureContextHelper)
  {
    this.h = paramContext;
    this.i = paramNewsFeedAnalyticsEventBuilder;
    this.j = paramAnalyticsLogger;
    this.k = paramFlyoutAnimationHandler;
    this.l = paramSecureContextHelper;
    this.e = this.h.getString(2131362080);
    this.f = this.h.getString(2131362079);
    this.g = this.h.getString(2131362085);
    this.c = this.h.getResources().getString(2131362072);
    this.d = this.h.getResources().getString(2131362110);
  }

  private Boolean a(FeedStory paramFeedStory, SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    Boolean localBoolean;
    if (Strings.isNullOrEmpty(paramString))
      localBoolean = Boolean.valueOf(false);
    while (true)
    {
      return localBoolean;
      int m = paramSpannableStringBuilder.toString().indexOf(paramString);
      if (m == -1)
      {
        localBoolean = Boolean.valueOf(false);
        continue;
      }
      if (paramFeedStory.O());
      for (String str = ((FeedStoryAttachment)paramFeedStory.attachments.get(0)).url; ; str = null)
      {
        if (!Strings.isNullOrEmpty(str))
          break label89;
        localBoolean = Boolean.valueOf(false);
        break;
      }
      label89: paramSpannableStringBuilder.setSpan(new FeedLinkifyUtil.ClickableSpanNoUnderline(str, this.h), m, m + paramString.length(), 33);
      localBoolean = Boolean.valueOf(true);
    }
  }

  private String a(GraphQLEntityRange paramGraphQLEntityRange)
  {
    GraphQLEntity localGraphQLEntity = paramGraphQLEntityRange.entity;
    String str1;
    if ((localGraphQLEntity.objectType.a() == GraphQLObjectType.ObjectType.ExternalUrl) || (localGraphQLEntity.objectType.a() == GraphQLObjectType.ObjectType.CrisisUserInfo))
      str1 = localGraphQLEntity.url;
    while (true)
    {
      return str1;
      if (localGraphQLEntity.objectType.a() == GraphQLObjectType.ObjectType.Story)
      {
        Uri localUri = Uri.parse(localGraphQLEntity.url);
        String str2 = new Uri.Builder().path(localUri.getPath()).query(localUri.getQuery()).fragment(localUri.getFragment()).toString();
        str1 = a(localGraphQLEntity.objectType, str2);
        continue;
      }
      str1 = a(localGraphQLEntity.objectType, localGraphQLEntity.id);
    }
  }

  private void a(GraphQLTextWithEntities paramGraphQLTextWithEntities, Spannable paramSpannable, JsonNode paramJsonNode)
  {
    if (!d(paramGraphQLTextWithEntities));
    while (true)
    {
      return;
      ArrayList localArrayList = Lists.a(paramGraphQLTextWithEntities.aggregatedRanges);
      Collections.sort(localArrayList);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        GraphQLAggregatedRange localGraphQLAggregatedRange = (GraphQLAggregatedRange)localIterator.next();
        a(localGraphQLAggregatedRange.entities, localGraphQLAggregatedRange.offset, localGraphQLAggregatedRange.offset + localGraphQLAggregatedRange.length, paramSpannable, paramJsonNode);
      }
    }
  }

  private void a(GraphQLTextWithEntities paramGraphQLTextWithEntities, FlyoutClickSource paramFlyoutClickSource, Spannable paramSpannable)
  {
    a(paramGraphQLTextWithEntities, paramFlyoutClickSource, paramSpannable, 2131165265, false);
  }

  private void a(GraphQLTextWithEntities paramGraphQLTextWithEntities, FlyoutClickSource paramFlyoutClickSource, Spannable paramSpannable, int paramInt, boolean paramBoolean)
  {
    if ((paramGraphQLTextWithEntities == null) || (paramGraphQLTextWithEntities.ranges == null));
    while (true)
    {
      return;
      ArrayList localArrayList = Lists.a(paramGraphQLTextWithEntities.ranges);
      Collections.sort(localArrayList);
      boolean bool = FlyoutClickSource.TITLE.equals(paramFlyoutClickSource);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        GraphQLEntityRange localGraphQLEntityRange = (GraphQLEntityRange)localIterator.next();
        if ((localGraphQLEntityRange.entity == null) || (localGraphQLEntityRange.entity.objectType == null))
          continue;
        a(a(localGraphQLEntityRange), localGraphQLEntityRange.offset, localGraphQLEntityRange.offset + localGraphQLEntityRange.length, paramSpannable, bool, paramInt, paramBoolean, null);
        if (!bool)
          continue;
        bool = false;
      }
    }
  }

  private void a(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, GraphQLProfile paramGraphQLProfile)
  {
    if (paramString == null);
    while (true)
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("gql_profile", paramGraphQLProfile);
      FeedLinkifyUtil.ClickableSpanNoUnderline localClickableSpanNoUnderline = new FeedLinkifyUtil.ClickableSpanNoUnderline(paramString, this.h, localBundle);
      localClickableSpanNoUnderline.a(paramInt3);
      paramSpannable.setSpan(localClickableSpanNoUnderline, paramInt1, paramInt2, 33);
      if ((!paramBoolean1) && (!paramBoolean2))
        continue;
      paramSpannable.setSpan(new StyleSpan(1), paramInt1, paramInt2, 33);
    }
  }

  private void a(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable, boolean paramBoolean, GraphQLProfile paramGraphQLProfile)
  {
    a(paramString, paramInt1, paramInt2, paramSpannable, paramBoolean, 2131165265, false, paramGraphQLProfile);
  }

  private void a(List<GraphQLProfile> paramList, int paramInt1, int paramInt2, Spannable paramSpannable, JsonNode paramJsonNode)
  {
    paramSpannable.setSpan(new FeedLinkifyUtil.FlyoutSpanNoUnderline(this, paramList, paramJsonNode), paramInt1, paramInt2, 33);
  }

  private boolean a(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    if ((localUnicodeBlock == Character.UnicodeBlock.BASIC_LATIN) || (localUnicodeBlock == Character.UnicodeBlock.LATIN_1_SUPPLEMENT) || (localUnicodeBlock == Character.UnicodeBlock.LATIN_EXTENDED_A) || (localUnicodeBlock == Character.UnicodeBlock.LATIN_EXTENDED_B));
    for (int m = 1; ; m = 0)
      return m;
  }

  private boolean a(String paramString)
  {
    int m = (int)(0.5D * paramString.length());
    char[] arrayOfChar = paramString.toCharArray();
    int n = arrayOfChar.length;
    int i1 = 0;
    int i2 = 0;
    if (i1 < n)
      if (a(arrayOfChar[i1]))
      {
        i2++;
        if (i2 <= m);
      }
    for (int i3 = 1; ; i3 = 0)
    {
      return i3;
      i1++;
      break;
    }
  }

  private Spannable c(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    String str;
    SpannableString localSpannableString1;
    if ((paramGraphQLTextWithEntities != null) && (paramGraphQLTextWithEntities.text != null))
    {
      str = paramGraphQLTextWithEntities.text;
      localSpannableString1 = SpannableString.valueOf(str);
      if (paramGraphQLTextWithEntities.ranges != null)
        break label41;
    }
    for (SpannableString localSpannableString2 = localSpannableString1; ; localSpannableString2 = localSpannableString1)
    {
      return localSpannableString2;
      str = "";
      break;
      label41: if ((paramGraphQLTextWithEntities.ranges != null) && (paramGraphQLTextWithEntities.ranges.size() > 0))
      {
        Iterator localIterator2 = Lists.a(paramGraphQLTextWithEntities.ranges).iterator();
        while (localIterator2.hasNext())
        {
          GraphQLEntityRange localGraphQLEntityRange = (GraphQLEntityRange)localIterator2.next();
          if ((localGraphQLEntityRange.entity == null) || (localGraphQLEntityRange.entity.objectType == null))
            continue;
          localSpannableString1.setSpan(new StyleSpan(1), localGraphQLEntityRange.offset, localGraphQLEntityRange.offset + localGraphQLEntityRange.length, 17);
        }
      }
      if ((paramGraphQLTextWithEntities.aggregatedRanges == null) || (paramGraphQLTextWithEntities.aggregatedRanges.size() <= 0))
        continue;
      Iterator localIterator1 = Lists.a(paramGraphQLTextWithEntities.aggregatedRanges).iterator();
      while (localIterator1.hasNext())
      {
        GraphQLAggregatedRange localGraphQLAggregatedRange = (GraphQLAggregatedRange)localIterator1.next();
        localSpannableString1.setSpan(new StyleSpan(1), localGraphQLAggregatedRange.offset, localGraphQLAggregatedRange.offset + localGraphQLAggregatedRange.length, 17);
      }
    }
  }

  private boolean d(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    if ((paramGraphQLTextWithEntities.aggregatedRanges != null) && (paramGraphQLTextWithEntities.aggregatedRanges.size() != 0) && (paramGraphQLTextWithEntities.aggregatedRanges.get(0) != null) && (((GraphQLAggregatedRange)paramGraphQLTextWithEntities.aggregatedRanges.get(0)).entities != null) && (((GraphQLAggregatedRange)paramGraphQLTextWithEntities.aggregatedRanges.get(0)).entities.get(0) != null) && (((GraphQLProfile)((GraphQLAggregatedRange)paramGraphQLTextWithEntities.aggregatedRanges.get(0)).entities.get(0)).name != null));
    for (int m = 1; ; m = 0)
      return m;
  }

  public Spannable a(GraphQLProfile paramGraphQLProfile)
  {
    return a(paramGraphQLProfile, 2131165265);
  }

  public Spannable a(GraphQLProfile paramGraphQLProfile, int paramInt)
  {
    SpannableString localSpannableString;
    if (paramGraphQLProfile == null)
    {
      localSpannableString = null;
      return localSpannableString;
    }
    if (paramGraphQLProfile.name != null);
    for (String str1 = paramGraphQLProfile.name; ; str1 = "")
    {
      String str2 = a(paramGraphQLProfile.objectType, paramGraphQLProfile.id);
      localSpannableString = SpannableString.valueOf(str1);
      a(str2, 0, str1.length(), localSpannableString, true, paramInt, false, paramGraphQLProfile);
      break;
    }
  }

  public Spannable a(GraphQLProfile paramGraphQLProfile1, GraphQLProfile paramGraphQLProfile2)
  {
    String str1 = paramGraphQLProfile1.name;
    String str2 = paramGraphQLProfile2.name;
    String str3 = StringUtil.a(this.h.getString(2131362096), new Object[] { str1, str2 });
    SpannableString localSpannableString = SpannableString.valueOf(str3);
    String str4 = a(paramGraphQLProfile1.objectType, paramGraphQLProfile1.id);
    int m = str3.indexOf(str1);
    a(str4, m, m + str1.length(), localSpannableString, true, paramGraphQLProfile1);
    int n = str3.indexOf(str2);
    a(a(paramGraphQLProfile2.objectType, paramGraphQLProfile2.id), n, n + str2.length(), localSpannableString, false, paramGraphQLProfile2);
    return localSpannableString;
  }

  public Spannable a(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    return a(paramGraphQLTextWithEntities, 2131165265, false);
  }

  public Spannable a(GraphQLTextWithEntities paramGraphQLTextWithEntities, int paramInt, boolean paramBoolean)
  {
    if ((paramGraphQLTextWithEntities != null) && (paramGraphQLTextWithEntities.text != null));
    for (String str = paramGraphQLTextWithEntities.text; ; str = "")
    {
      SpannableString localSpannableString = SpannableString.valueOf(str);
      a(paramGraphQLTextWithEntities, null, localSpannableString, paramInt, paramBoolean);
      return localSpannableString;
    }
  }

  public Spannable a(GraphQLTextWithEntities paramGraphQLTextWithEntities, FeedStory paramFeedStory, FlyoutClickSource paramFlyoutClickSource, Resources paramResources)
  {
    SpannableStringBuilder localSpannableStringBuilder;
    if (paramGraphQLTextWithEntities == null)
    {
      localSpannableStringBuilder = null;
      return localSpannableStringBuilder;
    }
    if ((paramGraphQLTextWithEntities != null) && (paramGraphQLTextWithEntities.text != null));
    for (String str = paramGraphQLTextWithEntities.text; ; str = "")
    {
      SpannableString localSpannableString = SpannableString.valueOf(str);
      localSpannableString.setSpan(new ForegroundColorSpan(paramResources.getColor(2131165268)), 0, localSpannableString.length(), 33);
      Spannable localSpannable = a(paramGraphQLTextWithEntities, paramFeedStory, paramFlyoutClickSource, localSpannableString);
      localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(SpannableString.valueOf(paramResources.getString(2131362117)));
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramResources.getColor(2131165268)), 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(localSpannable);
      break;
    }
  }

  public Spannable a(GraphQLTextWithEntities paramGraphQLTextWithEntities, FeedUnit paramFeedUnit, FlyoutClickSource paramFlyoutClickSource)
  {
    Spannable localSpannable;
    if (paramGraphQLTextWithEntities == null)
    {
      localSpannable = null;
      return localSpannable;
    }
    if ((paramGraphQLTextWithEntities != null) && (paramGraphQLTextWithEntities.text != null));
    for (String str = paramGraphQLTextWithEntities.text; ; str = "")
    {
      localSpannable = a(paramGraphQLTextWithEntities, paramFeedUnit, paramFlyoutClickSource, SpannableString.valueOf(str));
      break;
    }
  }

  public Spannable a(GraphQLTextWithEntities paramGraphQLTextWithEntities, FeedUnit paramFeedUnit, FlyoutClickSource paramFlyoutClickSource, Spannable paramSpannable)
  {
    Object localObject = null;
    if (paramSpannable == null);
    while (true)
    {
      return localObject;
      Spannable localSpannable = (Spannable)paramSpannable.subSequence(0, paramSpannable.length());
      a(paramGraphQLTextWithEntities, paramFlyoutClickSource, localSpannable);
      boolean bool = paramFeedUnit instanceof FeedStory;
      ArrayNode localArrayNode = null;
      if (bool)
        localArrayNode = ((FeedStory)paramFeedUnit).k();
      a(paramGraphQLTextWithEntities, localSpannable, localArrayNode);
      localObject = localSpannable;
    }
  }

  public String a(GraphQLObjectType paramGraphQLObjectType, Object paramObject)
  {
    return a(paramGraphQLObjectType, new Object[] { paramObject, null });
  }

  public String a(GraphQLObjectType paramGraphQLObjectType, Object[] paramArrayOfObject)
  {
    String str1 = null;
    if (paramGraphQLObjectType != null)
    {
      str1 = null;
      if (paramArrayOfObject != null)
      {
        int m = paramArrayOfObject.length;
        str1 = null;
        if (m != 0)
          break label25;
      }
    }
    return str1;
    label25: String str2;
    switch (FeedLinkifyUtil.1.a[paramGraphQLObjectType.a().ordinal()])
    {
    default:
      str2 = null;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    }
    while (true)
    {
      str1 = null;
      if (str2 == null)
        break;
      str1 = StringLocaleUtil.a(str2, paramArrayOfObject);
      break;
      str2 = "fb://profile/%s";
      continue;
      str2 = "fb://page/%s";
      continue;
      str2 = "fb://group/%s/wall/inner";
      continue;
      str2 = "fb://event/%s";
      continue;
      str2 = "fb://photo/%s";
      continue;
      str2 = "fb://mediaset/a.%s";
      continue;
      str2 = "fb://note/%s";
      continue;
      str2 = null;
      continue;
      str2 = null;
      continue;
      str2 = "fb://friendlist/%s";
      continue;
      str2 = "fb://faceweb/f?href=%s";
    }
  }

  public void a(FeedStory paramFeedStory)
  {
    b(paramFeedStory);
    b(paramFeedStory.attachedStory);
    if (paramFeedStory.j() > 0)
    {
      Iterator localIterator = paramFeedStory.substories.iterator();
      while (localIterator.hasNext())
        a((FeedStory)localIterator.next());
    }
  }

  public void a(LifeEventFeedUnit paramLifeEventFeedUnit)
  {
    if (paramLifeEventFeedUnit == null);
    while (true)
    {
      return;
      Spannable localSpannable1 = paramLifeEventFeedUnit.a();
      Spannable localSpannable2 = paramLifeEventFeedUnit.c();
      Spannable localSpannable3 = paramLifeEventFeedUnit.d();
      Spannable localSpannable4 = paramLifeEventFeedUnit.e();
      if ((localSpannable1 != null) || (localSpannable2 != null) || (localSpannable3 != null) || (localSpannable4 != null))
        continue;
      if (paramLifeEventFeedUnit.title != null)
        paramLifeEventFeedUnit.a(a(paramLifeEventFeedUnit.title, paramLifeEventFeedUnit, FlyoutClickSource.TITLE));
      if (paramLifeEventFeedUnit.subtitle != null)
        paramLifeEventFeedUnit.b(a(paramLifeEventFeedUnit.subtitle, paramLifeEventFeedUnit, FlyoutClickSource.SUBTITLE));
      if (paramLifeEventFeedUnit.underSubtitle != null)
        paramLifeEventFeedUnit.c(a(paramLifeEventFeedUnit.underSubtitle, paramLifeEventFeedUnit, FlyoutClickSource.SUBTITLE));
      if (paramLifeEventFeedUnit.message == null)
        continue;
      paramLifeEventFeedUnit.d(a(paramLifeEventFeedUnit.message, paramLifeEventFeedUnit, FlyoutClickSource.MESSAGE));
    }
  }

  public void a(PagesYouMayLikeFeedUnit paramPagesYouMayLikeFeedUnit)
  {
    if (paramPagesYouMayLikeFeedUnit.items == null);
    while (true)
    {
      return;
      Iterator localIterator = paramPagesYouMayLikeFeedUnit.items.iterator();
      while (localIterator.hasNext())
        a((PagesYouMayLikeFeedUnitItem)localIterator.next());
    }
  }

  public void a(PagesYouMayLikeFeedUnitItem paramPagesYouMayLikeFeedUnitItem)
  {
    if (paramPagesYouMayLikeFeedUnitItem.b() != null);
    while (true)
    {
      return;
      if ((paramPagesYouMayLikeFeedUnitItem.socialContext != null) && (paramPagesYouMayLikeFeedUnitItem.socialContext.text != null))
      {
        SpannableString localSpannableString = SpannableString.valueOf(paramPagesYouMayLikeFeedUnitItem.socialContext.text);
        a(paramPagesYouMayLikeFeedUnitItem.socialContext, FlyoutClickSource.SUBTITLE, localSpannableString);
        paramPagesYouMayLikeFeedUnitItem.a(localSpannableString);
        ArrayNode localArrayNode = paramPagesYouMayLikeFeedUnitItem.a();
        a(paramPagesYouMayLikeFeedUnitItem.socialContext, localSpannableString, localArrayNode);
        continue;
      }
    }
  }

  public Spannable b(GraphQLProfile paramGraphQLProfile1, GraphQLProfile paramGraphQLProfile2)
  {
    String str1 = paramGraphQLProfile1.name;
    String str2 = a(paramGraphQLProfile1.objectType, paramGraphQLProfile1.id);
    String str3 = paramGraphQLProfile2.name;
    String str4 = a(paramGraphQLProfile2.objectType, paramGraphQLProfile2.id);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str1;
    arrayOfObject[1] = this.e;
    arrayOfObject[2] = str3;
    String str5 = StringUtil.a("%s %s %s", arrayOfObject);
    SpannableString localSpannableString = SpannableString.valueOf(str5);
    a(str2, 0, str1.length(), localSpannableString, true, paramGraphQLProfile1);
    int m = str5.indexOf(str3);
    a(str4, m, m + str3.length(), localSpannableString, true, paramGraphQLProfile2);
    int n = str5.indexOf(this.e);
    localSpannableString.setSpan(new ForegroundColorSpan(this.h.getResources().getColor(2131165267)), n, n + 1, 17);
    return localSpannableString;
  }

  public Spannable b(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    return b(paramGraphQLTextWithEntities, 2131165254, true);
  }

  public Spannable b(GraphQLTextWithEntities paramGraphQLTextWithEntities, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramGraphQLTextWithEntities == null)
      localObject = null;
    while (true)
    {
      return localObject;
      if ((paramGraphQLTextWithEntities.aggregatedRanges != null) && (paramGraphQLTextWithEntities.aggregatedRanges.size() > 0))
      {
        localObject = c(paramGraphQLTextWithEntities);
        continue;
      }
      if (((paramGraphQLTextWithEntities.ranges == null) && (paramGraphQLTextWithEntities.aggregatedRanges == null)) || ((paramGraphQLTextWithEntities.ranges != null) && (paramGraphQLTextWithEntities.ranges.size() == 0) && (paramGraphQLTextWithEntities.aggregatedRanges != null) && (paramGraphQLTextWithEntities.aggregatedRanges.size() == 0)))
      {
        if ((paramGraphQLTextWithEntities != null) && (paramGraphQLTextWithEntities.text != null));
        for (String str = paramGraphQLTextWithEntities.text; ; str = "")
        {
          localObject = SpannableString.valueOf(str);
          break;
        }
      }
      localObject = a(paramGraphQLTextWithEntities, paramInt, paramBoolean);
    }
  }

  public void b(FeedStory paramFeedStory)
  {
    if (paramFeedStory == null);
    Spannable localSpannable1;
    Spannable localSpannable2;
    Spannable localSpannable3;
    do
    {
      return;
      localSpannable1 = paramFeedStory.H();
      localSpannable2 = paramFeedStory.I();
      localSpannable3 = paramFeedStory.J();
    }
    while ((localSpannable1 != null) || (localSpannable2 != null) || (localSpannable3 != null));
    if ((localSpannable1 == null) && (paramFeedStory.title != null))
    {
      localSpannable1 = a(paramFeedStory.title, paramFeedStory, FlyoutClickSource.TITLE);
      paramFeedStory.a(localSpannable1);
    }
    GraphQLProfile localGraphQLProfile = paramFeedStory.a();
    if ((localSpannable1 == null) && (paramFeedStory.title == null) && (paramFeedStory.via != null) && (paramFeedStory.to == null) && (localGraphQLProfile != null))
    {
      localSpannable1 = a(paramFeedStory.a(), paramFeedStory.via);
      paramFeedStory.a(localSpannable1);
    }
    if ((localSpannable1 == null) && (paramFeedStory.title == null) && (paramFeedStory.via == null) && (paramFeedStory.to != null) && (localGraphQLProfile != null))
    {
      localSpannable1 = b(localGraphQLProfile, paramFeedStory.to);
      paramFeedStory.a(localSpannable1);
    }
    if ((localSpannable1 == null) && (localGraphQLProfile != null))
      paramFeedStory.a(a(localGraphQLProfile));
    Object localObject2;
    if ((localSpannable2 == null) && (paramFeedStory.message != null))
    {
      localObject2 = a(paramFeedStory.message, paramFeedStory, FlyoutClickSource.MESSAGE);
      if (paramFeedStory.suffix != null)
        localObject2 = SpannableString.valueOf(TextUtils.concat(new CharSequence[] { localObject2, a(paramFeedStory.suffix, paramFeedStory, FlyoutClickSource.SUFFIX, this.h.getResources()) }));
      paramFeedStory.b((Spannable)localObject2);
    }
    for (Object localObject1 = localObject2; ; localObject1 = localSpannable2)
    {
      int m;
      if ((localSpannable3 == null) && (paramFeedStory.message != null))
      {
        m = paramFeedStory.message.text.length();
        if (paramFeedStory.suffix != null)
          m -= paramFeedStory.suffix.text.length();
        if (!a(paramFeedStory.message.text))
          break label453;
      }
      label453: for (int n = 350; ; n = 150)
      {
        if (m > n)
        {
          SpannableString localSpannableString = SpannableString.valueOf(this.d);
          localSpannableString.setSpan(new FeedLinkifyUtil.ContinueReadingSpan(paramFeedStory, this.h, this.l), 0, this.d.length(), 33);
          int i1 = paramFeedStory.message.text.substring(0, n).trim().length();
          CharSequence[] arrayOfCharSequence = new CharSequence[3];
          arrayOfCharSequence[0] = ((Spannable)localObject1).subSequence(0, i1);
          arrayOfCharSequence[1] = this.c;
          arrayOfCharSequence[2] = localSpannableString;
          paramFeedStory.c(SpannableString.valueOf(TextUtils.concat(arrayOfCharSequence)));
        }
        c(paramFeedStory);
        break;
      }
    }
  }

  public Spannable c(FeedStory paramFeedStory)
  {
    Object localObject = null;
    Preconditions.checkNotNull(paramFeedStory);
    if ((paramFeedStory.w()) || (paramFeedStory.j() > 0))
    {
      paramFeedStory.d(null);
      return localObject;
    }
    String str1;
    label38: String str2;
    label61: String str3;
    if (paramFeedStory.application == null)
    {
      str1 = null;
      if ((paramFeedStory.implicitPlace == null) || (paramFeedStory.q()))
        break label287;
      str2 = paramFeedStory.implicitPlace.name;
      if (!paramFeedStory.B())
        break label373;
      if ((str1 == null) || (str2 == null))
        break label293;
      str3 = this.h.getString(2131362102, new Object[] { "", str1, str2 });
    }
    while (true)
    {
      label110: if (paramFeedStory.C())
      {
        if ((!Strings.isNullOrEmpty(str3)) || (paramFeedStory.B()))
        {
          Object[] arrayOfObject2 = new Object[3];
          arrayOfObject2[0] = str3;
          arrayOfObject2[1] = this.f;
          arrayOfObject2[2] = this.g;
          str3 = StringLocaleUtil.a("%s %s %s", arrayOfObject2);
        }
      }
      else
      {
        localObject = null;
        if (str3 == null)
          break;
        if (!paramFeedStory.B())
          break label489;
      }
      label170: label489: for (String str4 = "%s" + str3; ; str4 = str3)
      {
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str4);
        a(paramFeedStory, localSpannableStringBuilder, str1);
        if (paramFeedStory.privacyScope != null)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = this.f;
          localSpannableStringBuilder.append(StringLocaleUtil.a(" %s ", arrayOfObject1));
        }
        paramFeedStory.d(localSpannableStringBuilder);
        localObject = localSpannableStringBuilder;
        break;
        str1 = paramFeedStory.application.name;
        break label38;
        str2 = null;
        break label61;
        if ((str1 != null) && (str2 == null))
        {
          str3 = this.h.getString(2131362100, new Object[] { "", str1 });
          break label110;
        }
        if ((str1 != null) || (str2 == null))
          break label496;
        str3 = this.h.getString(2131362101, new Object[] { "", str2 });
        break label110;
        label373: if ((str1 != null) && (str2 != null))
        {
          str3 = this.h.getString(2131362099, new Object[] { str1, str2 });
          break label110;
        }
        if ((str1 != null) && (str2 == null))
        {
          str3 = this.h.getString(2131362097, new Object[] { str1 });
          break label110;
        }
        if ((str1 != null) || (str2 == null))
          break label496;
        str3 = this.h.getString(2131362098, new Object[] { str2 });
        break label110;
        str3 = this.g;
        break label170;
      }
      label287: label293: label496: str3 = "";
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FeedLinkifyUtil
 * JD-Core Version:    0.6.0
 */