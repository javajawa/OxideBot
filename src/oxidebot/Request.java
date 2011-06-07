package oxidebot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Benedict
 */
public class Request implements Comparable<Request> {
  protected List<String> requesters;
  protected String request;
  protected int id;

  @Override
  public String toString() {
    return request + " (id:" + id + ", " + requesters.size() + " votes)";
  }

  public Request(String request, int id, String requester)
  {
    this.requesters = new ArrayList<String>(5);
    this.requesters.add(requester);
    this.request = request;
    this.id = id;
  }

  private Request()
  {
  }

  public boolean requestedBy(String requester) {
    if (this.requesters.contains(requester)) return false;

    this.requesters.add(requester);
    return true;
  }

  public int getId()
  {
    return id;
  }

  public String getRequest()
  {
    return request;
  }

  public List<String> getRequesters()
  {
    return Collections.unmodifiableList(requesters);
  }

  public int getRequestCount()
  {
    return this.requesters.size();
  }

  public int compareTo(Request o)
  {
    return ((Integer)this.requesters.size()).compareTo(o.requesters.size());
  }
}
