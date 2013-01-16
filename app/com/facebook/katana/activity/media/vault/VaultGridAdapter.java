package com.facebook.katana.activity.media.vault;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.facebook.debug.Assert;
import com.facebook.katana.view.vault.VaultGridItemController;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.photos.grid.UrlImageGrid;
import com.facebook.photos.grid.UrlImageGrid.UI_STATE;
import com.facebook.photos.grid.UrlImageGridAdapter;
import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.Photo.PhotoSize;
import com.facebook.photos.photogallery.photos.VaultPhoto;
import com.facebook.widget.UrlImage;
import java.util.HashMap;

public class VaultGridAdapter extends UrlImageGridAdapter<VaultPhoto>
{
  private static final String i = VaultGridAdapter.class.getSimpleName();
  protected VaultGridAdapter.DATA_LOADER_STATE a = VaultGridAdapter.DATA_LOADER_STATE.IDLE;
  protected String b = "";
  private HashMap<Uri, VaultGridItemController> j = new HashMap();

  public VaultGridAdapter(Context paramContext, UrlImageGrid paramUrlImageGrid, AdapterView paramAdapterView)
  {
    super(paramContext, paramUrlImageGrid, paramAdapterView);
  }

  private VaultGridItemController c(Uri paramUri)
  {
    Assert.a("Photo URI cannot be null", paramUri);
    int m;
    VaultGridItemController localVaultGridItemController;
    if (this.j.containsKey(paramUri))
    {
      int k = this.f.getFirstVisiblePosition();
      m = 0;
      if (m < this.f.getChildCount())
        if (((Photo)getItem(k + m)).a(Photo.PhotoSize.THUMBNAIL).a().equals(paramUri))
        {
          localVaultGridItemController = (VaultGridItemController)this.j.get(paramUri);
          localVaultGridItemController.a(this.f.getChildAt(m));
          this.f.getChildAt(m).setTag(paramUri);
        }
    }
    while (true)
    {
      return localVaultGridItemController;
      m++;
      break;
      localVaultGridItemController = null;
    }
  }

  protected int a()
  {
    return 2130903623;
  }

  public void a(int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      if ((getCount() <= 40 + (paramInt1 + paramInt2)) && (this.a == VaultGridAdapter.DATA_LOADER_STATE.IDLE))
      {
        this.a = VaultGridAdapter.DATA_LOADER_STATE.FETCHING;
        VaultGridAdapter.LoadPhotos localLoadPhotos = new VaultGridAdapter.LoadPhotos(this);
        String[] arrayOfString = new String[1];
        arrayOfString[0] = this.b;
        localLoadPhotos.execute(arrayOfString);
      }
      while (true)
      {
        return;
        if (getCount() <= 0)
          continue;
        this.e.a(UrlImageGrid.UI_STATE.HAS_PHOTO);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(Uri paramUri)
  {
    VaultGridItemController localVaultGridItemController = c(paramUri);
    if (localVaultGridItemController != null)
      localVaultGridItemController.a();
  }

  public void a(Uri paramUri, int paramInt)
  {
    VaultGridItemController localVaultGridItemController = c(paramUri);
    if (localVaultGridItemController != null)
      localVaultGridItemController.a(paramInt);
  }

  public void a(Photo paramPhoto)
  {
    super.a(paramPhoto);
    this.j.remove(paramPhoto.a(Photo.PhotoSize.SCREENNAIL).a());
  }

  protected int b()
  {
    return 2131297944;
  }

  public void b(Uri paramUri)
  {
    VaultGridItemController localVaultGridItemController = c(paramUri);
    if (localVaultGridItemController != null)
      localVaultGridItemController.b();
  }

  public void c()
  {
    sort(new VaultGridAdapter.1(this));
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramView.findViewById(2131297945).setVisibility(8);
      paramView.findViewById(2131297946).setVisibility(8);
      ((UrlImage)paramView.findViewById(2131297944)).getImageView().setAlpha(255);
    }
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    Photo localPhoto = (Photo)getItem(paramInt);
    Uri localUri = localPhoto.a(Photo.PhotoSize.THUMBNAIL).a();
    VaultGridItemController localVaultGridItemController1;
    if (!this.j.containsKey(localUri))
    {
      localVaultGridItemController1 = new VaultGridItemController(this.c, localPhoto);
      this.j.put(localPhoto.a(Photo.PhotoSize.THUMBNAIL).a(), localVaultGridItemController1);
    }
    for (VaultGridItemController localVaultGridItemController2 = localVaultGridItemController1; ; localVaultGridItemController2 = (VaultGridItemController)this.j.get(localUri))
    {
      localVaultGridItemController2.a(localView);
      localVaultGridItemController2.a();
      return localView;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultGridAdapter
 * JD-Core Version:    0.6.0
 */