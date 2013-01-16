package android_src.mms.dom.smil;

import android_src.mms.dom.DocumentImpl;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.smil.ElementSequentialTimeContainer;
import org.w3c.dom.smil.SMILDocument;
import org.w3c.dom.smil.SMILElement;
import org.w3c.dom.smil.SMILLayoutElement;

public class SmilDocumentImpl extends DocumentImpl
  implements SMILDocument
{
  ElementSequentialTimeContainer b;

  public SMILElement a()
  {
    Object localObject = getFirstChild();
    if ((localObject == null) || (!(localObject instanceof SMILElement)))
    {
      localObject = createElement("smil");
      appendChild((Node)localObject);
    }
    return (SMILElement)(SMILElement)localObject;
  }

  public void a(float paramFloat)
  {
    this.b.a(paramFloat);
  }

  public SMILElement b()
  {
    SMILElement localSMILElement = a();
    Object localObject = localSMILElement.getFirstChild();
    if ((localObject == null) || (!(localObject instanceof SMILElement)))
    {
      localObject = createElement("head");
      localSMILElement.appendChild((Node)localObject);
    }
    return (SMILElement)(SMILElement)localObject;
  }

  public SMILElement c()
  {
    SMILElement localSMILElement = a();
    Object localObject = b().getNextSibling();
    if ((localObject == null) || (!(localObject instanceof SMILElement)))
    {
      localObject = createElement("body");
      localSMILElement.appendChild((Node)localObject);
    }
    this.b = new SmilDocumentImpl.1(this, (SMILElement)localObject);
    return (SMILElement)(SMILElement)localObject;
  }

  public Element createElement(String paramString)
  {
    String str = paramString.toLowerCase();
    Object localObject;
    if ((str.equals("text")) || (str.equals("img")) || (str.equals("video")))
      localObject = new SmilRegionMediaElementImpl(this, str);
    while (true)
    {
      return localObject;
      if (str.equals("audio"))
      {
        localObject = new SmilMediaElementImpl(this, str);
        continue;
      }
      if (str.equals("layout"))
      {
        localObject = new SmilLayoutElementImpl(this, str);
        continue;
      }
      if (str.equals("root-layout"))
      {
        localObject = new SmilRootLayoutElementImpl(this, str);
        continue;
      }
      if (str.equals("region"))
      {
        localObject = new SmilRegionElementImpl(this, str);
        continue;
      }
      if (str.equals("ref"))
      {
        localObject = new SmilRefElementImpl(this, str);
        continue;
      }
      if (str.equals("par"))
      {
        localObject = new SmilParElementImpl(this, str);
        continue;
      }
      localObject = new SmilElementImpl(this, str);
    }
  }

  public SMILLayoutElement d()
  {
    SMILElement localSMILElement = b();
    for (Object localObject = localSMILElement.getFirstChild(); (localObject != null) && (!(localObject instanceof SMILLayoutElement)); localObject = ((Node)localObject).getNextSibling());
    if (localObject == null)
    {
      localObject = new SmilLayoutElementImpl(this, "layout");
      localSMILElement.appendChild((Node)localObject);
    }
    return (SMILLayoutElement)(SMILLayoutElement)localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.SmilDocumentImpl
 * JD-Core Version:    0.6.0
 */