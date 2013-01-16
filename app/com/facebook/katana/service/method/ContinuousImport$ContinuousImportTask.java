package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.Context;
import android.database.SQLException;
import android.os.AsyncTask;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.ObservedContactsProvider;

class ContinuousImport$ContinuousImportTask extends AsyncTask<Void, Void, Boolean>
{
  private ContinuousImport$ContinuousImportTask(ContinuousImport paramContinuousImport)
  {
  }

  protected Boolean a(Void[] paramArrayOfVoid)
  {
    try
    {
      this.a.g();
      this.a.h();
      localBoolean = Boolean.valueOf(true);
      return localBoolean;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a();
      throw localOutOfMemoryError;
    }
    catch (SQLException localSQLException)
    {
      while (true)
      {
        a();
        ErrorReporting.a("continuous import", "Continuous Import failed on SQL exception", localSQLException, true);
        Boolean localBoolean = Boolean.valueOf(false);
      }
    }
  }

  protected void a()
  {
    this.a.j();
    ContinuousImport.a(ContinuousImport.a(this.a), false);
    this.a.a(this.a, 200, null, null);
    try
    {
      ContinuousImport.a(this.a).getContentResolver().delete(ObservedContactsProvider.a, null, null);
      return;
    }
    catch (SQLException localSQLException)
    {
      while (true)
        Log.b(ContinuousImport.m(), "Counld not clear ContinuousImport DB while turning off ContinuousImport functionality");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.ContinuousImport.ContinuousImportTask
 * JD-Core Version:    0.6.0
 */