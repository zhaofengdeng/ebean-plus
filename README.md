# ebean-plus
基于ebean开发一些拓展功能

1.提供分页功能，分页（Paginate）

    query分页
    ExpressionList<User> el = Ebean.find(User.class).where();
    el.like("name", "%1%");
    Query<User> query = el.orderBy("id desc");
    Paginate<User> paginate = EbeanPaginateUtil.paginate(query, 1, 15);
    List<User> models = paginate.getModels();

    el分页
    ExpressionList<User> el = Ebean.find(User.class).where();
    Paginate<User> paginate = EbeanPaginateUtil.paginate(el, 1, 15);

2.提供日志功能

  调用更新时，自动校验现有的功能与之前的功能有何区别
  
  调用保存时，记录日志
  
  
3.提供Row、sql转model的工具类


4.提供常用的查询条件拼接

  like,equals,日期拼接
  
  增加查询规则对象
  
  
5.提供删除功能

逻辑删除：deleted更新为true

物理删除，记录日志，进行删除

  
6.提供保存更新功能，如果成功会返回true


7.提供map的更新保存功能(无model的情况下)
