package android_src.mms.dom.smil;

import org.w3c.dom.smil.ElementTime;
import org.w3c.dom.smil.SMILMediaElement;

public class SmilMediaElementImpl extends SmilElementImpl
  implements SMILMediaElement
{
  ElementTime b = new SmilMediaElementImpl.1(this, this);

  SmilMediaElementImpl(SmilDocumentImpl paramSmilDocumentImpl, String paramString)
  {
    super(paramSmilDocumentImpl, paramString);
  }

  public void a(float paramFloat)
  {
    this.b.a(paramFloat);
  }

  public void a(String paramString)
  {
    setAttribute("src", paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.SmilMediaElementImpl
 * JD-Core Version:    0.6.0
 */