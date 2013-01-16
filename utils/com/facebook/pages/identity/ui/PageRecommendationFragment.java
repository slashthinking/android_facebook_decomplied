package com.facebook.pages.identity.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.friends.FriendshipStatus;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PageRecommendation;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;

public class PageRecommendationFragment extends OrcaFragment
{
  private PageRecommendation a;
  private UrlImage b;
  private TextView c;
  private TextView d;
  private TextView e;
  private RatingBar f;
  private RatingBar g;

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903223, paramViewGroup, false);
    this.b = ((UrlImage)localView.findViewById(2131296956));
    this.c = ((TextView)localView.findViewById(2131296962));
    this.d = ((TextView)localView.findViewById(2131296958));
    this.e = ((TextView)localView.findViewById(2131296957));
    this.f = ((RatingBar)localView.findViewById(2131296960));
    this.g = ((RatingBar)localView.findViewById(2131296961));
    return localView;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Preconditions.checkArgument(n().getIntent().hasExtra("android.intent.extra.SUBJECT"), "Missing Recommendation Info in Intent");
    this.a = ((PageRecommendation)n().getIntent().getParcelableExtra("android.intent.extra.SUBJECT"));
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    Preconditions.checkNotNull(this.a.creator);
    Preconditions.checkNotNull(this.a.creator.profilePicture);
    boolean bool = FriendshipStatus.ARE_FRIENDS.toGqlString().equals(this.a.creator.friendshipStatus);
    this.b.setImageParams(Uri.parse(this.a.creator.profilePicture.uri));
    if (this.a.pageRating > 0)
      if (bool)
      {
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.f.setRating(this.a.pageRating);
      }
    while (true)
    {
      this.c.setText(this.a.value.text);
      this.e.setText(this.a.creator.name);
      String str = DefaultTimeFormatUtil.a(p(), TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * this.a.creationTime);
      this.d.setText(str);
      return;
      this.g.setVisibility(0);
      this.f.setVisibility(8);
      this.g.setRating(this.a.pageRating);
      continue;
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageRecommendationFragment
 * JD-Core Version:    0.6.2
 */