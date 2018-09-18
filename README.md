# Denis map-test 2018
Test map application developed with Spring Boot.

A small application that updates the UK map based on 2 independent continuous streams of events: 
1) around 2000 risk areas (Heat map) updated every second 
2) 100 moving vehicles updated every 2 seconds.

*server command line:
=====================
./readfile.sh <heatmapfile> | java -jar build/libs/heatmap-1.0.0.jar <lab> <vehicles> <rate> 
*Lab = Type of simulation. Valid Values: 1, 2, both. Default: both
*Vehicles = Number of vehicles to track. Defaul: 10
*Rate = Vehicles real refresh interval in seconds. Default: 60
*example: ./readfile.sh test1.csv | java -jar build/libs/heatmap-1.0.0.jar both 10 2

*client URL:
============
localhost:8080




