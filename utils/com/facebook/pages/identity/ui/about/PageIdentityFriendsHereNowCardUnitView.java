package com.facebook.pages.identity.ui.about;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PageFriendsHereNow;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

public class PageIdentityFriendsHereNowCardUnitView extends CustomRelativeLayout
{
  private final int a;
  private final ColorStateList b;
  private final TextView c;
  private final LinearLayout d;

  public PageIdentityFriendsHereNowCardUnitView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageIdentityFriendsHereNowCardUnitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageIdentityFriendsHereNowCardUnitView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903455);
    Resources localResources = (Resources)getInjector().a(Resources.class);
    this.a = localResources.getInteger(2131558400);
    this.b = ColorStateList.valueOf(localResources.getColor(2131165216));
    this.c = ((TextView)findViewById(2131297593));
    this.d = ((LinearLayout)findViewById(2131297594));
    a();
  }

  private void a()
  {
    for (int i = 0; i < this.a; i++)
      inflate(getContext(), 2130903456, this.d);
  }

  public void setFriendsHereNow(PageFriendsHereNow paramPageFriendsHereNow)
  {
    if ((paramPageFriendsHereNow == null) || (paramPageFriendsHereNow.friends == null) || (paramPageFriendsHereNow.friends.size() < 2))
    {
      this.d.setVisibility(8);
      return;
    }
    int i = Math.min(this.a, paramPageFriendsHereNow.friends.size());
    int j = 0;
    int k = 0;
    label56: GraphQLProfile localGraphQLProfile;
    int m;
    if (k < i)
    {
      localGraphQLProfile = (GraphQLProfile)paramPageFriendsHereNow.friends.get(k);
      if ((localGraphQLProfile != null) && (localGraphQLProfile.profilePicture != null))
        if (localGraphQLProfile.profilePicture.uri == null)
          m = k;
    }
    while (true)
    {
      if (m < this.a)
      {
        this.d.getChildAt(m).setVisibility(8);
        m++;
        continue;
        UrlImage localUrlImage = (UrlImage)this.d.getChildAt(k);
        localUrlImage.setImageParams(Uri.parse(localGraphQLProfile.profilePicture.uri));
        localUrlImage.setVisibility(0);
        k++;
        j = 1;
        break label56;
      }
      LinearLayout localLinearLayout = this.d;
      if (j != 0);
      for (int n = 0; ; n = 8)
      {
        localLinearLayout.setVisibility(n);
        break;
      }
      m = k;
    }
  }

  public void setFriendsHereNowText(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    Preconditions.checkNotNull(paramGraphQLTextWithEntities);
    Preconditions.checkNotNull(paramGraphQLTextWithEntities.text);
    Preconditions.checkNotNull(paramGraphQLTextWithEntities.ranges);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramGraphQLTextWithEntities.text);
    Iterator localIterator = paramGraphQLTextWithEntities.ranges.iterator();
    while (localIterator.hasNext())
    {
      GraphQLEntityRange localGraphQLEntityRange = (GraphQLEntityRange)localIterator.next();
      localSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 1, -1, this.b, null), localGraphQLEntityRange.offset, localGraphQLEntityRange.offset + localGraphQLEntityRange.length, 18);
    }
    this.c.setText(localSpannableStringBuilder);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityFriendsHereNowCardUnitView
 * JD-Core Version:    0.6.2
 */