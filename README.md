# whitesource


Implement a Java http server with REST API that gets as an input a pair (G,e1) while:

G: is string in dot format that represent a control flow graph. 
e1: an entry node in the graph 
  
The server outputs all the nodes that non-reachable  from  e1 in the graph.
 

For example:
$ curl -X POST http://localhost:10000/server -H "content-type:application/json" -d  '{"e1": "1",graph": " digraph graphname{\n0->1\n0->2\n2->1\n3->4}"}' 

The server should return  {3,4}

Guidelines 
	The code should be readable, maintainable, and clear. 
	The code should be valid and tested.
	The project should be packaged for shipment to be used by clients. 
	The server should log.
	Use open-source in all places that you can instead of implementing your own code. 



