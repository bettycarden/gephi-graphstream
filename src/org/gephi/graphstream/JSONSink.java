/**
 * 
 */
package org.gephi.graphstream;

import java.io.*;
import java.net.*;

import org.gephi.graphstream.JSONEventConstants.Fields;
import org.gephi.graphstream.JSONEventConstants.Types;
import org.gephi.graphstream.json.parser.*;
import org.graphstream.stream.Sink;
//import org.apache.commons.codec.binary.Base64;

/**
 * @author wumalbert
 *
 */
public class JSONSink implements Sink {

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#edgeAttributeAdded(java.lang.String, long, java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public void edgeAttributeAdded(String sourceId, long timeId, String edgeId,
			String attribute, Object value) {
		
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CE.value(), new JSONObject()
								.put(edgeId, new JSONObject()
									.put(attribute, value)
								)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#edgeAttributeChanged(java.lang.String, long, java.lang.String, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void edgeAttributeChanged(String sourceId, long timeId, String edgeId,
			String attribute, Object oldValue, Object newValue) {
		
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CE.value(), new JSONObject()
								.put(edgeId, new JSONObject()
									.put(attribute, newValue)
								)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#edgeAttributeRemoved(java.lang.String, long, java.lang.String, java.lang.String)
	 */
	@Override
	public void edgeAttributeRemoved(String sourceId, long timeId, String edgeId,
			String attribute) {
		
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CE.value(), new JSONObject()
								.put(edgeId, new JSONObject()
									.put(attribute, JSONObject.NULL)
								)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#graphAttributeAdded(java.lang.String, long, java.lang.String, java.lang.Object)
	 */
	@Override
	public void graphAttributeAdded(String sourceId, long timeId, String attribute,
			Object value) {
		
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CG.value(), new JSONObject()
								.put(attribute, value)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#graphAttributeChanged(java.lang.String, long, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void graphAttributeChanged(String sourceId, long timeId, String attribute,
			Object oldValue, Object newValue) {
		
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CG.value(), new JSONObject()
								.put(attribute, newValue)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#graphAttributeRemoved(java.lang.String, long, java.lang.String)
	 */
	@Override
	public void graphAttributeRemoved(String sourceId, long timeId, String attribute) {
		
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CG.value(), new JSONObject()
								.put(attribute, JSONObject.NULL)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#nodeAttributeAdded(java.lang.String, long, java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public void nodeAttributeAdded(String sourceId, long timeId, String nodeId,
			String attribute, Object value) {
		
		//make an JSON object
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CN.value(), new JSONObject()
								.put(nodeId, new JSONObject()
									.put(attribute, value)
								)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);
		
	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#nodeAttributeChanged(java.lang.String, long, java.lang.String, java.lang.String, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void nodeAttributeChanged(String sourceId, long timeId, String nodeId,
			String attribute, Object oldValue, Object newValue) {
		
		//make an JSON object
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CN.value(), new JSONObject()
								.put(nodeId, new JSONObject()
									.put(attribute, newValue)
								)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.AttributeSink#nodeAttributeRemoved(java.lang.String, long, java.lang.String, java.lang.String)
	 */
	@Override
	public void nodeAttributeRemoved(String sourceId, long timeId, String nodeId,
			String attribute) {
		
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.CN.value(), new JSONObject()
								.put(nodeId, new JSONObject()
									.put(attribute, JSONObject.NULL)
								)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.ElementSink#edgeAdded(java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public void edgeAdded(String sourceId, long timeId, String edgeId, String fromNodeId,
			String toNodeId, boolean directed) {
		//make an JSON object
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.AE.value(), new JSONObject()
								.put(edgeId, new JSONObject()
									.put(Fields.SOURCE.value(), fromNodeId)
									.put(Fields.TARGET.value(), toNodeId)
									.put(Fields.DIRECTED.value(), directed)
								)
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.ElementSink#edgeRemoved(java.lang.String, long, java.lang.String)
	 */
	@Override
	public void edgeRemoved(String sourceId, long timeId, String edgeId) {
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.DE.value(), new JSONObject()
								.put(edgeId, new JSONObject())
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.ElementSink#graphCleared(java.lang.String, long)
	 */
	@Override
	public void graphCleared(String sourceId, long timeId) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.ElementSink#nodeAdded(java.lang.String, long, java.lang.String)
	 */
	@Override
	public void nodeAdded(String sourceId, long timeId, String nodeId) {
		
		//make an JSON object
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.AN.value(), new JSONObject()
								.put(nodeId, new JSONObject())
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);

	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.ElementSink#nodeRemoved(java.lang.String, long, java.lang.String)
	 */
	@Override
	public void nodeRemoved(String sourceId, long timeId, String nodeId) {
		
		JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject()
							.put(Types.DN.value(), new JSONObject()
								.put(nodeId, new JSONObject())
							)
							.put(Fields.T.value(), timeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObj.toString());
		//send jsonObj to Gephi
		doSend(jsonObj);
	}

	/* (non-Javadoc)
	 * @see org.graphstream.stream.ElementSink#stepBegins(java.lang.String, long, double)
	 */
	@Override
	public void stepBegins(String sourceId, long timeId, double step) {
		// TODO Auto-generated method stub

	}

	private void doSend(JSONObject obj) {
		try {
            URL url = new URL("http://localhost:8080/workspace0?operation=updateGraph&format=JSON");

            URLConnection connection = url.openConnection();

            /*connection.setRequestProperty("Authorization", "Basic " +
                    Base64.encodeBase64(("gephi:gephi").getBytes()));*/
            
            connection.setDoOutput(true);
            connection.connect();

            OutputStream outputStream = null;
            PrintStream out = null;
            try {
                outputStream = connection.getOutputStream();
                out = new PrintStream(outputStream, true);
                
                out.print(obj.toString()+EOL);
    		    out.flush();
    		    out.close();
    		    //send event message to the server and read the result from the server
    		    InputStream inputStream = connection.getInputStream();
    		    BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
    		    String line;
    		    while ((line = bf.readLine()) != null) {
    		    	System.out.println(line);
    		    }
    		    inputStream.close();
    		    
            } catch (UnknownServiceException e) {
                // protocol doesn't support output
            	e.printStackTrace();
                return;
            }
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
	}
	
	private static String EOL = "\r\n";

}
