package com.facebook.orca.merge;

import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.threads.FolderName;

class MergeServiceHandler$3
  implements MergeServiceHandler.CallableWithFolder
{
  public OperationResult a(FolderName paramFolderName)
  {
    return MergeServiceHandler.c(this.c, this.a, paramFolderName, this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.merge.MergeServiceHandler.3
 * JD-Core Version:    0.6.0
 */