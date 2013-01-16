package com.facebook.katana.service.method;

import com.facebook.ipc.connections.ConnectionsContract.ConnectionType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.util.Utils;

class ConnectionsSync$FacebookPageProfile extends FacebookProfile
{
  protected ConnectionsContract.ConnectionType connectionType;

  ConnectionsContract.ConnectionType a()
  {
    return this.connectionType;
  }

  long b()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.mId);
    arrayOfObject[1] = this.mDisplayName;
    arrayOfObject[2] = this.mImageUrl;
    arrayOfObject[3] = Integer.valueOf(this.connectionType.ordinal());
    return Utils.c(arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ConnectionsSync.FacebookPageProfile
 * JD-Core Version:    0.6.0
 */