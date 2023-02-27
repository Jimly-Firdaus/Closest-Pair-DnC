# The Closest Pair of Points in 3D using the Divide and Conquer Algorithm.
Tugas Kecil 2 IF2211 Strategi Algoritma
<br />
Mencari Pasangan Titik Terdekat 3D dengan <i>Algoritma Divide and Conquer</i>


## Table of Contents
* [General Info](#general-information)
* [How To Run](#how-to-run)
* [Tech Stack](#tech-stack)
* [Requirements](#requirements)
* [Project Structure](#project-structure)
* [Credits](#credits)

## General Information
Mencari sepasang titik terdekat pada bidang 3D. Misalkan terdapat n buah titik pada ruang 3D. Setiap titik P di dalam ruang dinyatakan dengan koordinat P = (x, y, z). Carilah sepasang titik yang mempunyai jarak terdekat satu
sama lain. Jarak dua buah titk P1 = (x1, y1, z1) dan P2 = (x2, y2, z2) dihitung dengan rumus
Euclidean


## How To Run
Download the latest release, then
### Run Using Windows Batch File
1. Locate the `run.bat` batch file (on the root of this project).
2. Double click `run.bat`.

OR

Clone this repository, then
### Run Manually with Console
on the root of this project
```shell
pip install -r requirements.txt # install python dependencies
cd src                          # move to src directory
javac -d ../bin *.java          # compile all *.java
cd ../bin                       # move to bin directory
java Main                       # run Main.class
```

## Tech Stack
### Programming Languange
* Java (openjdk 18.0.2.1)

## Requirements
* openjdk 18.0.2.1 2022-08-18
* matplotlib ^3.5.3
* numpy ^1.23.1

## Project Structure
```bash
.
│   .gitignore
│   README.md
│   run.bat
│   requirements.txt
│
├───bin
│       Tucil2_13521102.jar
├───doc
│       Tucil2_K2_13521102_Jimly Firdaus.pdf
│
└──src
    │   Main.java
    │   Points.java
    │   QuickSort.java
    │
    └───type
            ClosestPair.java
            Point.java

```

## Credits
Creator:
Jimly Firdaus (13521102)
