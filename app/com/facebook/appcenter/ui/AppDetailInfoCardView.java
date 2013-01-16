package com.facebook.appcenter.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.UrlImage;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.List;

public class AppDetailInfoCardView extends CustomViewGroup
{
  private UrlImage a;
  private TextView b;
  private TextView c;
  private Button d;
  private AppDetailInfoCardView.UserActionListener e;
  private RatingBar f;

  public AppDetailInfoCardView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AppDetailInfoCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppDetailInfoCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903058);
    this.a = ((UrlImage)getView(2131296389));
    this.b = ((TextView)getView(2131296390));
    this.c = ((TextView)getView(2131296392));
    this.d = ((Button)getView(2131296393));
    this.f = ((RatingBar)getView(2131296391));
    this.d.setOnClickListener(new AppDetailInfoCardView.1(this));
  }

  private String a(List<String> paramList)
  {
    if (paramList == null);
    for (String str = ""; ; str = Joiner.on("-").join(paramList))
      return str;
  }

  public void setAppDetailInfo(AppDetail paramAppDetail)
  {
    Preconditions.checkNotNull(paramAppDetail);
    Preconditions.checkNotNull(paramAppDetail.name);
    this.b.setText(paramAppDetail.name);
    Preconditions.checkNotNull(paramAppDetail.square_logo);
    this.a.setImageParams(Uri.parse(paramAppDetail.square_logo.uri));
    this.f.setRating((float)paramAppDetail.averageStarRating);
    this.c.setText(a(paramAppDetail.appCenterCategories));
    if (paramAppDetail.isGame);
    for (int i = 2131362045; ; i = 2131362044)
    {
      this.d.setText(i);
      return;
    }
  }

  public void setAppState()
  {
  }

  public void setUserActionListener(AppDetailInfoCardView.UserActionListener paramUserActionListener)
  {
    this.e = paramUserActionListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppDetailInfoCardView
 * JD-Core Version:    0.6.0
 */