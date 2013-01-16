package com.facebook.katana.view.vault;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.katana.provider.VaultImageProviderRow;
import com.facebook.katana.service.vault.VaultTable;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.photos.VaultLocalPhoto;
import com.facebook.widget.UrlImage;

public class VaultGridItemController
{
  private ImageView a;
  private ProgressBar b;
  private ImageView c;
  private VaultTable d;
  private Photo e;

  public VaultGridItemController(Context paramContext, Photo paramPhoto)
  {
    this.d = ((VaultTable)FbInjector.a(paramContext).a(VaultTable.class));
    this.e = paramPhoto;
  }

  public void a()
  {
    if (!(this.e instanceof VaultLocalPhoto));
    VaultImageProviderRow localVaultImageProviderRow;
    do
    {
      return;
      localVaultImageProviderRow = this.d.a(((VaultLocalPhoto)this.e).b());
    }
    while (localVaultImageProviderRow == null);
    if (localVaultImageProviderRow.f != 7)
    {
      if ((localVaultImageProviderRow.f != 0) && (localVaultImageProviderRow.f != 1))
        break label102;
      b(255);
      this.e.a(localVaultImageProviderRow.b);
      label75: if (!localVaultImageProviderRow.b())
        break label111;
      this.c.setVisibility(0);
    }
    while (true)
    {
      this.b.setVisibility(8);
      break;
      label102: b(75);
      break label75;
      label111: this.c.setVisibility(8);
    }
  }

  public void a(int paramInt)
  {
    if (this.c.getVisibility() == 0)
      this.c.setVisibility(8);
    this.b.setVisibility(0);
    this.b.setProgress(paramInt);
  }

  public void a(View paramView)
  {
    this.b = ((ProgressBar)paramView.findViewById(2131297946));
    this.b.setMax(100);
    this.c = ((ImageView)paramView.findViewById(2131297945));
    this.a = ((UrlImage)paramView.findViewById(2131297944)).getImageView();
  }

  public void b()
  {
    if (this.c.getVisibility() == 0)
      this.c.setVisibility(8);
    this.b.setVisibility(0);
    this.b.setIndeterminate(true);
  }

  public void b(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.VaultGridItemController
 * JD-Core Version:    0.6.0
 */