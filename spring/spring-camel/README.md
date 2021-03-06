1. Execute in single node

=======================================================================================================================
 
=======================================================================================================================

#### Embedded FTP server
    
    http://mockftpserver.sourceforge.net/
    testCompile group: 'org.mockftpserver', name: 'MockFtpServer', version: '2.7.1'

#### Dynamic FTP Client using Apache Camel and Spring

    https://blog.jayway.com/2010/08/12/dynamic-ftp-client-using-apache-camel-and-spring/

#### Camel custom component
    
    https://camel.apache.org/manual/latest/writing-components.html

#### Camel Producer template
    
    https://camel.apache.org/manual/latest/producertemplate.html
    producerTemplate.sendBodyAndHeader("ftp://user@host.com/remoteDirectory?password=secret", file, Exchange.FILE_NAME, file.getName());

#### Create or change route at runtime
    
    https://stackoverflow.com/questions/42999274/apache-camel-how-to-add-remove-endpoints-dynamically-from-a-route
    https://stackoverflow.com/questions/34311595/how-in-camel-to-add-and-start-routes-dynamically
    https://stackoverflow.com/questions/15248776/dynamic-change-endpoint-camel
    https://wiki.eclipse.org/Camel_Route:_Dynamic_Endpoint_using_PropertyPlaceholder
    
#### Execute endpoint at single NODE

    https://camel.apache.org/components/2.x/ftp-component.html
    https://camel.apache.org/components/2.x/quartz2-component.html
    https://stackoverflow.com/questions/12957019/quartz-jobs-disallow-concurrent-execution-group-wide
    https://stackoverflow.com/questions/2676295/quartz-preventing-concurrent-instances-of-a-job-in-jobs-xml
    
    https://jayvilalta.com/blog/2014/06/04/understanding-the-disallowconcurrentexecution-job-attribute/
    org.quartz.DisallowConcurrentExecution            