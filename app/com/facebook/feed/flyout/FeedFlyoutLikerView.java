package com.facebook.feed.flyout;

import android.content.Context;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.common.util.ErrorReporting;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;

public class FeedFlyoutLikerView extends CustomRelativeLayout
{
  private final IFeedUnitRenderer a;
  private final FeedLinkifyUtil b;
  private UrlImage c;
  private TextView d;

  public FeedFlyoutLikerView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FeedFlyoutLikerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FeedFlyoutLikerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903217);
    this.c = ((UrlImage)b(2131296926));
    this.d = ((TextView)b(2131296942));
    this.d.setMovementMethod(LinkMovementMethod.getInstance());
    FbInjector localFbInjector = getInjector();
    this.a = ((IFeedUnitRenderer)localFbInjector.a(IFeedUnitRenderer.class));
    this.b = ((FeedLinkifyUtil)localFbInjector.a(FeedLinkifyUtil.class));
  }

  public void a(GraphQLProfile paramGraphQLProfile)
  {
    if (paramGraphQLProfile == null)
      ErrorReporting.a("AbstractFeedFlyoutActorAdapter", "profile cannot be null");
    while (true)
    {
      return;
      this.c.setImageParams(Uri.parse(paramGraphQLProfile.profilePicture.uri));
      this.d.setText(paramGraphQLProfile.name);
      String str = this.b.a(paramGraphQLProfile.objectType, paramGraphQLProfile.id);
      if (str != null)
      {
        this.a.a(this.c, str, null);
        this.a.a(this.d, str, null);
        this.a.a(this, str, null);
        continue;
      }
      this.d.setOnClickListener(null);
      this.c.setOnClickListener(null);
      setOnClickListener(null);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutLikerView
 * JD-Core Version:    0.6.0
 */