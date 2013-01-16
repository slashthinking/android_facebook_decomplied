package com.facebook.orca.photos.picking;

import android.content.Context;
import com.google.common.io.OutputSupplier;
import java.io.OutputStream;

class PickMediaOperation$2
  implements OutputSupplier<OutputStream>
{
  public OutputStream a()
  {
    return this.b.p().openFileOutput(this.a, 3);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.picking.PickMediaOperation.2
 * JD-Core Version:    0.6.0
 */