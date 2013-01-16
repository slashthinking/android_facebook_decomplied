package com.facebook.katana.view.vault;

import android.view.View;
import android.widget.ImageView;
import com.facebook.katana.activity.media.MediaPickerEnvironment;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.widget.PhotoToggleButton;

public class MediaGridItemController extends GridItemController
{
  private PhotoToggleButton a;
  private MediaPickerEnvironment b = MediaPickerEnvironment.a;
  private ImageView c;

  public MediaGridItemController(View paramView)
  {
    super(paramView);
    this.a = ((PhotoToggleButton)paramView.findViewById(2131297065));
    this.a.setOnCheckedChangeListener(this);
    this.a.setVisibility(8);
    this.c = ((ImageView)paramView.findViewById(2131297066));
    this.c.setEnabled(false);
    this.c.setVisibility(8);
    this.c.setClickable(false);
  }

  protected void a()
  {
    d().setVisibility(4);
  }

  public void a(MediaPickerEnvironment paramMediaPickerEnvironment)
  {
    this.b = paramMediaPickerEnvironment;
  }

  public void a(MediaItem paramMediaItem)
  {
    super.a(paramMediaItem);
    if (this.a.isChecked())
      a(false);
    if (paramMediaItem.e() == MediaItem.MediaType.PHOTO)
      if (this.b.a())
      {
        this.a.setVisibility(8);
        this.c.setVisibility(8);
      }
    while (true)
    {
      return;
      this.a.setVisibility(0);
      break;
      this.a.setVisibility(8);
      this.c.setVisibility(0);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.a.setOnCheckedChangeListener(null);
    this.a.setChecked(paramBoolean);
    this.a.setOnCheckedChangeListener(this);
  }

  protected void b()
  {
    d().setVisibility(0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.vault.MediaGridItemController
 * JD-Core Version:    0.6.0
 */