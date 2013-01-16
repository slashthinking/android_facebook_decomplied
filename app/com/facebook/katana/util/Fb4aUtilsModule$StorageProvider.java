package com.facebook.katana.util;

import com.facebook.camera.utils.Storage;
import com.facebook.common.util.FileUtil;
import com.facebook.orca.inject.AbstractProvider;

class Fb4aUtilsModule$StorageProvider extends AbstractProvider<Storage>
{
  private Fb4aUtilsModule$StorageProvider(Fb4aUtilsModule paramFb4aUtilsModule)
  {
  }

  public Storage a()
  {
    return new Storage((FileUtil)b(FileUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.Fb4aUtilsModule.StorageProvider
 * JD-Core Version:    0.6.0
 */