package org.acra;

import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.Field;

public class Compatibility
{
  static int getAPILevel()
  {
    try
    {
      int j = Build.VERSION.class.getField("SDK_INT").getInt(null);
      i = j;
      return i;
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        i = Integer.parseInt(Build.VERSION.SDK);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      while (true)
        i = Integer.parseInt(Build.VERSION.SDK);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        i = Integer.parseInt(Build.VERSION.SDK);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        int i = Integer.parseInt(Build.VERSION.SDK);
    }
  }

  static String getDropBoxServiceName()
  {
    Field localField = Context.class.getField("DROPBOX_SERVICE");
    String str = null;
    if (localField != null)
      str = (String)localField.get(null);
    return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.Compatibility
 * JD-Core Version:    0.6.0
 */