# Assignment
The purpose of this application is to demonstrated java.util.HashMap vulnerabilities when using in multithread environment.

Source code can be found in [Main](src/Main.java)

## Requirements
* `Jdk 1.8` or later.

## How to run
* Go to src dir.
* `javac Main.java`
* `java Main`

Alternatively open the project in favorite IDE e.g Intellij and run. 

## What application does

The application creates java.util.HashMap and put there 1500 `Integer` values using `parallel` method. The code is supposed to execute it on multiple threads.
At the end of program there is map size checked. The expected value is 1500, while actual depends on threads interleaving.

## Vulnerabilities

* `Colision` one thread calls `put` new key value pair into the map. New node is created and supposed to be inserted to a bucket `HashMap.Node<K, V>[] table;`. However in the same time another thread `put` key value and can override node created by different thread.
* `Resizing` when more than one thread realize that map has to be resized due to threshold. It can happen that `resize` method is executed a few times.

Another common issue that is likely to happen when multiple thread reads and writes to hash map is to not get the most recent result from the map. 