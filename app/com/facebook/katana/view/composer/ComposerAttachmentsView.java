package com.facebook.katana.view.composer;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.katana.activity.media.MediaPickerEnvironment;
import com.facebook.katana.model.MediaItem;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.Lists;
import java.util.List;

public class ComposerAttachmentsView extends CustomFrameLayout
  implements View.OnClickListener
{
  private FbInjector a = FbInjector.a(getContext());
  private LinearLayout b;
  private ComposerAttachmentsView.ItemClickedListener c;
  private List<MediaItem> d;
  private MediaPickerEnvironment e;
  private int f;
  private int g;

  public ComposerAttachmentsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903103);
    this.b = ((LinearLayout)b(2131296510));
    this.d = Lists.a();
    Resources localResources = paramContext.getResources();
    this.f = localResources.getDimensionPixelSize(2131230902);
    this.g = localResources.getDimensionPixelSize(2131230903);
  }

  private boolean a()
  {
    if ((this.e != null) && (!this.e.a()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void onClick(View paramView)
  {
    MediaItem localMediaItem;
    if (this.c != null)
    {
      localMediaItem = (MediaItem)paramView.getTag();
      if (localMediaItem != null)
        break label29;
      this.c.B();
    }
    while (true)
    {
      return;
      label29: this.c.a(localMediaItem);
    }
  }

  public void setAttachments(List<MediaItem> paramList)
  {
    this.d = paramList;
    this.b.removeAllViews();
    new ComposerAttachmentsView.AttachmentLoader(this, null).execute(new Void[0]);
  }

  public void setItemClickedListener(ComposerAttachmentsView.ItemClickedListener paramItemClickedListener)
  {
    this.c = paramItemClickedListener;
  }

  public void setPickerEnvironment(MediaPickerEnvironment paramMediaPickerEnvironment)
  {
    this.e = paramMediaPickerEnvironment;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.composer.ComposerAttachmentsView
 * JD-Core Version:    0.6.0
 */