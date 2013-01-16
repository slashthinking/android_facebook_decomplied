package com.facebook.pages.identity.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLPoint2D;
import com.facebook.orca.inject.FbInjector;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.timeline.util.PhotoUtil;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.List;

public class PageIdentityHeaderView extends CustomRelativeLayout
{
  private final Joiner a;
  private final int b;
  private final Drawable c;
  private final TextView d;
  private final TextView e;
  private final FrameLayout f;
  private final UrlImage g;

  public PageIdentityHeaderView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public PageIdentityHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageIdentityHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903459);
    Resources localResources = (Resources)getInjector().a(Resources.class);
    this.a = Joiner.on(" " + localResources.getString(2131361798) + " ");
    this.b = localResources.getDimensionPixelSize(2131230731);
    this.c = localResources.getDrawable(2130838798);
    this.d = ((TextView)findViewById(2131297602));
    this.e = ((TextView)findViewById(2131297603));
    this.f = ((FrameLayout)findViewById(2131297598));
    this.g = ((UrlImage)findViewById(2131297599));
  }

  private void a(UrlImage paramUrlImage, GraphQLPoint2D paramGraphQLPoint2D)
  {
    Drawable localDrawable = paramUrlImage.getImageView().getDrawable();
    if (localDrawable == paramUrlImage.getPlaceHolderDrawable())
      this.f.setForeground(null);
    while (true)
    {
      return;
      this.f.setForeground(this.c);
      paramUrlImage.setScaleType(ImageView.ScaleType.MATRIX);
      paramUrlImage.setImageMatrix(PhotoUtil.a(getScreenWidth(), this.b, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), paramGraphQLPoint2D.x, paramGraphQLPoint2D.y));
    }
  }

  private boolean a(GraphQLFocusedPhoto paramGraphQLFocusedPhoto)
  {
    if ((paramGraphQLFocusedPhoto != null) && (paramGraphQLFocusedPhoto.photo != null) && (paramGraphQLFocusedPhoto.photo.image != null) && (paramGraphQLFocusedPhoto.photo.image.uri != null) && (paramGraphQLFocusedPhoto.focus != null));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private int getScreenWidth()
  {
    return ((WindowManager)getInjector().a(WindowManager.class)).getDefaultDisplay().getWidth();
  }

  public void setPageData(PageIdentityData paramPageIdentityData)
  {
    Preconditions.checkNotNull(paramPageIdentityData);
    String str1 = paramPageIdentityData.l();
    if (str1 != null)
      this.d.setText(str1);
    List localList = paramPageIdentityData.c();
    if ((localList != null) && (localList.size() > 0))
    {
      String str2 = this.a.join(localList);
      this.e.setText(str2);
    }
    GraphQLFocusedPhoto localGraphQLFocusedPhoto = paramPageIdentityData.d();
    if (a(localGraphQLFocusedPhoto))
    {
      this.g.setOnImageDownloadListener(new PageIdentityHeaderView.1(this, localGraphQLFocusedPhoto));
      a(this.g, localGraphQLFocusedPhoto.focus);
      this.g.setImageParams(Uri.parse(localGraphQLFocusedPhoto.photo.image.uri));
    }
    GraphQLImage localGraphQLImage = paramPageIdentityData.s();
    if ((localGraphQLImage != null) && (localGraphQLImage.uri != null))
      ((UrlImage)findViewById(2131297601)).setImageParams(Uri.parse(localGraphQLImage.uri));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageIdentityHeaderView
 * JD-Core Version:    0.6.2
 */