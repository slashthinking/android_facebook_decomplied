package com.facebook.feed.ui.location;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;

public class StoryLocationViewProfile extends StoryLocationView
{
  private final UrlImage b;
  private final IFeedUnitRenderer c;

  public StoryLocationViewProfile(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryLocationViewProfile(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903180);
    this.b = ((UrlImage)b(2131296812));
    this.c = ((IFeedUnitRenderer)getInjector().a(IFeedUnitRenderer.class));
  }

  public void a(GraphQLProfile paramGraphQLProfile)
  {
    if (paramGraphQLProfile == null)
      this.b.setImageParams((Uri)null);
    while (true)
    {
      return;
      this.b.setImageParams(Uri.parse(paramGraphQLProfile.profilePicture.uri));
      this.c.a(this, paramGraphQLProfile, null);
    }
  }

  public int getRecyclableViewType()
  {
    return StoryLocationView.StoryLocationViewType.PROFILE.ordinal();
  }

  public StoryLocationView.StoryLocationViewType getViewType()
  {
    return StoryLocationView.StoryLocationViewType.PROFILE;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.location.StoryLocationViewProfile
 * JD-Core Version:    0.6.0
 */