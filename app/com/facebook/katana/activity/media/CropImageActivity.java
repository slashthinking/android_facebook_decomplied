package com.facebook.katana.activity.media;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.facebook.common.util.Log;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.util.ImageUtils;
import com.facebook.katana.util.ImageUtils.ImageException;

public class CropImageActivity extends BaseFacebookActivity
{
  private CropImageLayout n;
  private String o;

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903126);
    this.n = ((CropImageLayout)findViewById(2131296624));
    findViewById(2131296623).setOnClickListener(new CropImageActivity.1(this));
    Bundle localBundle = getIntent().getExtras();
    String str;
    if (localBundle != null)
    {
      str = localBundle.getString("input_image_path_extra");
      if (str == null);
    }
    try
    {
      this.n.setImageBitmap(ImageUtils.a(str, null));
      this.o = str.substring(1 + str.lastIndexOf('/'));
      deleteFile(this.o);
      Toast.makeText(this, 2131363408, 1).show();
      return;
    }
    catch (ImageUtils.ImageException localImageException)
    {
      while (true)
        Log.a(x(), "cannot decode file=" + str, localImageException);
    }
  }

  public void finishCropping(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("image_crop_rect_extra", this.n.getCropArea());
    setResult(-1, localIntent);
    finish();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.CropImageActivity
 * JD-Core Version:    0.6.0
 */