package com.facebook.katana.orca;

import android.app.Application;
import android.content.ContentResolver;
import android.content.res.AssetManager;
import com.facebook.common.util.FileUtil;
import com.facebook.katana.util.RingtoneUtils;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$RingtoneUtilsProvider extends AbstractProvider<RingtoneUtils>
{
  private FbandroidAppModule$RingtoneUtilsProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public RingtoneUtils a()
  {
    ContentResolver localContentResolver = FbandroidAppModule.a(this.a).getContentResolver();
    AssetManager localAssetManager = FbandroidAppModule.a(this.a).getAssets();
    FileUtil localFileUtil = (FileUtil)b(FileUtil.class);
    return new RingtoneUtils(FbandroidAppModule.a(this.a), localContentResolver, localAssetManager, localFileUtil);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.RingtoneUtilsProvider
 * JD-Core Version:    0.6.0
 */