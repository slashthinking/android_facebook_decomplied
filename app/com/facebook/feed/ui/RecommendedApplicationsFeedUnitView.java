package com.facebook.feed.ui;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.graphql.model.FeedStorySponsoredData;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PlatformApplication;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnit;
import com.facebook.graphql.model.RecommendedApplicationsFeedUnitItem;
import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import java.util.concurrent.ExecutorService;

public class RecommendedApplicationsFeedUnitView extends CustomLinearLayout
  implements BindableFeedUnitView<RecommendedApplicationsFeedUnit>
{
  private final AspectRatioAwareUrlImage a;
  private final TextView b;
  private final TextView c;
  private final RatingBar d;
  private final TextView e;
  private final IFeedUnitRenderer f;
  private final NewsFeedAnalyticsEventBuilder g;
  private final FbErrorReporter h;
  private final ExecutorService i;

  public RecommendedApplicationsFeedUnitView(Context paramContext)
  {
    this(paramContext, null);
  }

  public RecommendedApplicationsFeedUnitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903142);
    this.a = ((AspectRatioAwareUrlImage)b(2131296687));
    this.b = ((TextView)b(2131296688));
    this.c = ((TextView)b(2131296690));
    this.d = ((RatingBar)b(2131296689));
    this.e = ((TextView)b(2131296691));
    FbInjector localFbInjector = getInjector();
    this.f = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.g = ((NewsFeedAnalyticsEventBuilder)localFbInjector.a(NewsFeedAnalyticsEventBuilder.class));
    this.h = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.i = ((ExecutorService)localFbInjector.a(ExecutorService.class, DefaultExecutorService.class));
  }

  private void a(String paramString, Object[] paramArrayOfObject)
  {
    this.i.execute(new RecommendedApplicationsFeedUnitView.1(this, paramString, paramArrayOfObject));
  }

  private boolean a(RecommendedApplicationsFeedUnit paramRecommendedApplicationsFeedUnit)
  {
    int j = 0;
    if (paramRecommendedApplicationsFeedUnit == null)
      a("unit cannot be null", new Object[0]);
    while (true)
    {
      return j;
      RecommendedApplicationsFeedUnitItem localRecommendedApplicationsFeedUnitItem = paramRecommendedApplicationsFeedUnit.a();
      if (localRecommendedApplicationsFeedUnitItem == null)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = paramRecommendedApplicationsFeedUnit.getCacheId();
        arrayOfObject2[1] = Long.valueOf(paramRecommendedApplicationsFeedUnit.getFetchTimeMs());
        a("unit contains no applications.  CacheId:%s FetchTime:%d", arrayOfObject2);
        j = 0;
        continue;
      }
      if ((localRecommendedApplicationsFeedUnitItem.banner == null) || (TextUtils.isEmpty(localRecommendedApplicationsFeedUnitItem.banner.uri)) || (localRecommendedApplicationsFeedUnitItem.banner.width == 0) || (localRecommendedApplicationsFeedUnitItem.banner.height == 0))
      {
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = paramRecommendedApplicationsFeedUnit.getCacheId();
        arrayOfObject1[1] = Long.valueOf(paramRecommendedApplicationsFeedUnit.getFetchTimeMs());
        arrayOfObject1[2] = localRecommendedApplicationsFeedUnitItem.a();
        a("app to display does not have a valid banner.  CacheId:%s FetchTime:%d Tracking:%s", arrayOfObject1);
        j = 0;
        continue;
      }
      j = 1;
    }
  }

  public void a(RecommendedApplicationsFeedUnit paramRecommendedApplicationsFeedUnit, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    boolean bool = true;
    if (!a(paramRecommendedApplicationsFeedUnit))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    RecommendedApplicationsFeedUnitItem localRecommendedApplicationsFeedUnitItem = paramRecommendedApplicationsFeedUnit.a();
    this.a.setImageParams(Uri.parse(localRecommendedApplicationsFeedUnitItem.banner.uri));
    this.a.setAspectRatio(localRecommendedApplicationsFeedUnitItem.banner.width / localRecommendedApplicationsFeedUnitItem.banner.height);
    label109: GraphQLTextWithEntities localGraphQLTextWithEntities;
    label160: label226: label250: HoneyClientEvent localHoneyClientEvent;
    if (localRecommendedApplicationsFeedUnitItem.application.averageStarRating != 0.0F)
    {
      this.d.setVisibility(0);
      this.d.setRating(localRecommendedApplicationsFeedUnitItem.application.averageStarRating);
      this.b.setText(localRecommendedApplicationsFeedUnitItem.application.name);
      this.c.setText(localRecommendedApplicationsFeedUnitItem.body.text);
      if (localRecommendedApplicationsFeedUnitItem.application.socialUsageSentence == null)
        break label335;
      localGraphQLTextWithEntities = localRecommendedApplicationsFeedUnitItem.application.socialUsageSentence;
      if ((localGraphQLTextWithEntities == null) || (StringUtil.a(localGraphQLTextWithEntities.text)))
        break label363;
      if (localRecommendedApplicationsFeedUnitItem.sponsoredData == null)
        break label348;
      TextView localTextView = this.e;
      Context localContext = getContext();
      Object[] arrayOfObject = new Object[bool];
      arrayOfObject[0] = localGraphQLTextWithEntities.text;
      localTextView.setText(localContext.getString(2131362129, arrayOfObject));
      NewsFeedAnalyticsEventBuilder localNewsFeedAnalyticsEventBuilder = this.g;
      String str1 = localRecommendedApplicationsFeedUnitItem.application.id;
      if (localRecommendedApplicationsFeedUnitItem.sponsoredData == null)
        break label403;
      localHoneyClientEvent = localNewsFeedAnalyticsEventBuilder.a(str1, "single_app_install", "app_store", bool, localRecommendedApplicationsFeedUnitItem.a());
      if ((localRecommendedApplicationsFeedUnitItem.sponsoredData == null) || (TextUtils.isEmpty(localRecommendedApplicationsFeedUnitItem.sponsoredData.thirdPartyClickTrackingUrl)))
        break label409;
    }
    label403: label409: for (String str2 = localRecommendedApplicationsFeedUnitItem.sponsoredData.thirdPartyClickTrackingUrl; ; str2 = localRecommendedApplicationsFeedUnitItem.application.androidStoreUrl)
    {
      this.f.a(getChildAt(0), str2, localHoneyClientEvent);
      break;
      this.d.setVisibility(8);
      break label109;
      label335: localGraphQLTextWithEntities = localRecommendedApplicationsFeedUnitItem.application.globalUsageSentence;
      break label160;
      label348: this.e.setText(localGraphQLTextWithEntities.text);
      break label226;
      label363: if (localRecommendedApplicationsFeedUnitItem.sponsoredData != null)
      {
        this.e.setText(getContext().getString(2131362085));
        break label226;
      }
      this.e.setText("");
      break label226;
      bool = false;
      break label250;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.RecommendedApplicationsFeedUnitView
 * JD-Core Version:    0.6.0
 */