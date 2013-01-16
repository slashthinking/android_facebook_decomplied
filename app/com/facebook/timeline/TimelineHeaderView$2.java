package com.facebook.timeline;

import android.graphics.drawable.Drawable;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.widget.UrlImage;
import com.facebook.widget.UrlImage.OnImageDownloadListener;

class TimelineHeaderView$2
  implements UrlImage.OnImageDownloadListener
{
  public void a(Drawable paramDrawable)
  {
    TimelineHeaderView.a(this.e, this.a.uri);
    TimelineHeaderView.a(this.e, paramDrawable.getIntrinsicWidth());
    TimelineHeaderView.b(this.e, paramDrawable.getIntrinsicHeight());
    TimelineHeaderView.a(this.e, this.b, this.c, this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderView.2
 * JD-Core Version:    0.6.0
 */