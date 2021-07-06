We create wuzzuf jobs to run on computer without any server.
Then we create JobServices Project to run web services.
We used Java 8 and Tomcat 8.5 to Create this Project. 

Links:

http://localhost:4040/JobService/jobs           -> return List of Jobs in Json Type.
http://localhost:4040/JobService/titles         -> return a map of titles and its count in Json Type.
http://localhost:4040/JobService/areas          -> return a map of locations and its count in Json Type.
http://localhost:4040/JobService/companies      -> return a map of companieses and its count in Json Type.
http://localhost:4040/JobService/skills         -> return a map of skills and its count in Json Type.
http://localhost:4040/JobService/titlesgraph    -> return a bar graph of Top Six counted titles.
http://localhost:4040/JobService/areasgraph     -> return a bar graph of Top Six counted locations.
http://localhost:4040/JobService/companiesgraph -> return a pie graph of Top Six counted companies and other Companies.
