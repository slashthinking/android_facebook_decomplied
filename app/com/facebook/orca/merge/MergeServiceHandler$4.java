package com.facebook.orca.merge;

import android.os.Bundle;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.threads.FolderName;

class MergeServiceHandler$4
  implements MergeServiceHandler.CallableWithFolder
{
  public OperationResult a(FolderName paramFolderName)
  {
    Bundle localBundle = (Bundle)this.a.clone();
    localBundle.putParcelable("folderName", paramFolderName);
    OperationParams localOperationParams = new OperationParams(this.b, localBundle);
    return this.c.a(localOperationParams);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergeServiceHandler.4
 * JD-Core Version:    0.6.0
 */