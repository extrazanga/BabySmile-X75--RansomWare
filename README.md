_**To run the program, first compile the source code using javac. Ensure that you have Java JDK installed on your system.**_:

``Type > java RansomwarePayload.java``

_**To Encrypt Files:
Run the program with the following command, specifying the path of the folder containing the files to be encrypted:
**_:

``java RansomwarePayload encrypt <directoryPath>``

_**To Decrypt Files:
Run the program with the following command, specifying the path of the folder and the key used during encryption:**_ 

``java RansomwarePayload decrypt <directoryPath> <key>``

_**For example, if you have a folder on your desktop called TestFiles, you can encrypt the files inside it using the following command:**_

``java RansomwarePayload encrypt /Users/username/Desktop/TestFiles``
