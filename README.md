# Jolie_Hash_Calculator

FileIntegrity is a Java Service to calculate the hash of a file using the SHA-384 function.</br>
The java service can be used through the interface ```HashFileInterface``` contained in ```./Jolie/interface.iol```.</br>
HashFileInterface takes in input a Jile (the type is specified in ```./Jolie/type.iol```).</br>
A Jile has a: .fileName, .content, .path and a .hash.

*Note that the only used fields are .path and .hash*

When you use the service .path is used to open a stream on the file, then it is read and a Jile with your .path and the hash of the file (saved in .hash) is returned.
An example of the use is included in ```./Jolie/hash_example.ol```.

## Prerequisites

- Java(TM) SE Runtime Environment (build 1.8.0_211-b12)
- Jolie 1.7.1  (C) 2006-2019 the Jolie team

## Jolie_Hash_Calculator - Authors

The JavaTheHutt team is composed by students of bachelor degree in Computer Science for Management, these are our repositories:

- **Lorenzo Formato** : [@lorenzo-formato] (https://gitlab.com/lorenzo-formato)

## License

This project is licensed under the GNU v.3 License - see the [LICENSE](LICENSE)
file for details
