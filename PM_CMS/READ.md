## Spring Data mongodb和Spring Data JPA
Spring Data mongodb同Spring Data JPA一样也提供自定义方法的规则,如下:
按照findByXXX,findByXXXAndYYY,countByXXXAndYYY等规则定义方法,实现查询操作。

```java
public interface ProjectRepository extends MongoRepository<com.zp.model.Project,String >{
    // 根据项目名称查询
    com.zp.model.Project findByProjectName(String projectName);
    //根据项目名称和类型查询
    com.zp.model.Project findByProjectNameAndType(String projectName, String Type);
    // 根据类型和poolingName查询记录数
    int countByTypeAndPoolingName(String Type, String poolingName);
    // 根据类型和projectName分页查询
    Page<com.zp.model.Project> findByTypeAndProjectName(String Type, String projectName, Pageable pageable);
}
```

# 条件查询

使用ProjectRepository中的findAll(Example<S> var1, Pageable var2)方法实现


