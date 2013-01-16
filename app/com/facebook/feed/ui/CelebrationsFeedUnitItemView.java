package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.graphql.model.CelebrationsItem;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Strings;

public class CelebrationsFeedUnitItemView extends CustomLinearLayout
{
  private final UrlImage a;
  private final TextView b;
  private final TextView c;
  private final TextView d;
  private final ImageView e;
  private final FeedImageLoader f;
  private final View g;
  private final View h;
  private FeedRendererOptions i;
  private View j;
  private final CelebrationsFeedUnitItemView.HandleUriOnClickListener k;
  private final CelebrationsFeedUnitItemView.HandleUriOnClickListener l;

  public CelebrationsFeedUnitItemView(Context paramContext)
  {
    this(paramContext, null);
  }

  public CelebrationsFeedUnitItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903238);
    FbInjector localFbInjector = getInjector();
    this.i = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.f = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
    this.k = new CelebrationsFeedUnitItemView.HandleUriOnClickListener(this, null);
    this.l = new CelebrationsFeedUnitItemView.HandleUriOnClickListener(this, null);
    this.a = ((UrlImage)b(2131296995));
    this.b = ((TextView)b(2131296997));
    this.c = ((TextView)b(2131296998));
    this.d = ((TextView)b(2131296999));
    this.e = ((ImageView)b(2131297000));
    this.h = b(2131296996);
    this.g = b(2131296994);
    this.j = b(2131296993);
  }

  public void a()
  {
    this.g.setVisibility(0);
  }

  public void a(CelebrationsItem paramCelebrationsItem)
  {
    GraphQLProfile localGraphQLProfile = paramCelebrationsItem.profile;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = localGraphQLProfile.id;
    String str1 = StringLocaleUtil.a("fb://profile/%s", arrayOfObject1);
    this.k.a(str1);
    this.a.setOnClickListener(this.k);
    if (localGraphQLProfile.c())
    {
      this.a.setImageParams(this.f.a(localGraphQLProfile.profilePicture, FeedImageLoader.FeedImageType.Celebrations));
      this.b.setText(localGraphQLProfile.name);
      this.b.setOnClickListener(this.k);
      if ((paramCelebrationsItem.description == null) || (Strings.isNullOrEmpty(paramCelebrationsItem.description.text)))
        break label268;
      this.c.setText(paramCelebrationsItem.description.text);
      this.c.setVisibility(0);
      label137: if (!localGraphQLProfile.canViewerSendGift)
        break label280;
      this.e.setVisibility(0);
      this.h.setVisibility(0);
      this.d.setVisibility(0);
      this.d.setTextColor(2131165265);
      this.d.setText(2131362118);
      this.e.setImageResource(2130838204);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localGraphQLProfile.id;
      arrayOfObject2[1] = "mobile_birthday_box";
      String str2 = StringLocaleUtil.a("fb://gift/sendinterstitial/?recipient=%s&entry_point=%s", arrayOfObject2);
      this.l.a(str2);
      this.e.setOnClickListener(this.l);
      this.j.setOnClickListener(this.l);
    }
    while (true)
    {
      return;
      this.a.setImageParams(null, null);
      break;
      label268: this.c.setVisibility(8);
      break label137;
      label280: this.e.setOnClickListener(null);
      this.j.setOnClickListener(null);
      this.e.setVisibility(8);
      this.h.setVisibility(8);
      this.d.setVisibility(8);
    }
  }

  public void b()
  {
    this.g.setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.CelebrationsFeedUnitItemView
 * JD-Core Version:    0.6.0
 */