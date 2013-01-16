package com.facebook.katana.view.vault;

import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.util.StringUtils;
import com.facebook.widget.PhotoToggleButton;
import com.facebook.widget.PhotoToggleButton.OnCheckedChangeListener;

public abstract class GridItemController extends DataSetObserver
  implements View.OnClickListener, View.OnLongClickListener, PhotoToggleButton.OnCheckedChangeListener
{
  private boolean a;
  private MediaItem b;
  private Matrix c;
  private GridItemController.OnClickListener d;
  private GridItemController.SelectionListener e;
  private GridItemController.OnLongClickListener f;
  private ImageView g;

  public GridItemController(View paramView)
  {
    this.g = ((ImageView)paramView.findViewById(2131297064));
    this.c = new Matrix();
    this.g.setOnClickListener(this);
    this.g.setOnLongClickListener(this);
  }

  private void b(Bitmap paramBitmap)
  {
    float f1 = Math.min(paramBitmap.getHeight(), paramBitmap.getWidth());
    float f2 = this.g.getWidth() / f1;
    this.c.reset();
    this.c.postScale(f2, f2);
  }

  protected abstract void a();

  public void a(Bitmap paramBitmap)
  {
    b(paramBitmap);
    b();
    this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramBitmap != null)
    {
      this.g.setImageBitmap(paramBitmap);
      this.a = true;
    }
  }

  public void a(MediaItem paramMediaItem)
  {
    this.b = paramMediaItem;
    this.a = false;
    a();
    this.g.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }

  public void a(GridItemController.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }

  public void a(GridItemController.SelectionListener paramSelectionListener)
  {
    this.e = paramSelectionListener;
  }

  public void a(PhotoToggleButton paramPhotoToggleButton, boolean paramBoolean)
  {
    if ((this.e != null) && (this.b != null))
      this.e.a(this, paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
  }

  protected abstract void b();

  public boolean b(MediaItem paramMediaItem)
  {
    if ((this.a) && (this.b != null) && (StringUtils.a(paramMediaItem.b(), this.b.b())));
    for (int i = 1; ; i = 0)
      return i;
  }

  public MediaItem c()
  {
    return this.b;
  }

  protected final ImageView d()
  {
    return this.g;
  }

  public void onClick(View paramView)
  {
    if ((this.d != null) && (this.b != null))
      this.d.a(this);
  }

  public void onInvalidated()
  {
    a(this.b);
    this.g.invalidate();
  }

  public boolean onLongClick(View paramView)
  {
    if ((this.f != null) && (this.b != null))
      this.f.b(this);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.GridItemController
 * JD-Core Version:    0.6.0
 */