package android_src.mms.dom.smil;

import android_src.mms.layout.LayoutManager;
import android_src.mms.layout.LayoutParameters;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.smil.SMILLayoutElement;
import org.w3c.dom.smil.SMILRootLayoutElement;

public class SmilLayoutElementImpl extends SmilElementImpl
  implements SMILLayoutElement
{
  SmilLayoutElementImpl(SmilDocumentImpl paramSmilDocumentImpl, String paramString)
  {
    super(paramSmilDocumentImpl, paramString);
  }

  public SMILRootLayoutElement b()
  {
    NodeList localNodeList = getChildNodes();
    int i = localNodeList.getLength();
    SMILRootLayoutElement localSMILRootLayoutElement = null;
    for (int j = 0; j < i; j++)
    {
      if (!localNodeList.item(j).getNodeName().equals("root-layout"))
        continue;
      localSMILRootLayoutElement = (SMILRootLayoutElement)localNodeList.item(j);
    }
    if (localSMILRootLayoutElement == null)
    {
      localSMILRootLayoutElement = (SMILRootLayoutElement)getOwnerDocument().createElement("root-layout");
      localSMILRootLayoutElement.b(LayoutManager.a().b().a());
      localSMILRootLayoutElement.a(LayoutManager.a().b().b());
      appendChild(localSMILRootLayoutElement);
    }
    return localSMILRootLayoutElement;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.smil.SmilLayoutElementImpl
 * JD-Core Version:    0.6.0
 */