# mcweather
准备开始自学Android了，看了CSDN郭霖大神的书和博客（http://blog.csdn.net/sinyu890807/article/category/1807611），决定开始认真跟着做一个小app了。
所以这是我的第一个github项目，就是大神书里面最后一个天气预报的小项目，由于《第一行代码》中的天气预报的api接口已经没了，网上找了找，找到一个新的接口于开发工作开始了。

新接口获取城市代码都是返回xml格式的，不是书中的格式
XML接口根节点： http://flash.weather.com.cn/wmaps/xml/china.xml
XML接口主要作用是递归获取全国几千个县以上单位的城市代码，如：
江苏的XML地址为：http://flash.weather.com.cn/wmaps/xml/shanghai.xml
苏州的XML地址为：http://flash.weather.com.cn/wmaps/xml/jiangsu.xml
上面页面获得太仓city code：101190408

最后根据城市代码获取天气信息的时候是返回json格式
合成太仓天气信息地址：http://m.weather.com.cn/data/101190408.html
