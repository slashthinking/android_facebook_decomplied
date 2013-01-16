package android_src.mms.dom.smil;

import org.w3c.dom.smil.ElementTime;
import org.w3c.dom.smil.SMILElement;

public abstract class ElementTimeImpl
  implements ElementTime
{
  final SMILElement a;

  ElementTimeImpl(SMILElement paramSMILElement)
  {
    this.a = paramSMILElement;
  }

  public void a(float paramFloat)
  {
    this.a.setAttribute("dur", Integer.toString((int)(1000.0F * paramFloat)) + "ms");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.ElementTimeImpl
 * JD-Core Version:    0.6.0
 */