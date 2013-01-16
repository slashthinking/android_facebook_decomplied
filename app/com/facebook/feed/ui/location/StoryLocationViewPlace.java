package com.facebook.feed.ui.location;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import java.util.List;

public class StoryLocationViewPlace extends StoryLocationView
{
  private final UrlImage b;
  private final TextView c;
  private final TextView d;
  private final IFeedUnitRenderer e;

  public StoryLocationViewPlace(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryLocationViewPlace(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903179);
    this.b = ((UrlImage)b(2131296809));
    this.c = ((TextView)b(2131296810));
    this.d = ((TextView)b(2131296811));
    this.e = ((IFeedUnitRenderer)getInjector().a(IFeedUnitRenderer.class));
  }

  public void a(GraphQLPlace paramGraphQLPlace, HoneyClientEvent paramHoneyClientEvent)
  {
    if (paramGraphQLPlace.c())
    {
      this.b.setVisibility(0);
      this.b.setImageParams(Uri.parse(paramGraphQLPlace.profilePicture.uri));
      this.c.setText(paramGraphQLPlace.name);
      if ((paramGraphQLPlace.categories == null) || (paramGraphQLPlace.categories.size() <= 0))
        break label118;
      this.d.setVisibility(0);
      this.d.setText((CharSequence)paramGraphQLPlace.categories.get(0));
    }
    while (true)
    {
      this.e.a(this, paramGraphQLPlace.url, paramHoneyClientEvent);
      return;
      this.b.setVisibility(8);
      break;
      label118: this.d.setVisibility(8);
    }
  }

  public int getRecyclableViewType()
  {
    return StoryLocationView.StoryLocationViewType.PLACE.ordinal();
  }

  public StoryLocationView.StoryLocationViewType getViewType()
  {
    return StoryLocationView.StoryLocationViewType.PLACE;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.location.StoryLocationViewPlace
 * JD-Core Version:    0.6.0
 */