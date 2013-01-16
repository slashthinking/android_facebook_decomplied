package android_src.mms.dom.smil;

import org.w3c.dom.smil.SMILRootLayoutElement;

public class SmilRootLayoutElementImpl extends SmilElementImpl
  implements SMILRootLayoutElement
{
  SmilRootLayoutElementImpl(SmilDocumentImpl paramSmilDocumentImpl, String paramString)
  {
    super(paramSmilDocumentImpl, paramString);
  }

  private int a(String paramString)
  {
    if (paramString.endsWith("px"))
      paramString = paramString.substring(0, paramString.indexOf("px"));
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        int i = 0;
    }
  }

  public void a(int paramInt)
  {
    setAttribute("height", String.valueOf(paramInt) + "px");
  }

  public void b(int paramInt)
  {
    setAttribute("width", String.valueOf(paramInt) + "px");
  }

  public int d()
  {
    return a(getAttribute("height"));
  }

  public int e()
  {
    return a(getAttribute("width"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.SmilRootLayoutElementImpl
 * JD-Core Version:    0.6.0
 */