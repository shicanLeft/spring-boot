####这一些系列将整合springboot及其他开发必要技术（如：mybaits /shiro / vue /nosql /工作流/编辑器等等）

##这一章 主要事整合springboot-jdbc

  
   jdbc主要包括：
		1.数据源(datasource)
		2.事务(Transaction)  
		
springboot默认是使用tomcat-jdbc连接池对数据源提供连接		
我们这一章将排除掉默认的连接池，采用阿里的druid连接池技术
		
