===========JSP============
Understand the syntax of JSPs
Including other pages dynamically
Including other resources
Using Script on the page
==========MVC============
Well know pattern for UI applications
Originally from Smalltalk
Web MVC is not quite the same
Servlet as Controller
JSP used as the View
Bean used as model(POJO)
=========Jakarta Expression Language=========
JSP relied on Java as the scripting language
Make it difficult to produce dynamic pages.
JSP 2.0 introduced an EL
EL is very 'page-author' friendly
Allows page authors a limited form of page scripting

EL Base on
Nested properties
Access to collection classes
Operators (Relational; logical; arithmetic)
Extensibility function (mapped to static Java methods)
A set of implicit object
Syntax
    Always use ${expr} construct
EL can be used on page
    This will simply output the value of the expression
EL can be used in attributes
Not a "full" language
========The Jakarta Standard Tag========
Why Tag ?
Provide encapsulation of UI Logic that what we mean is logic that you want to execute on a page, so not business login.
Replace script on a page, makes the page cleaner, and it makes the pages much easier to understand.
Better for page designers than having to write java code.

What is tag library ?
Tag libraries are collections of tags.
The Jakarta Standard Tag Library (JSTL) is a set of tags used in Jakarta Server Pages.
Tags are Managed as Libraries:
    Individual tags are Java classes,and these Java classes have a lifetime. They have methods, and you can write your own tag libraries if you want to.
    Tag metadata held in Tag Library Descriptor file. There's also metadata associated with these class,
    and that metadata is held in something called a Tag Library descriptor file, or a TLD file.
    And they are all the collected together in one or more Jar file.
To use a tag library, we include jar file, along with our project. That JAR file is loaded and read by container.
And part of the information in that JAR file will be the URI, which is if you like, is the formal name of that tag library.
To use that tag library in our code, we have to reference the library, and we reference it by using this taglib directive on page.
We pass a URI, and that URI maps onto the URI defined by the library.
The container looks at that URI and then scans through all the JAR files it load on the class path,
looks for any TLDs.
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:out value ="${param['name']}" />
Core('c')
    - Setting and displaying data
    - Flow control
    - Text/URL management
I18N ('fmt')
    - Local and resource management
XML
    - Basic XML
    - Flow control
    - Transforms
SQL
    - Database management










