package com.facebook.orca.photos.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.attachments.ImageAttachmentData;
import com.facebook.orca.emoji.EmojiUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.ThreadDateUtil;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhotoViewActivity extends FbFragmentActivity
  implements AnalyticsActivity
{
  private final AdapterView.OnItemSelectedListener A = new PhotoViewActivity.1(this);
  private final GestureDetector.SimpleOnGestureListener B = new PhotoViewActivity.2(this);
  private Gallery n;
  private PhotoGalleryAdapter o;
  private RelativeLayout p;
  private FrameLayout q;
  private GestureDetector r;
  private TextView s;
  private UserTileView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private EmojiUtil x;
  private ThreadDateUtil y;
  private Message z;

  private boolean i()
  {
    if (this.p.getVisibility() == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  private void j()
  {
    if (this.q.getVisibility() == 8)
    {
      if (((PhotoMessageItem)this.n.getSelectedItem()).b() != null)
        this.p.setVisibility(0);
      this.q.setVisibility(0);
    }
  }

  private void k()
  {
    if (this.q.getVisibility() == 0)
    {
      this.p.setVisibility(8);
      this.q.setVisibility(8);
    }
  }

  public String a()
  {
    return "photo";
  }

  public void a(Bundle paramBundle)
  {
    int i = 0;
    super.a(paramBundle);
    this.y = ((ThreadDateUtil)C().a(ThreadDateUtil.class));
    this.x = ((EmojiUtil)C().a(EmojiUtil.class));
    setContentView(2130903390);
    Intent localIntent = getIntent();
    ImageAttachmentData localImageAttachmentData1 = (ImageAttachmentData)localIntent.getParcelableExtra("imageData");
    if (localImageAttachmentData1 == null)
      finish();
    while (true)
    {
      return;
      if (localIntent.hasExtra("message"))
        this.z = ((Message)localIntent.getParcelableExtra("message"));
      ArrayList localArrayList = Lists.a();
      if (localIntent.hasExtra("imageAttachments"))
      {
        Iterator localIterator = localIntent.getParcelableArrayListExtra("imageAttachments").iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          ImageAttachmentData localImageAttachmentData2 = (ImageAttachmentData)localIterator.next();
          localArrayList.add(new PhotoMessageItem(localImageAttachmentData2.b(), this.z));
          if (localImageAttachmentData2.b().equals(localImageAttachmentData1.b()))
            j = i;
          i++;
        }
      }
      localArrayList.add(new PhotoMessageItem(localImageAttachmentData1.b(), null));
      int j = 0;
      this.r = new GestureDetector(this, this.B);
      this.n = ((Gallery)f(2131297398));
      this.o = new PhotoGalleryAdapter(this, localArrayList);
      this.n.setAdapter(this.o);
      this.n.setOnItemSelectedListener(this.A);
      this.p = ((RelativeLayout)f(2131297179));
      this.s = ((TextView)f(2131297345));
      this.t = ((UserTileView)f(2131297343));
      this.u = ((TextView)f(2131297402));
      this.v = ((TextView)f(2131297403));
      this.w = ((TextView)f(2131297400));
      this.q = ((FrameLayout)f(2131297399));
      this.n.setSelection(j);
    }
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.r.onTouchEvent(paramMotionEvent)) || (super.dispatchTouchEvent(paramMotionEvent)));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.view.PhotoViewActivity
 * JD-Core Version:    0.6.0
 */