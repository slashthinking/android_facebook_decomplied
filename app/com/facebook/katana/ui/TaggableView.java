package com.facebook.katana.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.katana.model.FacebookPhotoTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TaggableView extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private Context a;
  private TaggableView.TaggableViewListener b;
  private GestureDetector c;
  private int d;
  private int e;
  private HashMap<Long, TagView> f;
  private ArrayList<TagSuggestionView> g;
  private int h;

  public TaggableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903575, this);
    this.c = new GestureDetector(this);
    this.f = new HashMap();
    this.g = new ArrayList();
    this.h = -1;
    getViewTreeObserver().addOnGlobalLayoutListener(new TaggableView.1(this));
  }

  private int c(TagSuggestionView paramTagSuggestionView)
  {
    ImageView localImageView = (ImageView)findViewById(2131297397);
    int i = (int)(paramTagSuggestionView.getX() * localImageView.getWidth());
    int j = paramTagSuggestionView.getFullWidth();
    int k = i - j / 2;
    if (k + j > this.d)
      k = this.d - j;
    return k;
  }

  private int c(TagView paramTagView)
  {
    ImageView localImageView = (ImageView)findViewById(2131297397);
    int i = (int)(paramTagView.b * localImageView.getWidth());
    int j = paramTagView.getFullWidth();
    int k = i - j / 2;
    if (k + j > this.d)
      k = this.d - j;
    if (k < 0)
      k = 0;
    return k;
  }

  private int d(TagSuggestionView paramTagSuggestionView)
  {
    ImageView localImageView = (ImageView)findViewById(2131297397);
    int i = (int)(paramTagSuggestionView.getY() * localImageView.getHeight());
    int j = paramTagSuggestionView.getFullHeight();
    int k = i - paramTagSuggestionView.getFaceBoxHeight() / 3;
    if (k + j > this.e)
      k = this.e - j;
    return k;
  }

  private int d(TagView paramTagView)
  {
    ImageView localImageView = (ImageView)findViewById(2131297397);
    int i = (int)(paramTagView.c * localImageView.getHeight());
    int j = paramTagView.getFullHeight();
    if (i + j > this.e)
      i = this.e - j;
    return i;
  }

  public TagSuggestionView a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    TagSuggestionView localTagSuggestionView = (TagSuggestionView)((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903571, null);
    localTagSuggestionView.setImageSize(this.d);
    localTagSuggestionView.setEyeDistance(paramFloat3);
    localTagSuggestionView.setX(paramFloat1);
    localTagSuggestionView.setY(paramFloat2);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 0);
    localLayoutParams.setMargins(c(localTagSuggestionView), d(localTagSuggestionView), 0, 0);
    addView(localTagSuggestionView, localLayoutParams);
    this.g.add(localTagSuggestionView);
    localTagSuggestionView.setOnClickListener(new TaggableView.2(this, localTagSuggestionView));
    return localTagSuggestionView;
  }

  public TagView a(long paramLong, float paramFloat1, float paramFloat2, String paramString)
  {
    TagView localTagView;
    if ((paramLong == -1L) || (!this.f.containsKey(Long.valueOf(paramLong))))
    {
      localTagView = (TagView)((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130903573, null);
      localTagView.b = paramFloat1;
      localTagView.c = paramFloat2;
      localTagView.a = paramLong;
      localTagView.setText(paramString);
      if (paramLong == -1L)
        localTagView.a = getNextTextId();
      a(localTagView);
      this.f.put(Long.valueOf(localTagView.a), localTagView);
    }
    while (true)
    {
      return localTagView;
      localTagView = (TagView)this.f.get(Long.valueOf(paramLong));
      localTagView.b = paramFloat1;
      localTagView.c = paramFloat2;
      b(localTagView);
    }
  }

  public void a()
  {
    ImageView localImageView = (ImageView)findViewById(2131297397);
    int i = localImageView.getWidth();
    int j = localImageView.getHeight();
    if (this.d != i)
    {
      this.d = i;
      this.e = j;
      Iterator localIterator1 = this.f.keySet().iterator();
      while (localIterator1.hasNext())
      {
        long l = ((Long)localIterator1.next()).longValue();
        b((TagView)this.f.get(Long.valueOf(l)));
      }
      Iterator localIterator2 = this.g.iterator();
      while (localIterator2.hasNext())
        b((TagSuggestionView)localIterator2.next());
    }
  }

  public void a(long paramLong)
  {
    if (this.f.containsKey(Long.valueOf(paramLong)))
    {
      TagView localTagView = (TagView)this.f.get(Long.valueOf(paramLong));
      this.f.remove(Long.valueOf(paramLong));
      removeView(localTagView);
    }
  }

  public void a(TagSuggestionView paramTagSuggestionView)
  {
    if (this.g.contains(paramTagSuggestionView))
    {
      this.g.remove(paramTagSuggestionView);
      removeView(paramTagSuggestionView);
    }
  }

  public void a(TagView paramTagView)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 0);
    localLayoutParams.setMargins(c(paramTagView), d(paramTagView), 0, 0);
    addView(paramTagView, localLayoutParams);
  }

  public void b(TagSuggestionView paramTagSuggestionView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramTagSuggestionView.getLayoutParams();
    paramTagSuggestionView.setImageSize(this.d);
    localLayoutParams.setMargins(c(paramTagSuggestionView), d(paramTagSuggestionView), 0, 0);
    paramTagSuggestionView.setLayoutParams(localLayoutParams);
  }

  public void b(TagView paramTagView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramTagView.getLayoutParams();
    localLayoutParams.setMargins(c(paramTagView), d(paramTagView), 0, 0);
    paramTagView.setLayoutParams(localLayoutParams);
  }

  public int getNextTextId()
  {
    int i = this.h;
    this.h = (i - 1);
    return i;
  }

  public List<FacebookPhotoTag> getTags()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.keySet().iterator();
    if (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      TagView localTagView = (TagView)this.f.get(Long.valueOf(l));
      if (localTagView.a <= -1L);
      for (FacebookPhotoTag localFacebookPhotoTag = new FacebookPhotoTag("", -1L, 100.0F * localTagView.b, 100.0F * localTagView.c, -1L, localTagView.getText().toString()); ; localFacebookPhotoTag = new FacebookPhotoTag("", localTagView.a, 100.0F * localTagView.b, 100.0F * localTagView.c, -1L, null))
      {
        localArrayList.add(localFacebookPhotoTag);
        break;
      }
    }
    return localArrayList;
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    ImageView localImageView = (ImageView)findViewById(2131297397);
    float f1 = paramMotionEvent.getX() / localImageView.getWidth();
    float f2 = paramMotionEvent.getY() / localImageView.getHeight();
    this.b.a(f1, f2);
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.c.onTouchEvent(paramMotionEvent);
    return true;
  }

  public void setImage(Bitmap paramBitmap)
  {
    ImageView localImageView = (ImageView)findViewById(2131297397);
    localImageView.setImageBitmap(paramBitmap);
    findViewById(2131297397).setVisibility(0);
    this.d = localImageView.getWidth();
    this.e = localImageView.getHeight();
  }

  public void setListener(TaggableView.TaggableViewListener paramTaggableViewListener)
  {
    this.b = paramTaggableViewListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.TaggableView
 * JD-Core Version:    0.6.0
 */