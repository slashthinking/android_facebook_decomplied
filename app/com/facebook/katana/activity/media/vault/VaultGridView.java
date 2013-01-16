package com.facebook.katana.activity.media.vault;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.photos.grid.UrlImageGrid;
import com.facebook.photos.grid.UrlImageGridAdapter;

public class VaultGridView extends UrlImageGrid
{
  public VaultGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }

  protected UrlImageGridAdapter a()
  {
    return new VaultGridAdapter(this.a, this, this.c);
  }

  protected int getEmptyTextResourceId()
  {
    return 2131296644;
  }

  protected int getEmptyTextStringId()
  {
    return 2131363044;
  }

  protected int getGridResourceId()
  {
    return 2131297964;
  }

  protected int getProgressResourceId()
  {
    return 2131296645;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultGridView
 * JD-Core Version:    0.6.0
 */