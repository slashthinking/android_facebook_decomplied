package com.facebook.appcenter.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.appcenter.util.SocialTextStringGenerator;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Preconditions;
import java.util.List;

public class AppDetailFriendsAndDescriptionCardView extends CustomViewGroup
{
  private TextView a;
  private TextView b;
  private TextView c;
  private View d;
  private SocialTextStringGenerator e;
  private boolean f;
  private Context g;

  public AppDetailFriendsAndDescriptionCardView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AppDetailFriendsAndDescriptionCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppDetailFriendsAndDescriptionCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = paramContext;
    setContentView(2130903049);
    this.b = ((TextView)getView(2131296372));
    this.a = ((TextView)getView(2131296371));
    this.c = ((TextView)getView(2131296369));
    this.d = getView(2131296370);
    this.e = ((SocialTextStringGenerator)getInjector().a(SocialTextStringGenerator.class));
    Preconditions.checkNotNull(this.b);
    Preconditions.checkNotNull(this.c);
    Preconditions.checkNotNull(this.d);
    this.a.setOnClickListener(new AppDetailFriendsAndDescriptionCardView.1(this));
  }

  private void a(Boolean paramBoolean)
  {
    if (!this.f);
    while (true)
    {
      return;
      if (paramBoolean.booleanValue())
      {
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        continue;
      }
      this.a.setVisibility(8);
      this.b.setVisibility(0);
    }
  }

  public void setAppDescription(String paramString1, String paramString2)
  {
    this.f = false;
    if (paramString1 != null)
    {
      this.a.setText(paramString1 + " " + this.e.a());
      this.f = true;
    }
    Preconditions.checkNotNull(paramString2);
    this.b.setText(paramString2);
    a(Boolean.valueOf(this.f));
  }

  public void setFriendsUsing(GraphQLProfileList paramGraphQLProfileList, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramGraphQLProfileList);
    List localList = paramGraphQLProfileList.profiles;
    if ((localList == null) || (localList.size() == 0))
    {
      this.d.setVisibility(8);
      this.c.setVisibility(8);
    }
    while (true)
    {
      return;
      String str = this.e.a(paramGraphQLProfileList, paramBoolean);
      this.c.setText(str);
      this.d.setVisibility(0);
      this.c.setVisibility(0);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppDetailFriendsAndDescriptionCardView
 * JD-Core Version:    0.6.0
 */