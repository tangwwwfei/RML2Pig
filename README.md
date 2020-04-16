# RML2Pig
This project contains three projects: [LoadTurtle](https://github.com/tangwwwfei/RML2Pig/tree/master/LoadTurtle) (maven proejct), [org.xtext.r2ps.rml](https://github.com/tangwwwfei/RML2Pig/tree/master/org.xtext.r2ps.rml) (Xtext proejct) and [RML2Pig](https://github.com/tangwwwfei/RML2Pig/tree/master/RML2Pig) (eclipse ATL).

## Overview
This project is a transformation from the RML document to the Pig code.
There are two steps to translate RML to Pig:
1. Run Xtext project [org.xtext.r2ps.rml](https://github.com/tangwwwfei/RML2Pig/tree/master/org.xtext.r2ps.rml) to get RML models. (file extensions .xmi)
2. Run eclipse ATL project [RML2Pig](https://github.com/tangwwwfei/RML2Pig/tree/master/RML2Pig) to get Pig code. (file extensions .pig)

Maven project [LoadTurtle](https://github.com/tangwwwfei/RML2Pig/tree/master/LoadTurtle) contains the [UDFs](https://github.com/tangwwwfei/RML2Pig/tree/master/LoadTurtle/src/main/java/r2ps/) of Pig and [Pig tests](https://github.com/tangwwwfei/RML2Pig/blob/master/LoadTurtle/src/test/java/PigStdTest.java) (which could run pig script without installing Hadoop).

## How to compile

The tools need to install: Eclipse with [modeling tools](https://www.eclipse.org/downloads/packages/release/2019-12/r/eclipse-modeling-tools), [ATL](https://www.eclipse.org/atl/downloads/) and [Xtext](https://download.eclipse.org/modeling/tmf/xtext/updates/composite/milestones/).

1. Run this [xtext](https://github.com/tangwwwfei/RML2Pig/blob/master/org.xtext.r2ps.rml.tests/src/org/xtext/r2ps/rml/tests/RMLParsingTest.xtend) to generate pig models in the given directory.
2. Use Ant (can't without eclipse workbench) to build [RML2Pig.xml](https://github.com/tangwwwfei/RML2Pig/blob/master/RML2Pig/RML2Pig.xml), here we should set the property 'inputPath' to the directory where the pig models are located. Then we got Pig code.
3. To run the Pig code, we have two choices. The first is run with [Pig tests](https://github.com/tangwwwfei/RML2Pig/blob/master/LoadTurtle/src/test/java/PigStdTest.java). The second is run with the Hadoop environment.

