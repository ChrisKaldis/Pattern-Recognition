# Pattern-Recognition
Classification of medical exams into recurrence-events and no-recurence using K-Means.

The medical exams from a file are transposed into patterns in order to use the algorithm
(the data are first stored into String in order to be readable and then into double).

---

## API
There are two basic methods implemented into this project so far.

- One GET method that finds all medical exams. 
- One POST method that classify a pattern based in the trainning using kMeans.

## Install
The commands to run the program into a complete new system with Ubuntu OS.

After you install the project, istall docker & run project.
`code` $ sudo apt-get install docker.io -y
`code` $ sudo mv /path/of/repository/before /opt/pattern.recognition
`code` $ sudo docker build patternrecproject /opt/pattern.recognition
`code` $ docker run -d -p 9090:8888 patternrecproject

After the code above you can test the project into the localhost.
