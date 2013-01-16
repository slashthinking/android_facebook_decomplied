package android_src.mms.dom;

import java.util.Vector;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class NamedNodeMapImpl
  implements NamedNodeMap
{
  private Vector<Node> a = new Vector();

  public int getLength()
  {
    return this.a.size();
  }

  public Node getNamedItem(String paramString)
  {
    int i = 0;
    if (i < this.a.size())
      if (!paramString.equals(((Node)this.a.elementAt(i)).getNodeName()));
    for (Node localNode = (Node)this.a.elementAt(i); ; localNode = null)
    {
      return localNode;
      i++;
      break;
    }
  }

  public Node getNamedItemNS(String paramString1, String paramString2)
  {
    return null;
  }

  public Node item(int paramInt)
  {
    if (paramInt < this.a.size());
    for (Node localNode = (Node)this.a.elementAt(paramInt); ; localNode = null)
      return localNode;
  }

  public Node removeNamedItem(String paramString)
  {
    Node localNode = getNamedItem(paramString);
    if (localNode == null)
      throw new DOMException(8, "Not found");
    this.a.remove(localNode);
    return localNode;
  }

  public Node removeNamedItemNS(String paramString1, String paramString2)
  {
    return null;
  }

  public Node setNamedItem(Node paramNode)
  {
    Node localNode = getNamedItem(paramNode.getNodeName());
    if (localNode != null)
      this.a.remove(localNode);
    this.a.add(paramNode);
    return localNode;
  }

  public Node setNamedItemNS(Node paramNode)
  {
    return null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.mms.dom.NamedNodeMapImpl
 * JD-Core Version:    0.6.0
 */