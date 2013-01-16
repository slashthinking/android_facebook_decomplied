package android_src.mms.dom.smil;

import org.w3c.dom.smil.SMILDocument;
import org.w3c.dom.smil.SMILLayoutElement;
import org.w3c.dom.smil.SMILRegionElement;
import org.w3c.dom.smil.SMILRootLayoutElement;

public class SmilRegionElementImpl extends SmilElementImpl
  implements SMILRegionElement
{
  SmilRegionElementImpl(SmilDocumentImpl paramSmilDocumentImpl, String paramString)
  {
    super(paramSmilDocumentImpl, paramString);
  }

  private int a(String paramString, boolean paramBoolean)
  {
    int i;
    if (paramString.endsWith("px"))
      i = Integer.parseInt(paramString.substring(0, paramString.indexOf("px")));
    while (true)
    {
      return i;
      if (paramString.endsWith("%"))
      {
        double d1 = 0.01D * Integer.parseInt(paramString.substring(0, -1 + paramString.length()));
        double d2;
        if (paramBoolean)
          d2 = d1 * ((SMILDocument)getOwnerDocument()).d().b().e();
        while (true)
        {
          i = (int)Math.round(d2);
          break;
          d2 = d1 * ((SMILDocument)getOwnerDocument()).d().b().d();
        }
      }
      i = Integer.parseInt(paramString);
    }
  }

  public String a()
  {
    return getAttribute("id");
  }

  public void a(int paramInt)
  {
    setAttribute("height", String.valueOf(paramInt) + "px");
  }

  public int b()
  {
    try
    {
      int n = a(getAttribute("left"), true);
      i = n;
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      while (true)
        try
        {
          int j = ((SMILDocument)getOwnerDocument()).d().b().e();
          int k = a(getAttribute("right"), true);
          int m = a(getAttribute("width"), true);
          i = j - k - m;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          int i = 0;
        }
    }
  }

  public void b(int paramInt)
  {
    setAttribute("width", String.valueOf(paramInt) + "px");
  }

  public int c()
  {
    try
    {
      int n = a(getAttribute("top"), false);
      i = n;
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      while (true)
        try
        {
          int j = ((SMILDocument)getOwnerDocument()).d().b().d();
          int k = a(getAttribute("bottom"), false);
          int m = a(getAttribute("height"), false);
          i = j - k - m;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          int i = 0;
        }
    }
  }

  public int d()
  {
    while (true)
    {
      int i;
      try
      {
        i = a(getAttribute("height"), false);
        if (i != 0)
          continue;
        int m = ((SMILDocument)getOwnerDocument()).d().b().d();
        i = m;
        return i;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        i = ((SMILDocument)getOwnerDocument()).d().b().d();
      }
      try
      {
        int k = a(getAttribute("top"), false);
        i -= k;
        try
        {
          label87: int j = a(getAttribute("bottom"), false);
          i -= j;
        }
        catch (NumberFormatException localNumberFormatException3)
        {
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        break label87;
      }
    }
  }

  public int e()
  {
    while (true)
    {
      int i;
      try
      {
        i = a(getAttribute("width"), true);
        if (i != 0)
          continue;
        int m = ((SMILDocument)getOwnerDocument()).d().b().e();
        i = m;
        return i;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        i = ((SMILDocument)getOwnerDocument()).d().b().e();
      }
      try
      {
        int k = a(getAttribute("left"), true);
        i -= k;
        try
        {
          label87: int j = a(getAttribute("right"), true);
          i -= j;
        }
        catch (NumberFormatException localNumberFormatException3)
        {
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        break label87;
      }
    }
  }

  public String toString()
  {
    return super.toString() + ": id=" + a() + ", width=" + e() + ", height=" + d() + ", left=" + b() + ", top=" + c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.SmilRegionElementImpl
 * JD-Core Version:    0.6.0
 */