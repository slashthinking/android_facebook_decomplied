package com.facebook.katana.activity.media.crop;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.katana.model.PhotoItem;
import com.facebook.orca.inject.FbInjector;

public class CropManager extends Fragment
{
  private int Y = 8;
  private CropManager.OnCropFinishedListener Z = null;
  private Context a;
  private CropManager.OnCropAppliedListener aa = null;
  private CropState b = null;
  private CropImageView c;
  private CropRectView d;
  private CropAnimationManager e;
  private Button f;
  private Button g;
  private ImageView h;
  private View i;

  private void b()
  {
    this.b.l();
  }

  private void c()
  {
    if (this.Z != null)
      this.Z.a();
  }

  private void d()
  {
    if (this.aa != null)
      this.aa.a();
  }

  public View A()
  {
    return this.i;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.i = paramLayoutInflater.inflate(2130903127, paramViewGroup, false);
    this.i.setVisibility(this.Y);
    this.f = ((Button)this.i.findViewById(2131296628));
    this.g = ((Button)this.i.findViewById(2131296630));
    this.h = ((ImageView)this.i.findViewById(2131296629));
    this.d = ((CropRectView)this.i.findViewById(2131296626));
    this.c = ((CropImageView)this.i.findViewById(2131296625));
    this.e = new CropAnimationManager(this.c, this.d, this.b);
    this.c.a((CropHelper)FbInjector.a(this.a).a(CropHelper.class), this.b, this.a);
    this.d.a((CropHelper)FbInjector.a(this.a).a(CropHelper.class), this.b);
    return this.i;
  }

  public void a()
  {
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setVisibility(8);
    this.h.setVisibility(8);
    this.g.setVisibility(8);
    b();
    c();
  }

  public void a(Context paramContext)
  {
    super.a(paramContext);
    b(paramContext.getApplicationContext());
  }

  public void a(CropManager.OnCropAppliedListener paramOnCropAppliedListener)
  {
    this.aa = paramOnCropAppliedListener;
  }

  public void a(CropManager.OnCropFinishedListener paramOnCropFinishedListener)
  {
    this.Z = paramOnCropFinishedListener;
  }

  public void a(PhotoItem paramPhotoItem)
  {
    this.b.a(paramPhotoItem);
    this.c.setImageBitmapResetBase();
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    this.f.setVisibility(0);
    this.h.setVisibility(0);
    this.g.setVisibility(0);
  }

  protected boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.b.n();
    int j = 0;
    if (!bool1);
    while (true)
    {
      return j;
      if (this.e.b())
      {
        j = 1;
        continue;
      }
      if (this.d.a(paramMotionEvent))
      {
        j = 1;
        continue;
      }
      boolean bool2 = this.c.a(paramMotionEvent);
      j = 0;
      if (!bool2)
        continue;
      j = 1;
    }
  }

  public void b(Context paramContext)
  {
    this.a = paramContext;
    this.b = new CropState((CropHelper)FbInjector.a(this.a).a(CropHelper.class));
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.i.setOnTouchListener(new CropManager.1(this));
    this.f.setOnClickListener(new CropManager.2(this));
    this.h.setOnClickListener(new CropManager.3(this));
    this.g.setOnClickListener(new CropManager.4(this));
    this.c.setOnImageSizeCalculatedListener(new CropManager.5(this));
    this.d.setOnAnimationRequestedListener(new CropManager.6(this));
  }

  public void f(int paramInt)
  {
    this.Y = paramInt;
    this.i.setVisibility(paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropManager
 * JD-Core Version:    0.6.0
 */