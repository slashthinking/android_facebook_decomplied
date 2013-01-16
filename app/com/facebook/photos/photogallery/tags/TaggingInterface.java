package com.facebook.photos.photogallery.tags;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.photos.photogallery.ui.TouchPoint;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewTransform;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class TaggingInterface extends CustomFrameLayout
{
  private RelativeLayout a;
  private AutoCompleteTextView b;
  private ImageView c;
  private TouchPoint d;
  private ViewTransform e;
  private ViewPropertyAnimator f;
  private TaggingInterface.TaggingInterfaceAdapter g;
  private TaggingInterface.TaggingInterfaceListener h;
  private PointF i;
  private boolean j;
  private GestureDetector k;

  public TaggingInterface(Context paramContext)
  {
    this(paramContext, null);
  }

  public TaggingInterface(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903576);
    this.a = ((RelativeLayout)findViewById(2131297865));
    this.b = ((AutoCompleteTextView)findViewById(2131297866));
    this.c = ((ImageView)findViewById(2131297867));
    this.d = ((TouchPoint)findViewById(2131297869));
    this.b.setDropDownAnchor(2131297868);
    this.b.setDropDownVerticalOffset(0);
    this.b.setOnItemClickListener(new TaggingInterface.TypeaheadItemClickListener(this, null));
    this.c.setOnClickListener(new TaggingInterface.1(this));
    this.e = new ViewTransform(this.a);
    this.f = ViewPropertyAnimator.a(this.a);
    this.f.a(200L);
    this.k = new GestureDetector(getContext(), new TaggingInterface.GestureListener(this));
    getViewTreeObserver().addOnGlobalLayoutListener(new TaggingInterface.2(this));
  }

  public void a(PointF paramPointF)
  {
    this.i = paramPointF;
    this.f.a(0.0F);
    this.d.a(this.i);
    this.h.a();
    this.b.requestFocus();
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this.b, 1);
    this.j = true;
  }

  public void a(ArrayAdapter paramArrayAdapter, TaggingInterface.TaggingInterfaceAdapter paramTaggingInterfaceAdapter)
  {
    this.b.setAdapter(paramArrayAdapter);
    this.g = paramTaggingInterfaceAdapter;
  }

  public void a(TaggingInterface.TaggingInterfaceListener paramTaggingInterfaceListener)
  {
    this.h = paramTaggingInterfaceListener;
  }

  public void a(boolean paramBoolean)
  {
    this.b.setText("");
    this.f.a(-getHeight());
    this.d.a(paramBoolean);
    this.h.b();
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
    this.j = false;
  }

  public boolean a()
  {
    return this.j;
  }

  public void b()
  {
    a(true);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.j)
      this.k.onTouchEvent(paramMotionEvent);
    for (int m = 1; ; m = 0)
      return m;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.TaggingInterface
 * JD-Core Version:    0.6.0
 */