package com.facebook.katana.view.composer;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.composer.LegacyAlbumPrivacyValues;
import com.facebook.katana.features.composer.AudienceAdapter;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.UrlImage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComposerAudienceSelectorButton extends CustomViewGroup
{
  private ImageView a;
  private ImageView b;
  private ProgressBar c;
  private UrlImage d;
  private FacebookAlbum e;
  private FacebookProfile f;
  private ComposerAudienceSelectorButton.AudienceType g;

  public ComposerAudienceSelectorButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public ComposerAudienceSelectorButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ComposerAudienceSelectorButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903102);
    this.a = ((ImageView)findViewById(2131296509));
    this.b = ((ImageView)findViewById(2131296506));
    this.c = ((ProgressBar)findViewById(2131296507));
    this.d = ((UrlImage)findViewById(2131296508));
  }

  private String a(String paramString)
  {
    Matcher localMatcher = Pattern.compile("/images/icons/group-types/large/(.*?).png").matcher(paramString);
    String str2;
    if (localMatcher.find())
      str2 = localMatcher.group(1);
    for (String str1 = "group_types_" + str2.replace('-', '_'); ; str1 = "")
      return str1;
  }

  private void a()
  {
    if (!b())
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    ImageView localImageView = this.a;
    boolean bool = c();
    int i = 0;
    if (bool);
    while (true)
    {
      localImageView.setVisibility(i);
      break;
      i = 8;
    }
  }

  private boolean b()
  {
    if (this.g != ComposerAudienceSelectorButton.AudienceType.HIDDEN);
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean c()
  {
    if (this.g == ComposerAudienceSelectorButton.AudienceType.SELECTABLE);
    for (int i = 1; ; i = 0)
      return i;
  }

  private void d()
  {
    if (this.f == null)
    {
      this.c.setVisibility(0);
      this.b.setVisibility(8);
    }
    while (true)
    {
      return;
      if (this.f.mType == 3)
      {
        this.c.setVisibility(8);
        String str1 = a(this.f.mImageUrl);
        String str2 = getContext().getPackageName();
        int i = getResources().getIdentifier(str1, "drawable", str2);
        if (i != 0)
        {
          this.b.setVisibility(0);
          this.b.setImageResource(i);
          continue;
        }
        this.d.setVisibility(0);
        this.d.setImageParams(Uri.parse(this.f.mImageUrl));
        continue;
      }
      setVisibility(8);
    }
  }

  private void e()
  {
    if (this.e == null);
    while (true)
    {
      return;
      LegacyAlbumPrivacyValues localLegacyAlbumPrivacyValues = LegacyAlbumPrivacyValues.fromAlbum(this.e);
      this.b.setImageResource(localLegacyAlbumPrivacyValues.getIconResource());
    }
  }

  private void f()
  {
    LegacyAlbumPrivacyValues localLegacyAlbumPrivacyValues = LegacyAlbumPrivacyValues.fromAlbum(this.e);
    String str = getContext().getString(localLegacyAlbumPrivacyValues.getNameResource());
    new AlertDialog.Builder(getContext()).setTitle(2131362882).setMessage(getContext().getString(2131362883, new Object[] { str })).setNeutralButton(2131361888, new ComposerAudienceSelectorButton.2(this)).create().show();
  }

  public FacebookAlbum getAlbum()
  {
    return this.e;
  }

  public ComposerAudienceSelectorButton.AudienceType getAudienceType()
  {
    return this.g;
  }

  public FacebookProfile getGroup()
  {
    return this.f;
  }

  public void setAudienceType(ComposerAudienceSelectorButton.AudienceType paramAudienceType, AudienceAdapter paramAudienceAdapter)
  {
    this.g = paramAudienceType;
    a();
    switch (ComposerAudienceSelectorButton.3.a[this.g.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      this.b.setImageResource(2130838166);
      continue;
      d();
      continue;
      int i = paramAudienceAdapter.h();
      if (i != -1)
      {
        this.b.setImageResource(i);
        this.c.setVisibility(8);
        this.b.setVisibility(0);
        continue;
      }
      this.c.setVisibility(0);
      this.b.setVisibility(8);
      this.a.setVisibility(8);
      continue;
      this.b.setImageResource(2130837541);
    }
  }

  public void setGroup(FacebookProfile paramFacebookProfile)
  {
    if (this.g == ComposerAudienceSelectorButton.AudienceType.GROUP)
    {
      this.f = paramFacebookProfile;
      d();
    }
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    ComposerAudienceSelectorButton.1 local1 = null;
    if (paramOnClickListener != null)
      local1 = new ComposerAudienceSelectorButton.1(this, paramOnClickListener);
    super.setOnClickListener(local1);
    this.b.setOnClickListener(local1);
  }

  public void setPhotoAlbum(FacebookAlbum paramFacebookAlbum)
  {
    if (this.g == ComposerAudienceSelectorButton.AudienceType.PHOTO_ALBUM)
    {
      this.e = paramFacebookAlbum;
      e();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.composer.ComposerAudienceSelectorButton
 * JD-Core Version:    0.6.0
 */