package com.facebook.katana.activity.faceweb;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.activity.media.MediaPickerActivity;
import com.facebook.katana.activity.media.MediaPickerEnvironment;
import com.facebook.katana.activity.media.MediaPickerEnvironment.Builder;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;

class FacewebFragment$ShowPublisherHandler$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    FacewebFragment.l(this.b.a).a(FB4A_AnalyticEntities.UIElements.g, FB4A_AnalyticEntities.Modules.l);
    MediaPickerEnvironment.Builder localBuilder = new MediaPickerEnvironment.Builder(FacewebFragment.h(this.b.a));
    if (!FacewebFragment.g(this.b.a));
    for (boolean bool = true; ; bool = false)
    {
      MediaPickerEnvironment localMediaPickerEnvironment = localBuilder.b(bool).a(true).a(this.a).a();
      Intent localIntent = new Intent(this.b.a.n(), MediaPickerActivity.class);
      localIntent.putExtra("extra_environment", localMediaPickerEnvironment);
      localIntent.putExtra("extra_source_activity", this.b.a.getClass().getSimpleName());
      this.b.a.a(localIntent, 50);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowPublisherHandler.2
 * JD-Core Version:    0.6.0
 */