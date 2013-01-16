package com.facebook.appcenter.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.util.SocialTextStringGenerator;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLText;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;
import java.util.List;

public class AppBrowseInfoCardView extends CustomRelativeLayout
  implements BindableInfoCardView
{
  private final UrlImage a;
  private final TextView b;
  private final RatingBar c;
  private final TextView d;
  private SocialTextStringGenerator e;

  public AppBrowseInfoCardView(Context paramContext)
  {
    this(paramContext, null);
  }

  public AppBrowseInfoCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppBrowseInfoCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903206);
    this.a = ((UrlImage)b(2131296884));
    Preconditions.checkNotNull(this.a);
    this.b = ((TextView)b(2131296390));
    Preconditions.checkNotNull(this.b);
    this.c = ((RatingBar)b(2131296391));
    Preconditions.checkNotNull(this.c);
    this.d = ((TextView)b(2131296885));
    Preconditions.checkNotNull(this.d);
    this.e = ((SocialTextStringGenerator)getInjector().a(SocialTextStringGenerator.class));
  }

  public void a(AppDetail paramAppDetail)
  {
    Preconditions.checkNotNull(paramAppDetail);
    setContentDescription(paramAppDetail.name);
    this.b.setText(paramAppDetail.name);
    String str = this.e.a(paramAppDetail.friendsWhoRecentlyUsed, paramAppDetail.isGame);
    if (StringUtil.a(str))
    {
      Preconditions.checkNotNull(paramAppDetail.globalUsageSummarySentence);
      str = paramAppDetail.globalUsageSummarySentence.text;
    }
    this.d.setText(str);
    if (paramAppDetail.averageStarRating >= 0.0D)
      this.c.setRating((float)paramAppDetail.averageStarRating);
    if (paramAppDetail.bannerLogo != null)
    {
      GraphQLImage localGraphQLImage = (GraphQLImage)paramAppDetail.bannerLogo.get(0);
      if (localGraphQLImage != null)
        this.a.setImageParams(Uri.parse(localGraphQLImage.uri));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseInfoCardView
 * JD-Core Version:    0.6.0
 */