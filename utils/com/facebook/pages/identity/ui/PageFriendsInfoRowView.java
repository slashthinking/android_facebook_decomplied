package com.facebook.pages.identity.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;

public class PageFriendsInfoRowView extends CustomViewGroup
{
  private final UrlImage a;
  private final TextView b;

  public PageFriendsInfoRowView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageFriendsInfoRowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageFriendsInfoRowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903458);
    this.a = ((UrlImage)findViewById(2131297596));
    this.b = ((TextView)findViewById(2131297597));
  }

  public void a(GraphQLProfile paramGraphQLProfile)
  {
    if (paramGraphQLProfile != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (paramGraphQLProfile.profilePicture != null)
        this.a.setImageParams(Uri.parse(paramGraphQLProfile.profilePicture.uri));
      this.b.setText(paramGraphQLProfile.name);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageFriendsInfoRowView
 * JD-Core Version:    0.6.2
 */