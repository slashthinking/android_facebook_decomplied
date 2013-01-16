package com.facebook.photos.photogallery.tags;

import android.content.Context;
import android.graphics.PointF;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewTransform;

public class TagView extends CustomFrameLayout
{
  private TextView a;
  private ViewTransform b;

  public TagView(Context paramContext, Tag paramTag)
  {
    super(paramContext, null);
    setContentView(2130903482);
    this.a = ((TextView)b(2131296472));
    this.a.setText(paramTag.b());
    this.b = new ViewTransform(this);
  }

  public void a(PointF paramPointF)
  {
    this.b.setTranslationX(paramPointF.x);
    this.b.setTranslationY(paramPointF.y);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TagView
 * JD-Core Version:    0.6.0
 */