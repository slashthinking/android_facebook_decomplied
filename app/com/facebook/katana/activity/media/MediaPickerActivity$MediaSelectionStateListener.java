package com.facebook.katana.activity.media;

import com.facebook.widget.CountBadge;

class MediaPickerActivity$MediaSelectionStateListener
  implements SelectionState.SelectionListener
{
  private MediaPickerActivity$MediaSelectionStateListener(MediaPickerActivity paramMediaPickerActivity)
  {
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    if (!MediaPickerActivity.r(this.a))
    {
      if (!paramBoolean)
        break label32;
      MediaPickerActivity.s(this.a).a();
    }
    while (true)
    {
      MediaPickerActivity.u(this.a);
      return;
      label32: MediaPickerActivity.s(this.a).b();
      if ((MediaPickerActivity.t(this.a).b() != 0) || (MediaPickerActivity.m(this.a) != MediaPickerActivity.SelectedMode.SELECTED))
        continue;
      this.a.j();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.MediaPickerActivity.MediaSelectionStateListener
 * JD-Core Version:    0.6.0
 */