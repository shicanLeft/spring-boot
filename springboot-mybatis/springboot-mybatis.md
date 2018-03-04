####这一些系列将整合springboot及其他开发必要技术（如：mybaits /shiro / vue /nosql /工作流/编辑器等等）

##这一章 主要事整合springboot-mybaits

  
   jdbc主要包括：
		1.主要是整合xml的方式（企业中用的比较多）
		2.会使用到PageHelper 分页插件
		3.由于时间紧张（以后会把mvn mybatis-generator自动生成代码的代码pull上去）
		
mybatis 其实是对jdbc的进一步封装，
 所以也可以直接采用java 调用mybatis API的方式  直接连接数据库（这个与JDBC一样），
 用的比较少 ----接下来  我们直接使用自动配置的方式完善代码	
		
