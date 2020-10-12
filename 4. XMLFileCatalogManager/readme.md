# XML File Catalog Manager

## General information
XMLFileCatalogManager

### Description:
Simple application for bookshop using XML files
to display book catalog.
Is required to load correct format of XML file after run this application.
Required format:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<catalog xmlns="http://www.eti.pg.gda.pl/kask/pt/catalog">
	<book title="example1" pages="0"/>
	<book title="example2" pages="0"/>
</catalog>
```
Where title attribute is a 'book' title and 'pages' attribute is a count of pages.
All saved modifications are saved to loaded file.

### Features
- Catalog browsing
- Delete record from catalog
- Add record to catalog

### Technologies
- Java 8
- JavaFX
- XML

## Setup
Requirements:
- Ant 1.8.0 or higher
- Java 8 or higher
To build this project locally open project directory and run:
```
ant compile 
ant jar
```
To run program from Command Prompt run follow: 
```
java -jar dist\XMLFileCatalogManager.jar
```