package com.facebook.photos.photogallery.photogalleries.consumption;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.photos.photogallery.LaunchableGalleryFragment;
import com.facebook.photos.photogallery.Photo;
import com.facebook.photos.photogallery.PhotoFragment;
import com.facebook.photos.photogallery.PhotoFragmentFactory;
import com.facebook.photos.photogallery.PhotoGallery;
import com.facebook.photos.photogallery.PhotoSource;
import com.facebook.photos.photogallery.tags.Tag;
import com.facebook.photos.photogallery.tags.TaggedPhotoFragment;
import com.facebook.photos.photogallery.tags.TaggingInterface;
import com.facebook.widget.PhotoButton;
import com.facebook.widget.PhotoToggleButton;
import com.facebook.widget.PhotoToggleButton.OnCheckedChangeListener;
import com.facebook.widget.ViewTransform;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.util.Iterator;
import java.util.List;

public class ConsumptionPhotoGalleryFragment extends LaunchableGalleryFragment<ConsumptionPhoto, TaggedPhotoFragment>
  implements View.OnClickListener, ConsumptionPhotoDataAdapter.ConsumptionPhotoDataAdapterListener, PhotoToggleButton.OnCheckedChangeListener
{
  private TextView Y;
  private ConsumptionPhotoDataAdapter Z;
  private boolean aa;
  private ViewTransform ab;
  private ViewPropertyAnimator ac;
  private TaggingInterface b;
  private LinearLayout c;
  private LinearLayout d;
  private TextView e;
  private PhotoToggleButton f;
  private PhotoButton g;
  private PhotoButton h;
  private TextView i;

  private void R()
  {
    LinearLayout localLinearLayout = this.d;
    if (((ConsumptionPhoto)K()).f());
    for (int j = 0; ; j = 8)
    {
      localLinearLayout.setVisibility(j);
      this.e.setText(((ConsumptionPhoto)K()).b());
      return;
    }
  }

  private void S()
  {
    this.f.setChecked(((ConsumptionPhoto)K()).e());
    this.i.setText(U());
    this.Y.setText(V());
  }

  private void T()
  {
    int j;
    PhotoButton localPhotoButton;
    int k;
    if ((((ConsumptionPhoto)K()).g()) || (((ConsumptionPhoto)K()).h()))
    {
      j = 1;
      localPhotoButton = this.h;
      k = 0;
      if (j == 0)
        break label50;
    }
    while (true)
    {
      localPhotoButton.setVisibility(k);
      return;
      j = 0;
      break;
      label50: k = 8;
    }
  }

  private String U()
  {
    ConsumptionPhoto localConsumptionPhoto = (ConsumptionPhoto)K();
    String str;
    if (localConsumptionPhoto.c() == 0)
    {
      str = "";
      return str;
    }
    if (localConsumptionPhoto.e());
    for (int j = 99; ; j = 98)
    {
      int k = Math.min(localConsumptionPhoto.c(), j);
      Resources localResources = q();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(k);
      str = localResources.getQuantityString(2131427345, k, arrayOfObject);
      break;
    }
  }

  private String V()
  {
    ConsumptionPhoto localConsumptionPhoto = (ConsumptionPhoto)K();
    if (localConsumptionPhoto.d() == 0);
    int j;
    Resources localResources;
    Object[] arrayOfObject;
    for (String str = ""; ; str = localResources.getQuantityString(2131427346, j, arrayOfObject))
    {
      return str;
      j = Math.min(localConsumptionPhoto.d(), 99);
      localResources = q();
      arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(j);
    }
  }

  private boolean W()
  {
    return this.aa;
  }

  private void X()
  {
    Iterator localIterator = O().iterator();
    while (localIterator.hasNext())
      ((TaggedPhotoFragment)((Pair)localIterator.next()).second).M();
    this.f.b();
    this.g.b();
    this.aa = true;
  }

  private void Y()
  {
    if (this.b.a())
      this.b.b();
    Iterator localIterator = O().iterator();
    while (localIterator.hasNext())
      ((TaggedPhotoFragment)((Pair)localIterator.next()).second).O();
    this.f.a();
    this.g.a();
    this.aa = false;
  }

  private boolean Z()
  {
    if (this.ab.getAlpha() == 1.0F);
    for (int j = 1; ; j = 0)
      return j;
  }

  private void aa()
  {
    this.ac.d(1.0F);
  }

  private void ab()
  {
    this.ac.d(0.0F);
  }

  protected void P()
  {
  }

  protected void Q()
  {
    this.Z.a();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903107, paramViewGroup, false);
    a((PhotoGallery)localView.findViewById(2131296552));
    this.b = ((TaggingInterface)localView.findViewById(2131296553));
    this.c = ((LinearLayout)localView.findViewById(2131296554));
    this.d = ((LinearLayout)localView.findViewById(2131296555));
    this.e = ((TextView)localView.findViewById(2131296556));
    this.f = ((PhotoToggleButton)localView.findViewById(2131296559));
    this.g = ((PhotoButton)localView.findViewById(2131296560));
    this.h = ((PhotoButton)localView.findViewById(2131296561));
    this.i = ((TextView)localView.findViewById(2131296562));
    this.Y = ((TextView)localView.findViewById(2131296563));
    this.f.setOnCheckedChangeListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.b.a(this.Z.b(), new ConsumptionPhotoGalleryFragment.1(this));
    this.b.a(new ConsumptionPhotoGalleryFragment.TaggingInterfaceListener(this, null));
    this.ab = new ViewTransform(this.c);
    this.ac = ViewPropertyAnimator.a(this.c);
    this.ac.a(200L);
    return localView;
  }

  protected void a(int paramInt, PhotoFragment paramPhotoFragment)
  {
    ((TaggedPhotoFragment)paramPhotoFragment).a(W());
  }

  public void a(int paramInt, PhotoSource paramPhotoSource, PhotoFragmentFactory paramPhotoFragmentFactory, FragmentManager paramFragmentManager)
  {
    throw new IllegalArgumentException("Missing data adapter, use other init method");
  }

  public void a(int paramInt, PhotoSource paramPhotoSource, PhotoFragmentFactory paramPhotoFragmentFactory, FragmentManager paramFragmentManager, ConsumptionPhotoDataAdapter paramConsumptionPhotoDataAdapter)
  {
    super.a(paramInt, paramPhotoSource, paramPhotoFragmentFactory, paramFragmentManager);
    this.Z = paramConsumptionPhotoDataAdapter;
    this.Z.a(this);
  }

  public void a(long paramLong)
  {
  }

  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    ConsumptionPhoto localConsumptionPhoto = (ConsumptionPhoto)d().a(paramLong);
    if (localConsumptionPhoto != null)
    {
      localConsumptionPhoto.c(paramInt1);
      localConsumptionPhoto.d(paramInt2);
      if (paramLong == ((ConsumptionPhoto)K()).a())
        S();
    }
  }

  public void a(long paramLong, List<Tag> paramList)
  {
    ConsumptionPhoto localConsumptionPhoto = (ConsumptionPhoto)d().a(paramLong);
    if (localConsumptionPhoto != null)
    {
      localConsumptionPhoto.a(paramList);
      Iterator localIterator = O().iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (paramLong != d().a(((Integer)localPair.first).intValue()).a())
          continue;
        ((TaggedPhotoFragment)localPair.second).K();
        T();
      }
    }
  }

  public void a(PhotoToggleButton paramPhotoToggleButton, boolean paramBoolean)
  {
    this.Z.a(((ConsumptionPhoto)K()).a(), paramBoolean);
  }

  protected void b(int paramInt, PhotoFragment paramPhotoFragment)
  {
    ((TaggedPhotoFragment)L()).a(new ConsumptionPhotoGalleryFragment.2(this));
    R();
    S();
    T();
    this.Z.a(((ConsumptionPhoto)K()).a());
    this.Z.b(((ConsumptionPhoto)K()).a());
  }

  public void b(long paramLong)
  {
  }

  public void c(long paramLong)
  {
  }

  public void d(long paramLong)
  {
  }

  public void e(long paramLong)
  {
  }

  public void f(long paramLong)
  {
  }

  public void onClick(View paramView)
  {
    if (paramView == this.g)
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(p()).create();
      localAlertDialog.setMessage("Comment Button!");
      localAlertDialog.show();
    }
    while (true)
    {
      return;
      if (paramView == this.h)
      {
        if (W())
        {
          Y();
          continue;
        }
        X();
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoGalleryFragment
 * JD-Core Version:    0.6.0
 */