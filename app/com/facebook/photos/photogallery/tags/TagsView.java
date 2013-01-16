package com.facebook.photos.photogallery.tags;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ZoomableImageView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TagsView extends CustomFrameLayout
{
  private ZoomableImageView a;
  private List<Tag> b;
  private Map<Tag, TagView> c;
  private TagsView.TagsViewListenerAdapter d;

  public TagsView(Context paramContext, ZoomableImageView paramZoomableImageView, List<Tag> paramList)
  {
    super(paramContext, null);
    setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.a = paramZoomableImageView;
    setTags(paramList);
  }

  private void a(Tag paramTag)
  {
    TagView localTagView = new TagView(getContext(), paramTag);
    localTagView.setOnClickListener(new TagsView.1(this, paramTag));
    addView(localTagView, new FrameLayout.LayoutParams(-2, -2));
    this.c.put(paramTag, localTagView);
    localTagView.getViewTreeObserver().addOnGlobalLayoutListener(new TagsView.2(this, localTagView, paramTag));
  }

  private void b(Tag paramTag)
  {
    if ((this.b != null) && (this.a.getDrawable() != null) && (this.a.getImageMatrix() != null))
    {
      TagView localTagView = (TagView)this.c.get(paramTag);
      int i = this.a.getDrawable().getIntrinsicWidth();
      int j = this.a.getDrawable().getIntrinsicHeight();
      localTagView.a(a(paramTag.a(), localTagView.getWidth(), localTagView.getHeight(), getWidth(), getHeight(), i, j, this.a.getImageMatrix()));
    }
  }

  PointF a(PointF paramPointF, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramPointF.x / 100.0F * paramInt5);
    arrayOfFloat[1] = (paramPointF.y / 100.0F * paramInt6);
    paramMatrix.mapPoints(arrayOfFloat);
    PointF localPointF = new PointF(arrayOfFloat[0], arrayOfFloat[1]);
    int i = getContext().getResources().getDimensionPixelSize(2131230812);
    localPointF.x -= paramInt1 / 2;
    localPointF.y += i / 2;
    return localPointF;
  }

  public void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      b((Tag)localIterator.next());
  }

  public void a(TagsView.TagsViewListenerAdapter paramTagsViewListenerAdapter)
  {
    this.d = paramTagsViewListenerAdapter;
  }

  public void setTags(List<Tag> paramList)
  {
    this.b = paramList;
    this.c = new HashMap();
    removeAllViews();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      a((Tag)localIterator.next());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TagsView
 * JD-Core Version:    0.6.0
 */