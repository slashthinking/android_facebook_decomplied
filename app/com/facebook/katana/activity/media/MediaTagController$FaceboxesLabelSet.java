package com.facebook.katana.activity.media;

import android.graphics.PointF;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.katana.activity.media.detection.PhotoDetectionData;
import com.facebook.katana.model.FacebookPhotoTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

class MediaTagController$FaceboxesLabelSet extends ArrayList<Facebox>
  implements MediaTagController.LabelSet<Facebox>
{
  private MediaTagController$FaceboxesLabelSet(MediaTagController paramMediaTagController)
  {
  }

  private void c(Facebox paramFacebox)
  {
    ViewGroup localViewGroup = (ViewGroup)MediaTagController.e(this.this$0).get(paramFacebox);
    if (localViewGroup != null)
    {
      MediaTagController.c(this.this$0).removeView(localViewGroup);
      MediaTagController.e(this.this$0).remove(paramFacebox);
      View localView1 = localViewGroup.findViewById(2131297803);
      MediaTagController.f(this.this$0).remove(localView1);
      View localView2 = (View)MediaTagController.g(this.this$0).get(paramFacebox);
      if (localView2 != null)
        MediaTagController.c(this.this$0).removeView(localView2);
      MediaTagController.g(this.this$0).remove(paramFacebox);
    }
  }

  public View.OnClickListener a(Facebox paramFacebox)
  {
    return new MediaTagController.FaceboxesLabelSet.2(this, paramFacebox);
  }

  public Facebox a(PointF paramPointF)
  {
    Iterator localIterator = iterator();
    Facebox localFacebox;
    do
    {
      if (!localIterator.hasNext())
        break;
      localFacebox = (Facebox)localIterator.next();
    }
    while (!paramPointF.equals(localFacebox.a()));
    while (true)
    {
      return localFacebox;
      localFacebox = null;
    }
  }

  public void a()
  {
    ListIterator localListIterator = MediaTagController.h(this.this$0).f();
    while (localListIterator.hasNext())
    {
      c((Facebox)localListIterator.next());
      localListIterator.remove();
    }
  }

  public Facebox b(PointF paramPointF)
  {
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    Iterator localIterator = MediaTagController.h(this.this$0).iterator();
    Object localObject2;
    double d2;
    if (localIterator.hasNext())
    {
      Facebox localFacebox = (Facebox)localIterator.next();
      if (!localFacebox.b(paramPointF))
        break label83;
      double d3 = localFacebox.c(paramPointF);
      if (d3 >= d1)
        break label83;
      localObject2 = localFacebox;
      d2 = d3;
    }
    while (true)
    {
      d1 = d2;
      localObject1 = localObject2;
      break;
      return localObject1;
      label83: d2 = d1;
      localObject2 = localObject1;
    }
  }

  public void b()
  {
    if ((MediaTagController.i(this.this$0) != null) && (MediaTagController.m() != null))
    {
      String str = MediaTagController.a(MediaTagController.i(this.this$0));
      PhotoDetectionData localPhotoDetectionData = (PhotoDetectionData)MediaTagController.m().get(str);
      if (localPhotoDetectionData != null)
      {
        MediaTagController.h(this.this$0).clear();
        MediaTagController.h(this.this$0).addAll(localPhotoDetectionData.a());
      }
    }
    if (MediaTagController.d(this.this$0).a() >= 7)
      MediaTagController.h(this.this$0).k();
    label209: 
    while (true)
    {
      if (MediaTagController.h(this.this$0).size() > 0)
        MediaTagController.j(this.this$0);
      return;
      if (MediaTagController.d(this.this$0).a() == 0)
        continue;
      ListIterator localListIterator = MediaTagController.h(this.this$0).f();
      while (true)
      {
        if (!localListIterator.hasNext())
          break label209;
        Facebox localFacebox = (Facebox)localListIterator.next();
        Iterator localIterator = MediaTagController.d(this.this$0).iterator();
        if (!localIterator.hasNext())
          continue;
        if (!localFacebox.a(((FacebookPhotoTag)localIterator.next()).b()))
          break;
        localListIterator.remove();
      }
    }
  }

  public void b(Facebox paramFacebox)
  {
    super.remove(paramFacebox);
    c(paramFacebox);
  }

  public ListIterator<Facebox> f()
  {
    return listIterator();
  }

  public Map<Facebox, ViewGroup> g()
  {
    return MediaTagController.e(this.this$0);
  }

  public Map<View, Facebox> h()
  {
    return MediaTagController.f(this.this$0);
  }

  public View.OnClickListener i()
  {
    return new MediaTagController.FaceboxesLabelSet.1(this);
  }

  public int j()
  {
    return 2130837607;
  }

  public void k()
  {
    MediaTagController.h(this.this$0).clear();
    MediaTagController.e(this.this$0).clear();
    MediaTagController.f(this.this$0).clear();
    MediaTagController.g(this.this$0).clear();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaTagController.FaceboxesLabelSet
 * JD-Core Version:    0.6.0
 */