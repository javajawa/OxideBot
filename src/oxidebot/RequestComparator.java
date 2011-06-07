package oxidebot;

/**
 *
 * @author Benedict
 */
public class RequestComparator implements java.util.Comparator<Request>
{

  public int compare(Request o1, Request o2)
  {
    if (o1.getRequestCount() > o2.getRequestCount()) return -1;
    if (o1.getRequestCount() < o2.getRequestCount()) return 1;
    return 0;
  }

  public RequestComparator()
  {
  }

}