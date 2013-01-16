package com.facebook.katana.service.method;

import com.facebook.ipc.connections.ConnectionsContract.ConnectionType;

class ConnectionsSync$FacebookAdminPageProfile extends ConnectionsSync.FacebookPageProfile
{
  ConnectionsSync$FacebookAdminPageProfile()
  {
    super(null);
    this.connectionType = ConnectionsContract.ConnectionType.PAGE_ADMIN;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ConnectionsSync.FacebookAdminPageProfile
 * JD-Core Version:    0.6.0
 */