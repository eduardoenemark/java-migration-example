### Java Migration Example: 8 to 21.

This example project of a web application that using java 8, but have desire migration to java 21.  To migration of web application are make using the [IBM Migration Toolkit for Application Binaries](https://www.ibm.com/docs/en/wamt?topic=migration-toolkit-application-binaries).

IBM Migration Toolkit make scanning into all dependencies of war file and at the end presents a report. You can get report of the example project by running: 

```cli 
. ./ibm-analyze.sh
```

At the final processing of IBM Toolkit analysis results in HTML file that is name is same that analysed artifact with the suffix: *_AnalysisReport*. Therefore after running above script we have *java-migration-example.war_AnalysisReport.html* file. You can apply --output option to modify location and filename or even results to json format.

You have mind this project is an example and you can locally make another tests using *ibm/wamt/binaryAppScanner.jar*.


I'm reviewing and building another test examples. I'm appreciation by your suggestion. 
X/Telegram: @eduardoenemark.

