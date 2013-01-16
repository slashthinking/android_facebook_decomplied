package android_src.mms.dom.smil;

import org.w3c.dom.smil.ElementParallelTimeContainer;
import org.w3c.dom.smil.SMILParElement;

public class SmilParElementImpl extends SmilElementImpl
  implements SMILParElement
{
  ElementParallelTimeContainer b = new SmilParElementImpl.1(this, this);

  SmilParElementImpl(SmilDocumentImpl paramSmilDocumentImpl, String paramString)
  {
    super(paramSmilDocumentImpl, paramString.toUpperCase());
  }

  public void a(float paramFloat)
  {
    this.b.a(paramFloat);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.SmilParElementImpl
 * JD-Core Version:    0.6.0
 */