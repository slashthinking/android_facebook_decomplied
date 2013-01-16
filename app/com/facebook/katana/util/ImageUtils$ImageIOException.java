package com.facebook.katana.util;

import java.io.IOException;

public class ImageUtils$ImageIOException extends ImageUtils.ImageException
{
  private static final long serialVersionUID = -2436325656553613203L;

  public ImageUtils$ImageIOException(String paramString, IOException paramIOException)
  {
    super("I/O error while loading: " + paramString, paramIOException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.ImageUtils.ImageIOException
 * JD-Core Version:    0.6.0
 */